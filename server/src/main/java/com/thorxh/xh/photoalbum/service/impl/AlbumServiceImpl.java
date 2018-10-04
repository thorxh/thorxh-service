package com.thorxh.xh.photoalbum.service.impl;

import com.thorxh.xh.common.AbstractService;
import com.thorxh.xh.photoalbum.entity.DO.Album;
import com.thorxh.xh.photoalbum.mapper.AlbumMapper;
import com.thorxh.xh.photoalbum.service.AlbumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
@Service
public class AlbumServiceImpl extends AbstractService<Album> implements AlbumService {

    @Resource
    private AlbumMapper albumMapper;

    @Override
    public List<Album> getAll() {
        return albumMapper.selectAll();
    }

    @Override
    public List<Album> get(Integer createrId) {
        if (createrId == null) {
            return albumMapper.selectAll();
        }
        return albumMapper.findByCreaterId(createrId);
    }

}
