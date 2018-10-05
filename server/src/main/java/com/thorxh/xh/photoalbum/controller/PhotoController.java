package com.thorxh.xh.photoalbum.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thorxh.xh.photoalbum.entity.DO.FileFinger;
import com.thorxh.xh.photoalbum.entity.DO.Photo;
import com.thorxh.xh.photoalbum.entity.VO.PhotoVO;
import com.thorxh.xh.photoalbum.service.FileFingerService;
import com.thorxh.xh.photoalbum.service.PhotoService;
import com.thorxh.xh.photoalbum.service.QiniuService;
import com.thorxh.xh.result.ResponseCode;
import com.thorxh.xh.result.Result;
import com.thorxh.xh.util.FileHelper;
import com.thorxh.xh.util.ObjectConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import static com.thorxh.xh.util.ObjectConverter.simpleConvert;

/**
 * created on 2018/10/4
 *
 * @author thorxh
 */
@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/pa/photo")
public class PhotoController {

    @Value("${qiniu.image.domain://image.thorxh.site}")
    private String QINIU_IMAGE_DOMAIN;

    @Value("${qiniu.image.style:imageView2/1/w/200/h/200/q/75|imageslim}")
    private String QINIU_IMAGE_STYLE;

    @Resource
    private PhotoService photoService;

    @Resource
    private FileFingerService fileFingerService;

    @Resource
    private QiniuService qiniuService;

    @Resource
    private FileHelper fileHelper;

    @GetMapping
    public Result<PageInfo<PhotoVO>> get(@RequestParam("albumId") Integer albumId,
                                         @RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
                                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        if (albumId == null) {
            return Result.getFailedResult();
        }
        PageHelper.startPage(pageNum, pageSize);
        List<PhotoVO> photoVOS = simpleConvert(photoService.get(albumId), PhotoVO.class);
        photoVOS.forEach(photoVO -> {
            photoVO.setImagePath(QINIU_IMAGE_DOMAIN + "/" + photoVO.getFinger());
            photoVO.setImageStyle(QINIU_IMAGE_STYLE);
        });
        return Result.getOKResult(new PageInfo<>(photoVOS));
    }

    @PostMapping
    public Result<String> addPhoto(@RequestParam("file") MultipartFile coverFile,
                                   @RequestParam("albumId") Integer albumId) throws IOException {
        if (coverFile == null || albumId == null) {
            return new Result<>(ResponseCode.BAD_REQUEST.code, "请传入相关参数", false, null);
        }
        ByteArrayInputStream inputStream = fileHelper.toByteArrayInputStream(coverFile.getInputStream());
        String finger = fileHelper.getMD5(inputStream);
        if (photoService.isPhotoExists(finger)) {
            return Result.getOKResult(finger);
        }

        fileFingerService.save(new FileFinger(finger));

        qiniuService.uploadImage(inputStream, finger);

        Photo photo = fileHelper.getImageMeta(inputStream, finger);
        photo.setUserId(0);
        photo.setAlbumId(albumId);
        photoService.save(photo);
        return Result.getOKResult(finger);
    }

    @DeleteMapping
    public Result<String> deletePhoto(@RequestParam("name") String name) {
        // TODO 添加权限

        return Result.getOKResult();
    }

}
