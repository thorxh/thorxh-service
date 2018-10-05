package com.thorxh.xh.util;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.thorxh.xh.photoalbum.entity.DO.Photo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created on 2018/10/4
 *
 * @author thorxh
 */
@Component
@Log4j2
public class FileHelper {

    // 生产者
    private static final String MAKE = "Make";
    // 型号
    private static final String MODEL = "Model";
    // 拍摄时间
    private static final String DATE_TIME = "Date/Time";
    // 照片宽度
    private static final String EXIF_IMAGE_WIDTH = "Exif Image Width";
    // 照片高度
    private static final String EXIF_IMAGE_HEIGHT = "Exif Image Height";
    // 纬度 北纬
    private static final String GPS_LATITUDE = "GPS Latitude";
    // 经度 东经
    private static final String GPS_LONGITUDE = "GPS Longitude";

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");

    @Value("${server.temp.dir:./temp}")
    private String tempDir;

    public Photo getImageMeta(InputStream inputStream, String finger) {
        Photo photo = new Photo();
        photo.setFinger(finger);
        try {
            inputStream.reset();
            // 必须紧接着 inputStream.reset();
            photo.setSize(inputStream.available());
            Metadata metadata = JpegMetadataReader.readMetadata(inputStream);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    if (MAKE.equals(tag.getTagName())) {
                        photo.setMake(tag.getDescription());
                    } else if (MODEL.equals(tag.getTagName())) {
                        photo.setModel(tag.getDescription());
                    } else if (DATE_TIME.equals(tag.getTagName())) {
                        if (tag.getDescription() != null) {
                            Date date = SIMPLE_DATE_FORMAT.parse(tag.getDescription());
                            if (date != null) {
                                photo.setShootTime(new Timestamp(date.getTime()));
                            }
                        }
                    } else if (EXIF_IMAGE_WIDTH.equals(tag.getTagName())) {
                        String imageWidth = tag.getDescription();
                        if (imageWidth != null && imageWidth.length() != 0) {
                            photo.setImageWidth(imageWidth.replace(" pixels", ""));
                        }
                    } else if (EXIF_IMAGE_HEIGHT.equals(tag.getTagName())) {
                        String imageHeight = tag.getDescription();
                        if (imageHeight != null && imageHeight.length() != 0) {
                            photo.setImageHeight(imageHeight.replace(" pixels", ""));
                        }
                    } else if (GPS_LATITUDE.equals(tag.getTagName())) {
                        photo.setLatitude(tag.getDescription());
                    } else if (GPS_LONGITUDE.equals(tag.getTagName())) {
                        photo.setLongitude(tag.getDescription());
                    }
                }
            }
        } catch (JpegProcessingException | IOException | ParseException e) {
            log.error(e);
        }
        return photo;
    }

    /**
     * 将 inputStream 转为 ByteArrayInputStream 中
     */
    public ByteArrayInputStream toByteArrayInputStream(InputStream inputStream) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int len;
            while ((len = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
            }
            outputStream.flush();
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException e) {
            log.error(e);
        }
        return null;
    }

    public File saveTempFile(InputStream inputStream) {
        File tempFile = new File(tempDir + File.separator + UuidUtil.getUUIDStr());
        createDir(tempFile.getParentFile());
        try (OutputStream  outputStream = new FileOutputStream(tempFile);) {
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
            }
            outputStream.flush();
        } catch (IOException e) {
            log.error(e);
        }
        return tempFile;
    }

    public String getMD5(InputStream inputStream) {
        try {
            inputStream.reset();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] buff = new byte[1024];
            int len;
            while ((len = inputStream.read(buff)) != -1) {
                md5.update(buff, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, md5.digest());
            return bigInt.toString(16).toUpperCase();
        } catch (NoSuchAlgorithmException | IOException e) {
            log.error(e);
        }
        return null;
    }

    private void createDir(File file) {
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            int count = 0;
            while (!mkdirs && count++ < 5) {
                mkdirs = file.mkdirs();
            }
        }
    }

}
