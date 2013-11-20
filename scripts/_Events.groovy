import groovy.xml.StreamingMarkupBuilder
import grails.util.Environment

def jndiName = 'WeceemDS'
/*
if (Environment.current == Environment.PRODUCTION) {
    eventWebXmlEnd = {String tmpfile ->
        def root = new XmlSlurper().parse(webXmlFile)

        // add the data source
        root.appendNode {
            'resource-ref'{
                'description'('The JNDI Database resource')
                'res-ref-name'('jdbc/'+jndiName)
                'res-type'('javax.sql.DataSource')
                'res-auth'('Container')
            }
        }
    
        // add the data source
        root.appendNode {
            'resource-ref'{
                'description'('The Mail session resource')
                'res-ref-name'('mail/Session')
                'res-type'('javax.mail.Session')
                'res-auth'('Container')
            }
        }

        webXmlFile.text = new StreamingMarkupBuilder().bind {
            mkp.declareNamespace("": "http://java.sun.com/xml/ns/j2ee")
            mkp.yield(root)
        }
    }
}  */
