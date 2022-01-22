--fisherman
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted, penalties) values ('opiscopo0@storify.com', '186 Goodland Drive', 'Sendangagung', 'Oliver', 'Piscopo', '246-585-5287', 'Indonesia', false,1);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted, penalties) values ('lrymmer1@merriam-webster.com', '9 Summerview Hill', 'Masis', 'Leann', 'Rymmer', '496-617-2168', 'Armenia', false,1);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted, penalties) values ('rtownsend2@nba.com', '8 Northland Point', 'Sadao', 'Raimundo', 'Townsend', '469-987-4411', 'Thailand', false,2);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted, penalties) values ('bsallnow3@goo.ne.jp', '89 Dorton Avenue', 'As Sūq al Jadīd', 'Bondie', 'Sallnow', '559-858-1453', 'Yemen', false,2);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted, penalties) values ('taddy4@bbb.org', '4 Scofield Crossing', 'Ichnya', 'Travis', 'Addy', '858-402-4531', 'Ukraine', false,2);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted, penalties) values ('mgiottini5@51.la', '8 Upham Avenue', 'Shiojiri', 'Melisent', 'Giottini', '908-562-4535', 'Japan', false,2);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted, penalties) values ('ebeardmore6@netvibes.com', '84267 Vidon Road', 'Södertälje', 'Elianore', 'Beardmore', '322-513-0524', 'Sweden', false,1);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted, penalties) values ('kbotten7@foxnews.com', '63 Utah Terrace', 'Mafraq', 'Karrie', 'Botten', '342-822-7835', 'Jordan', false,1);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted, penalties) values ('cfleeming8@ucla.edu', '946 Glacier Hill Pass', 'Florentino Ameghino', 'Ced', 'Fleeming', '908-406-4991', 'Argentina', false,1);
insert into FISHERMAN (email, address, city, name, surname, phone_num, state, deleted, penalties) values ('glodder9@last.fm', '5 Dorton Road', 'Fanzeres', 'Glen', 'Lodder', '255-182-5161', 'Portugal', false,1);








--admin
insert into admin (EMAIL, ADDRESS, CITY,STATE, NAME,  PHONE_NUM, SURNAME, deleted) values ('wvanmerwe3@ihg.com', 'Strum Strase', 'Wien', 'Austria', 'Ben', '536-385-333', 'Hellin', false);
insert into admin (EMAIL, ADDRESS, CITY, STATE, NAME,  PHONE_NUM, SURNAME, deleted) values ('wvanmerwe1@ihg.com', 'Pandor Strase', 'Wien', 'Austria', 'Bjorn', '536-222-333', 'Helow', false);




--boat
insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted, rating) values
('nelson@verizon.net', 'Eirena', 'Rumbold', '0 Village Place', 'Živinice', 'Bosnia and Herzegovina', '521-486-3914', false, 4.6);

insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating, navigation_tool, equipment) values
 (1, 'Zlatibor', 'No smoking', true, 12, 'Beautiful and fast', 2, 152, 12.5, 45, 'Ursel', 'gliser',  'nelson@verizon.net', 45.0 , 4.56, 'FISHFINDER', 'fishing rod, fishnet, lures, floats, fly fishing equipment');
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (1,'pet friendly', 5, 1);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (2,'minibar', 20, 1);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (3,'Capetain', 40, 1);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(1, '2021-08-26', '2022-04-01', 1);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(2, '2022-04-26', '2023-01-26', 1);
insert into boat_pics(boat_id,boat_pics) values(1, 'boat1.jpg');
insert into boat_pics(boat_id,boat_pics) values(1, 'boat2.jpg');
insert into boat_pics(boat_id,boat_pics) values(1, 'boat3.jpg');



insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (1, '2021-11-28T12:00:00', false, '2021-11-28T14:00:00', 3, 90, 1, 'opiscopo0@storify.com' , false, null, null, 10);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (2, '2021-09-29T10:00:00', false, '2021-09-29T14:00:00', 5, 160, 1, 'lrymmer1@merriam-webster.com' , true, '2021-08-17T14:00:00', '2021-08-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(2,1);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(2,2);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (3, '2022-12-28T12:00:00', false, '2022-12-28T14:00:00', 6, 90, 1, 'rtownsend2@nba.com', true, '2021-11-20T14:00:00', '2021-12-01T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(3,3);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (4, '2022-12-28T18:00:00', false, '2022-12-28T19:00:00', 4, 45, 1,'glodder9@last.fm' , false, null, null,10);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (5, '2022-08-25T12:00:00', false, '2022-08-25T14:00:00', 2,90 , 1, null, true, '2021-11-20T14:00:00', '2022-12-24T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(5,3);
--- opiscopo0@storify.com future koja moze 
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (6, '2022-02-25T12:00:00', false, '2022-02-25T14:00:00', 10, 90, 1, 'opiscopo0@storify.com', true, '2021-11-17T14:00:00', '2022-02-20T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(6,3);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(6,2);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(6,1);

 insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating, navigation_tool, equipment) values
 (2, 'Tara', 'No pets; No smoking; No parties', false, 15, 'Bit rusty but great', 3, 160, 15.5, 30, 'Kalina', 'ferry',  'nelson@verizon.net', 25.0 , 4.5, 'RADAR', '');
 insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (4,'minibar', 20, 2);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (5,'Capetain', 40, 2);
 insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(3, '2021-08-26', '2022-04-01', 2);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(4, '2022-04-26', '2023-01-26', 2);
insert into boat_pics(boat_id,boat_pics) values(2, 'boat4.jpg');
insert into boat_pics(boat_id,boat_pics) values(2, 'boat5.jpg');
insert into boat_pics(boat_id,boat_pics) values(2, 'boat6.jpg');



insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (7, '2022-10-28T12:00:00', false, '2022-10-28T14:00:00', 4, 50, 2, 'glodder9@last.fm' , false, null, null, 10);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (8, '2022-10-29T10:00:00', false, '2022-10-29T14:00:00', 5, 100, 2, 'opiscopo0@storify.com' , true, '2021-10-17T14:00:00', '2021-10-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(7,4);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(7,5);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (9, '2022-12-24T12:00:00', false, '2022-12-24T14:00:00', 6, 50, 2, 'rtownsend2@nba.com', true, '2022-11-20T14:00:00', '2022-12-20T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(8,4);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (10, '2021-12-30T18:00:00', false, '2021-12-30T19:00:00', 4, 45, 2, 'lrymmer1@merriam-webster.com' , false, null, null,10);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (11, '2022-08-22T12:00:00', false, '2022-08-22T14:00:00', 2, 50 , 2, null, true, '2021-11-20T14:00:00', '2022-12-20T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(11,4);
--- opiscopo future koja ne moze
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (12, '2022-01-30T12:00:00', false, '2022-02-02T14:00:00', 10, 50, 2, 'opiscopo0@storify.com' , true, '2021-11-17T14:00:00', '2021-12-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(12,4);




insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted, rating) values
('jimtopo@cloudscredit.com', 'Tijana', 'Tasic', 'Ive Andrica 5', 'Beograd', 'Serbia', '511-486-6958', false, 4.8);

insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating, navigation_tool, equipment) values
 (3, 'Beograd', 'Leave everything as clean as you have found it', true, 100, 'Big boat good for cruising', 2, 800, 50.5, 40, 'Biser', 'cluiser',  'jimtopo@cloudscredit.com', 200.0 , 4.9, 'RADAR', 'fishing rod, fishnet, lures, floats, fly fishing equipment');
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
(5, '2021-08-26', '2022-05-01', 3);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(6, '2022-05-26', '2023-01-26', 3);
insert into boat_pics(boat_id,boat_pics) values(3, 'boat7.jpg');
insert into boat_pics(boat_id,boat_pics) values(3, 'boat8.jpg');
insert into boat_pics(boat_id,boat_pics) values(3, 'boat9.jpg');





insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (13, '2022-07-28T12:00:00', false, '2022-07-28T14:00:00', 50 , 485, 3, 'rtownsend2@nba.com' , false, null, null, 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(13,8);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(13,6);


insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (14, '2022-10-29T10:00:00', false, '2022-10-29T14:00:00', 100, 800, 3, 'glodder9@last.fm' , true, '2021-10-17T14:00:00', '2022-10-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,6);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,11);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,7);



--- opiscopo future koja moze
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (15, '2022-04-28T12:00:00', false, '2022-04-30T14:00:00', 80, 400, 3, 'opiscopo0@storify.com', true, '2021-11-20T14:00:00', '2022-03-30T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,8);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,9);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,14);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (17, '2022-03-26T12:00:00', false, '2022-03-26T14:00:00', 100, 400 , 3, null, true, '2021-11-20T14:00:00', '2022-02-24T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,6);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,7);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,8);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,9);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,11);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,12);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (18, '2022-12-31T12:00:00', false, '2022-12-31T14:00:00', 100, 400, 3, null, true, '2021-11-17T14:00:00', '2022-12-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,6);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,7);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,11);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(18,12);


insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted, rating) values
('xjpzll@littlefarmhouserecipes.com', 'Rudolf', 'Rashord', 'Bolfost Road 5', 'Manchester', 'UK', '521-001-0258', false, 4.7);

insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating, navigation_tool, equipment) values
 (4, 'Zlatibor', 'Life jackets neccessary', true, 5, 'Slow but very good at this terain', 7, 60, 10, 30, 'Taniel', 'gliser',  'xjpzll@littlefarmhouserecipes.com', 30.0 , 4.42, 'GPS', '');
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (15,'Snorkel masks', 5, 4);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (16,'Food', 15, 4);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (17,'Capetain', 20, 4);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(7, '2021-08-26', '2022-04-01', 4);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(8, '2022-04-26', '2023-01-26', 4);
insert into boat_pics(boat_id,boat_pics) values(4, 'boat10.jpg');
insert into boat_pics(boat_id,boat_pics) values(4, 'boat11.jpg');
insert into boat_pics(boat_id,boat_pics) values(4, 'boat12.jpg');




insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (19, '2022-10-08T12:00:00', false, '2022-10-08T14:00:00', 3, 60, 4, 'glodder9@last.fm' , false, null, null, 10);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (20, '2022-10-10T10:00:00', false, '2022-10-10T14:00:00', 5, 120, 4, 'rtownsend2@nba.com', true, '2021-10-17T14:00:00', '2022-10-02T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(20,15);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(20,16);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (21, '2021-12-28T12:00:00', false, '2021-12-28T14:00:00', 5, 60, 4,'lrymmer1@merriam-webster.com' , true, '2021-11-20T14:00:00', '2021-12-30T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,17);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (22, '2022-02-26T18:00:00', false, '2022-02-26T19:00:00', 4, 30, 4, 'cfleeming8@ucla.edu', false, null, null,10);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (23, '2022-12-26T12:00:00', false, '2022-12-26T14:00:00', 2,60 , 4, null, true, '2021-11-20T14:00:00', '2022-12-24T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,16);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (24, '2022-12-31T12:00:00', false, '2022-12-31T16:00:00', 5, 120, 4, null, true, '2021-11-17T14:00:00', '2022-12-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,17);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,16);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,15);

 insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating, navigation_tool, equipment) values
 (5, 'Tara', 'No pets', false, 8, 'Fast and adaptable', 5, 120, 10.5, 60, 'Olosisk', 'Dinghy',  'xjpzll@littlefarmhouserecipes.com', 20.0 , 4.8, 'GPS', 'fishing rod, fishnet, lures, floats, fly fishing equipment');
 insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (18,'Railings', 10, 5);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (19,'Navigation lights', 6, 5);
 insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(9, '2021-08-26', '2022-04-01', 5);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(10, '2022-04-26', '2023-01-26', 5);
insert into boat_pics(boat_id,boat_pics) values(5, 'boat13.jpg');
insert into boat_pics(boat_id,boat_pics) values(5, 'boat14.jpg');
insert into boat_pics(boat_id,boat_pics) values(5, 'boat15.jpg');





insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (25, '2022-06-28T12:00:00', false, '2022-06-28T14:00:00', 4, 40, 5, 'rtownsend2@nba.com' , false, null, null, 10);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (26, '2022-10-27T10:00:00', false, '2022-10-27T14:00:00', 5, 80, 5,'glodder9@last.fm' , true, '2021-10-17T14:00:00', '2022-10-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(26,18);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(26,19);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (27, '2022-12-22T12:00:00', false, '2022-12-22T14:00:00', 6, 40, 5, 'cfleeming8@ucla.edu', true, '2021-11-20T14:00:00', '2022-12-20T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,18);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (28, '2021-12-30T18:00:00', false, '2021-12-30T19:00:00', 4, 20, 5, 'opiscopo0@storify.com' , false, null, null,10);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (29, '2022-03-26T12:00:00', false, '2022-03-26T14:00:00', 2, 40 , 5, null, true, '2021-11-20T14:00:00', '2022-02-24T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(29,19);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (30, '2021-12-31T12:00:00', false, '2022-01-01T14:00:00', 8, 40, 5,'lrymmer1@merriam-webster.com'  , true, '2021-11-17T14:00:00', '2021-12-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(30,18);




insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted, rating) values
('sowsowabdel@bookj.site', 'Tamara', 'Tadic', 'Nikole Pasica 5', 'Beograd', 'Serbia', '502-658-7854', false, 4.4);

insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating, navigation_tool, equipment) values
 (6, 'Beograd', 'Clean everything; No jumping off', true, 90, 'Good for cruising for families', 3, 750, 48.5, 38, 'Oktabas', 'cluiser',  'sowsowabdel@bookj.site', 150.0 , 4.8, 'GPS', '');
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
(11, '2021-08-26', '2022-04-01', 6);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(12, '2022-04-26', '2023-01-26', 6);

insert into boat_pics(boat_id,boat_pics) values(6, 'boat16.jpg');
insert into boat_pics(boat_id,boat_pics) values(6, 'boat17.jpg');
insert into boat_pics(boat_id,boat_pics) values(6, 'boat18.jpg');




insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (31, '2022-10-28T17:00:00', false, '2022-10-28T19:00:00', 50 , 385, 6, 'kbotten7@foxnews.com' , false, null, null, 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(31,20);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(31,22);


insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (32, '2022-10-29T14:00:00', false, '2022-10-29T15:00:00', 90, 150, 6, 'ebeardmore6@netvibes.com' , true, '2021-10-17T14:00:00', '2022-10-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(32,20);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(32,21);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(32,22);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(32,23);




insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (33, '2022-12-28T10:00:00', false, '2022-12-28T14:00:00', 80, 600, 6, 'taddy4@bbb.org', true, '2021-11-20T14:00:00', '2022-11-30T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(33,20);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(33,22);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(33,28);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (34, '2021-12-26T12:00:00', false, '2021-12-26T14:00:00', 90, 300 , 6, 'opiscopo0@storify.com', true, '2021-11-20T14:00:00', '2021-12-24T15:00:00', 10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,20);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,21);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,22);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,23);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,24);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,25);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,26);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (35, '2022-03-24T12:00:00', false, '2022-03-24T14:00:00', 90, 300, 6, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(35,22);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(35,23);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(35,24);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(35,25);
insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(35,26);





insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted, rating) values
('tadica@bookj.site', 'Lenka', 'Tusil', 'Nikole Stankovica 6', 'Beograd', 'Serbia', '542-555-5656', false, 4.68);
--nijedna buduca
insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating, navigation_tool, equipment) values
 (7, 'Beograd', 'No loud music; No jumping off', true, 50, 'Beautiful Titanic vibe', 2, 500, 44.5, 39, 'Manchester Eye', 'cluiser',  'tadica@bookj.site', 90.0 , 4.88, 'GPS', '');
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (29,'minibar', 200, 7);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (30,'Capetain', 80, 7);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (31,'Wifi', 5, 7);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (32,'Food', 100, 7);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (33,'Fishing equipments', 50, 7);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (34,'Waiters', 100, 7);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(13, '2021-08-26', '2022-01-01', 7);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(14, '2022-02-26', '2022-09-26', 7);

insert into boat_pics(boat_id,boat_pics) values(7, 'boat1.jpg');
insert into boat_pics(boat_id,boat_pics) values(7, 'boat7.jpg');
insert into boat_pics(boat_id,boat_pics) values(7, 'boat8.jpg');




 insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL, price, rating, navigation_tool, equipment) values
 (8, 'Tara', 'No pets', false, 8, 'Not big but comfy', 5, 120, 10.5, 60, 'Feather', 'Dinghy',  'tadica@bookj.site', 25.0 , 4.81, 'GPS', 'fishing rod, fishnet, lures, floats, fly fishing equipment');
 insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (35,'Railings', 10, 8);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (36,'Navigation lights', 6, 8);
 insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(15, '2021-08-26', '2022-01-01', 8);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(16, '2022-02-26', '2022-08-26', 8);
insert into boat_pics(boat_id,boat_pics) values(8, 'boat3.jpg');
insert into boat_pics(boat_id,boat_pics) values(8, 'boat6.jpg');
insert into boat_pics(boat_id,boat_pics) values(8, 'boat8.jpg');

----------da nema u buducnosti A DA IMA AKCIJU 

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE)
values (36, '2022-03-01T12:00:00', false, '2022-03-04T14:00:00', 8, 40, 8, null, true, '2021-11-20T14:00:00', '2022-02-20T15:00:00', 10);


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
(1, '2021-08-26', '2022-05-01', 1);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(2, '2022-05-24', '2023-01-26', 1);

