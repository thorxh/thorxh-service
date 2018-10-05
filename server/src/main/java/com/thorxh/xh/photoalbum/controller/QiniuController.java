package com.thorxh.xh.photoalbum.controller;

import com.thorxh.xh.photoalbum.entity.DO.FileFinger;
import com.thorxh.xh.photoalbum.service.FileFingerService;
import com.thorxh.xh.photoalbum.service.QiniuService;
import com.thorxh.xh.result.Result;
import com.thorxh.xh.util.FileHelper;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * created on 2018/10/3
 *
 * @author thorxh
 */
@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/pa/file")
public class QiniuController {

    @Resource
    private QiniuService qiniuService;

    @Resource
    private FileHelper fileHelper;

    @Resource
    private FileFingerService fileFingerService;

    @PostMapping("/uploadCover")
    public Result<String> uploadCover(@RequestParam("file") MultipartFile coverFile) {
        try {
            ByteArrayInputStream arrayInputStream = fileHelper.toByteArrayInputStream(coverFile.getInputStream());
            String finger = fileHelper.getMD5(arrayInputStream);
            if (!fileFingerService.isFingerExists(finger)) {
                fileFingerService.save(new FileFinger(finger));
                qiniuService.uploadImage(arrayInputStream, finger);
            }
            return Result.getOKResult(finger);
        } catch (IOException e) {
            log.error("an exception occured when get inputStream from MultipartFile", e);
        }
        return Result.getFailedResult();
    }

}
