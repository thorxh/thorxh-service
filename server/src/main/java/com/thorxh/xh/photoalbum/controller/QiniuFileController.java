package com.thorxh.xh.photoalbum.controller;

import com.thorxh.xh.photoalbum.service.QiniuFileService;
import com.thorxh.xh.result.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
public class QiniuFileController {

    private final QiniuFileService qiniuFileService;

    @Autowired
    public QiniuFileController(QiniuFileService qiniuFileService) {
        this.qiniuFileService = qiniuFileService;
    }

    @PostMapping("/uploadCover")
    public Result<String> uploadCover(@RequestParam("file") MultipartFile coverFile) {
        String coverFileName;
        try {
            coverFileName = qiniuFileService.uploadCover(coverFile.getInputStream());
        } catch (IOException e) {
            log.error("an Exception occured when get InputStream from MultipartFile", e);
            return Result.getFailedResult();
        }
        if (coverFileName == null) {
            return Result.getFailedResult();
        }
        return Result.getOKResult(coverFileName);
    }

}
