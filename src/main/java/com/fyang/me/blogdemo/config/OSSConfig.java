package com.fyang.me.blogdemo.config;

import com.qiniu.common.Zone;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
  * @auther:fyang
  * @date: 2018/2/8
  * @description: QiniuYun OSS设置Bean
  *
 */
@Configuration
public class OSSConfig {

    @Value("${file.server.ak}")
    private String accessKey;

    @Value("${file.server.sk}")
    private String secretKey;

    @Value("${file.server.bucket}")
    private String bucketName;

    @Bean
    public UploadManager uploadManager() {
        com.qiniu.storage.Configuration config = new com.qiniu.storage.Configuration(Zone.zone0());
        return new UploadManager(config);
    }

    @Bean
    public String uploadToken(){
        return Auth.create(accessKey, secretKey).uploadToken(bucketName);
    }

}
