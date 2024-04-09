package cn.rlfit.gulimall.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 导入依赖
 * 编写配置，给容器中注入一个es
 * 操作es: https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/getting-started-java.html
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GulimallSearchApplication {
	public static void main(String[] args) {
		SpringApplication.run(GulimallSearchApplication.class, args);
	}
}
