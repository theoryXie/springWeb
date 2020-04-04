package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2	//启用swagger
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	//通过createRestApi函数创建Docket的Bean之后，apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
	@Bean
	public Docket createRestApi(){
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("Spring Boot中使用Swagger2构建RESTful APIs")
				.description("更多请关注http://www.baidu.com")
				.termsOfServiceUrl("http://www.baidu.com")
				.contact("sunf")
				.version("1.0")
				.build();

		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.paths(PathSelectors.any())
				.build();
	}

}
//swagger注解说明
/*
@Api：用在类上，说明该类的作用。

@ApiOperation：注解来给API增加方法说明。

@ApiImplicitParams : 用在方法上包含一组参数说明。

@ApiImplicitParam：用来注解来给方法入参增加说明。

@ApiResponses：用于表示一组响应

@ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息

    l   code：数字，例如400

    l   message：信息，例如"请求参数没填好"

    l   response：抛出异常的类

@ApiModel：描述一个Model的信息（一般用在请求参数无法使用@ApiImplicitParam注解进行描述的时候）

    l   @ApiModelProperty：描述一个model的属性* */

//swagger ApiImplicitParam参数的使用说明
//@ApiImplicitParam的参数说明：
//		paramType：指定参数放在哪个地方	header：请求参数放置于Request Header，使用@RequestHeader获取；	query：请求参数放置于请求地址，使用@RequestParam获取；	path：（用于restful接口）-->请求参数的获取；@PathVariable	body：（不常用）	form（不常用）
//		name：参数名
//		dataType：参数类型
//		required：参数是否必须传
//		true | false
//		value：说明参数的意思
//		defaultValue：参数的默认值