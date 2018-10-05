package com.thorxh.xh.photoalbum.service.impl;

import com.thorxh.xh.Application;
import com.thorxh.xh.photoalbum.service.FileFingerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created on 2018/10/4
 *
 * @author thorxh
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FileFingerServiceImplTest {

    @Autowired
    private FileFingerService fileFingerService;

    @Test
    public void testIsFingerExists() {
        Assert.assertTrue(fileFingerService.isFingerExists("301d61853fc9ce94bbfb55b56c218d06"));
    }

}