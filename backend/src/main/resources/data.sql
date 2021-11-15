insert into boat_owner (email, name, surname, address, city, state, phone_num) values ('erumbold0@usa.gov', 'Eirena', 'Rumbold', '0 Village Place', 'Živinice', 'Bosnia and Herzegovina', '521-486-3914');
insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL) values
 (1, 'Zlatibor', 'No smoking', true, 12, 'Beautiful and fast', 2, 152, 12.5, 45, 'Ursel', 'gliser',  'erumbold0@usa.gov' );
insert into boat (BOAT_ID,	ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, CAPACITY, DESCRIPTION, ENGINE_NUM, ENGINE_POWER, LENGTH, MAX_SPEED, NAME, BOAT_TYPE, OWNER_EMAIL) values
 (2, 'Tara', 'No pets', false, 12, 'Beautiful and fast', 2, 152, 12.5, 45, 'Kalina', 'ferry',  'erumbold0@usa.gov' );
insert into boat_owner (email, name, surname, address, city, state, phone_num) values ('cboniface1@about.me', 'Crystal', 'Boniface', '9 Sommers Circle', 'Biaoxi', 'China', '966-218-4628');
insert into boat_owner (email, name, surname, address, city, state, phone_num) values ('bhellin2@gravatar.com', 'Brenna', 'Hellin', '4 Charing Cross Way', 'Kukawa', 'Nigeria', '748-544-1143');
insert into boat_owner (email, name, surname, address, city, state, phone_num) values ('igitsham3@cdc.gov', 'Itch', 'Gitsham', '2124 Pawling Street', 'Liping', 'China', '521-698-2896');
insert into boat_owner (email, name, surname, address, city, state, phone_num) values ('pedmed4@vk.com', 'Pete', 'Edmed', '88 Fuller Lane', 'Qinhe', 'China', '916-404-7190');


insert into cottage_owner (email, name, surname, address, city, state, phone_num) values ('acretney7@businessinsider.com', 'Antin', 'Vuitton', '8 Mayfield Road', 'Hīsh', 'Syria', '627-651-4290');
insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL) values
 (1, 'Zlatibor', 'No smoking', 'Lovely cottage', 'Zlatni bor', 2, 'acretney7@businessinsider.com' );
insert into cottage (COTTAGE_ID, ADDRESS, BEHAVIOUR_RULES, DESCRIPTION, NAME, ROOM_NUM, OWNER_EMAIL) values
 (2, 'Tara', 'No pets', 'Family house', 'Tarska zora', 3, 'acretney7@businessinsider.com');

 
 insert into cottage_owner (email, name, surname, address, city, state, phone_num) values ('bcoffey8@cmu.edu', 'Alleen', 'Carabet', '85 Rowland Alley', 'Taoyuan', 'China', '307-249-1188');
insert into cottage_owner (email, name, surname, address, city, state, phone_num) values ('swilkie9@digg.com', 'Ariela', 'Angel', '529 Spohn Alley', 'Kabor', 'Indonesia', '407-853-9057');
insert into cottage_owner (email, name, surname, address, city, state, phone_num) values ('kgriswooda@aol.com', 'Rodrique', 'Rudman', '634 Golf Course Crossing', 'Gandekan', 'Indonesia', '833-691-1487');
insert into cottage_owner (email, name, surname, address, city, state, phone_num) values ('nlustedb@skyrock.com', 'Gottfried', 'Tutchell', '05420 Tomscot Drive', 'Prior Velho', 'Portugal', '252-676-2335');

insert into instructor (name, surname, email, address, city, state, phone_num, short_bio) values ('Legra', 'D''Aguanno', 'ldaguanno0@issuu.com', '15313 Burrows Alley', 'Hongzhou', 'China', '331-356-5166', 'not schooled for this but success guaranteed');
insert into instructor (name, surname, email, address, city, state, phone_num, short_bio) values ('Lisle', 'Creeber', 'lcreeber1@google.de', '1955 Fair Oaks Plaza', 'Wushi', 'China', '518-718-7196', 'finished 2 courses myself');
insert into instructor (name, surname, email, address, city, state, phone_num, short_bio) values ('Cybill', 'Exroll', 'cexroll2@barnesandnoble.com', '6 Paget Crossing', 'Xiejiatan', 'China', '879-718-3715', 'I have a show called fishing with bello');
insert into instructor (name, surname, email, address, city, state, phone_num, short_bio) values ('Leticia', 'Gorch', 'lgorch3@cnn.com', '7 Cambridge Lane', 'Ternovka', 'Russia', '340-956-7178', 'I never participated in any competitions but I am the best');
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL) values
(3, 'Djetinja', 'Never return the fish', true, 'We start from city beach', 6, 'Riverfish', 'lgorch3@cnn.com');
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL) values
(2, 'Zaovine', 'Carry bear protection', false, 'Fishing only for catfish', 2, 'BearsInTrap', 'lgorch3@cnn.com');
insert into instructor (name, surname, email, address, city, state, phone_num, short_bio) values ('Ursula', 'Lago', 'ulago4@vimeo.com', '70075 Dwight Center', 'Rabat', 'Morocco', '110-752-9868', 'My grandfather gave me the love for fishing');
insert into adventure (ADVENTURE_ID, ADDRESS, BEHAVIOUR_RULES, CANCEL_POLICY, DESCRIPTION, MAX_PARTICIPANTS, NAME, INSTRUCTOR_EMAIL) values
(1, 'Uvac', 'ALways return the fish', false, 'We start from sjenicko jezero and continue towards peak', 5, 'Beloglavi supovi', 'ulago4@vimeo.com');






INSERT INTO roles(name) VALUES('FISHERMAN');
INSERT INTO roles(name) VALUES('SYS_ADMIN');
INSERT INTO roles(name) VALUES('COTTAGE_OWNER');
INSERT INTO roles(name) VALUES('BOAT_OWNER');
INSERT INTO roles(name) VALUES('INSTRUCTOR');



insert into users (user_id,username, password, enabled) values (1,'erumbold0@usa.gov', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2', true);
insert into users (user_id,username, password, enabled) values (2,'cboniface1@about.me', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2', true);
insert into users (user_id,username, password, enabled) values (3,'bhellin2@gravatar.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2', true);
insert into users (user_id,username, password, enabled) values (4,'wvanmerwe3@ihg.com', '$2a$10$Fh4qeAY.sD6A/BdTBl8g6e5iYh8scygIZcAbT1iUpisI.qHhYdgR2', true);



insert into USER_ROLES(user_id, role_id) values(1, 1);
insert into USER_ROLES(user_id, role_id) values(2, 1);
insert into USER_ROLES(user_id, role_id) values(3, 1);
insert into USER_ROLES(user_id, role_id) values(4, 2);