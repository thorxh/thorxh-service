package com.thorxh.xh.photoalbum.controller;

import com.thorxh.xh.photoalbum.entity.DO.PhotoAlbum;
import com.thorxh.xh.photoalbum.entity.DTO.PhotoAlbumDTO;
import com.thorxh.xh.photoalbum.entity.VO.PhotoAlbumVO;
import com.thorxh.xh.photoalbum.service.PhotoAlbumService;
import com.thorxh.xh.result.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.thorxh.xh.util.ObjectConverter.simpleConvert;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
@Log4j2
@RestController
@RequestMapping("/photoAlbum")
public class PhotoAlbumController {

    private final PhotoAlbumService photoAlbumService;

    @Autowired
    public PhotoAlbumController(PhotoAlbumService photoAlbumService) {
        this.photoAlbumService = photoAlbumService;
    }

    @GetMapping
    public Result<List<PhotoAlbumVO>> getAll() {
        List<PhotoAlbumVO> photoAlbumVOS = simpleConvert(photoAlbumService.getAll(), PhotoAlbumVO.class);
        return Result.getOKResult(photoAlbumVOS);
    }

    @GetMapping("/findByCreaterId")
    public Result<List<PhotoAlbumVO>> findByCreaterId(@RequestParam("createrId") Integer createrId) {
        List<PhotoAlbumVO> photoAlbumVOS =
                simpleConvert(photoAlbumService.findByCreaterId(createrId), PhotoAlbumVO.class);
        return Result.getOKResult(photoAlbumVOS);
    }

    @PostMapping
    public Result save(@RequestBody PhotoAlbumDTO photoAlbumDTO) {
        PhotoAlbum photoAlbum = simpleConvert(photoAlbumDTO, PhotoAlbum.class);
        if (photoAlbum == null) {
            log.error("failed to convert PhotoAlbumDTO{} to PhotoAlbum", photoAlbumDTO);
            return Result.getFailedResult();
        }
//        photoAlbum.setCreaterId(0);
        photoAlbumService.save(photoAlbum);
        return Result.getOKResult();
    }

}