insert into cottage_pics(cottage_id,cottage_pics) values(1, 'cottage1.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(1, 'cottage2.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(1, 'cottage3.jpg');




insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (1, '2022-10-22T12:00:00', false, '2022-10-28T14:00:00', 5, 270, 1,'bsallnow3@goo.ne.jp', true, '2021-10-19T14:00:00','2022-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(1,1);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(1,2);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (2, '2022-10-29T12:00:00', false, '2022-11-06T14:00:00', 4, 360, 1, 'rtownsend2@nba.com', true, '2021-10-19T14:00:00','2022-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(2,3);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(2,2);
--- opiscopo past
insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (3, '2021-12-22T12:00:00', false, '2021-12-24T14:00:00', 5, 104, 1, 'opiscopo0@storify.com' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(3,3);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(3,2);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(3,1);


--- opiscopo future koja ne moze
insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (4, '2022-01-30T12:00:00', false, '2022-02-05T14:00:00', 4, 312, 1, 'opiscopo0@storify.com' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,1);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,2);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,3);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,4);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,5);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(4,6);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (5, '2022-02-27T12:00:00', false, '2022-03-05T14:00:00', 3, 250, 1, null , true, '2021-11-19T14:00:00','2022-02-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(5,3);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(5,5);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(5,1);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (6, '2022-02-28T12:00:00', false, '2022-03-04T14:00:00', 5, 200, 1, null , true, '2021-11-19T14:00:00','2022-02-20T14:00:00', 10 );
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
(3, '2021-08-26', '2022-04-10', 2);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(4, '2022-04-20', '2022-11-26', 2);
insert into cottage_pics(cottage_id,cottage_pics) values(2, 'cottage4.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(2, 'cottage5.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(2, 'cottage6.jpg');





insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (7, '2022-06-22T12:00:00', false, '2022-06-28T14:00:00', 2, 150, 2,'kbotten7@foxnews.com', true, '2021-10-19T14:00:00','2022-06-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(7,7);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(7,9);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (8, '2022-10-29T12:00:00', false, '2022-11-06T14:00:00', 2, 180, 2, 'ebeardmore6@netvibes.com', true, '2021-10-19T14:00:00','2022-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(8,8);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(8,10);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (9, '2021-12-22T12:00:00', false, '2021-12-24T14:00:00', 2, 69, 2,'lrymmer1@merriam-webster.com' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(9,9);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(9,10);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(9,11);


--- opiscopo past
insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (10, '2021-12-25T12:00:00', false, '2021-12-29T14:00:00', 2, 127, 2, 'opiscopo0@storify.com' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(10,7);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(10,8);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(10,9);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(10,10);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(10,11);


insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (11, '2022-03-30T12:00:00', false, '2022-04-05T14:00:00', 2,130 , 2, null , true, '2021-11-19T14:00:00','2022-02-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(11,7);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(11,8);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(11,9);

--- opiscopo future koja moze
insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (12, '2022-05-30T12:00:00', false, '2022-06-02T14:00:00', 2, 100, 2, 'opiscopo0@storify.com' , true, '2021-11-19T14:00:00','2022-02-19T14:00:00', 10 );
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
(5, '2021-08-26', '2022-04-01', 3);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(6, '2022-04-20', '2023-08-26', 3);

insert into cottage_pics(cottage_id,cottage_pics) values(3, 'cottage7.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(3, 'cottage8.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(3, 'cottage9.jpg');



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (13, '2022-10-02T12:00:00', false, '2022-10-05T14:00:00', 10, 230, 3,'taddy4@bbb.org', true, '2021-10-19T14:00:00','2022-10-01T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(13,12);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(13,13);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (14, '2022-10-14T12:00:00', false, '2022-10-18T14:00:00', 12, 300, 3, 'cfleeming8@ucla.edu', true, '2021-10-19T14:00:00','2022-10-10T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,15);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(14,16);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (15, '2022-05-22T12:00:00', false, '2022-05-24T14:00:00', 11, 174, 3,'mgiottini5@51.la' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,15);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,14);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(15,13);



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (16, '2022-05-25T12:00:00', false, '2022-05-29T14:00:00', 10, 347, 3, 'bsallnow3@goo.ne.jp' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(16,12);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(16,13);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(16,14);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(16,15);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(16,16);

--- opiscopo past
insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (17, '2021-12-30T12:00:00', false, '2022-01-05T14:00:00', 12, 480, 3, 'opiscopo0@storify.com' , true, '2021-11-19T14:00:00','2021-12-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,17);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,16);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(17,15);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (18, '2022-02-22T12:00:00', false, '2022-02-27T14:00:00', 12, 400, 3, null , true, '2021-11-19T14:00:00','2022-02-19T14:00:00', 10 );
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
(7, '2021-08-26', '2022-03-01', 4);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(8, '2022-03-26', '2023-08-26', 4);
insert into cottage_pics(cottage_id,cottage_pics) values(4, 'cottage10.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(4, 'cottage11.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(4, 'cottage12.jpg');


insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (19, '2022-04-22T12:00:00', false, '2022-04-28T14:00:00', 8, 500, 4,'mgiottini5@51.la', true, '2021-10-19T14:00:00','2022-04-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(19,18);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(19,20);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (20, '2022-10-29T12:00:00', false, '2022-11-06T14:00:00', 6, 630, 4, 'cfleeming8@ucla.edu', true, '2021-10-19T14:00:00','2022-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(20,23);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(20,24);
--- opiscopo past
insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (21, '2022-01-19T12:00:00', false, '2022-01-24T14:00:00', 7, 473, 4,'opiscopo0@storify.com' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,23);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,21);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,19);



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (22, '2022-06-25T12:00:00', false, '2022-06-29T14:00:00', 6, 492 ,4, 'glodder9@last.fm' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,19);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,20);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,23);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,24);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,18);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(22,21);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (23, '2022-05-30T12:00:00', false, '2022-06-05T14:00:00', 8, 360, 4, null , true, '2021-11-19T14:00:00','2021-02-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,23);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,18);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,19);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (24, '2022-04-22T12:00:00', false, '2022-04-30T14:00:00', 8, 700, 4, null , true, '2021-11-19T14:00:00','2022-02-19T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,19);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,20);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,22);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,23);


insert into cottage_owner (email, name, surname, address, city, state, phone_num, deleted, rating)
values ('meave@codw.site', 'Meave', 'Claks', 'Hohgsville 16', 'Brisbane', 'UK', '458-852-4521', false, 3.8);
insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL, GUESTS_NUM, price, rating) values
 (10, 'Tara', 'Leave everything tidy as it was', 'Huge house with a lot of space', 'Sabljarka', 6, 'meave@codw.site', 15 , 150.0, 4.63);
  insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (25,'WiFi', 3, 10);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (26,'Parking', 5, 10);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (27,'Breakfast', 6, 10);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (28,'Baby crib', 3, 10);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (29,'Cleaning', 10, 10);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (30,'Tour day', 15, 10);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (31,'2 bathrooms', 20, 10);
 insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(9, '2021-08-26', '2022-05-01', 10);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(10, '2022-05-10', '2023-12-26', 10);
