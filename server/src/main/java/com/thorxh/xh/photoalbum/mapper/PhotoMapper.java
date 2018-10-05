package com.thorxh.xh.photoalbum.mapper;

import com.thorxh.xh.common.CustomMapper;
import com.thorxh.xh.photoalbum.entity.DO.Photo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created on 2018/10/4
 *
 * @author thorxh
 */
public interface PhotoMapper extends CustomMapper<Photo> {

    List<Photo> findByAlbumId(@Param("albumId") Integer albumId);

}
