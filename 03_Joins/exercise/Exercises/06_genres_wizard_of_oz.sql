-- 6. The genres of "The Wizard of Oz" (3 rows)
SELECt
	g.genre_name
	
FROM
	genre g
JOIN
	movie_genre mg
ON
	mg.genre_id = g.genre_id
JOIN
	 movie m
ON
	m.movie_id = mg.movie_id
WHERE
	title = 'The Wizard of Oz'



