package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//clase lanzadora
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"service","controller"})
public class Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//navegaciones estáticas
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/").setViewName("inicio");
			registry.addViewController("toAlta").setViewName("altaPagina");
			registry.addViewController("toDatos").setViewName("datos");
			registry.addViewController("toInicio").setViewName("inicio");
		}
}
