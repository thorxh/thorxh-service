package com.thorxh.xh.photoalbum.service;

import java.io.InputStream;

/**
 * created on 2018/10/3
 *
 * @author thorxh
 */
public interface QiniuFileService {

    /**
     * 上传相册封面
     * @param inputStream 图片输入流
     * @return 成功则返回图片名称，失败返回 null
     */
    String uploadCover(InputStream inputStream);

}
