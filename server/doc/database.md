# 数据库设计

## 相册设计

相册：(photo_album)
    ID
    是否删除(status)
    创建时间(create_time)
    修改时间(modify_time)
    名称(name)
    封面(cover_path)
    描述(description)
    创建人ID(creater_id)

```SQL
create table photo_album (
    id integer PRIMARY KEY AUTO_INCREMENT,
    status integer NOT NULL DEFAULT 1,
    create_time timestamp NOT NULL DEFAULT NOW(),
    modify_time timestamp NOT NULL DEFAULT NOW(),
    name varchar(20) NOT NULL DEFAULT '',
    cover_path varchar(100) NOT NULL DEFAULT '',
    description varchar(20) NOT NULL DEFAULT '',
    creater_id integer
)
```


相片：
    ID
    是否删除
    创建时间
    修改时间
    名称
    路径
    尺寸(分辨率)
    大小
    拍摄地点
    拍摄设备

用户：
    ID
    是否删除
    创建时间
    修改时间
    用户名
    密码
    头像



新建相册
查看相册
上传图片
下载图片