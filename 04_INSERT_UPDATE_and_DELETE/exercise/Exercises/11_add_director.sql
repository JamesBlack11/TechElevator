-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. Add yourself to the person table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)
INSERT INTO
	person
(
	person_name
	, birthday
	, biography
)
VALUES
(
	'James Schwartz' 
	,'10-28-1996'
	, 'A WILD AND CRAZY GUY'
);

UPDATE
movie
 SET director_id = (SELECT person_id FROM person WHERE person_name = 'James Schwartz') 
 WHERE
 title = 'The Blob';
 
 
 

 
 
