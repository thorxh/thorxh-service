package com.thorxh.xh.photoalbum.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thorxh.xh.photoalbum.entity.DO.Album;
import com.thorxh.xh.photoalbum.entity.DTO.AlbumDTO;
import com.thorxh.xh.photoalbum.entity.VO.AlbumVO;
import com.thorxh.xh.photoalbum.service.AlbumService;
import com.thorxh.xh.result.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.thorxh.xh.util.ObjectConverter.simpleConvert;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/pa/album")
public class AlbumController {

    @Value("${qiniu.image.domain://image.thorxh.site}")
    private String QINIU_IMAGE_DOMAIN;

    @Value("${qiniu.image.style:imageView2/1/w/200/h/200/q/75|imageslim}")
    private String QINIU_IMAGE_STYLE;

    @Resource
    private AlbumService albumService;

    @GetMapping
    public Result<PageInfo<AlbumVO>> get(
            @RequestParam(value = "createrId", required = false) Integer createrId,
            @RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AlbumVO> albumVOS = simpleConvert(albumService.get(createrId), AlbumVO.class);
        albumVOS.forEach(albumVO -> albumVO.setCoverPath(QINIU_IMAGE_DOMAIN + "/" + albumVO.getCoverPath() + "?" + QINIU_IMAGE_STYLE));
        return Result.getOKResult(new PageInfo<>(albumVOS));
    }

    @PostMapping
    public Result save(@RequestBody AlbumDTO albumDTO) {
        Album album = simpleConvert(albumDTO, Album.class);
        if (album == null) {
            log.error("failed to convert AlbumDTO{} to Album", albumDTO);
            return Result.getFailedResult();
        }
        album.setCreaterId(0);
        albumService.save(album);
        return Result.getOKResult();
    }

}
