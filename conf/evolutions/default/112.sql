# --- !Ups

CREATE TRIGGER insertFuzzyFirst
before INSERT
ON patients
FOR EACH ROW
SET new.fuzzy_first_name = dm(new.first_name);

CREATE TRIGGER updateFuzzyFirst
before UPDATE
ON patients
FOR EACH ROW
SET new.fuzzy_first_name = dm(new.first_name);

CREATE TRIGGER insertFuzzyLast
before INSERT
ON patients
FOR EACH ROW
SET new.fuzzy_last_name = dm(new.last_name);

CREATE TRIGGER updateFuzzyLast
before UPDATE
ON patients
FOR EACH ROW
SET new.fuzzy_last_name = dm(new.last_name);


# --- !Downs

DROP TRIGGER insertFuzzyFirst;
DROP TRIGGER updateFuzzyFirst;
DROP TRIGGER insertFuzzyLast;
DROP TRIGGER updateFuzzyLast;