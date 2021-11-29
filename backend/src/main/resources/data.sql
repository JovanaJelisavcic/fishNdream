insert into fisherman (EMAIL, ADDRESS, CITY, NAME, PHONE_NUM, STATE, SURNAME, deleted) values ('erumbold0@usa.gov', 'Lenin 145', 'Moskow', 'Russia', 'Erum', '556-885-999', 'Boldov', false);
insert into fisherman (EMAIL, ADDRESS, CITY, NAME, PHONE_NUM, STATE, SURNAME, deleted) values ('cboniface1@about.me', 'Picaso Street 85', 'Bilbao', 'Spain', 'Clara', '551-815-989', 'Bonifaces', false);
insert into fisherman (EMAIL, ADDRESS, CITY, NAME, PHONE_NUM, STATE, SURNAME, deleted) values ('bhellin2@gravatar.com', 'Strum Strase', 'Wien', 'Austria', 'Ben', '536-385-333', 'Hellin', false);
insert into admin (EMAIL, ADDRESS, CITY, NAME, PHONE_NUM, STATE, SURNAME, deleted) values ('wvanmerwe3@ihg.com', 'Strum Strase', 'Wien', 'Austria', 'Ben', '536-385-333', 'Hellin', false);
insert into admin (EMAIL, ADDRESS, CITY, NAME, PHONE_NUM, STATE, SURNAME, deleted) values ('wvanmerwe1@ihg.com', 'Strum Strase', 'Wien', 'Austria', 'Ben', '536-385-333', 'Hellin', false);

insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted) values ('erumbold0@usa.gov', 'Eirena', 'Rumbold', '0 Village Place', 'Živinice', 'Bosnia and Herzegovina', '521-486-3914', false);
insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL) values
 (1, 'Zlatibor', 'No smoking', true, 12, 'Beautiful and fast', 2, 152, 12.5, 45, 'Ursel', 'gliser',  'erumbold0@usa.gov' );
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (1,'pet friendly', 5, 1);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (2,'minibar', 20, 1);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (3,'Capetain', 40, 1);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(1, '2021-08-26', '2022-01-01', 1);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(2, '2022-02-26', '2022-08-26', 1);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time )
values (1, '2021-12-28T12:00:00', false, '2021-12-28T14:00:00', 10, 250, 1, 'cboniface1@about.me', true, '2021-11-20T14:00:00', '2021-11-30T15:00:00');
--insert into reservation_boat_additional_services(RESERVATION_BOAT_RESERVATION_ID,ADDITIONAL_SERVICES_SERVICE_ID  )values(1,3);

insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time )
values (2, '2021-10-29T12:00:00', false, '2021-10-30T14:00:00', 10, 250, 1, 'cboniface1@about.me', true, '2021-11-17T14:00:00', '2021-11-25T14:00:00');

 insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL) values
 (2, 'Tara', 'No pets', false, 12, 'Beautiful and fast', 2, 152, 12.5, 45, 'Kalina', 'ferry',  'erumbold0@usa.gov' );
 insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(3, '2021-08-26', '2022-01-01', 2);
insert into AVAILABILITY_PERIOD_BOATS  (PERIOD_ID, BEGGINING, ENDING,BOAT_ID ) values
(4, '2022-02-26', '2022-08-26', 2);
insert into reservation_boat (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, BOAT_ID, EMAIL, action_res, action_start_time, action_end_time )
values (3, '2021-11-26T12:00:00', false, '2021-11-26T14:00:00', 10, 250, 2, null, true, '2021-11-17T14:00:00', '2021-11-25T14:00:00');
 insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (4,'minibar', 20, 2);
insert into additional_services_boat (SERVICE_ID, NAME, PRICE, BOAT_ID) values (5,'Capetain', 40, 2);
insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted) values ('cboniface1@about.me', 'Crystal', 'Boniface', '9 Sommers Circle', 'Biaoxi', 'China', '966-218-4628', false);
insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted) values ('bhellin2@gravatar.com', 'Brenna', 'Hellin', '4 Charing Cross Way', 'Kukawa', 'Nigeria', '748-544-1143', false);
insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted) values ('igitsham3@cdc.gov', 'Itch', 'Gitsham', '2124 Pawling Street', 'Liping', 'China', '521-698-2896', false);
insert into boat_owner (email, name, surname, address, city, state, phone_num, deleted) values ('pedmed4@vk.com', 'Pete', 'Edmed', '88 Fuller Lane', 'Qinhe', 'China', '916-404-7190', false);


insert into cottage_owner (email, name, surname, address, city, state, phone_num, deleted) values ('acretney7@businessinsider.com', 'Antin', 'Vuitton', '8 Mayfield Road', 'Hīsh', 'Syria', '627-651-4290', false);
insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL, GUESTS_NUM) values
 (1, 'Zlatibor', 'No smoking', 'Lovely cottage', 'Zlatni bor', 2, 'acretney7@businessinsider.com', 5 );
 insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (1,'WiFi', 3, 1);
  insert into additional_services_cottage (SERVICE_ID, NAME, PRICE, COTTAGE_ID) values (2,'Free Parking', 5, 1);
 insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(1, '2021-08-26', '2022-01-01', 1);
insert into AVAILABILITY_PERIOD_COTTAGES  (PERIOD_ID, BEGGINING, ENDING,COTTAGE_ID ) values
(2, '2022-02-26', '2022-08-26', 1);

