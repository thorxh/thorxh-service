package com.thorxh.xh.photoalbum.mapper;

import com.thorxh.xh.common.CommonMapper;
import com.thorxh.xh.photoalbum.entity.DO.Album;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
@Mapper
public interface AlbumMapper extends CommonMapper<Album> {

    List<Album> findByCreaterId(@Param("createrId") Integer createrId);

}
