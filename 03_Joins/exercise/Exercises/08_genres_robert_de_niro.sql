-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)
SELECT DISTINCT
	g.genre_name
FROM
	genre g
JOIN
	movie_genre mg
ON
	g.genre_id = mg.genre_id  
JOIN
	 movie m
ON 
	mg.movie_id = m.movie_id

JOIN
	movie_actor ma
ON
	m.movie_id = ma.movie_id
JOIN
	person p
ON
	ma.actor_id = p.person_id
WHERE
	 m.release_date >= '2010-01-01' AND p.person_name = 'Robert De Niro';
