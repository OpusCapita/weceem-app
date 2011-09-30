// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }
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
grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"

// Set JSON encoded dates to JS native ie. new Date(1194127343161)
grails {
    converters {
        encoding="UTF-8"
        json {
            date = 'javascript'
        }
    }
}

navigation.'weceem.app.admin' = [
    controller:'CMSUser',
    action: 'list',
    title: 'users'
]

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
        authorities: authorities,
        // optional stuff we add
        email: email,
        description: description,
        firstName: firstName,
        lastName: lastName,
        id: id
    ]
}

grails.validateable.packages=['org.weceem']

// Configure Spring Security
grails {
    plugins {
        springsecurity {
            active = true
            //registerLoggerListener = true

            password.algorithm = "MD5"
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

            securityConfigType = 'InterceptUrlMap'
            interceptUrlMap = [
               '/admin/users/**': ['ROLE_ADMIN', 'IS_AUTHENTICATED_REMEMBERED'],
               '/admin/**':       ['IS_AUTHENTICATED_REMEMBERED'],
               '/ck/**':          ['IS_AUTHENTICATED_REMEMBERED'],
               '/*':              ['IS_AUTHENTICATED_ANONYMOUSLY'],
               '/login/**':       ['IS_AUTHENTICATED_ANONYMOUSLY'],
               '/logout/**':      ['IS_AUTHENTICATED_ANONYMOUSLY']
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


environments {
   development {

       weceem.upload.dir = 'file:/var/www/weceem.org/uploads/'
       
       // log4j configuration
       log4j = {

           root.level = org.apache.log4j.Level.INFO
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
                
           error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
                  'org.codehaus.groovy.grails.web.pages' //  GSP

       }
       
       def dbConfLoc = System.getProperty('weceem.config.location', null)
       if (!dbConfLoc) {
           dbConfLoc = "file:./weceem.properties"
       }
       grails.config.locations = [ dbConfLoc ]

       // Load them because we need them here, even though Grails hasn't loaded them all yet
       def slurper = new ConfigSlurper()
       def configs = grails.config.locations?.collect { l -> 
           println "Loading Weceem config from ${l}"
           if (l.endsWith('.properties')) {
               def props = new Properties()
               props.load( new URL(l).newInputStream() )
               slurper.parse(props) 
           } else {
               slurper.parse(new URL(l)) 
           }
       }
       def config = new ConfigObject() 
       if (configs) {
           configs.each { c -> config.merge(c) }
           
           println "Loaded weceem properties: ${config}"
       }
       searchable {
           def diskPath = config.searchable.index.path
           if (!diskPath || !(diskPath instanceof String) ) {
               diskPath = "/var/cache/weceem/searchable-index"
           }
           println "Setting searchable index path to: ${diskPath}"
           compassConnection = new File(diskPath).absolutePath
       }       
   }
}
