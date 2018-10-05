package com.thorxh.xh.photoalbum.entity.VO;

import lombok.*;

/**
 * created on 2018/10/5
 *
 * @author thorxh
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PhotoVO {

    private Integer id;
    /**
     * 记录状态: 1 - 正常, 0 - 已删除
     */
    private Integer status;
    /**
     * 记录创建时间
     */
    private Long createTime;
    /**
     * 记录修改时间
     */
    private Long modifyTime;
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
    private String imageWidth;
    /**
     * 照片高度
     */
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
    private Long shootTime;
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
     * 图片链接
     */
    private String imagePath;
    /**
     * 图片预览样式
     */
    private String imageStyle;

}
