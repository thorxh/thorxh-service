package com.thorxh.xh.photoalbum.mapper;

import com.thorxh.xh.common.CustomMapper;
import com.thorxh.xh.photoalbum.entity.DO.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
public interface AlbumMapper extends CustomMapper<Album> {

    List<Album> findByCreaterId(@Param("createrId") Integer createrId);

    List<Album> selectAllOrderByCreateTime();

}
