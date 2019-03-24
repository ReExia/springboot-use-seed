/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.20 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `agency` (
	`id` int (11),
	`name` varchar (60),
	`address` varchar (300),
	`phone` varchar (90),
	`email` varchar (150),
	`about_us` varchar (300),
	`mobile` varchar (33),
	`web_site` varchar (60)
); 
insert into `agency` (`id`, `name`, `address`, `phone`, `email`, `about_us`, `mobile`, `web_site`) values('1','恋家','恋家地址','010-89898989','010@gmail.com','1','1','1');
insert into `agency` (`id`, `name`, `address`, `phone`, `email`, `about_us`, `mobile`, `web_site`) values('2','交点房产','交点房产地址','010-87898989','020@gmail.com','1','1','1');
insert into `agency` (`id`, `name`, `address`, `phone`, `email`, `about_us`, `mobile`, `web_site`) values('3','唛田','唛田地址','010-88898989','030@gmail.com','1','1','1');
insert into `agency` (`id`, `name`, `address`, `phone`, `email`, `about_us`, `mobile`, `web_site`) values('4','安聚客','安聚客地址','010-81898989','040@gmail.com','1','1','1');
