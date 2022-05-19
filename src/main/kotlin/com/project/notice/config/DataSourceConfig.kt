package com.project.notice.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.orm.jpa.JpaTransactionManager
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "transactionManager",
    basePackages = ["com.project.notice.apis"]
)
class DataSourceConfig {
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.notice")
    fun dataSource(): DataSource {
        var dataSource = DataSourceBuilder.create().type(HikariDataSource::class.java).build()

        // UTF-8
        dataSource.connectionInitSql = "SET NAMES utf8mb4"

        return dataSource
    }

    @Primary
    @Bean
    fun entityManagerFactory(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(this.dataSource())
            .packages("com.project.notice.apis")
            .persistenceUnit("notice")
            .build()
    }

    @Primary
    @Bean
    fun transactionManager(builder: EntityManagerFactoryBuilder): JpaTransactionManager {
        return JpaTransactionManager(entityManagerFactory(builder).`object`!!)
    }
}