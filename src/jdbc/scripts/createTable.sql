drop table ProductAccounting;
CREATE TABLE ProductAccounting (productAccountingId NUMERIC, productAccountingType VARCHAR(30) NOT NULL, productAccountingStatus VARCHAR(30) NOT NULL, amount NUMBER(19,2) NOT NULL, currency VARCHAR(3) NOT NULL, createDate date NOT NULL);
ALTER TABLE ProductAccounting ADD CONSTRAINT ProductAccounting_PK PRIMARY KEY (productAccountingId);
CREATE SEQUENCE ProductAccounting_seq START WITH 1;