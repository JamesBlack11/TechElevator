CREATE TABLE  member
(
	member_number SERIAL
	, last_name VARCHAR(100) NOT NULL
	, first_name VARCHAR(100) NOT NULL
	, email_address VARCHAR(150) NOT NULL
	, phone VARCHAR(15) NULL
	, notification_flag boolean
	, date_of_birth DATE NOT NULL
	,
	CONSTRAINT pk_member PRIMARY KEY (member_number)
);


CREATE TABLE interest_group
(
	group_name VARCHAR(200)
	, group_number SERIAL
	, CONSTRAINT pk_interest_group PRIMARY KEY (group_number)
);


CREATE TABLE event_event
(
	event_number SERIAL
	, event_name VARCHAR(200)
	, description VARCHAR(500)
	, start_and_date_time TIMESTAMP NOT NULL
	, duration INT NOT NULL
	, group_number INT NOT NULL
	,

	CONSTRAINT pk_event_event PRIMARY KEY (event_number),

);


CREATE TABLE group_member
(
	 member_number INT NOT NULL
	, group_number INT NOT NULL
	,

	CONSTRAINT pk_group_member PRIMARY KEY (group_number, member_number),
	CONSTRAINT fk_group_member_member FOREIGN KEY (member_number) REFERENCES member(member_number),
	CONSTRAINT fk_group_member_interest_group FOREIGN KEY (group_number) REFERENCES interest_group (group_number)
);



CREATE TABLE member_event (
	event_number INT NOT NULL
	, member_number INT NOT NULL
	,
	CONSTRAINT pk_member_event PRIMARY KEY (event_number, member_number),
	CONSTRAINT fk_group_event_event_event FOREIGN KEY (event_number) REFERENCES event_event (event_number),
	CONSTRAINT fk_group_event_member FOREIGN KEY (member_number) REFERENCES member (member_number)
);

INSERT INTO member (member_number, last_name, first_name, email_address, phone, notification_flag, date_of_birth) VALUES
('001', 'Elessar', 'Aragorn',  'rangerofnorth@Strider.com' , '(717)-234-4234', true, '2937-03-01'),
('002', 'Olorin', 'Gandolf',  'Mithrandir@theWhite.com' , '(717)-254-4634', true, '1000-11-19'),
('003', 'Baggins', 'Frodo',  'ringbearer@sonofdrogo.com' , '(717)-221-5421', false, '4094-09-22'),
('004', 'Thranduil', 'Legolas',  'regularelf@Greenleaf.com' , '(717)-993-4267', true, '0087-12-31'),
('005', 'Gloin', 'Gimli',  'andmyaxe@houseofdurin.com' , '(717)-456-3216', false, '2879-12-31'),
('006', 'Gamgee', 'Samwise',  'stickeminastew@mainhere.com' , '(717)-921-4476', false, '2980-04-06'),
('007', 'Denethor', 'Boromir',  'onedoesnotsimply@mybrothermycaptainmyking.com' , '(717)-674-7922', true, '2978-02-26'),
('008', 'Took', 'Pippin',  'foolofatook@halfling.com' , '(717)-121-9785', true, '2990-03-09'),
('009', 'Brandybuck', 'Merry',  'secondbreakfast@halfling.com' , '(717)-564-1247', true, '2982-12-31');


SELECT * FROM member;

INSERT INTO interest_group (group_name, group_number) VALUES
('LOTR DND', '001' ),
('ELF LARPING', '002' ),
('ORC SLAYING', '003'),
('MORDOR TRAVELING', '004');

SELECT * FROM interest_group;

