package com.thorxh.xh.photoalbum.service;

import com.thorxh.xh.common.CommonService;
import com.thorxh.xh.photoalbum.entity.DO.PhotoAlbum;

import java.util.List;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
public interface PhotoAlbumService extends CommonService<PhotoAlbum> {

    List<PhotoAlbum> findByCreaterId(Integer createrId);

}
