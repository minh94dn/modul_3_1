create database user_management;
use user_management;
create table user_management(
id int auto_increment primary key,
`name` varchar(45),
email varchar(45),
country varchar(45)
);

insert into user_management(`name`, email, country)
values ("Minh", "minh1994dn@gmail.com", "Đà Nẵng"), ("Thắng", "thang@gmail.com", "Quảng Nam"), ("Công", "cong@gmail.com", "Quảng Trị");

select * from user_management;
insert into user_management(`name`, email, country) values ("Minh", "minh1994dn@gmail.com", "Đà Nẵng");

select * from user_management where id = 1;

update user_management set `name` = "a", email ="b", country="c" where id =1;

delete from user_management where id = 1;
select * from user_management where country like 222;

