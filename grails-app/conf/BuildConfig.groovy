grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"

// Remove any files that have been created locally during testing
grails.war.resources = { stagingDir, args ->
    delete(dir:"${stagingDir}/WeceemFiles")
}

grails.tomcat.jvmArgs = ["-Xmx1024m", "-XX:MaxPermSize=256m", '-verbose:class'] 
 
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
	}
	dependencies {
		// specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
		
		// runtime 'mysql:mysql-connector-java:5.1.5'
	}

	plugins { 
		compile ':weceem:1.1.2'
	}
}
