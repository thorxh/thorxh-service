package com.thorxh.xh.photoalbum.service.impl;

import com.thorxh.xh.common.AbstractService;
import com.thorxh.xh.photoalbum.entity.DO.FileFinger;
import com.thorxh.xh.photoalbum.mapper.FileFingerMapper;
import com.thorxh.xh.photoalbum.service.FileFingerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created on 2018/10/4
 *
 * @author thorxh
 */
@Service
@Log4j2
public class FileFingerServiceImpl extends AbstractService<FileFinger> implements FileFingerService {

    @Resource
    private FileFingerMapper fileFingerMapper;

    @Override
    public boolean isFingerExists(String finger) {
        return fileFingerMapper.isFingerExists(finger) == 1;
    }

}
