package com.thorxh.xh.photoalbum.mapper;

import com.thorxh.xh.common.CustomMapper;
import com.thorxh.xh.photoalbum.entity.DO.FileFinger;
import org.apache.ibatis.annotations.Param;

/**
 * created on 2018/10/4
 *
 * @author thorxh
 */
public interface FileFingerMapper extends CustomMapper<FileFinger> {

    int isFingerExists(@Param("finger") String finger);

}
