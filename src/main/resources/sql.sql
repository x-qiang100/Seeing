create table user
(
    id       int auto_increment  comment '主键'
        primary key,
    name     varchar(255)                         not null comment '姓名',
    phone    varchar(255)                         not null comment '电话号码',
    password varchar(255)                         not null comment '密码',
    type     int                                    not null  comment '0:志愿者 1:视障者',
    email    varchar(255)  default '尚未填写'           null comment '邮箱',
    picture  varchar(255) default '尚未填写'          null comment '图片url',
    gender   int          default 2               null comment '性别（0女，1男，2未知）',
    msg      varchar(255) default '此人很懒，尚未填写个人信息' null comment '个人信息',
    address  varchar(255) default '尚未填写'          null comment '家庭住址',
    number   int          default 0                null comment '帮助或被帮助次数'
);

create table record
(
    id        int auto_increment comment '主键'
        primary key,
    volunteer int                               not null comment '志愿者id',
    blind     int                               not null comment '视障者id',
    evaluate  varchar(255) default '此人很懒，未填写评价' null comment '对志愿者此次帮助评价',
    time      datetime                          not null comment '时间'
);


create table contact
(
    id    int auto_increment comment '主键'
        primary key,
    user  int          not null comment '视障者id',
    name  varchar(255) not null comment '联系人姓名',
    phone varchar(255) not null  comment '联系人电话'
);
