hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true // Warning, turning this on causes lock contention
    cache.provider_class='org.hibernate.cache.EhCacheProvider'
}

// environment specific settings
environments {
    development {
        dataSource {
            pooled = false
            driverClassName = "org.hsqldb.jdbcDriver"
            username = "sa"
            password = ""
            dbCreate = 'create-drop' // one of 'create', 'create-drop','update'
            url = 'jdbc:hsqldb:mem:devDB'
//            logSql = true
        }
    }
    test {
        dataSource {
            pooled = false
            driverClassName = "org.hsqldb.jdbcDriver"
            username = "sa"
            password = ""
            dbCreate = "create"
            url = "jdbc:hsqldb:mem:testDb"
        }
    }
}
