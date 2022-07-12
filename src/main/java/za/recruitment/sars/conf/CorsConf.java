package za.recruitment.sars.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConf implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS")
				.allowedOrigins("http://localhost:4200");
		registry.addMapping("api/v1/swagger.json").allowedMethods("GET", "OPTIONS").allowedOrigins("*");
	}
}
