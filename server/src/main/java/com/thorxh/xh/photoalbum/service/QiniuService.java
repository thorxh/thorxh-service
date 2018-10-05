package com.thorxh.xh.photoalbum.service;

import java.io.InputStream;

/**
 * created on 2018/10/3
 *
 * @author thorxh
 */
public interface QiniuService {

    /**
     * 上传图片
     */
    void uploadImage(InputStream inputStream, String name);

    void deleteFile(String fileName);

}
