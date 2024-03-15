package cn.rlfit.gulimall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@EnableDiscoveryClient
@SpringBootApplication
public class GulimallGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallGatewayApplication.class, args);
	}
	@Bean
	public CorsWebFilter corsWebFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration corsConfiguration = new CorsConfiguration();

		//1、配置跨域
		corsConfiguration.addAllowedHeader("*"); //任何头部都可以跨域
		corsConfiguration.addAllowedMethod("*"); //任何请求方式都可跨域
		corsConfiguration.addAllowedOrigin("http://localhost:8001"); //任何请求来源都可以跨域
		corsConfiguration.setAllowCredentials(true); //允许cooke携带进行跨域

		source.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsWebFilter(source);
	}
}
