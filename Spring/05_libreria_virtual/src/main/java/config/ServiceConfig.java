package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@ComponentScan(basePackages = "service")
@Configuration
@PropertySource(value = "classpath:config/application.properties")
public class ServiceConfig {
	/*private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String cadenaCon="jdbc:mysql://localhost:3307/ejemplobd";
	private static final String user="root";
	private static final String pwd="root";*/
	@Value("${driver}")
	private String driver;
	@Value("${cadenaCon}")
	private String cadenaCon;
	@Value("${usuario}")
	private String user;
	@Value("${pwd}")
	private String pwd;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(cadenaCon);
		ds.setUsername(user);
		ds.setPassword(pwd);
		return ds;
	}
	
	@Bean
	public JdbcTemplate template(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
