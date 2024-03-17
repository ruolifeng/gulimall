package cn.rlfit.gulimall.third_party.controller;

import cn.rlfit.gulimall.third_party.utils.AlibabaOss;
import cn.rlfit.gulimall.utils.resp.R;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 17/03/2024 1:26 PM
 */
@RestController
public class OssController {
    @Autowired
    AlibabaOss alibabaOss;
    @Value("${aliyun.endpoint}")
    private String endPoint;
    @Value("${aliyun.bucketName}")
    private String buckName;
    @Value("${aliyun.callback}")
    private String callbackUrl;
    private String dir = "";
    @GetMapping("/oss/policy")
    public R policy(){
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, "gu");

            String postPolicy = alibabaOss.getOSSClient().generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String accessId = alibabaOss.getDefaultCredentialProvider().getCredentials().getAccessKeyId();
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = alibabaOss.getOSSClient().calculatePostSignature(postPolicy);

            Map<String, String> respMap = new LinkedHashMap<String, String>();
            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", "gu");
            respMap.put("host", "https://"+buckName+"."+endPoint);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            // respMap.put("expire", formatISO8601Date(expiration));
//            JSONObject jasonCallback = new JSONObject();
//            jasonCallback.put("callbackUrl", callbackUrl);
//            jasonCallback.put("callbackBody",
//                    "filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
//            jasonCallback.put("callbackBodyType", "application/x-www-form-urlencoded");
//            String base64CallbackBody = BinaryUtil.toBase64String(jasonCallback.toString().getBytes());
//            respMap.put("callback", base64CallbackBody);
            return R.ok().put("data", respMap);
        } catch (Exception e) {
            // Assert.fail(e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            alibabaOss.getOSSClient().shutdown();
        }
        return null;
    }
}
