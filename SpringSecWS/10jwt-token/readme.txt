
Run through postman (Spring security collection)
http://localhost:8080/mylogin
{
    "username": "bob@example.com",
    "password": "54321"
}

Get token in the header. (e.g abcdefg...)

Run other API
http://localhost:8080/welcome
with Authorization header 
Authorization abcdefg... 

user- bob@example.com
pass- 54321




/*
-- Query: SELECT * FROM mydb.customer
LIMIT 0, 1000

-- Date: 2021-03-19 14:19
*/
INSERT INTO `` (`id`,`email`,`pwd`,`role`) VALUES (1,'johndoe@example.com','54321','admin');
INSERT INTO `` (`id`,`email`,`pwd`,`role`) VALUES (2,'bob@example.com','$2y$12$1naKP40MA8IsrZ/dglYLUO72lcCBufQoWUuL5MRJ/2SwUguhy3qYW','write');
INSERT INTO `` (`id`,`email`,`pwd`,`role`) VALUES (3,'thomas@example.com','$2y$12$1naKP40MA8IsrZ/dglYLUO72lcCBufQoWUuL5MRJ/2SwUguhy3qYW','read');
INSERT INTO `` (`id`,`email`,`pwd`,`role`) VALUES (4,'lisa@example.com','$2y$12$1naKP40MA8IsrZ/dglYLUO72lcCBufQoWUuL5MRJ/2SwUguhy3qYW','ROLE_ADMIN');
INSERT INTO `` (`id`,`email`,`pwd`,`role`) VALUES (5,'george@example.com','$2y$12$1naKP40MA8IsrZ/dglYLUO72lcCBufQoWUuL5MRJ/2SwUguhy3qYW','ROLE_NONADMIN');
