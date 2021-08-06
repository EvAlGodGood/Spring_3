DROP TABLE productsall;
CREATE TABLE productsall (id bigserial PRIMARY KEY, name VARCHAR(255), price INT);
INSERT INTO productsall (name, price) VALUES ('Salt', 25);
INSERT INTO productsall (name, price) VALUES ('Bread', 40);
INSERT INTO productsall (name, price) VALUES ('Oil', 100);
INSERT INTO productsall (name, price) VALUES ('Сoffee', 190);