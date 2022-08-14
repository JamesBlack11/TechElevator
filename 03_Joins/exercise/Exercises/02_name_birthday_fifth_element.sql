-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
SELECT
	p.birthday
	, p.person_name
FROM
	person p
JOIN
	movie_actor ma
ON
	 ma.actor_id = p.person_id
JOIN
	movie m
ON
	m.movie_id = ma.movie_id
WHERE m.title = 'The Fifth Element';

