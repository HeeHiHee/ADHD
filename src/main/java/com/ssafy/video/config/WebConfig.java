package com.ssafy.video.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.ssafy.video.interceptor.JwtInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private JwtInterceptor jwtInterceptor;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

		registry.addResourceHandler("/swagger-ui/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");

	}	
	
	//CORS 에러를 해결하기 위해서 컨트롤러에 각각 작성을 할수도 있지만 공통처리(전역처리)라면 요기다 한방에 가넝
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	  registry.addMapping("/**")
	  	.allowedOrigins("http://localhost:5173")
	    .allowedMethods(
	    	HttpMethod.GET.name(),
	    	HttpMethod.HEAD.name(),
	    	HttpMethod.POST.name(),
	    	HttpMethod.PUT.name(),
	    	HttpMethod.DELETE.name());
	}
	
//	// 등록할 인터셉터가 있다면...
//	// 필드를 통해 의존성을 주입 받고
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(jwtInterceptor)
//		.addPathPatterns("/**") // 모든 애들이 통과되게끔
//		// 경로중에 /api/login가 있다면 동작 시키지 않겠다
//		.excludePathPatterns("/api/login", "/swagger-resources/**", "/swagger-ui/**", "/v2/api-docs");
//	}
	
	
	
	

}