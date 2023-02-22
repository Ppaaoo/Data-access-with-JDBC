DROP TABLE IF EXISTS linkink;
DROP TABLE IF EXISTS power;
DROP TABLE IF EXISTS superhero;
DROP TABLE IF EXISTS assistant;


CREATE TABLE superhero(
	superhero_id SERIAL PRIMARY KEY,
	superhero_name VARCHAR(50) NOT NULL,
	superhero_alians VARCHAR(50) NOT NULL,
	origin VARCHAR(50)
);



CREATE TABLE assistant(
	assistant_id SERIAL PRIMARY KEY,
	assistant_name VARCHAR(50) NOT NULL,
	superhero_id INT NOT NULL
);


CREATE TABLE power(
	power_id SERIAL PRIMARY KEY,
	power_name VARCHAR(50) NOT NULL,
	power_description VARCHAR(150)
);