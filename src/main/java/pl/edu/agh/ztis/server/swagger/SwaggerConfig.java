package pl.edu.agh.ztis.server.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Jakub Sloniec on 31.03.2016.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(regex("/api/.*"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("ZTIS REST")
				.description("ZTIS REST Documentation")
				.termsOfServiceUrl("")
				.contact("Jakub Sloniec & Krzysztof Kicinger")
				.license("The MIT License (MIT)")
				.licenseUrl("https://opensource.org/licenses/MIT")
				.version("2.0")
				.build();
	}

}