CREATE TABLE customer 
(
	customer_id SERIAL
	, name VARCHAR(100) NOT NULL
	, address VARCHAR(150) NOT NULL
	, phone VARCHAR(11) NULL
	,
	
	CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);



CREATE TABLE artist
(
	artist_id SERIAL
	, first_name VARCHAR(50)
	, last_name VARCHAR(100)
	, CONSTRAINT pk_artist PRIMARY KEY (artist_id)
);


CREATE TABLE art
(
	art_code VARCHAR(3)
	, title VARCHAR(200)
	, artist_id INT NOT NULL
	,
	
	CONSTRAINT pk_art PRIMARY KEY (art_code),
	CONSTRAINT fk_art_artist FOREIGN KEY (artist_id) REFERENCES artist (artist_id) 
);


CREATE TABLE customer_purchase
(
	customer_id INT NOT NULL
	, art_code VARCHAR(3)
	, purchase_date TIMESTAMP NOT NULL
	, price INT NOT NULL
	,
	
	CONSTRAINT pk_customer_purchase PRIMARY KEY(customer_id, art_code, purchase_date),
	CONSTRAINT fk_customer_purchase_customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
	CONSTRAINT fk_customer_purchase_art FOREIGN KEY (art_code) REFERENCES art(art_code),
	CONSTRAINT ch_price CHECK(price >= 500) 
);

