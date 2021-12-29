/*CREATE TABLE ORIGIN(
ID INT NOT NULL,
COUNTRY_NAME VARCHAR(30),
CONSTRAINT PK_ORIGIN PRIMARY KEY(ID)
);

CREATE TABLE FRUIT(
ID INT NOT NULL,
NAME VARCHAR(30),
COLOR VARCHAR(30),
ORIGIN_ID INT NOT NULL,
PRICE DECIMAL(2,2),
CONSTRAINT PK_FRUIT PRIMARY KEY(ID),
CONSTRAINT FK_FRUIT_ORIGIN_ID FOREIGN KEY(ORIGIN_ID) REFERENCES ORIGIN(ID)
);*/

INSERT INTO ORIGIN(ID, COUNTRY_NAME) VALUES (1, 'Germany');
INSERT INTO ORIGIN(ID, COUNTRY_NAME) VALUES (2, 'Peru');
INSERT INTO ORIGIN(ID, COUNTRY_NAME) VALUES (3, 'Netherlands');
INSERT INTO ORIGIN(ID, COUNTRY_NAME) VALUES (4, 'Spain');

INSERT INTO FRUIT(ID, NAME, COLOR, ORIGIN_ID, PRICE) VALUES (1, 'Cherry', 'Red', 1, 1.99);
INSERT INTO FRUIT(ID, NAME, COLOR, ORIGIN_ID, PRICE) VALUES (2, 'Apple', 'Red', 1, 1.49);
INSERT INTO FRUIT(ID, NAME, COLOR, ORIGIN_ID, PRICE) VALUES (3, 'Banana', 'Yellow', 2, 1.19);
INSERT INTO FRUIT(ID, NAME, COLOR, ORIGIN_ID, PRICE) VALUES (4, 'Avocado', 'Green', 2, 1.49);
INSERT INTO FRUIT(ID, NAME, COLOR, ORIGIN_ID, PRICE) VALUES (5, 'Strawberry', 'Red', 3, 2.39);

/*
INSERT INTO vegetable(id, name, color, origin, price) VALUES (1, 'Tomato', 'Red', 'Spain', 1.49);
INSERT INTO vegetable(id, name, color, origin, price) VALUES (2, 'Cucumber', 'Green', 'Spain', 1.49);
INSERT INTO vegetable(id, name, color, origin, price) VALUES (3, 'Paprika', 'Yellow', 'Netherlands', 1.19);
INSERT INTO vegetable(id, name, color, origin, price) VALUES (4, 'Potato', 'Yello', 'Germany', 0.89);
INSERT INTO vegetable(id, name, color, origin, price) VALUES (5, 'Celery', 'Green', 'Netherlands', 0.59);
*/

