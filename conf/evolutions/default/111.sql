# --- !Ups

ALTER TABLE patients
  ADD fuzzy_first_name VARCHAR(255),
  ADD fuzzy_last_name VARCHAR(255);

SET SQL_SAFE_UPDATES=0;
UPDATE patients
SET fuzzy_first_name = dm(first_name);

UPDATE patients
SET fuzzy_last_name = dm(last_name);
SET SQL_SAFE_UPDATES=1;

# --- !Downs

ALTER TABLE patients
DROP COLUMN fuzzy_first_name;

ALTER TABLE patients
DROP COLUMN fuzzy_last_name;