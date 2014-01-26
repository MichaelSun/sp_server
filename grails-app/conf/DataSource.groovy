dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            //			logSql = true

        }
    }
    test {


        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://10.2.124.149:3306/sp?useUnicode=true&characterEncoding=UTF-8"
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            username = "root"
            password = "mysql123"
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect

            properties {
                maxActive = 50
                maxIdle = 25
                minIdle = 5
                initialSize = 5
                minEvictableIdleTimeMillis = 60000
                timeBetweenEvictionRunsMillis = 60000
                maxWait = 10000
                validationQuery = "/* ping */"
            }
        }

    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/sp?useUnicode=true&characterEncoding=UTF-8"
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            username = "root"
            password = "mysql123"
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect

            properties {
                maxActive = 50
                maxIdle = 25
                minIdle = 5
                initialSize = 5
                minEvictableIdleTimeMillis = 60000
                timeBetweenEvictionRunsMillis = 60000
                maxWait = 10000
                validationQuery = "/* ping */"
            }
        }
    }
}
