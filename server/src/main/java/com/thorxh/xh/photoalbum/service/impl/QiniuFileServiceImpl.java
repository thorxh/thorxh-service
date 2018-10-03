package com.thorxh.xh.photoalbum.service.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.thorxh.xh.photoalbum.service.QiniuFileService;
import com.thorxh.xh.util.UuidUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * created on 2018/10/3
 *
 * @author thorxh
 */
//@PropertySource("classpath:application.yml")
@Log4j2
@Service
public class QiniuFileServiceImpl implements QiniuFileService {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.cover.bucket:cover}")
    private String bucket;

    @Override
    public String uploadCover(InputStream inputStream) {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        String fileName = UuidUtil.getUUIDStr();
        try {
            Response response = uploadManager.put(inputStream, fileName, upToken, null, null);
            if (response.statusCode == 200) {
                return fileName;
            } else {
                log.warn("failed to uploadCover file, response {}", response);
            }
        } catch (QiniuException e) {
            log.error("failed to uploadCover file", e);
        }
        return null;
    }

}
