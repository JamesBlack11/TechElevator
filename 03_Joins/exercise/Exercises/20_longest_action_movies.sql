-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre. Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)
SELECT
	m.title
	, m.release_date
	,m.length_minutes
FROM
	movie m
JOIN
	movie_genre mg
ON
	m.movie_id = mg.movie_id
JOIN
	genre g
ON
	mg.genre_id = g.genre_id
WHERE
	genre_name = 'Action'
GROUP BY
	m.title
	, m.release_date
	, m.length_minutes
ORDER by
	length_minutes DESC, m.release_date DESC LIMIT 5;
	
	

