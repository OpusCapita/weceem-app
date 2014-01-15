hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true // Warning, turning this on causes lock contention
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
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
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
//            logSql = true
        }
    }
    production {
        dataSource {
            pooled = true
            driverClassName = "org.h2.Driver"
            username = "sa"
            password = ""
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis=1800000
                timeBetweenEvictionRunsMillis=1800000
                numTestsPerEvictionRun=3
                testOnBorrow=true
                testWhileIdle=true
                testOnReturn=false
                validationQuery="SELECT 1"
                jdbcInterceptors="ConnectionState"
            }
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
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
}
