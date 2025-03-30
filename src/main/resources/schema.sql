create table calc_history (
id integer not null AUTO_INCREMENT,
expression varchar(30), calculated_time varchar(50),
error_msg varchar(50), result double ,primary key(id)
);


