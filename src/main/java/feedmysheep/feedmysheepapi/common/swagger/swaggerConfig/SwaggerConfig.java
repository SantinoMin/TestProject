//package test.swagger.swaggerConfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//public class SwaggerConfig {
//
//  @Bean
//  public Docket api() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        // select() : ApiSelectorBuilder 를 활성화 하여, Builder 형태로 합니다.
//        .select()
//        // apis()
//        // API문서에 출력할 패키지 경로를 지정. (String)
//        .apis(RequestHandlerSelectors.basePackage("/test/swagger/register"))
//        // paths()
//        // API문서에 출력할 URL 경로 지정. (String)
//        .paths(PathSelectors.ant("/app/church"))
//        // build() : build
//        .build()
//        // apiInfo()
//        // API문서 title, version 등 설정 진행.
//        .apiInfo(apiInfo())
//        // swagger에서 제공하는 기본 응답 코드 설명 제거
//        .useDefaultResponseMessages(false)
//        // API문서에서 제외할 class 지정. "," 로 이어서 작성해도 됨.
//        .ignoredParameterTypes()
//        ;
//  }
//
//  private ApiInfo apiInfo() {
//    return new ApiInfoBuilder()
//        .title("이것은 API 문서 이름입니다.")
//        .description("이것은 API문서 상세 설명입니다.")
//        .version("1.23")
//        .build();
//  }
//}