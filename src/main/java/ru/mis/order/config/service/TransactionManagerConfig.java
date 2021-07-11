package ru.mis.order.config.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class TransactionManagerConfig implements TransactionManagementConfigurer {

    private final DataSource dataSource;

    public TransactionManagerConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
        public PlatformTransactionManager annotationDrivenTransactionManager() {
            return new DataSourceTransactionManager(dataSource);
        }
}
