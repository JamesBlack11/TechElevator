-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population

FROM  state

ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT 	state_name, census_region
from state

ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area
SELECT area, park_name
FROM park

ORDER BY area DESC LIMIT 1;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name, date_part('year', CURRENT_DATE) - date_part('year', date_established) AS age
FROM park
ORDER BY date_established ASC, park_name ASC LIMIT 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT city_name || ',' || state_abbreviation AS city_state

FROM city;


-- The all parks by name and date established.
SELECT park_name || ' , ' || date_established AS park_date
FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT census_region || ' , ' || state_name AS midwest_states
FROM state
WHERE census_region IN ('West', 'Midwest')
ORDER BY state_name ASC;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_state_population
FROM state;

-- Total population in the West and South census regions
SELECT sum(population) AS west_south_pop 
FROM state
WHERE census_region IN ('West', 'South'); 

-- The number of cities with populations greater than 1 million
SELECT count(population) AS city_pop_over_million
FROM city
where population > 1000000;

-- The number of state nicknames.
SELECT count(state_nickname) AS nickname_count
FROM state;


-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest, MAX(area) AS largest
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT COUNT(city_name) AS city_number , state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY city_number DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT avg(area) AS camping_area, has_camping
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT sum(population) AS city_pop, state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, city_name,  min(population) AS smallest_city_pop
FROM city
GROUP BY state_abbreviation, city_name
ORDER BY smallest_city_pop;

-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT count(city_name) AS cities, (SELECT state_name FROM state WHERE state_abbreviation = c.state_abbreviation) AS state_name
FROM city AS c
ORDER BY cities DESC;
-- Include the names of the smallest and largest parks
SELECT park_name, area
FROM park p,
	(SELECT MIN(area) AS smallest, MAX(area) AS largest FROM park
	where area > 0) AS s1
WHERE
p.area = s1.smallest OR p.area = s1.largest;


-- List the capital cities for the states in the Northeast census region.
SELECT state_abbreviation, city_name

FROM city

WHERE
city_id IN (SELECT capital FROM state WHERE census_region = 'Northeast')
ORDER BY state_abbreviation;
