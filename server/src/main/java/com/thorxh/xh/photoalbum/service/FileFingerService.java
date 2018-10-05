package com.thorxh.xh.photoalbum.service;

import com.thorxh.xh.common.CommonService;
import com.thorxh.xh.photoalbum.entity.DO.FileFinger;

/**
 * created on 2018/10/4
 *
 * @author thorxh
 */
public interface FileFingerService extends CommonService<FileFinger> {

    boolean isFingerExists(String finger);

}
