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
drop table if exists album;
create table album (
    id integer PRIMARY KEY AUTO_INCREMENT,
    status integer NOT NULL DEFAULT 1,
    create_time timestamp NOT NULL DEFAULT NOW(),
    modify_time timestamp NOT NULL DEFAULT NOW(),
    name varchar(20) NOT NULL DEFAULT '',
    cover_path varchar(100) NOT NULL DEFAULT '',
    description varchar(200) NOT NULL DEFAULT '',
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
    照片长度
    照片宽度
    大小
    纬度
    经度
    拍摄时间
    拍摄设备生产者(make)
    拍摄设备型号(model)
    所属相册
    所属用户

```SQL
drop table if exists photo;
create table photo (
    id integer PRIMARY KEY AUTO_INCREMENT,
    status integer NOT NULL DEFAULT 1,
    create_time timestamp NOT NULL DEFAULT NOW(),
    modify_time timestamp NOT NULL DEFAULT NOW(),
    name varchar(20) NOT NULL DEFAULT '',
    finger char(32) NOT NULL DEFAULT '',
    description varchar(200) NOT NULL DEFAULT '',
    image_width varchar(20) NOT NULL DEFAULT 'unknow',
    image_height varchar(20) NOT NULL DEFAULT 'unknow',
    size integer NOT NULL DEFAULT 0,
    latitude varchar(100) NOT NULL DEFAULT 'unknow' COMMENT '纬度-北纬',
    longitude varchar(100) NOT NULL DEFAULT 'unknow' COMMENT '经度-东经',
    shoot_time timestamp,
    make varchar(100) NOT NULL DEFAULT 'unknow',
    model varchar(100) NOT NULL DEFAULT 'unknow',
    album_id integer NOT NULL,
    user_id integer NOT NULL
)
```

文件签名：
    ID
    创建时间
    MD5签名

```SQL
drop table if exists file_finger;
create table file_finger (
    id integer PRIMARY KEY AUTO_INCREMENT,
    create_time timestamp NOT NULL DEFAULT NOW(),
    finger char(32)  NOT NULL,
    counter integer NOT NULL DEFAULT 1,
    unique key finger_index (finger)
)
```


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