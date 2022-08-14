-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)
INSERT INTO genre
	(genre_name)
VALUES ('Sports');

INSERT INTO	movie_genre
	(movie_id, genre_id)
VALUES ((SELECT movie_id FROM movie WHERE title = 'Coach Carter'), (SELECT genre_id FROM genre WHERE genre_name = 'Sports'));

SELECT g.genre_name
FROM genre g 
JOIN movie_genre mg ON g.genre_id = mg.genre_id
JOIN movie m ON m.movie_id = mg.movie_id
WHERE m.title = 'Coach Carter';