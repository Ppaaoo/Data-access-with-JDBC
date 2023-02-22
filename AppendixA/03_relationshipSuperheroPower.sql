CREATE TABLE linkink (
    superhero_id int REFERENCES superhero,
    power_id int REFERENCES power,
    PRIMARY KEY (superhero_id, power_id)
);

