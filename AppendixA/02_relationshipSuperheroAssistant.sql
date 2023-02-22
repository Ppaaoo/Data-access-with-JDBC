-- Add column to table superhero to use it as FK
ALTER TABLE superhero
ADD assistant_id INT;


ALTER TABLE superhero
ADD FOREIGN KEY (assistant_id) REFERENCES assistant(assistant_id);


