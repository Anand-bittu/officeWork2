package com.anand.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

    /**
     * This bean defines the data source for your application, which is used to
     * establish a connection to the MySQL database.
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // You MUST replace 'your_database_name', 'your_username', and 'your_password' with your actual MySQL credentials.
        dataSource.setUrl("jdbc:mysql://localhost:3306/database_name");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }
    /**
     * This bean sets up the EntityManagerFactory, which is essential for JPA.
     * It configures Hibernate as the JPA provider and links it to the data source.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());

        // This line tells Spring where to find your @Entity classes (like Employee.java).
        em.setPackagesToScan("com.anand.entity");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());

        return em;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();

        // 'update' automatically creates/updates the database schema based on your entities.
        // It's great for development, but consider 'validate' or migration tools for production.
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true"); // Displays SQL queries in the console.
        properties.setProperty("hibernate.format_sql", "true"); // Formats the SQL for readability.
        return properties;
    }

    // This is the new, crucial bean that was missing.
    // It provides the transaction management functionality for JPA.
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
