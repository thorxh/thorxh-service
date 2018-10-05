package com.thorxh.xh.photoalbum.service.impl;

import com.thorxh.xh.common.AbstractService;
import com.thorxh.xh.photoalbum.entity.DO.Photo;
import com.thorxh.xh.photoalbum.mapper.FileFingerMapper;
import com.thorxh.xh.photoalbum.mapper.PhotoMapper;
import com.thorxh.xh.photoalbum.service.PhotoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created on 2018/10/4
 *
 * @author thorxh
 */
@Log4j2
@Service
public class PhotoServiceImpl extends AbstractService<Photo> implements PhotoService {

    @Resource
    private PhotoMapper photoMapper;

    @Resource
    private FileFingerMapper fileFingerMapper;

    @Override
    public boolean isPhotoExists(String finger) {
        return fileFingerMapper.isFingerExists(finger) == 1;
    }

    @Override
    public List<Photo> get(Integer albumId) {
        return photoMapper.findByAlbumId(albumId);
    }

}
