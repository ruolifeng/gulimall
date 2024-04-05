package cn.rlfit.gulimall.search;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallSearchApplicationTests {

	@Autowired
	ElasticsearchClient elasticsearchClient;
	@Test
	void contextLoads() {
		System.out.println(elasticsearchClient);
	}

}
