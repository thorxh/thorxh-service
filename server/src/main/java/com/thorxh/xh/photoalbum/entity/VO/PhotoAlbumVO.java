package com.thorxh.xh.photoalbum.entity.VO;

import lombok.*;

import java.sql.Timestamp;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PhotoAlbumVO {

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
    /**
     * 相册创建者 ID
     */
    private Integer createrId;

}
