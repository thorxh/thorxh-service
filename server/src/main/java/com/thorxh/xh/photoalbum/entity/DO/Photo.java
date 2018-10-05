package com.thorxh.xh.photoalbum.entity.DO;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * created on 2018/10/4
 *
 * @author thorxh
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 记录状态: 1 - 正常, 0 - 已删除
     */
    private Integer status;
    /**
     * 记录创建时间
     */
    @Column(name = "create_time")
    private Timestamp createTime;
    /**
     * 记录修改时间
     */
    @Column(name = "modify_time")
    private Timestamp modifyTime;
    /**
     * 照片名称
     */
    private String name;
    /**
     * 照片签名，用于唯一标识一张图片
     */
    private String finger;
    /**
     * 照片描述
     */
    private String description;
    /**
     * 照片文件大小
     */
    private Integer size;
    /**
     * 照片宽度
     */
    @Column(name = "image_width")
    private String imageWidth;
    /**
     * 照片高度
     */
    @Column(name = "image_height")
    private String imageHeight;
    /**
     * 纬度-北纬
     */
    private String latitude;
    /**
     * 经度-东经
     */
    private String longitude;
    /**
     * 照片拍摄时间
     */
    @Column(name = "shoot_time")
    private Timestamp shootTime;
    /**
     * 拍摄设备生产者
     */
    private String make;
    /**
     * 拍摄设备型号
     */
    private String model;
    /**
     * 相册ID
     */
    private Integer albumId;
    /**
     * 照片所属用户ID
     */
    private Integer userId;

}
