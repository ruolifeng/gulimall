package cn.rlfit.gulimall.search;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 导入依赖
 * 编写配置，给容器中注入一个es
 * 操作es: https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/getting-started-java.html
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GulimallSearchApplication {
	// URL and API key
	String serverUrl = "http://192.168.50.101:9200";
//	String apiKey = "UqvK_PymQdSauo3d7MWv4w";
	public static void main(String[] args) {
		SpringApplication.run(GulimallSearchApplication.class, args);
	}

	@Bean
	public ElasticsearchClient elasticsearchClient(){
		// Create the low-level client
		RestClient restClient = RestClient
				.builder(HttpHost.create(serverUrl))
				.build();
		// Create the transport with a Jackson mapper
		ElasticsearchTransport transport = new RestClientTransport(
				restClient, new JacksonJsonpMapper());

		// And create the API client
        return new ElasticsearchClient(transport);
	}
}
