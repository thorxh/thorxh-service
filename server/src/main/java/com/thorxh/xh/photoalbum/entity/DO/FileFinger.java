package com.thorxh.xh.photoalbum.entity.DO;

import lombok.*;

import javax.persistence.*;

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
@Table(name = "file_finger")
public class FileFinger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    /**
     * 记录创建时间
     */
    @Column(name = "create_time")
    private String createTime;
    /**
     * 文件指纹
     */
    private String finger;
    /**
     * 引用计数(如果文件签名相同则两个文件相同， counter 值加一)
     */
    private Integer counter;

    public FileFinger(String finger) {
        this.finger = finger;
    }

}
