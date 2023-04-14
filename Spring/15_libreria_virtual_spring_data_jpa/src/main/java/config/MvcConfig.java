package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan(basePackages = "controller")
@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer{
	//configuración del objeto que se encarga de la navegación
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//navegaciones estáticas
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("toRegistro").setViewName("registro");
		registry.addViewController("toLogin").setViewName("login");
		
	}
}