INSERT INTO event_event (event_number, event_name, description, start_and_date_time, duration, group_number) VALUES
('001', 'FELLOWSHIP OF THE RING', 'A RACE TO DESTROY THE RING', '2022-12-15 07:30', 90, '001'),
('002', 'RING MAKING', 'One ring to rule them all, one ring to find them, One ring to bring them all, and in the darkness bind them', '2022-09-23 06:30', 120, '002'),
('003', 'ORC HIDE AND SEEK', ' FIND THE HALFLINGSSSSS', '2022-10-20 05:45', 120, '003';

SELECT * FROM event_event;


INSERT INTO group_member
	(group_number, member_number)
VALUES ((SELECT group_number from interest_group WHERE group_name = 'ORC SLAYING'),
(SElECT member_number FROM member WHERE member_number = '001'));
 
 INSERT INTO group_member
	(group_number, member_number)
VALUES ((SELECT group_number from interest_group WHERE group_name = 'ORC SLAYING'),
(SElECT member_number FROM member WHERE member_number = '002'));
 
 INSERT INTO group_member
	(group_number, member_number)
VALUES ((SELECT group_number from interest_group WHERE group_name = 'ORC SLAYING'),
(SElECT member_number FROM member WHERE member_number = '003'));
 
 INSERT INTO group_member
	(group_number, member_number)
VALUES ((SELECT group_number from interest_group WHERE group_name = 'ORC SLAYING'),
(SElECT member_number FROM member WHERE member_number = '004'));
 
 INSERT INTO group_member
	(group_number, member_number)
VALUES ((SELECT group_number from interest_group WHERE group_name = 'ELF LARPING'),
(SElECT member_number FROM member WHERE member_number = '001'));
 
  INSERT INTO group_member
	(group_number, member_number)
VALUES ((SELECT group_number from interest_group WHERE group_name = 'ELF LARPING'),
(SElECT member_number FROM member WHERE member_number = '004'));
 
  INSERT INTO group_member
	(group_number, member_number)
VALUES ((SELECT group_number from interest_group WHERE group_name = 'MORDOR TRAVELING'),
(SElECT member_number FROM member WHERE member_number = '006'));
 
 INSERT INTO group_member
	(group_number, member_number)
VALUES ((SELECT group_number from interest_group WHERE group_name = 'MORDOR TRAVELING'),
(SElECT member_number FROM member WHERE member_number = '003'));
 
  INSERT INTO group_member
	(group_number, member_number)
VALUES ((SELECT group_number from interest_group WHERE group_name = 'LOTR DND'),
(SElECT member_number FROM member WHERE member_number = '009'));
 
   INSERT INTO group_member
	(group_number, member_number)
VALUES ((SELECT group_number from interest_group WHERE group_name = 'LOTR DND'),
(SElECT member_number FROM member WHERE member_number = '008'));
 
   INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'RING MAKING'),
(SElECT member_number FROM member WHERE member_number = '006'));
 
    INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'RING MAKING'),
(SElECT member_number FROM member WHERE member_number = '003'));
 
    INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'ORC HIDE AND SEEK'),
(SElECT member_number FROM member WHERE member_number = '008'));
 
  INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'ORC HIDE AND SEEK'),
(SElECT member_number FROM member WHERE member_number = '009'));
 
  INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'FELLOWSHIP OF THE RING'),
(SElECT member_number FROM member WHERE member_number = '007'));
 
 
   INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'FELLOWSHIP OF THE RING'),
(SElECT member_number FROM member WHERE member_number = '005'));
 
   INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'FELLOWSHIP OF THE RING'),
(SElECT member_number FROM member WHERE member_number = '004'));
 
   INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'FELLOWSHIP OF THE RING'),
(SElECT member_number FROM member WHERE member_number = '003'));
 
   INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'FELLOWSHIP OF THE RING'),
(SElECT member_number FROM member WHERE member_number = '002'));
 
   INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'FELLOWSHIP OF THE RING'),
(SElECT member_number FROM member WHERE member_number = '001'));
 
   INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'FELLOWSHIP OF THE RING'),
(SElECT member_number FROM member WHERE member_number = '006'));
 
   INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'FELLOWSHIP OF THE RING'),
(SElECT member_number FROM member WHERE member_number = '008'));
 
   INSERT INTO member_event
	(event_number, member_number)
VALUES ((SELECT event_number from event_event WHERE event_name = 'FELLOWSHIP OF THE RING'),
(SElECT member_number FROM member WHERE member_number = '009'));