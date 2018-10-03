package com.thorxh.xh.photoalbum.service.impl;

import com.thorxh.xh.Application;
import com.thorxh.xh.photoalbum.service.QiniuFileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * created on 2018/10/3
 *
 * @author thorxh
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class QiniuFileServiceImplTest {

    @Resource
    private QiniuFileService qiniuFileService;

    @Test
    public void testUpload() {
        InputStream inputStream = QiniuFileServiceImplTest.class.getClassLoader().getResourceAsStream("application.properties");
        Assert.assertNotNull(qiniuFileService.uploadCover(inputStream));
    }

}