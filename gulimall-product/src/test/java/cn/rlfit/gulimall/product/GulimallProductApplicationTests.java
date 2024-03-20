package cn.rlfit.gulimall.product;

import cn.rlfit.gulimall.product.domain.PmsCategoryBrandRelation;
import cn.rlfit.gulimall.product.mapper.PmsCategoryBrandRelationMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class GulimallProductApplicationTests {
    @Autowired
    PmsCategoryBrandRelationMapper pmsCategoryBrandRelationMapper;
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    @Test
    void contextLoads() {
        PmsCategoryBrandRelation pmsCategoryBrandRelation = pmsCategoryBrandRelationMapper.selectByPrimaryKey(1l);
        System.out.println(pmsCategoryBrandRelation);
    }

    @Test
    void testUploadFile() {

    }

    @Test
    void testGetBean(){
        Object o = new Object();
        applicationContext.getBeanFactory().registerSingleton("xxx", o);
    }
}
