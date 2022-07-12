package za.recruitment.sars.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConf {

	public static final String DEFAULT_INCLUDE_PATTERN = "/api.*";
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
        		.useDefaultResponseMessages(false)  
        		.select()                                  
        		.apis(RequestHandlerSelectors.basePackage("za.recruitment.sars.controller"))              
        		.paths(PathSelectors.any())                          
        		.build();                                           
    }
	//.regex(DEFAULT_INCLUDE_PATTERN)
	private ApiInfo apiInfo() {
		return new ApiInfo("Employee Management System API", "Employee Management System API service", "v1",
				"Terms of service", new Contact(null, null, null), null, null, new ArrayList<>());
	}

	/*private ApiKey apiKey() {
		return new ApiKey(JWTProperties.HEADER_STRING, JWTProperties.HEADER_STRING, "header");
	}

	private List<SecurityScheme> securitySchemes() {
		List<SecurityScheme> schemeList = new ArrayList<>();
		schemeList.add(apiKey());
		return schemeList;
	}

	private List<SecurityContext> securityContext() {
		List<SecurityContext> list = new ArrayList<>();
		list.add(SecurityContext.builder().securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN)).build());
		return list;
	}

	private List<SecurityReference> defaultAuth() {
		List<SecurityReference> list = new ArrayList<>();
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		list.add(new SecurityReference("Authorization", authorizationScopes));
		return list;
	}*/
}
