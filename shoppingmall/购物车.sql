#使用数据库
use shoppingdb;

#删除数据库
drop  database shoppingdb; 

#创建数据库
create database shoppingdb;


#创建用户表
CREATE TABLE user(
u_id int primary key AUTO_INCREMENT,
u_name varchar(10) NOT NULL,
u_pwd varchar(6) NOT NULL,
u_emeail varchar(30) NOT NULL,
u_phone varchar(11) NOT NULL
);



#创建类型表
CREATE TABLE type (
t_id int primary key AUTO_INCREMENT,
t_name varchar(10) NOT NULL
);



#创建商品表
create table commodity(
c_id int primary key AUTO_INCREMENT,
c_name varchar(50) ,
c_particulars varchar(100) ,
c_price double(10,2) ,
c_state varchar(8) ,
c_img varchar(15) ,
t_id int,foreign key (t_id) references type(t_id)
);

#插入商品
insert into commodity values
(default,"Apple/苹果commodity笔记本电脑","笔记本电脑13.3英寸笔记本电脑带触控2018款官方正品","133800.00","上架","1.jpg",1),
(default,"2017新款27寸5K苹果/Apple"," iMac Pro一体机台式电脑MQ2Y2CH/A定制","335800.00","上架","2.jpg",1),
(default,"Apple/苹果主机"," Mac Mini MGEN2CH/A MGEQ2CH/A 主机 低中配定制 美版","3280.00","上架","3.jpg",1),
(default,"Apple/苹果 iPhone 8","iPhone 8 全网通4G手机 官方旗舰店","4458.00","上架","4.jpg",2),
(default,"Huawei/华为 nova 3 ","nova 3 全面屏正品千玺代言手机","2799.00","上架","5.jpg",2),
(default,"vivo NEX","移动vivo NEX 旗舰版官方全新正品","4498.00","上架","6.jpg",2);



#创建购物表
create table shoppinglist(
s_id int primary key auto_increment,
c_id int ,foreign key (c_id) references commodity(c_id),
s_count int not null,
s_state int,
u_id int, foreign key (u_id) references User(u_id),
o_id int,foreign key (o_id) references orderlist(o_id)
);


#创建订单表
create table orderlist(
o_id int primary key auto_increment, 
a_id int ,foreign key (a_id) references address(a_id),
o_money double(10,2) ,
o_date date ,
o_state varchar(6)
);



#创建地址表
CREATE TABLE address (  
a_id int primary key AUTO_INCREMENT,
a_contacts varchar(10) NOT NULL,
a_phoneNumber varchar(15) NOT NULL,
a_address varchar(100) NOT NULL,
u_id int,foreign key (u_id) references User(u_id)
);


#插入用户
insert into user values
(default,"nzh",666666,"982357421@qq.com",13580041170),
(default,"zs",223344,"2345446464@qq.com",13553745242),
(default,"ls",888888,"2624562264@qq.com",13580026242);

alter table shoppinglist modify column s_state int ;#--修改字段长度
delete from user where u_id=2;
select * from user;

select * from user where u_name="zs";

#根据用户名查询id
select u_id as id from user where u_name='李四';

#插入类型
insert into type values
(default,"电脑"),
(default,"手机"),
(default,"食品"),
(default,"汽车"),
(default,"运动"),
(default,"玩具"),
(default,"家电"),
(default,"办公"),
(default,"珠宝");
select * from type;



select * from commodity;
select * from commodity where c_id=1;


#插入地址
insert into address values(default,"","","",1);
select * from address where u_id=1;
delete from address;

#查询用户
select * from User where u_name ='zs' and u_pwd='223344';


#查询购物表
select * from shoppinglist ;
#查询指定用户的购物网项
select * from shoppinglist where u_id=1;

#根据商品id查询数据
select c_id  as c_id from shoppinglist  where c_id=3;

#查询用户添加的购物车商品
select c.c_id,c_particulars,c_price,c_img,t_id,s_id,s_count,s.s_state from commodity c inner join shoppinglist s on s.c_id=c.c_id where u_id=1;
delete from shoppinglist; #删除表所用数据
delete from shoppinglist where s_id=14; #删除表某一条数据

select count(*) as s_count from shoppinglist where u_id=1;


#修改数量
update shoppinglist set s_count=s_count+1  where c_id=3 and u_id=4;

update shoppinglist set s_count=1  where c_id=3 and u_id=4;