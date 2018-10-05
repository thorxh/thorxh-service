package com.thorxh.xh.photoalbum.service.impl;

import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.thorxh.xh.photoalbum.service.QiniuService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * created on 2018/10/3
 *
 * @author thorxh
 */
//@PropertySource("classpath:application.yml")
@Log4j2
@Service
public class QiniuServiceImpl implements QiniuService {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.image.bucket:image}")
    private String imageBucket;

    @Override
    public void uploadImage(InputStream inputStream, String name) {
        uploadFile(inputStream, name);
    }

    @Override
    public void deleteFile(String fileName) {

    }

    private void uploadFile(InputStream inputStream, String name) {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(imageBucket);
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            inputStream.reset();
            Response response = uploadManager.put(inputStream, name, upToken, null, null);
            if (response.statusCode != 200) {
                log.warn("failed to uploadCover file, response {}", response);
            }
        } catch (IOException e) {
            log.error("failed to uploadCover file", e);
        }
    }

}
