// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.resources.adhoc.excludes = ['/plugins/weceem-1.3']

grails.mime.file.extensions = false // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]
// The default codec used to encode data with ${}
grails.views.default.codec="html" // none, html, base64

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
// escapes all not-encoded output at final stage of outputting
// filteringCodecForContentType.'text/html' = 'html'
    }
}

grails.views.gsp.encoding="UTF-8"

// Bootstrap
grails.plugins.twitterbootstrap.fixtaglib = true

// Set JSON encoded dates to JS native ie. new Date(1194127343161)
grails {
    converters {
        encoding="UTF-8"
        json {
            date = 'javascript'
        }
    }
}

//cache.headers.enabled = false

// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true


weceem.profile.url = [controller:'userProfile', action:'edit']
weceem.logout.url = [controller:'logout']
weceem.content.prefix = ''
weceem.admin.prefix = 'admin'
weceem.tools.prefix="cms/tools"
weceem.space.templates = [
    default: "classpath:/org/weceem/resources/default-space-template.zip", 
    basic:"classpath:/org/weceem/resources/basic-space-template.zip"]

weceem.springsecurity.details.mapper = { ->
    [   // Stuff required by weceem spring sec
        username: username,
        password: passwd,
        enabled: enabled,
        accountNonExpired: accountNonExpired,
        credentialsNonExpired: credentialsNonExpired,
        accountNonLocked: accountNonLocked,
        authorities: authorities,
        // optional stuff we add
        email: email,
        description: description,
        firstName: firstName,
        lastName: lastName,
        id: id
    ]
}

// configure custom page for HTTP 404 response
// weceem.page404 = 'test404page'

// configure custom page for HTTP 406 response
// weceem.page406 = 'test406page'

grails.validateable.packages=['org.weceem']

// Configure Spring Security

grails.plugin.springsecurity.rejectIfNoRule = false
grails.plugin.springsecurity.fii.rejectPublicInvocations = false
grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails {
    plugin {
        springsecurity {
            active = true
            //registerLoggerListener = true

            password.algorithm = "SHA-512"
            dao.reflectionSaltSourceProperty = 'username'
            //use Base64 text ( true or false )
            password.encodeHashAsBase64 = false
            adh.errorPage = "null"

            // Turn of user caching, acegi plugin requires diskstore cache by default, which we don't want.
            cacheUsers = false
    
            /** login user domain class name and fields */
            userLookup.userDomainClassName = "org.weceem.auth.CMSUser"
            userLookup.userNamePropertyName = "username"
            userLookup.passwordPropertyName = "passwd"
            userLookup.enabledPropertyName = "enabled"
            userLookup.authoritiesPropertyName = "authorities"

            /**
            * Authority domain class authority field name
            * authorityFieldInList
            */
            authority.className = "org.weceem.auth.CMSRole"
            authority.nameField = "authority"

            interceptUrlMap = [
                    '/admin/users/**': ['hasRole(\'ROLE_ADMIN\')', 'isRememberMe()'],
                    '/admin/**': ['hasRole(\'ROLE_ADMIN\')', 'isRememberMe()'],
                    '/ck/**': ['isRememberMe()'],
                    '/*': ['permitAll'],
                    '/login/**': ['permitAll'],
                    '/logout/**': ['permitAll']
            ]

            /** AJAX request header */
            ajaxHeader = "X-Requested-With"

            /** use basicProcessingFilter */
            useBasicAuth = false
            /** use switchUserProcessingFilter */
            useSwitchUserFilter = false

        }
    }
}

// elasticsearch configuration
def hasCustomElasticSearchConfig

def dbConfLoc = System.getProperty('weceem.config.location', null)
if (!dbConfLoc) {
    dbConfLoc = "file:./weceem.properties"
}
if (!grails.config.locations) {
    grails.config.locations =  [dbConfLoc]
} else grails.config.locations <<  dbConfLoc

def slurper = new ConfigSlurper()
def configs = grails.config.locations?.collect { l ->
    println "Loading Weceem config from ${l}"
    try {
        URL fileUrl = new URL(l)
        boolean isFileExists = new File(fileUrl.getPath()).exists()
        if (isFileExists) {
            if (l.endsWith('.properties')) {
                def props = new Properties()
                props.load(fileUrl.newInputStream() )
                slurper.parse(props)
            } else {
                slurper.parse(fileUrl)
            }
        }
    } catch (IOException e) {
        println "Couldn't load config from URL $l: $e"
    }
}
def config = new ConfigObject()
if (configs && !configs.isEmpty()) {
    configs.each { c -> if (config) config?.merge(c) else config = c }
    println "Loaded weceem properties: ${config}"
}

if (config?.elasticSearch) {
    elasticSearch = config.elasticSearch
} else {
    elasticSearch.datastoreImpl = 'hibernateDatastore'
    elasticSearch.bulkIndexOnStartup = true
    elasticSearch.disableAutoIndex = false
}

environments {
   development {

       weceem.upload.dir = 'file:/var/www/weceem.org/uploads/'

       // log4j configuration
       log4j = {
           root {
               info()
               additivity = true
           }

/*
           debug   'org.weceem',
                   'grails.app.controller',
                   'grails.app.service',
                   'grails.app.filters',
                   'grails.app.task'
*/
           info    'org.weceem',
                   'grails.app'

           error   'org.codehaus.groovy.grails.web.servlet',  //  controllers
                   'org.codehaus.groovy.grails.plugins', // plugins
                   'org.codehaus.groovy.grails.web.pages', //  GSP
                   'org.codehaus.groovy.grails.web.sitemesh', //  layouts
                   'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
                   'org.codehaus.groovy.grails.commons', // core / classloading
                   'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
                   'org.springframework',
                   'org.hibernate'
       }
   }
   test {
   }
   production {

       log4j = {
           appenders {
               rollingFile name: 'fileLog',
               fileName: 'application.log',
               maxFileSize: 26214400,
               maxBackupIndex: 10,
               layout: pattern(conversionPattern: '%d{yyyy-MM-dd HH:mm:ss,SSS} %p %c{2} %m%n')
           }
           root {
                info()
                additivity = true
           }
           info 'org.weceem',
                'grails.app'

           error   'org.codehaus.groovy.grails.web.servlet',  //  controllers
                   'org.codehaus.groovy.grails.plugins', // plugins
                   'org.codehaus.groovy.grails.web.pages', //  GSP
                   'org.codehaus.groovy.grails.web.sitemesh', //  layouts
                   'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
                   'org.codehaus.groovy.grails.commons', // core / classloading
                   'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
                   'org.springframework',
                   'org.hibernate'

       }

   }
}
