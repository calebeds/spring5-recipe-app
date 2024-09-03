#create databases
CREATE DATABASE calebe_dev;
CREATE DATABASE calebe_prod;

# create database service accounts
CREATE USER 'calebe_dev_user'@'localhost' IDENTIFIED BY 'calebe';
CREATE USER 'calebe_prod_user'@'localhost' IDENTIFIED BY 'calebe';

# Database grants
GRANT SELECT ON calebe_dev.* to 'calebe_dev_user'@'localhost';
GRANT INSERT ON calebe_dev.* to 'calebe_dev_user'@'localhost';
GRANT DELETE ON calebe_dev.* to 'calebe_dev_user'@'localhost';
GRANT UPDATE ON calebe_dev.* to 'calebe_dev_user'@'localhost';
GRANT SELECT ON calebe_prod.* to 'calebe_prod_user'@'localhost';
GRANT INSERT ON calebe_prod.* to 'calebe_prod_user'@'localhost';
GRANT DELETE ON calebe_prod.* to 'calebe_prod_user'@'localhost';
GRANT UPDATE ON calebe_prod.* to 'calebe_prod_user'@'localhost';

# Using db via docker

CREATE USER 'calebe_dev_user'@'%' IDENTIFIED BY 'calebe';
CREATE USER 'calebe_prod_user'@'%' IDENTIFIED BY 'calebe';

GRANT SELECT ON calebe_dev.* to 'calebe_dev_user'@'%';
GRANT INSERT ON calebe_dev.* to 'calebe_dev_user'@'%';
GRANT DELETE ON calebe_dev.* to 'calebe_dev_user'@'%';
GRANT UPDATE ON calebe_dev.* to 'calebe_dev_user'@'%';
GRANT SELECT ON calebe_prod.* to 'calebe_prod_user'@'%';
GRANT INSERT ON calebe_prod.* to 'calebe_prod_user'@'%';
GRANT DELETE ON calebe_prod.* to 'calebe_prod_user'@'%';
GRANT UPDATE ON calebe_prod.* to 'calebe_prod_user'@'%';
