package com.thorxh.xh.photoalbum.entity.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * created on 2018/10/3
 *
 * @author thorxh
 */
@Setter
@Getter
@ToString
public class PhotoAlbumDTO {

    /**
     * 相册名称
     */
    private String name;
    /**
     * 相册封面路径
     */
    private String coverPath;
    /**
     * 描述
     */
    private String description;

}
