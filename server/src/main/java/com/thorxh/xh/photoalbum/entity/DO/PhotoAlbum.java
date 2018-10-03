package com.thorxh.xh.photoalbum.entity.DO;

import lombok.*;

import javax.persistence.*;
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
@Table(name = "photo_album")
public class PhotoAlbum {

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
     * 相册名称
     */
    private String name;
    /**
     * 相册封面路径
     */
    @Column(name = "cover_path")
    private String coverPath;
    /**
     * 描述
     */
    private String description;
    /**
     * 相册创建者 ID
     */
    @Column(name = "creater_id")
    private Integer createrId;

}
