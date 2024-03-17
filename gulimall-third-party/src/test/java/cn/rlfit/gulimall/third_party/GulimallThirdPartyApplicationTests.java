package cn.rlfit.gulimall.third_party;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.rlfit.gulimall.third_party.utils.AlibabaOss;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;

@SpringBootTest
class GulimallThirdPartyApplicationTests {

    @Autowired
    AlibabaOss alibabaOss;
    @Test
    void contextLoads() {
    }
    @Test
    void testUpload(){
        byte[] bytes = FileUtil.readBytes("\u202AC:\\Users\\18777\\OneDrive\\图片\\Saved Pictures\\动漫美女 鲜花 帽子 唯美 好看 4K壁纸_彼岸图网.jpg");
        ByteArrayInputStream stream = IoUtil.toStream(bytes);
        alibabaOss.uploadAliYunOss("美女.jpg", stream);
    }
}
