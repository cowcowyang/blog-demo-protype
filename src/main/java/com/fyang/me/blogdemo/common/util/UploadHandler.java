package com.fyang.me.blogdemo.common.util;

import com.alibaba.fastjson.JSON;
import com.fyang.me.blogdemo.domain.OSSBody;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
  * @auther:fyang
  * @date: 2018/2/8
  * @description: OSS 上传工具类
  *
 */
@Component
public class UploadHandler {

    @Autowired
    private  UploadManager uploadManager;

    @Autowired
    private  String uploadToken;

    public  OSSBody upload(InputStream io) throws QiniuException {
        Response uploadResp = uploadManager.put(io, null, uploadToken, null, null);
        return JSON.parseObject(uploadResp.bodyString(), OSSBody.class);
    }
}
