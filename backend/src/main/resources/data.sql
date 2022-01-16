--fisherman
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted) values ('opiscopo0@storify.com', '186 Goodland Drive', 'Sendangagung', 'Oliver', 'Piscopo', '246-585-5287', 'Indonesia', false);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted) values ('lrymmer1@merriam-webster.com', '9 Summerview Hill', 'Masis', 'Leann', 'Rymmer', '496-617-2168', 'Armenia', false);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted) values ('rtownsend2@nba.com', '8 Northland Point', 'Sadao', 'Raimundo', 'Townsend', '469-987-4411', 'Thailand', false);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted) values ('bsallnow3@goo.ne.jp', '89 Dorton Avenue', 'As Sūq al Jadīd', 'Bondie', 'Sallnow', '559-858-1453', 'Yemen', false);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted) values ('taddy4@bbb.org', '4 Scofield Crossing', 'Ichnya', 'Travis', 'Addy', '858-402-4531', 'Ukraine', false);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted) values ('mgiottini5@51.la', '8 Upham Avenue', 'Shiojiri', 'Melisent', 'Giottini', '908-562-4535', 'Japan', false);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted) values ('ebeardmore6@netvibes.com', '84267 Vidon Road', 'Södertälje', 'Elianore', 'Beardmore', '322-513-0524', 'Sweden', false);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted) values ('kbotten7@foxnews.com', '63 Utah Terrace', 'Mafraq', 'Karrie', 'Botten', '342-822-7835', 'Jordan', false);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted) values ('cfleeming8@ucla.edu', '946 Glacier Hill Pass', 'Florentino Ameghino', 'Ced', 'Fleeming', '908-406-4991', 'Argentina', false);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted) values ('glodder9@last.fm', '5 Dorton Road', 'Fanzeres', 'Glen', 'Lodder', '255-182-5161', 'Portugal', false);








--admin
insert into admin (EMAIL, ADDRESS, CITY,STATE, NAME,  PHONE_NUM, SURNAME, deleted) values ('wvanmerwe3@ihg.com', 'Strum Strase', 'Wien', 'Austria', 'Ben', '536-385-333', 'Hellin', false);
insert into admin (EMAIL, ADDRESS, CITY, STATE, NAME,  PHONE_NUM, SURNAME, deleted) values ('wvanmerwe1@ihg.com', 'Pandor Strase', 'Wien', 'Austria', 'Bjorn', '536-222-333', 'Helow', false);




--boat
insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted, rating) values
('nelson@verizon.net', 'Eirena', 'Rumbold', '0 Village Place', 'Živinice', 'Bosnia and Herzegovina', '521-486-3914', false, 4.6);

insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating) values
 (1, 'Zlatibor', 'No smoking', true, 12, 'Beautiful and fast', 2, 152, 12.5, 45, 'Ursel', 'gliser',  'nelson@verizon.net', 45.0 , 4.56);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (1,'pet friendly', 5, 1);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (2,'minibar', 20, 1);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (3,'Capetain', 40, 1);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(1, '2021-08-26', '2022-01-01', 1);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(2, '2022-02-26', '2022-08-26', 1);
insert into boat_pics(boat_id,boat_pics) values(1, 'boat1.jpg');
insert into boat_pics(boat_id,boat_pics) values(1, 'boat2.jpg');
insert into boat_pics(boat_id,boat_pics) values(1, 'boat3.jpg');



insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (1, '2021-10-28T12:00:00', false, '2021-10-28T14:00:00', 3, 90, 1, 'opiscopo0@storify.com' , false, null, null, 10);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (2, '2021-10-29T10:00:00', false, '2021-10-29T14:00:00', 5, 150, 1, 'lrymmer1@merriam-webster.com' , true, '2021-10-17T14:00:00', '2021-10-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(2,1);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(2,2);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (3, '2021-12-28T12:00:00', false, '2021-12-28T14:00:00', 6, 50, 1, 'rtownsend2@nba.com', true, '2021-11-20T14:00:00', '2021-12-30T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(3,3);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (4, '2021-12-30T18:00:00', false, '2021-12-30T19:00:00', 4, 45, 1,'glodder9@last.fm' , false, null, null,10);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (5, '2021-12-26T12:00:00', false, '2021-12-26T14:00:00', 2,100 , 1, null, true, '2021-11-20T14:00:00', '2021-12-24T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(5,3);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (6, '2021-12-31T12:00:00', false, '2022-01-01T14:00:00', 10, 500, 1, null, true, '2021-11-17T14:00:00', '2022-01-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(6,3);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(6,2);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(6,1);

 insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating) values
 (2, 'Tara', 'No pets; No smoking; No parties', false, 15, 'Bit rusty but great', 3, 160, 15.5, 30, 'Kalina', 'ferry',  'nelson@verizon.net', 25.0 , 4.5);
 insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (4,'minibar', 20, 2);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (5,'Capetain', 40, 2);
 insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(3, '2021-08-26', '2022-01-01', 2);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(4, '2022-02-26', '2022-08-26', 2);
insert into boat_pics(boat_id,boat_pics) values(2, 'boat4.jpg');
insert into boat_pics(boat_id,boat_pics) values(2, 'boat5.jpg');
insert into boat_pics(boat_id,boat_pics) values(2, 'boat6.jpg');



insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (7, '2021-10-28T12:00:00', false, '2021-10-28T14:00:00', 4, 90, 2, 'glodder9@last.fm' , false, null, null, 10);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (8, '2021-10-29T10:00:00', false, '2021-10-29T14:00:00', 5, 135, 2, 'opiscopo0@storify.com' , true, '2021-10-17T14:00:00', '2021-10-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(2,1);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(2,2);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (9, '2021-12-28T12:00:00', false, '2021-12-28T14:00:00', 6, 50, 2, 'rtownsend2@nba.com', true, '2021-11-20T14:00:00', '2021-12-30T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(3,3);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (10, '2021-12-30T18:00:00', false, '2021-12-30T19:00:00', 4, 45, 2, 'lrymmer1@merriam-webster.com' , false, null, null,10);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (11, '2021-12-26T12:00:00', false, '2021-12-26T14:00:00', 2, 75 , 2, null, true, '2021-11-20T14:00:00', '2021-12-24T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(11,4);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (12, '2021-12-31T12:00:00', false, '2022-01-01T14:00:00', 10, 300, 2, 'opiscopo0@storify.com' , true, '2021-11-17T14:00:00', '2021-12-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(12,4);




insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted, rating) values
('jimtopo@cloudscredit.com', 'Tijana', 'Tasic', 'Ive Andrica 5', 'Beograd', 'Serbia', '511-486-6958', false, 4.8);

insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating) values
 (3, 'Beograd', 'Leave everything as clean as you have found it', true, 100, 'Big boat good for cruising', 2, 800, 50.5, 40, 'Biser', 'cluiser',  'jimtopo@cloudscredit.com', 200.0 , 4.9);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (6,'pet friendly', 5, 3);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (7,'minibar', 200, 3);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (8,'Capetain', 80, 3);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (9,'Wifi', 5, 3);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (10,'Food', 100, 3);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (11,'Fishing equipments', 50, 3);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (12,'Party Decorations', 10, 3);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (13,'Waiters', 100, 3);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (14,'Barman', 60, 3);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(5, '2021-08-26', '2022-01-01', 3);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(6, '2022-02-26', '2022-08-26', 3);
insert into boat_pics(boat_id,boat_pics) values(3, 'boat7.jpg');
insert into boat_pics(boat_id,boat_pics) values(3, 'boat8.jpg');
insert into boat_pics(boat_id,boat_pics) values(3, 'boat9.jpg');





insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (13, '2021-10-28T12:00:00', false, '2021-10-28T14:00:00', 50 , 485, 3, 'rtownsend2@nba.com' , false, null, null, 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(13,8);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(13,6);


insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (14, '2021-10-29T10:00:00', false, '2021-10-29T14:00:00', 100, 500, 3, 'glodder9@last.fm' , true, '2021-10-17T14:00:00', '2021-10-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,6);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,11);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,7);




insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (15, '2021-12-28T12:00:00', false, '2021-12-28T14:00:00', 80, 400, 3, 'opiscopo0@storify.com', true, '2021-11-20T14:00:00', '2021-12-30T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,8);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,9);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,14);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (17, '2021-12-26T12:00:00', false, '2021-12-26T14:00:00', 100, 800 , 3, null, true, '2021-11-20T14:00:00', '2021-12-24T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,6);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,7);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,8);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,9);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,11);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,12);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (18, '2021-12-31T12:00:00', false, '2022-01-01T14:00:00', 100, 1500, 3, null, true, '2021-11-17T14:00:00', '2021-12-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,6);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,7);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,11);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,12);


insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted, rating) values
('xjpzll@littlefarmhouserecipes.com', 'Rudolf', 'Rashord', 'Bolfost Road 5', 'Manchester', 'UK', '521-001-0258', false, 4.7);

insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating) values
 (4, 'Zlatibor', 'Life jackets neccessary', true, 5, 'Slow but very good at this terain', 7, 60, 10, 30, 'Taniel', 'gliser',  'xjpzll@littlefarmhouserecipes.com', 30.0 , 4.42);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (15,'Snorkel masks', 5, 4);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (16,'Food', 15, 4);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (17,'Capetain', 20, 4);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(7, '2021-08-26', '2022-01-01', 4);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(8, '2022-02-26', '2022-08-26', 4);
insert into boat_pics(boat_id,boat_pics) values(4, 'boat10.jpg');
insert into boat_pics(boat_id,boat_pics) values(4, 'boat11.jpg');
insert into boat_pics(boat_id,boat_pics) values(4, 'boat12.jpg');




insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (19, '2021-10-28T12:00:00', false, '2021-10-28T14:00:00', 3, 60, 4, 'glodder9@last.fm' , false, null, null, 10);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (20, '2021-10-29T10:00:00', false, '2021-10-29T14:00:00', 5, 60, 4, 'rtownsend2@nba.com', true, '2021-10-17T14:00:00', '2021-10-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(20,15);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(20,16);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (21, '2021-12-28T12:00:00', false, '2021-12-28T14:00:00', 5, 50, 4,'lrymmer1@merriam-webster.com' , true, '2021-11-20T14:00:00', '2021-12-30T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,17);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (22, '2021-12-30T18:00:00', false, '2021-12-30T19:00:00', 4, 45, 4, 'cfleeming8@ucla.edu', false, null, null,10);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (23, '2021-12-26T12:00:00', false, '2021-12-26T14:00:00', 2,40 , 4, null, true, '2021-11-20T14:00:00', '2021-12-24T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,16);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (24, '2021-12-31T12:00:00', false, '2022-01-01T14:00:00', 5, 100, 4, null, true, '2021-11-17T14:00:00', '2021-12-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,17);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,16);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,15);

 insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating) values
 (5, 'Tara', 'No pets', false, 8, 'Fast and adaptable', 5, 120, 10.5, 60, 'Olosisk', 'Dinghy',  'xjpzll@littlefarmhouserecipes.com', 28.0 , 4.8);
 insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (18,'Railings', 10, 5);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (19,'Navigation lights', 6, 5);
 insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(9, '2021-08-26', '2022-01-01', 5);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(10, '2022-02-26', '2022-08-26', 5);
insert into boat_pics(boat_id,boat_pics) values(5, 'boat13.jpg');
insert into boat_pics(boat_id,boat_pics) values(5, 'boat14.jpg');
insert into boat_pics(boat_id,boat_pics) values(5, 'boat15.jpg');





insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (25, '2021-10-28T12:00:00', false, '2021-10-28T14:00:00', 4, 56, 5, 'rtownsend2@nba.com' , false, null, null, 10);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (26, '2021-10-29T10:00:00', false, '2021-10-29T14:00:00', 5, 90, 5,'glodder9@last.fm' , true, '2021-10-17T14:00:00', '2021-10-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(26,18);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(26,19);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (27, '2021-12-28T12:00:00', false, '2021-12-28T14:00:00', 6, 45, 5, 'cfleeming8@ucla.edu', true, '2021-11-20T14:00:00', '2021-12-30T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,18);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (28, '2021-12-30T18:00:00', false, '2021-12-30T19:00:00', 4, 20, 5, 'opiscopo0@storify.com' , false, null, null,10);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (29, '2021-12-26T12:00:00', false, '2021-12-26T14:00:00', 2, 50 , 5, null, true, '2021-11-20T14:00:00', '2021-12-24T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(29,19);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (30, '2021-12-31T12:00:00', false, '2022-01-01T14:00:00', 8, 80, 5,'lrymmer1@merriam-webster.com'  , true, '2021-11-17T14:00:00', '2021-12-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(30,18);




insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted, rating) values
('sowsowabdel@bookj.site', 'Tamara', 'Tadic', 'Nikole Pasica 5', 'Beograd', 'Serbia', '502-658-7854', false, 4.4);

insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating) values
 (6, 'Beograd', 'Clean everything; No jumping off', true, 90, 'Good for cruising for families', 3, 750, 48.5, 38, 'Oktabas', 'cluiser',  'sowsowabdel@bookj.site', 150.0 , 4.8);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (20,'pet friendly', 5, 6);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (21,'minibar', 200, 6);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (22,'Capetain', 80, 6);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (23,'Wifi', 5, 6);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (24,'Food', 100, 6);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (25,'Fishing equipments', 50, 6);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (26,'Party Decorations', 10, 6);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (27,'Waiters', 100, 6);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (28,'Barman', 60, 6);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(11, '2021-08-26', '2022-01-01', 6);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(12, '2022-02-26', '2022-08-26', 6);

insert into boat_pics(boat_id,boat_pics) values(6, 'boat16.jpg');
insert into boat_pics(boat_id,boat_pics) values(6, 'boat17.jpg');
insert into boat_pics(boat_id,boat_pics) values(6, 'boat18.jpg');




insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (31, '2021-10-28T12:00:00', false, '2021-10-28T14:00:00', 50 , 400, 6, 'kbotten7@foxnews.com' , false, null, null, 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(31,20);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(31,22);


insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (32, '2021-10-29T10:00:00', false, '2021-10-29T14:00:00', 90, 500, 6, 'ebeardmore6@netvibes.com' , true, '2021-10-17T14:00:00', '2021-10-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(32,20);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(32,21);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(32,22);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(32,23);




insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (33, '2021-12-28T12:00:00', false, '2021-12-28T14:00:00', 80, 350, 6, 'taddy4@bbb.org', true, '2021-11-20T14:00:00', '2021-12-30T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(33,20);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(33,22);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(33,28);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (34, '2021-12-26T12:00:00', false, '2021-12-26T14:00:00', 90, 500 , 6, 'opiscopo0@storify.com', true, '2021-11-20T14:00:00', '2021-12-24T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,20);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,21);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,22);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,23);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,24);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,25);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,26);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (35, '2021-12-31T12:00:00', false, '2022-01-01T14:00:00', 90, 1300, 6, null, true, '2021-11-17T14:00:00', '2021-12-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(35,22);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(35,23);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(35,24);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(35,25);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(35,26);

--cottage

insert into cottage_owner (email, name, surname, address, city, state, phone_num, deleted, rating) values ('acretney7@businessinsider.com', 'Antin', 'Vuitton', '8 Mayfield Road', 'Hīsh', 'Syria', '627-651-4290', false, 4.2);
insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL, GUESTS_NUM, price, rating) values
 (1, 'Zlatibor', 'No smoking', 'Lovely cottage', 'Zlatni bor', 2, 'acretney7@businessinsider.com', 5 , 45.0, 4.1);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (1,'WiFi', 3, 1);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (2,'Parking', 5, 1);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (3,'Breakfast', 6, 1);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (4,'Baby crib', 3, 1);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (5,'Cleaning', 10, 1);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (6,'Tour day', 15, 1);
 insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(1, '2021-08-26', '2022-01-01', 1);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(2, '2022-02-26', '2022-08-26', 1);