insert into reservation_cottage (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, 	COTTAGE_ID, EMAIL, action_res, action_start_time, action_end_time)
values (1, '2021-10-22T12:00:00', false, '2021-10-24T14:00:00', 5, 150, 1,'cboniface1@about.me' , true, '2021-11-19T14:00:00','2021-12-20T14:00:00' );

insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL,GUESTS_NUM) values
 (2, 'Tara', 'No pets', 'Family house', 'Tarska zora', 3, 'acretney7@businessinsider.com',6);

 
 insert into cottage_owner (email, name, surname, address, city, state, phone_num, deleted) values ('bcoffey8@cmu.edu', 'Alleen', 'Carabet', '85 Rowland Alley', 'Taoyuan', 'China', '307-249-1188', false);
insert into cottage_owner (email, name, surname, address, city, state, phone_num, deleted) values ('swilkie9@digg.com', 'Ariela', 'Angel', '529 Spohn Alley', 'Kabor', 'Indonesia', '407-853-9057', false);
insert into cottage_owner (email, name, surname, address, city, state, phone_num, deleted) values ('kgriswooda@aol.com', 'Rodrique', 'Rudman', '634 Golf Course Crossing', 'Gandekan', 'Indonesia', '833-691-1487', false);
insert into cottage_owner (email, name, surname, address, city, state, phone_num, deleted) values ('nlustedb@skyrock.com', 'Gottfried', 'Tutchell', '05420 Tomscot Drive', 'Prior Velho', 'Portugal', '252-676-2335', false);

insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted) values ('Legra', 'D''Aguanno', 'ldaguanno0@issuu.com', '15313 Burrows Alley', 'Hongzhou', 'China', '331-356-5166', 'not schooled for this but success guaranteed', false);
insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted) values ('Lisle', 'Creeber', 'lcreeber1@google.de', '1955 Fair Oaks Plaza', 'Wushi', 'China', '518-718-7196', 'finished 2 courses myself', false);
insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted) values ('Cybill', 'Exroll', 'cexroll2@barnesandnoble.com', '6 Paget Crossing', 'Xiejiatan', 'China', '879-718-3715', 'I have a show called fishing with bello', false);
insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted) values ('Leticia', 'Gorch', 'lgorch3@cnn.com', '7 Cambridge Lane', 'Ternovka', 'Russia', '340-956-7178', 'I never participated in any competitions but I am the best', false);
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL) values
(3, 'Djetinja', 'Never return the fish', true, 'We start from city beach', 6, 'Riverfish', 'lgorch3@cnn.com');
 insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (1,'Boat, Fishing ofshore', 15, 3);
  insert into additional_services_adventure (SERVICE_ID, NAME, PRICE, ADVENTURE_ID) values (2,'Transport to destination', 10, 3);
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(1, '2021-08-26', '2022-01-01',3 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(2, '2022-02-26', '2022-08-26', 3);
insert into reservation_adventure (RESERVATION_ID, BEGINNING, CANCELED, ENDING, PARTICIPANTS_NUM, PRICE, ADVENTURE_ID, EMAIL, action_res, action_start_time, action_end_time)
values (1, '2021-12-28T12:00:00', false, '2021-12-29T14:00:00', 3, 200, 3, 'cboniface1@about.me', true, '2021-11-20T14:00:00', '2021-11-25T14:00:00');
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL) values
(2, 'Zaovine', 'Carry bear protection', false, 'Fishing only for catfish', 2, 'BearsInTrap', 'lgorch3@cnn.com');
 insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(3, '2021-08-26', '2022-01-01',2 );
insert into AVAILABILITY_PERIOD_ADVENTURES  (PERIOD_ID, BEGGINING, ENDING,ADVENTURE_ID ) values
(4, '2022-02-26', '2022-08-26', 2);
insert into instructor (name, surname, email, address, city, state, phone_num, short_bio, deleted) values ('Ursula', 'Lago', 'ulago4@vimeo.com', '70075 Dwight Center', 'Rabat', 'Morocco', '110-752-9868', 'My grandfather gave me the love for fishing', false);
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL) values
(1, 'Uvac', 'ALways return the fish', false, 'We start from sjenicko jezero and continue towards peak', 5, 'Beloglavi supovi', 'ulago4@vimeo.com');






INSERT INTO roles(name) VALUES('FISHERMAN');
INSERT INTO roles(name) VALUES('SYS_ADMIN');
INSERT INTO roles(name) VALUES('COTTAGE_OWNER');
INSERT INTO roles(name) VALUES('BOAT_OWNER');
INSERT INTO roles(name) VALUES('INSTRUCTOR');



insert into users (user_id,username, password, enabled, deleted, verification_code) values (1,'erumbold0@usa.gov', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2', true, false, null);
insert into users (user_id,username, password, enabled, deleted, verification_code) values (2,'cboniface1@about.me', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2', true, false, null);
insert into users (user_id,username, password, enabled, deleted, verification_code) values (3,'bhellin2@gravatar.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2', true, false, null);
insert into users (user_id,username, password, enabled, deleted, verification_code) values (4,'wvanmerwe3@ihg.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2', true, false, null);
insert into users (user_id,username, password, enabled, deleted, verification_code) values (5,'wvanmerwe1@ihg.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2', true, false, null);



insert into USER_ROLES(user_id, role_id) values(1, 1);
insert into USER_ROLES(user_id, role_id) values(2, 1);
insert into USER_ROLES(user_id, role_id) values(3, 1);
insert into USER_ROLES(user_id, role_id) values(4, 2);
insert into USER_ROLES(user_id, role_id) values(5, 2);