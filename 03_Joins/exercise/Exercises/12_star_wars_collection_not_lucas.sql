-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas (5 rows)
SELECT
	m.title
FROM
	movie m
JOIN
	collection c
ON
	m.collection_id = c.collection_id
	
JOIN
	person p
ON
	m.director_id = p.person_id
WHERE
	p.person_name != 'George Lucas'AND collection_name = 'Star Wars Collection';

