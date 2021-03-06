C:\app\zakru\product\11.2.0\dbhome_1\NETWORK\ADMIN
tnsnames.ora

Подключение к руту
SqlPlus /nolog
CONN / AS SYSDBA
ALTER SYSTEM SET SEC_CASE_SENSITIVE_LOGON = TRUE;

========

создание схемы

CREATE TABLESPACE tm_tbs DATAFILE 'tm_tbs.dat' SIZE 40M;

CREATE TEMPORARY TABLESPACE tm_temp TEMPFILE 'tm_temp.dbf' SIZE 5M;


CREATE USER TM_ORACLE IDENTIFIED BY TM_ORACLE_PASSWORD DEFAULT TABLESPACE tm_tbs QUOTA 10M ON tm_tbs TEMPORARY TABLESPACE tm_temp QUOTA 5M ON system;

GRANT CONNECT TO TM_ORACLE;

GRANT CREATE TABLE  TO TM_ORACLE;

GRANT CREATE SESSION TO TM_ORACLE;