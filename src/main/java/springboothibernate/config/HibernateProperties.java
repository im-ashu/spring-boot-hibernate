package springboothibernate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "hibernate")
public class HibernateProperties {

  private String dialect;
  private String showSql;
  private String hbm2ddl;
  private String useSecondLevelCache;
  private String regionFactory;
  private String useQueryCache;

  public HibernateProperties() {
  }

  public String getDialect() {
    return dialect;
  }

  public void setDialect(String dialect) {
    this.dialect = dialect;
  }

  public String getShowSql() {
    return showSql;
  }

  public void setShowSql(String showSql) {
    this.showSql = showSql;
  }

  public String getHbm2ddl() {
    return hbm2ddl;
  }

  public void setHbm2ddl(String hbm2ddl) {
    this.hbm2ddl = hbm2ddl;
  }

  public String getUseSecondLevelCache() {
    return useSecondLevelCache;
  }

  public void setUseSecondLevelCache(String useSecondLevelCache) {
    this.useSecondLevelCache = useSecondLevelCache;
  }

  public String getRegionFactory() {
    return regionFactory;
  }

  public void setRegionFactory(String regionFactory) {
    this.regionFactory = regionFactory;
  }

  public String getUseQueryCache() {
    return useQueryCache;
  }

  public void setUseQueryCache(String useQueryCache) {
    this.useQueryCache = useQueryCache;
  }
}
