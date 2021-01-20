package com.hanbinjava.iexcel.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
* Swagger 配置文件
* @ClassName: Swagger
* @Description: TODO(配置文件)
* @author fuce
* @date 2018年6月3日
*
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket createRestApi() {

		ParameterBuilder parameterBuilder = new ParameterBuilder();
		List<Parameter> parameterList = new ArrayList<>();
		parameterBuilder.name("Authrization").description("认证token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
		parameterList.add(parameterBuilder.build());
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.hanbinjava.iexcel.controller"))
				.paths(PathSelectors.any())
				.build()
				.globalOperationParameters(parameterList);

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("swagger-bootstrap-ui RESTful APIs")
				.description("swagger-bootstrap-ui")
				.termsOfServiceUrl("http://localhost:8080/")
				.contact("han_bin@outlook.com")
				.version("1.0")
				.build();
	}

}
