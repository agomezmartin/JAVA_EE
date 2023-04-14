package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement //habilita la transaccionalidad mediante anotaciones
@ComponentScan(basePackages = "service")
@Configuration
@PropertySource(value = "classpath:config/application.properties")
public class ServiceConfig {
	@Value("${driver}")
	private String driver;
	@Value("${cadenaCon}")
	private String cadenaCon;
	@Value("${usuario}")
	private String user;
	@Value("${pwd}")
	private String pwd;
	///
	@Value("${dialect}")
	private String dialect;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(cadenaCon);
		ds.setUsername(user);
		ds.setPassword(pwd);
		return ds;
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
