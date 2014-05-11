
INSERT INTO role VALUES(1,"bao_super_admin",0);
INSERT INTO role VALUES(2,"bao_member",0);
INSERT INTO role VALUES(3,"bao_visitor",0);



INSERT INTO auth VALUES ( '1','web_auth_index');
INSERT INTO auth VALUES ( '2','web_auth_member_home');
INSERT INTO auth VALUES ( '3','web_auth_member_update');

INSERT INTO roleauth VALUES(1,1,1);
INSERT INTO roleauth VALUES(2,1,2);
INSERT INTO roleauth VALUES(3,1,3);
INSERT INTO roleauth VALUES(4,3,1);
INSERT INTO roleauth VALUES(5,7,1);



INSERT INTO `Member` (`id`,`name`,`password`,`update_time`,`sex`,`school_id`,`party_join_sum`,`photo`,`description`,`phone`,`points`,`reputation`,`success_sum`,`fail_sum`,`party_create_sum`,`major`,`email`,`create_time`,`roleid`) 
VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e','2014-03-20 01:22:43','女',1,0,'/resources/web/images/buy/lands-end.png',
'投资者','18610625648',0,0,0,0,0,'计算机科学与技术','admin@gmail.com','2014-03-16 23:28:03',1);





