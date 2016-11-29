
-- 创建数据库 --
CREATE DATABASE platform DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- 创建用户--
CREATE USER 'platform'@'localhost' IDENTIFIED BY 'platform'; 
-- 数据库用户授权 --
GRANT ALL ON platform.* TO 'platform'@'localhost'; 


ssh-keygen -t rsa -C "wangwenbin8023@sina.com" -f "C:\Users\Administrator\.ssh\id_rsa_plstform"


mybatis-generator:generate




