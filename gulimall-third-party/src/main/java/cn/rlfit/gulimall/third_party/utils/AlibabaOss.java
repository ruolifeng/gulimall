package cn.rlfit.gulimall.third_party.utils;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.common.comm.SignVersion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;

/**
 * @author: sunjianrong
 * @email: sunruolifeng@gmail.com
 * @date: 17/03/2024 9:29 AM
 */
@RefreshScope
@Component
public class AlibabaOss {
    // STS临时访问密钥AccessKey ID和AccessKey Secret。
    @Value("${aliyun.key.id}")
    private  String accessKeyId;
    @Value("${aliyun.key.sec}")
    private  String accessKeySecret;
    // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
    @Value("${aliyun.endpoint}")
    private  String endpoint;
    // 填写Endpoint对应的Region信息，例如cn-hangzhou。
    @Value("${aliyun.region}")
    private  String region;
    @Value("${aliyun.bucketName}")
    private  String bucketName;
    String securityToken = "yourSecurityToken";
    public  void   uploadAliYunOss(String objectName, ByteArrayInputStream byteArrayInputStream){
        // 使用代码嵌入的STS临时访问密钥和安全令牌配置访问凭证。
        // 使用代码嵌入的RAM用户的访问密钥配置访问凭证。
        DefaultCredentialProvider credentialsProvider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);
        // 填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
//        // 从环境变量中获取访问凭证。运行本代码示例之前，请先配置环境变量。
//        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

        // 创建OSSClient实例。
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(endpoint)
                .credentialsProvider(credentialsProvider)
                .clientConfiguration(clientBuilderConfiguration)
                .region(region)
                .build();
        try {
            // 创建存储空间。
//            ossClient.createBucket(bucketName);
            String content = "Hello OSS";
            ossClient.putObject(bucketName, objectName, byteArrayInputStream);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } finally {
            // 关闭OSSClient。
            System.out.println("上传文件"+objectName+"成功...");
            ossClient.shutdown();
        }
    }
}
