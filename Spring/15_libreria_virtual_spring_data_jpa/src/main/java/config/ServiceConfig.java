package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableJpaRepositories(basePackages = "dao",entityManagerFactoryRef = "factory", transactionManagerRef = "txManager")
@ComponentScan(basePackages = "service")
@Configuration
@PropertySource(value = "classpath:config/application.properties")
public class ServiceConfig {
	@Value("${referenciads}")
	String ref;
	@Value("${dialect}")
	private String dialect;
	@Bean
	public DataSource getDataSource() {
		JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource(ref);
	}
	
	//adaptador spring para JPA-Hibernate
		@Bean
		public HibernateJpaVendorAdapter adapter() {
			HibernateJpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
			adapter.setDatabasePlatform(dialect);
			return adapter;
		}
		//creación del EntityManager
		@Bean
		public LocalContainerEntityManagerFactoryBean factory(HibernateJpaVendorAdapter adapter, DataSource data) {
			LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
			factory.setDataSource(data);
			factory.setJpaVendorAdapter(adapter);
			factory.setPackagesToScan("model");
			return factory;
		}
		
		//objeto encargado de gestionar transacciones
		@Bean
		public JpaTransactionManager txManager(LocalContainerEntityManagerFactoryBean factory) {
			JpaTransactionManager txmanager=new JpaTransactionManager();
			txmanager.setEntityManagerFactory(factory.getObject());
			return txmanager;
		}
}
