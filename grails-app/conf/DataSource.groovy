hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true // Warning, turning this on causes lock contention
    cache.provider_class='org.hibernate.cache.EhCacheProvider'
}

// environment specific settings
environments {
    development {
        dataSource {
            pooled = true
            driverClassName = "org.h2.Driver"
            username = "sa"
            password = ""
            dbCreate = 'create-drop' // one of 'create', 'create-drop','update'
            url = "jdbc:h2:mem:devDb;MVCC=TRUE"
//            logSql = true
        }
    }
    production {
        dataSource {
            pooled = true
            driverClassName = "org.h2.Driver"
            username = "sa"
            password = ""
            dbCreate = 'update' // one of 'create', 'create-drop','update'
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
//            logSql = true
        }
    }
    test {
        dataSource {
            pooled = false
            driverClassName = "org.h2.Driver"
            username = "sa"
            password = ""
            dbCreate = "create-drop"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE"
        }
    }
}
