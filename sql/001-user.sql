drop table  if exists `user`;
create table `user`(
    `id`   varchar(50) NOT NULL COMMENT '用户ID',
    `username` varchar(200) NOT NULL COMMENT '用户ID',
    `email` varchar(200) NOT NULL COMMENT '用户ID',
    `create_timestamp` bigint(20)  NOT NULL COMMENT '创建时间',
    `update_timestamp` bigint(20)  NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    unique `uni_username`(`username`),
    unique `idx_email`(`email`),
    key `idx_create_timestamp` (`create_timestamp`)
);