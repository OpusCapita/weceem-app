grails.servlet.version = "3.0"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"

// Remove any files that have been created locally during testing
grails.war.resources = { stagingDir, args ->
    delete(dir:"${stagingDir}/WeceemFiles")
}

grails.tomcat.jvmArgs = ["-Xmx1024m", "-XX:MaxPermSize=256m", '-verbose:class']
grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
	// inherit Grails' default dependencies
	inherits( "global" ) {
		// uncomment to disable ehcache
		// excludes 'ehcache'
	}
	log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	repositories {
        mavenLocal grailsSettings.config.jcatalog.mavenLocal
        grailsPlugins()
		grailsHome()
		grailsCentral()
        mavenRepo "http://repo.grails.org/grails/core"
	}
	dependencies {
		// specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        compile 'net.java.dev.textile-j:textile-j:2.2.864'
        compile 'xstream:xstream:1.2.1'
	}

	plugins {
        compile ':weceem:1.2-M1'

        // plugins for the build system only
        build ":tomcat:7.0.47"
        // plugins for the compile step
        compile ":scaffolding:2.0.1"
        compile ':cache:1.1.1'

        // plugins needed at runtime but not for compilation
        runtime ":hibernate:3.6.10.6" // or ":hibernate4:4.1.11.2"
        runtime ":database-migration:1.3.8"

        compile ":bean-fields:1.0" // consider replacing with the fields plugin or even with the new Platform UI
        compile ":blueprint:1.0.2"
        compile ":cache-headers:1.1.5"
        compile ":ckeditor:3.6.6.1.0"
        compile ":feeds:1.6"

        compile ":jquery:1.8.3"
        compile ":jquery-ui:1.8.24"
        compile ":navigation:1.3.2"
        compile ":quartz:1.0-RC7"
        compile ":searchable:0.6.6"
        compile ":taggable:1.0.1"
        compile ":mail:1.0.1"

        compile ":weceem-spring-security:1.2-M1"
        compile ":spring-security-core:1.2.7.3"
}
}
