dataSource {
    pooled = false
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}

hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true // Warning, turning this on causes lock contention
    cache.provider_class='org.hibernate.cache.EhCacheProvider'
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = 'create-drop' // one of 'create', 'create-drop','update'
            url = 'jdbc:h2:mem:devDB;MVCC=true'
//            logSql = true
        }
    }
    test {
        dataSource {
            dbCreate = "create"
            url = 'jdbc:h2:mem:testDB;MVCC=true'
        }
    }
}
