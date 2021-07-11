package ru.mis.order.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class SessionFactoryConfig {
    @Value("${mybatis.config-location}")
    private String mybatisConfigFilePath;
    @Value("${mybatis.mapper-location}")
    private String mapperPath;
    @Value("{mybatis.type-aliases-package}")
    private String entityPackage;
    private final DataSource dataSource;

    public SessionFactoryConfig(@Qualifier("dataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean(); // Создать экземпляр SqlSession FactoryBean
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath)); // сканировать файл конфигурации mybatis;
        // Установить информацию о соединении с базой данных
        sqlSessionFactoryBean.setDataSource(dataSource);
        // Установить путь сканирования файла XML, соответствующего mapper
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        // Устанавливаем путь сканирования класса сущностей
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }

}
