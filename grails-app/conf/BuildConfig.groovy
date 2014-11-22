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
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()
    }
	dependencies {

		// specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        compile 'net.java.dev.textile-j:textile-j:2.2.864'
        compile 'xstream:xstream:1.2.1'
        runtime "org.apache.ant:ant:1.8.0"
        runtime 'org.apache.ant:ant-launcher:1.8.0'
        test "org.grails:grails-datastore-test-support:1.0-grails-2.4"
	}

	plugins {
        compile ':weceem:1.3-SNAPSHOT'
        // plugins for the build system only
        build ':tomcat:7.0.54'
        compile ':cache:1.1.8'
        compile ':scaffolding:2.1.2'

        // plugins needed at runtime but not for compilation
        runtime ':hibernate4:4.3.5.5'
        runtime ":database-migration:1.4.0"
        runtime ':elasticsearch:0.0.3.6'
        runtime ":jquery:1.11.1"
        compile ":jquery-ui:1.10.4"
        compile ":twitter-bootstrap:3.2.0.2"
        compile ":cache-headers:1.1.7"
        compile ":ckeditor:4.4.1.0"
        compile ":feeds:1.6"

        compile ":platform-core:1.0.0"
        compile ":fields:1.4"
        compile ":quartz:1.0.2"
        compile ":taggable:1.1.0"
        compile ":mail:1.0.7"

        compile ":weceem-spring-security:1.3-SNAPSHOT"
        compile ":spring-security-core:2.0-RC4"

}
}