insert into cottage_pics(cottage_id,cottage_pics) values(1, 'cottage1.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(1, 'cottage2.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(1, 'cottage3.jpg');



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (1, '2021-10-22T12:00:00', false, '2021-10-28T14:00:00', 5, 220, 1,'bsallnow3@goo.ne.jp', true, '2021-10-19T14:00:00','2021-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(1,1);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(1,2);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (2, '2021-10-29T12:00:00', false, '2021-11-06T14:00:00', 4, 250, 1, 'rtownsend2@nba.com', true, '2021-10-19T14:00:00','2021-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(2,3);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(2,2);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (3, '2021-12-22T12:00:00', false, '2021-12-24T14:00:00', 5, 100, 1,'lrymmer1@merriam-webster.com' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(3,3);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(3,2);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(3,1);



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (4, '2021-12-25T12:00:00', false, '2021-12-29T14:00:00', 4, 190, 1, 'opiscopo0@storify.com' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,1);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,2);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,3);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,4);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,5);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,6);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (5, '2021-12-30T12:00:00', false, '2022-01-05T14:00:00', 3, 250, 1, null , true, '2021-11-19T14:00:00','2021-12-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(5,3);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(5,5);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(5,1);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (6, '2022-02-28T12:00:00', false, '2021-03-04T14:00:00', 5, 300, 1, null , true, '2021-11-19T14:00:00','2022-01-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(6,1);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(6,2);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(6,5);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(6,6);

insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL, GUESTS_NUM, price, rating) values
 (2, 'Zlatibor', 'No parties', 'Cottage made for couples', 'Beli bor', 1, 'acretney7@businessinsider.com', 2 , 25.0, 4.65);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (7,'WiFi', 3, 2);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (8,'Parking', 5, 2);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (9,'Breakfast', 6, 2);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (10,'Baby crib', 3, 2);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (11,'Cleaning', 10, 2);
 insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(3, '2021-08-26', '2022-01-01', 2);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(4, '2022-02-26', '2022-08-26', 2);
insert into cottage_pics(cottage_id,cottage_pics) values(2, 'cottage4.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(2, 'cottage5.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(2, 'cottage6.jpg');




insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (7, '2021-10-22T12:00:00', false, '2021-10-28T14:00:00', 2, 150, 2,'kbotten7@foxnews.com', true, '2021-10-19T14:00:00','2021-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(7,7);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(7,9);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (8, '2021-10-29T12:00:00', false, '2021-11-06T14:00:00', 2, 150, 2, 'ebeardmore6@netvibes.com', true, '2021-10-19T14:00:00','2021-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(8,8);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(8,10);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (9, '2021-12-22T12:00:00', false, '2021-12-24T14:00:00', 2, 65, 2,'lrymmer1@merriam-webster.com' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(9,9);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(9,10);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(9,11);



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (10, '2021-12-25T12:00:00', false, '2021-12-29T14:00:00', 2, 127, 2, 'taddy4@bbb.org' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(10,7);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(10,8);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(10,9);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(10,10);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(10,11);


insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (11, '2021-12-30T12:00:00', false, '2022-01-05T14:00:00', 2, 130, 2, null , true, '2021-11-19T14:00:00','2021-12-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(11,7);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(11,8);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(11,9);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (12, '2022-01-22T12:00:00', false, '2021-01-30T14:00:00', 2, 180, 2, 'glodder9@last.fm' , true, '2021-11-19T14:00:00','2022-01-19T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(12,8);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(12,9);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(12,10);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(12,11);



insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL, GUESTS_NUM, price, rating) values
 (3, 'Zlatibor', 'No smoking', 'Healthy lifestyle', 'Dvorana', 4, 'acretney7@businessinsider.com', 12 , 80.0, 4.78);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (12,'WiFi', 3, 3);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (13,'Parking', 5, 3);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (14,'Breakfast', 6, 3);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (15,'Baby crib', 3, 3);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (16,'Cleaning', 10, 3);
  insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (17,'Minibar', 50, 3);
 insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(5, '2021-08-26', '2022-01-01', 3);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(6, '2022-02-26', '2022-08-26', 3);

insert into cottage_pics(cottage_id,cottage_pics) values(3, 'cottage7.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(3, 'cottage8.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(3, 'cottage9.jpg');



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (13, '2021-10-22T12:00:00', false, '2021-10-28T14:00:00', 10, 450, 2,'taddy4@bbb.org', true, '2021-10-19T14:00:00','2021-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(13,12);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(13,13);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (14, '2021-10-29T12:00:00', false, '2021-11-06T14:00:00', 12, 550, 2, 'cfleeming8@ucla.edu', true, '2021-10-19T14:00:00','2021-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,15);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,16);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (15, '2021-12-22T12:00:00', false, '2021-12-24T14:00:00', 11, 170, 2,'mgiottini5@51.la' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,15);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,14);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,13);



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (16, '2021-12-25T12:00:00', false, '2021-12-29T14:00:00', 10, 370, 2, 'bsallnow3@goo.ne.jp' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(16,12);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(16,13);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(16,14);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(16,15);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(16,16);


insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (17, '2021-12-30T12:00:00', false, '2022-01-05T14:00:00', 12, 450, 2, 'lrymmer1@merriam-webster.com' , true, '2021-11-19T14:00:00','2021-12-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,17);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,16);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,15);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (18, '2022-01-22T12:00:00', false, '2021-01-30T14:00:00', 12, 600, 2, null , true, '2021-11-19T14:00:00','2022-01-19T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,14);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,13);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,15);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,16);

