drop table USER_ACCOUNT if exists;

create table USER_ACCOUNT ( userId int
                            , name varchar(20)
                            , emailId varchar(150)
                            , PRIMARY KEY (userId));
