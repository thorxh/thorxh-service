package com.thorxh.xh.photoalbum.service;

import com.thorxh.xh.common.CommonService;
import com.thorxh.xh.photoalbum.entity.DO.Photo;

import java.util.List;

/**
 * created on 2018/10/4
 *
 * @author thorxh
 */
public interface PhotoService extends CommonService<Photo> {

    boolean isPhotoExists(String finger);

    List<Photo> get(Integer albumId);

}
