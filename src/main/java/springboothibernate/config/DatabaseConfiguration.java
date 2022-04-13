package springboothibernate.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.lang.NonNull;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class DatabaseConfiguration {

  @Autowired
  private DatabaseProperties databaseProperties;

  @Autowired
  private HibernateProperties hibernateProperties;

  @Value("${entityManager.packagesToScan}")
  private String packagesToScan;

  @Autowired
  private DataSource dataSource;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(databaseProperties.getDriver());
    dataSource.setUrl(databaseProperties.getUrl());
    dataSource.setUsername(databaseProperties.getUsername());
    dataSource.setPassword(databaseProperties.getPassword());
    return dataSource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setPackagesToScan(packagesToScan);
    sessionFactory.setHibernateProperties(additionalProperties());
    return sessionFactory;
  }

  @Bean
  public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  @NonNull
  private Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.show_sql", hibernateProperties.getShowSql());
    properties.setProperty("hibernate.dialect", hibernateProperties.getDialect());
    properties.setProperty("hibernate.hbm2ddl.auto", hibernateProperties.getHbm2ddl());
    properties.setProperty("hibernate.cache.use_second_level_cache",
        hibernateProperties.getUseSecondLevelCache());
    properties.setProperty("hibernate.cache.region.factory_class",
        hibernateProperties.getRegionFactory());
    properties.setProperty("hibernate.cache.use_query_cache",
        hibernateProperties.getUseQueryCache());
    return properties;
  }
}
