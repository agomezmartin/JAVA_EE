package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@EnableJpaRepositories(basePackages = "dao")
@SpringBootApplication(scanBasePackages = {"service","controller"})
@EntityScan(basePackages = "model")
public class Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	//navegaciones estáticas
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/").setViewName("login");
			registry.addViewController("toRegistro").setViewName("registro");
			registry.addViewController("toLogin").setViewName("login");
			
		}
}
