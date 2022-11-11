package com.AcmeFresh;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class AcmeFreshDoc {
	
	@Bean
	public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.AcmeFresh"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apidetails());
    }
	
	private ApiInfo apidetails() {
		
		return new ApiInfo("Acme Fresh REST Api", 
				"Generating REST Api's for Acme Fresh application for Buyer and Grower", "1.0", "Free to use", 
				new Contact("muralikrishna70321@gmail.com","https://github.com/purimetlamuralikrishna","https://www.linkedin.com/in/murali-krishna-purimetla/"), 
				null,"https://github.com/purimetlamuralikrishna", Collections.emptyList());
		
	}
}