insert into cottage_owner (email, name, surname, address, city, state, phone_num, deleted, rating)
values ('bobacott@codw.site', 'Bob', 'Cottag', 'Liversville 16', 'Brisbane', 'UK', '256-958-6853', false, 4.36);
insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL, GUESTS_NUM, price, rating) values
 (4, 'Zlatibor', 'No noise', 'Cottage secluded from town noise', 'Capiljica', 4, 'bobacott@codw.site', 8 , 90.0, 4.8);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (18,'WiFi', 3, 4);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (19,'Parking', 5, 4);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (20,'Breakfast', 6, 4);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (21,'Baby crib', 3, 4);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (22,'Cleaning', 10, 4);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (23,'Tour day', 15, 4);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (24,'2 bathrooms', 20, 4);
 insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(7, '2021-08-26', '2022-01-01', 4);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(8, '2022-02-26', '2022-08-26', 4);
insert into cottage_pics(cottage_id,cottage_pics) values(4, 'cottage10.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(4, 'cottage11.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(4, 'cottage12.jpg');


insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (19, '2021-10-22T12:00:00', false, '2021-10-28T14:00:00', 8, 500, 4,'mgiottini5@51.la', true, '2021-10-19T14:00:00','2021-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(19,18);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(19,20);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (20, '2021-10-29T12:00:00', false, '2021-11-06T14:00:00', 6, 600, 4, 'cfleeming8@ucla.edu', true, '2021-10-19T14:00:00','2021-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(20,23);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(20,24);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (21, '2021-12-22T12:00:00', false, '2021-12-24T14:00:00', 7, 203, 4,'opiscopo0@storify.com' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,23);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,21);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,19);



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (22, '2021-12-25T12:00:00', false, '2021-12-29T14:00:00', 6, 412,4, 'glodder9@last.fm' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,19);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,20);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,23);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,24);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,18);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,21);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (23, '2021-12-30T12:00:00', false, '2022-01-05T14:00:00', 8, 520, 4, null , true, '2021-11-19T14:00:00','2021-12-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,23);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,18);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,19);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (24, '2022-01-22T12:00:00', false, '2021-01-30T14:00:00', 8, 650, 4, null , true, '2021-11-19T14:00:00','2022-01-19T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,19);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,20);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,22);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,23);








 
---adventure

insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted, rating) values ('Leticia', 'Gorch', 'lgorch3@cnn.com', '7 Cambridge Lane', 'Ternovka', 'Russia', '340-956-7178', 'I never participated in any competitions but I am the best', false, 4.5);
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price) values
(1, 'Djetinja', 'Never return the fish', true, 'We start from city beach', 6, 'Riverfish', 'lgorch3@cnn.com', 10.0);
 insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (1,'Boat, Fishing ofshore', 15, 1);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (2,'Transport to destination', 10, 1);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(1, '2021-08-26', '2022-01-01',1 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(2, '2022-02-26', '2022-08-26', 1);
insert into adventure_pics(adventure_id,adventure_pics) values(1, 'fishing1.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(1, 'fishing2.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(1, 'fishing3.jpg');

insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (1, '2021-12-31T12:00:00', false, '2022-01-01T14:00:00', 10, 500, 1, 'opiscopo0@storify.com', true, '2021-11-17T14:00:00', '2022-01-25T14:00:00',10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(1,1);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(1,2);


insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price) values
(2, 'Zaovine', 'Carry bear protection', false, 'Fishing only for catfish', 2, 'BearsInTrap', 'lgorch3@cnn.com', 9.0);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(3, '2021-08-26', '2022-01-01',2 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(4, '2022-02-26', '2022-08-26', 2);
insert into adventure_pics(adventure_id,adventure_pics) values(2, 'fishing4.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(2, 'fishing5.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(2, 'fishing6.jpg');

insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted, rating) values ('Ursula', 'Lago', 'ulago4@vimeo.com', '70075 Dwight Center', 'Rabat', 'Morocco', '110-752-9868', 'My grandfather gave me the love for fishing', false, 4.2);
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price) values
(3, 'Uvac', 'ALways return the fish', false, 'We start from sjenicko jezero and continue towards peak', 5, 'Beloglavi supovi', 'ulago4@vimeo.com', 5.0);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(5, '2021-08-26', '2022-01-01',3 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(6, '2022-02-26', '2022-08-26', 3);
insert into adventure_pics(adventure_id,adventure_pics) values(3, 'fishing7.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(3, 'fishing8.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(3, 'fishing9.jpg');



--additional

insert into revenue_item(revenue_id, reservation_id, res_type, percentage_active, fisherman_price, revenue)
values (1, 1, 'BOAT', 10, 90, 9);



INSERT INTO roles(name) VALUES('FISHERMAN');
INSERT INTO roles(name) VALUES('SYS_ADMIN');
INSERT INTO roles(name) VALUES('COTTAGE_OWNER');
INSERT INTO roles(name) VALUES('BOAT_OWNER');
INSERT INTO roles(name) VALUES('INSTRUCTOR');



insert into USERS (user_id, username, password, enabled, deleted, verification_code, FIRST_LOGIN) values (1, 'opiscopo0@storify.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (2, 'lrymmer1@merriam-webster.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (3, 'rtownsend2@nba.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (4, 'bsallnow3@goo.ne.jp', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (5, 'taddy4@bbb.org', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (6, 'mgiottini5@51.la', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (7, 'ebeardmore6@netvibes.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (8, 'kbotten7@foxnews.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (9, 'cfleeming8@ucla.edu', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (10, 'glodder9@last.fm', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (11, 'wvanmerwe3@ihg.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (12, 'wvanmerwe1@ihg.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (13, 'nelson@verizon.net', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (14, 'jimtopo@cloudscredit.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (15, 'xjpzll@littlefarmhouserecipes.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (16, 'sowsowabdel@bookj.site', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (17, 'acretney7@businessinsider.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (18, 'bobacott@codw.site', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (19, 'lgorch3@cnn.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (20, 'ulago4@vimeo.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);



insert into USER_ROLES(user_id, role_id) values(1, 1);
insert into USER_ROLES(user_id, role_id) values(2, 1);
insert into USER_ROLES(user_id, role_id) values(3, 1);
insert into USER_ROLES(user_id, role_id) values(4, 1);
insert into USER_ROLES(user_id, role_id) values(5, 1);
insert into USER_ROLES(user_id, role_id) values(6, 1);
insert into USER_ROLES(user_id, role_id) values(7, 1);
insert into USER_ROLES(user_id, role_id) values(8, 1);
insert into USER_ROLES(user_id, role_id) values(9, 1);
insert into USER_ROLES(user_id, role_id) values(10, 1);
insert into USER_ROLES(user_id, role_id) values(11, 2);
insert into USER_ROLES(user_id, role_id) values(12, 2);
insert into USER_ROLES(user_id, role_id) values(13, 4);
insert into USER_ROLES(user_id, role_id) values(14, 4);
insert into USER_ROLES(user_id, role_id) values(15, 4);
insert into USER_ROLES(user_id, role_id) values(16, 4);
insert into USER_ROLES(user_id, role_id) values(17, 3);
insert into USER_ROLES(user_id, role_id) values(18, 3);
insert into USER_ROLES(user_id, role_id) values(19, 5);
insert into USER_ROLES(user_id, role_id) values(20, 5);

