package com.thorxh.xh.photoalbum.service.impl;

import com.thorxh.xh.common.AbstractService;
import com.thorxh.xh.photoalbum.entity.DO.PhotoAlbum;
import com.thorxh.xh.photoalbum.mapper.PhotoAlbumMapper;
import com.thorxh.xh.photoalbum.service.PhotoAlbumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
@Service
public class PhotoAlbumServiceImpl extends AbstractService<PhotoAlbum> implements PhotoAlbumService {

    @Resource
    private PhotoAlbumMapper photoAlbumMapper;

    @Override
    public List<PhotoAlbum> getAll() {
        return photoAlbumMapper.selectAll();
    }

    @Override
    public List<PhotoAlbum> get(Integer createrId) {
        if (createrId == null) {
            return photoAlbumMapper.selectAll();
        }
        return photoAlbumMapper.findByCreaterId(createrId);
    }

}
