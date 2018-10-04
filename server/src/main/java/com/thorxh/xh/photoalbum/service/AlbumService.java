package com.thorxh.xh.photoalbum.service;

import com.thorxh.xh.common.CommonService;
import com.thorxh.xh.photoalbum.entity.DO.Album;

import java.util.List;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
public interface AlbumService extends CommonService<Album> {

    List<Album> get(Integer createrId);

}
