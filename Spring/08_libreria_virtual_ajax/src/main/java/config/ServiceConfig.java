package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@ComponentScan(basePackages = "service")
@Configuration
@PropertySource(value = "classpath:config/application.properties")
public class ServiceConfig {
	@Value("${referenciads}")
	String ref;
	@Bean
	public DataSource getDataSource() {
		JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource(ref);
	}
	
	@Bean
	public JdbcTemplate template(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
