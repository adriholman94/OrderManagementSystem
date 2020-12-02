CREATE TABLE IF NOT EXISTS migrations."Users" (
  "userId" int4 NOT NULL,
  "userName" varchar(255) NOT NULL,
  "userPassword" varchar(255) NOT NULL,
  "firstName" varchar(255) NOT NULL,
  "lastName" varchar(255) NOT NULL,
  "userPhone" varchar(255),
  "userMail" varchar(255) NOT NULL,
  PRIMARY KEY ("userId")
);