insert into cottage_pics(cottage_id,cottage_pics) values(10, 'cottage13.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(10, 'cottage14.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(10, 'cottage15.jpg');


------da nema u budcnosti

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (25, '2021-10-22T12:00:00', false, '2021-10-28T14:00:00', 12, 900, 10,'rtownsend2@nba.com', true, '2021-10-19T14:00:00','2021-10-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(25,25);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(25,26);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (26, '2022-04-29T12:00:00', false, '2022-05-06T14:00:00', 15, 1050, 10, null, true, '2021-10-19T14:00:00','2022-02-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(26,27);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(26,28);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (27, '2022-01-19T12:00:00', false, '2022-01-24T14:00:00', 13, 795, 10,'opiscopo0@storify.com' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,29);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,30);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,31);



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (28, '2021-12-25T12:00:00', false, '2021-12-29T14:00:00', 10, 642,10, 'taddy4@bbb.org' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(28,25);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(28,26);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(28,27);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(28,28);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(28,29);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(28,30);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (29, '2022-03-30T12:00:00', false, '2022-04-05T14:00:00', 12, 750, 10, null , true, '2021-11-19T14:00:00','2021-02-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(29,31);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(29,30);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(29,25);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (30, '2022-03-22T12:00:00', false, '2022-03-30T14:00:00', 13, 1200, 10, null , true, '2021-11-19T14:00:00','2022-02-19T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(30,26);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(30,27);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(30,29);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(30,30);



 

insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL, GUESTS_NUM, price, rating) values
 (5, 'Tara', 'No noise', 'Cottage secluded from town noise', 'Omorika', 3, 'meave@codw.site', 6 , 85.0, 4.75);
   insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (32,'WiFi', 3, 5);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (33,'Parking', 5, 5);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (34,'Breakfast', 6, 5);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (35,'Baby crib', 3, 5);
 insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(11, '2021-08-26', '2022-05-01', 5);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(12, '2022-05-26', '2022-12-26', 5);
insert into cottage_pics(cottage_id,cottage_pics) values(5, 'cottage16.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(5, 'cottage6.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(5, 'cottage10.jpg');
 



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (31, '2021-03-22T12:00:00', false, '2021-03-28T14:00:00', 6, 500, 5,'rtownsend2@nba.com', true, '2020-10-19T14:00:00','2021-02-20T14:00:00', 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(31,32);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(31,33);

--- opiscopo future koja moze
insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (33, '2022-01-30T12:00:00', false, '2022-02-02T14:00:00', 6, 267, 5,'opiscopo0@storify.com' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(33,34);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(33,35);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(33,32);



insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time, PERCENTAGE_REVENUE)
values (34, '2021-12-25T12:00:00', false, '2021-12-29T14:00:00', 6, 351,5, 'taddy4@bbb.org' , false, null,null, 10 );
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,33);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,35);
insert into reservation_cottage_additional_services(RESERVATION_COTTAGE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(34,32);





 
 insert into cottage_owner (email, name, surname, address, city, state, phone_num, deleted, rating)
values ('sokonina@codw.site', 'Nina', 'Sukic', 'Liversville 16', 'London', 'UK', '485-875-4521', false, 4.88);
insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL, GUESTS_NUM, price, rating) values
 (6, 'Tara', 'Just be pleasant', 'Gradma house with grandma gratis', 'Baka Bora', 2, 'sokonina@codw.site', 5 , 60.0, 4.74);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (36,'Baby crib', 3, 6);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (37,'Cleaning', 10, 6);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (38,'Tour day', 15, 6);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (39,'2 bathrooms', 20, 6);
 insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(13, '2021-08-26', '2022-01-01', 6);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(14, '2022-01-26', '2022-12-26', 6);
insert into cottage_pics(cottage_id,cottage_pics) values(6, 'cottage5.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(6, 'cottage8.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(6, 'cottage11.jpg');
 

 insert into cottage_owner (email, name, surname, address, city, state, phone_num, deleted, rating)
values ('jopas@codw.site', 'Pavle', 'Gagic', 'Sumarska 16', 'Uzice', 'Serbia', '854-854-6853', false, 4.68);

--nijedna buduce 
insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL, GUESTS_NUM, price, rating) values
 (7, 'Zlatibor', 'No loud music but you can do what you want', 'Cottage secluded from town noise', 'Zaki', 5, 'jopas@codw.site', 12 ,60.0, 4.25);
   insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (40,'WiFi', 3, 7);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (41,'Breakfast', 6, 7);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (42,'Cleaning', 10, 7);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (43,'2 bathrooms', 20, 7);
 insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(15, '2021-08-26', '2022-01-01', 7);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(16, '2022-01-26', '2022-12-26', 7);
insert into cottage_pics(cottage_id,cottage_pics) values(7, 'cottage2.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(7, 'cottage9.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(7, 'cottage13.jpg');
 
 
 
insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL, GUESTS_NUM, price, rating) values
 (8, 'Tara', 'No pets', 'Cottage secluded from main road so a little difficult to get to', 'Milka', 3, 'jopas@codw.site', 7 , 50.0, 4.54);
   insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (44,'WiFi', 3, 8);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (45,'Parking', 5, 8);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (46,'Baby crib', 3, 8);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (47,'Tour day', 15, 8);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (48,'2 bathrooms', 20, 8);
 insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(17, '2021-08-26', '2022-01-01', 8);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(18, '2022-01-26', '2022-12-26', 8);
insert into cottage_pics(cottage_id,cottage_pics) values(8, 'cottage1.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(8, 'cottage4.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(8, 'cottage7.jpg');
 
 
 
 
insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL, GUESTS_NUM, price, rating) values
 (9, 'Zlatar', 'No smoking', 'CLose to center and all atractive places', 'Hari', 2, 'jopas@codw.site', 6 , 40.0, 4.67);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (49,'Breakfast', 6, 9);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (50,'Baby crib', 3, 9);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (51,'Cleaning', 10, 9);
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (52,'2 bathrooms', 20, 9);
 insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(19, '2021-08-26', '2022-01-01', 9);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(20, '2022-01-26', '2022-12-26', 9);
insert into cottage_pics(cottage_id,cottage_pics) values(9, 'cottage3.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(9, 'cottage8.jpg');
insert into cottage_pics(cottage_id,cottage_pics) values(9, 'cottage12.jpg');



 
---adventure

insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted, rating) values ('Leticia', 'Gorch', 'lgorch3@cnn.com', '7 Cambridge Lane', 'Ternovka', 'Russia', '340-956-7178', 'I never participated in any competitions but I am the best', false, 4.5);
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price, equipment) values
(1, 'Djetinja', 'Never return the fish', true, 'We start from city beach', 6, 'Riverfish', 'lgorch3@cnn.com', 10.0, '');
 insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (1,'Boat, Fishing ofshore', 15, 1);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (2,'Transport to destination', 10, 1);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(1, '2021-08-26', '2022-02-01',1 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(2, '2022-02-26', '2023-08-26', 1);
insert into adventure_pics(adventure_id,adventure_pics) values(1, 'fishing1.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(1, 'fishing2.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(1, 'fishing3.jpg');





--- opiscopo past
insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (1, '2021-12-28T12:00:00', false, '2021-12-28T14:00:00', 6, 20, 1, 'opiscopo0@storify.com', true, '2021-01-17T14:00:00', '2021-02-25T14:00:00',10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(1,1);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(1,2);

insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (4, '2022-08-20T12:00:00', false, '2022-08-20T14:00:00', 6, 15, 1, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (5, '2022-05-28T12:00:00', false, '2022-05-28T14:00:00', 6, 20, 1, 'taddy4@bbb.org', true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(5,1);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(5,2);


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (6, '2022-06-28T12:00:00', false, '2022-06-28T16:00:00', 6, 55, 1, 'bsallnow3@goo.ne.jp', false, null, null,10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(6,1);



--- opiscopo future koja ne moze
insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (7, '2022-01-30T12:00:00', false, '2022-01-30T15:00:00', 5, 55, 1, 'opiscopo0@storify.com', false, null, null,10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(7,1);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(7,2);



insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (8, '2022-07-28T14:00:00', false, '2022-07-28T18:00:00', 4, 40, 1, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(8,2);




insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price, equipment) values
(2, 'Zaovine', 'Carry bear protection', false, 'Fishing only for catfish', 2, 'BearsInTrap', 'lgorch3@cnn.com', 9.0, 'fishing rod, fishnet, lures, floats, fly fishing equipment');
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(3, '2021-08-26', '2022-04-01',2 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(4, '2022-04-05', '2023-08-26', 2);
insert into adventure_pics(adventure_id,adventure_pics) values(2, 'fishing4.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(2, 'fishing5.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(2, 'fishing6.jpg');


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (9, '2022-12-21T12:00:00', false, '2022-12-21T14:00:00', 2, 15, 2, 'cfleeming8@ucla.edu' , true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (10, '2022-08-14T12:00:00', false, '2022-08-14T14:00:00', 2, 15, 2, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (11, '2022-06-18T12:00:00', false, '2022-06-18T14:00:00', 2, 15, 2, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);



insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (12, '2022-04-10T12:00:00', false, '2022-04-10T14:00:00', 2, 18, 2, 'ebeardmore6@netvibes.com', false, null, null,10);





insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (13, '2022-03-16T12:00:00', false, '2022-03-16T14:00:00', 2, 18, 2, 'opiscopo0@storify.com', false, null, null,10);




insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (14, '2022-05-06T12:00:00', false, '2022-05-06T14:00:00', 2, 15, 2, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);



insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted, rating) values ('Ursula', 'Lago', 'ulago4@vimeo.com', '70075 Dwight Center', 'Rabat', 'Morocco', '110-752-9868', 'My grandfather gave me the love for fishing', false, 4.2);
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price, equipment) values
(3, 'Uvac', 'ALways return the fish', false, 'We start from sjenicko jezero and continue towards peak', 5, 'Beloglavi supovi', 'ulago4@vimeo.com', 50.0, 'fishing rod, fishnet, lures, floats, fly fishing equipment');
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(5, '2021-08-26', '2022-02-01',3 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(6, '2022-02-26', '2023-08-26', 3);
insert into adventure_pics(adventure_id,adventure_pics) values(3, 'fishing7.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(3, 'fishing8.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(3, 'fishing9.jpg');



insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (2, '2022-12-28T12:00:00', false, '2022-12-28T14:00:00', 5, 50, 3, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (3, '2022-08-20T12:00:00', false, '2022-08-20T14:00:00', 5, 50, 3, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (15, '2022-12-28T18:00:00', false, '2022-12-28T19:00:00', 5, 25, 3, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);


--- opiscopo past
insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (16, '2021-12-28T12:00:00', false, '2021-12-28T14:00:00', 5, 100, 3, 'opiscopo0@storify.com' , false, null, null,10);





insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (17, '2022-03-28T12:00:00', false, '2022-03-28T14:00:00', 5, 100, 3,'ebeardmore6@netvibes.com' , false, null, null,10);




insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (18, '2022-04-28T12:00:00', false, '2022-04-28T14:00:00', 5, 50, 3, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);


insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted, rating) values ('Maria', 'Stark', 'makistark@cnn.com', '7 Ruziceva', 'Beograd', 'Serbia', '485-854-6952', 'I teach a man how to fish not give him a fish', false, 4.65);
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price, equipment) values
(4, 'Uvac', 'Always return the fish', true, 'We start from the top of the hill', 3, 'Meandri', 'makistark@cnn.com', 25.0, '');
 insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (3,'Quad ride', 100, 4);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (4,'Handmade flies', 10, 4);
   insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (5,'Map for each participant', 3, 4);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (6,'Long boots', 10, 4);
   insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (7,'Photographer', 15, 4);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(7, '2021-08-26', '2022-01-01',4);
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(8, '2022-02-26', '2023-08-26', 4);
insert into adventure_pics(adventure_id,adventure_pics) values(4, 'fishing10.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(4, 'fishing11.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(4, 'fishing12.jpg');

------------da nema u buducnosti

insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (20, '2022-08-20T12:00:00', false, '2022-08-20T14:00:00', 3, 50, 4, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(20,7);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(20,6);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(20,5);



insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (21, '2022-12-28T12:00:00', false, '2022-12-28T14:00:00', 3, 50, 4, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,4);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,3);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,5);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,7);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(21,6);


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (23, '2021-12-28T16:00:00', false, '2021-12-28T18:00:00', 3, 183, 4, 'glodder9@last.fm', false, null, null,10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,3);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,4);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,5);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,6);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(23,7);


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (24, '2021-12-28T12:00:00', false, '2021-12-28T14:00:00', 3, 173, 4, 'opiscopo0@storify.com' , true, '2021-01-17T14:00:00', '2022-01-25T14:00:00',10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,3);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,5);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,4);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(24,6);








insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price, equipment) values
(5, 'Uvac', 'Only responsible adult behaviour', true, 'Complimentary lunch at nearby etno restaurant from caugth fish', 8, 'HappyFishing', 'makistark@cnn.com', 20.0, '');
 insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (8,'fly fishing rods', 15, 5);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (9,'Transport to destination', 10, 5);
    insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (10,'fishing nets', 5, 5);
      insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (11,'spray for European chub', 10, 5);
        insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (12,'snacks', 8, 5);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(9, '2021-08-26', '2022-05-01',5 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(10, '2022-05-26', '2023-08-26', 5);
insert into adventure_pics(adventure_id,adventure_pics) values(5, 'fishing13.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(5, 'fishing14.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(5, 'fishing15.jpg');


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (25, '2022-12-21T12:00:00', false, '2022-12-21T14:00:00', 8, 40, 5, 'mgiottini5@51.la', true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(25,8);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(25,9);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(25,10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(25,12);

insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (26, '2022-06-20T12:00:00', false, '2022-06-20T14:00:00', 8, 40, 5, null, true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(26,12);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(26,11);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(26,9);


--- opiscopo past

insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (27, '2021-11-28T12:00:00', false, '2021-11-28T14:00:00', 7, 40, 5, 'opiscopo0@storify.com', true, '2021-01-17T14:00:00', '2021-02-25T14:00:00',10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,8);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,9);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,11);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,12);


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (28, '2022-03-28T12:00:00', false, '2022-03-28T14:00:00', 8, 73, 5, 'cfleeming8@ucla.edu', false, null, null,10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,9);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,11);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(27,12);



insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (29, '2021-12-27T12:00:00', false, '2021-12-27T14:00:00', 7, 88, 5, 'lrymmer1@merriam-webster.com', false, null, null,10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(29,8);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(29,9);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(29,10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(29,11);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(29,12);


insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, participants_num, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time,PERCENTAGE_REVENUE )
values (30, '2022-02-27T12:00:00', false, '2022-02-27T14:00:00', 6, 50, 5, null , true, '2021-11-17T14:00:00', '2022-02-25T14:00:00',10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(30,10);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(30,11);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(30,9);
insert into reservation_ADVENTURE_additional_services(RESERVATION_ADVENTURE_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(30,8);













insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted, rating) values ('David', 'Oliko', 'stanka@cnn.com', 'Nikole Pasica 7', 'Uzice', 'Serbia', '584-785-3265', 'I never participated in any competitions but I am the best', false, 4.9);
-----nema nijedna buduce

insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price, equipment) values
(6, 'Djetinja', 'Try to stay as quiet as you can', true, 'We start from city beach', 6, 'Lov na soma', 'stanka@cnn.com', 15.0, '');
 insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (13,'Healthy snacks', 5, 6);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (14,'Talkie walkie', 5, 6);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(11, '2021-08-26', '2022-01-01',6 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(12, '2022-02-26', '2023-08-26', 6);
insert into adventure_pics(adventure_id,adventure_pics) values(6, 'fishing16.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(6, 'fishing1.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(6, 'fishing5.jpg');





insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price, equipment) values
(7, 'Zaovine', 'No throwing trash around', true, 'Special experience', 5, 'Campit', 'stanka@cnn.com', 18.0, 'rods, lures, special zander spray');
 insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (15,'Boat', 20, 7);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (16,'Transport to destination', 15, 7);
    insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (17,'Camping', 5, 7);
      insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (18,'Tents for camping', 15, 7);
        insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (19,'fishing net', 5, 7);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(13, '2021-08-26', '2022-02-01',7 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(14, '2022-02-15', '2023-08-26', 7);
insert into adventure_pics(adventure_id,adventure_pics) values(7, 'fishing6.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(7, 'fishing4.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(7, 'fishing10.jpg');





insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price, equipment) values
(8, 'Zaovine', 'No fires!', true, 'We go fishing only for small fish for beginers', 8, 'Beginners luck', 'stanka@cnn.com', 13.0, '');
 insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (20,'full float fishing equipment', 20, 8);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (21,'Transport to destination', 10, 8);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(15, '2021-08-26', '2022-01-01',8 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(16, '2022-02-26', '2023-08-26', 8);
insert into adventure_pics(adventure_id,adventure_pics) values(8, 'fishing8.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(8, 'fishing9.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(8, 'fishin13.jpg');





insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted, rating) values ('Bojan', 'Vitorovic', 'bociboi@cnn.com', 'Uskokovica 8', 'Uzice', 'Serbia', '524-874-5795', 'Relaxing hobby type of fishing is my style', false, 4.85);
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price, equipment) values
(9, 'Ribnicko', 'Be careful around the falls of the forest, bring your dog', true, 'Try to relax in this impossible to achieve fishing quest', 6, 'Impossible Mission', 'bociboi@cnn.com', 20.0, 'rods, nets, lures');
 insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (22,'Boat, Fishing ofshore', 5, 9);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (23,'Transport to destination', 10, 9);
   insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (24,'float rods', 5, 9);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (25,'Hook lines sinkers', 10, 9);
   insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (26,'reels', 7, 9);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (27,'Tackle boxes', 6, 9);
   insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (28,'Bait boxes', 5, 9);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (29,'Lure spray', 4, 9);
   insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (30,'parasol', 5, 9);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (31,'binoculars', 8, 9);
   insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (32,'Photographer', 10, 9);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (33,'snacks and sweets', 9, 9);
   insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (34,'dog snacks', 10, 9);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (35,'knives', 10, 9);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(17, '2021-08-26', '2022-01-01',9 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(18, '2022-02-01', '2023-12-26', 9);
insert into adventure_pics(adventure_id,adventure_pics) values(9, 'fishing10.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(9, 'fishing2.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(9, 'fishing15.jpg');


insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted, rating) values ('Petar', 'Wolf', 'perce@cnn.com', 'Zivka Davidovica 2', 'Beograd', 'Serbia', '584-589-5888', 'If you are on the edge just move from it', false, 4.5);
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL, price, equipment) values
(10, 'Ribnicko', 'Do whatever you want just make sure to always know where is the dog', true, 'I pick you up with a van and you never come back. We are taking my dog with us', 10, 'Gringozica', 'perce@cnn.com', 30.0, 'all neccessary equipment for lure fishing');
 insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (36,'Boat', 15, 10);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (37,'dog treats', 10, 10);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(19, '2021-08-26', '2022-01-01',10 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(20, '2022-03-01', '2023-08-26', 10);
insert into adventure_pics(adventure_id,adventure_pics) values(10, 'fishing7.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(10, 'fishing4.jpg');
insert into adventure_pics(adventure_id,adventure_pics) values(10, 'fishing14.jpg');


--additional

insert into revenue_item(revenue_id, reservation_id, res_type, percentage_active, fisherman_price, revenue)
values (1, 1, 'BOAT', 10, 90, 9);




insert into sign_up_request(EMAIL,ADDRESS,CITY,DELETED,NAME,PHONE_NUM,STATE,SURNAME,EXPLANATION,REG_TYPE )
values('lovelina@ujik.com', 'Vase Stajica 64', 'Novi Sad', false, 'Lovelina', '582-965-9856', 'Serbia', 'Lalic', 'I have a cottage I never use', 'COTTAGE_OWNER');
insert into sign_up_request(EMAIL,ADDRESS,CITY,DELETED,NAME,PHONE_NUM,STATE,SURNAME,EXPLANATION,REG_TYPE )
values('olivera@ujik.com', 'Petra Kocica 64', 'Novi Sad', false, 'Olivera', '254-854-9652', 'Serbia', 'Katic', 'I want to put muy boat to a good use', 'BOAT_OWNER');
insert into sign_up_request(EMAIL,ADDRESS,CITY,DELETED,NAME,PHONE_NUM,STATE,SURNAME,EXPLANATION,REG_TYPE )
values('olivero@ujik.com', 'Iva Andrica 64', 'Sabac', false, 'Oliver', '854-000-0255', 'Serbia', 'Tomic', 'I want to make a living by fishing', 'INSTRUCTOR');


insert into DELETE_ACCOUNT_REQUEST(REQUEST_ID,PERMITED,PROCESSED,REQUEST_TEXT,RESPONSE,EMAIL)
values(1, false, false, 'I have no more wish to go fishing', null, 'rtownsend2@nba.com');
insert into DELETE_ACCOUNT_REQUEST(REQUEST_ID,PERMITED,PROCESSED,REQUEST_TEXT,RESPONSE,EMAIL)
values(2, false, false, 'The service here is terrible', null, 'taddy4@bbb.org');
insert into DELETE_ACCOUNT_REQUEST(REQUEST_ID,PERMITED,PROCESSED,REQUEST_TEXT,RESPONSE,EMAIL)
values(3, false, false, 'I stopped fishing years ago', null, 'mgiottini5@51.la');
insert into DELETE_ACCOUNT_REQUEST(REQUEST_ID,PERMITED,PROCESSED,REQUEST_TEXT,RESPONSE,EMAIL)
values(4, false, false, 'I do not need it', null, 'lrymmer1@merriam-webster.com');




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
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (21, 'makistark@cnn.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (22, 'stanka@cnn.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (23, 'bociboi@cnn.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (24, 'perce@cnn.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (25, 'meave@codw.site', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (26, 'sokonina@codw.site', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (27, 'jopas@codw.site', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (28, 'tadica@bookj.site', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',true, false, null, false);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (29, 'lovelina@ujik.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',false, false, null, true);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (30, 'olivera@ujik.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',false, false, null, true);
insert into USERS (user_id, username, password, enabled, deleted, verification_code,FIRST_LOGIN) values (31, 'olivero@ujik.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2',false, false, null, true);

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
insert into USER_ROLES(user_id, role_id) values(21, 5);
insert into USER_ROLES(user_id, role_id) values(22, 5);
insert into USER_ROLES(user_id, role_id) values(23, 5);
insert into USER_ROLES(user_id, role_id) values(24, 5);
insert into USER_ROLES(user_id, role_id) values(25, 3);
insert into USER_ROLES(user_id, role_id) values(26, 3);
insert into USER_ROLES(user_id, role_id) values(27, 3);
insert into USER_ROLES(user_id, role_id) values(28, 4);
insert into USER_ROLES(user_id, role_id) values(29, 3);
insert into USER_ROLES(user_id, role_id) values(30, 4);
insert into USER_ROLES(user_id, role_id) values(31, 5);
