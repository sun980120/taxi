package com.example.taxiApi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    private License license() {
        return new License()
                .name("MIT")
                .url("https://opensource.org/licenses/MIT");
    }
    private Info info() {
        return new Info()
                .title("Taxi API")
                .description("CodingLog - WooDong")
                .version("0.1")
                .license(license());
    }
    private ExternalDocumentation externalDocumentation() {
        return new ExternalDocumentation()
                .description("CodingLog - WooDong")
                .url("https://github.com/sun980120");
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(info())
                .externalDocs(externalDocumentation());
    }
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.OAS_30)
//                .useDefaultResponseMessages(true) // Swagger 에서 제공해주는 기본 응답 코드를 표시할 것이면 true
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.taxiApi")) // Controller가 들어있는 패키지. 이 경로의 하위에 있는 api만 표시됨.
//                .paths(PathSelectors.any()) // 위 패키지 안의 api 중 지정된 path만 보여줌. (any()로 설정 시 모든 api가 보여짐)
//                .build();
//    }
//
//    public ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Taxi-1.0 API Documentation")
//                .description("CodingLog - WooDong")
//                .version("0.1")
//                .build();
//    }
}
