create database if not exists music;

use music;

drop table if exists record_label;
drop table if exists artists;
drop table if exists songs;
drop table if exists albums;


create table record_label(
id int(10) not null auto_increment,
label_name varchar(50) not null,
year_created varchar(4) not null,
primary key(id)
);

create table artists(
id int(10) not null auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
primary key(id)
);

create table songs(
id int(10) not null auto_increment,
song varchar(50) not null,
primary key(id)
);

create table albums(
id int(10) not null auto_increment,
title varchar(50) not null,
year_released int(4) not null,
label varchar(50) not null,
song_id int(10) not null,
artists_id int(10) not null,
record_label_id int(10) not null,
primary key (id),
foreign key (song_id) references songs(id),
foreign key (artists_id) references artists(id),
foreign key (record_label_id) references record_label(id)
);