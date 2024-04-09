package cn.rlfit.gulimall.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 给容器中注入一个操作依赖
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 09/04/2024 3:14 PM
 */
@Configuration
public class GulimallElasticSearchConfig {

    @Bean
    public RestHighLevelClient esRestClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.50.101:22", 9200, "http")
                )
        );
        return client;
    }
}
