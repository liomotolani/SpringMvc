drop user if exists 'springdemouser'@'localhost';

create user 'springdemouser'@'localhost' identified by 'spring_Demo';

drop database if exists springdemodb;

create database springdemodb;

use springdemodb;

grant all privileges on springdemodb.* to 'springdemouser'@'localhost';

flush privileges;