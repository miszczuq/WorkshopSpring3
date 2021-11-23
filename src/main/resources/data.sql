INSERT INTO address (id,street, city, country) VALUES
(1, 'Koszykowa 86', 'Warszawa', 'Polska'),
(2, 'R. Gen. Garcia Rosado 25 3º', 'Lizbona', 'Portugalia');

INSERT INTO person (id, name, lastname, birthdate, gender, address_id) VALUES
(1, 'Jan', 'Kowalski', '1995-11-10', 'MALE', 1),
(2, 'Anna', 'Nowak', '1997-01-23', 'FEMALE', 2);
