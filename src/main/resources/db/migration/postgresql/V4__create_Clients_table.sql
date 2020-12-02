CREATE TABLE IF NOT EXISTS migrations."Clients" (
  "clientId" int4 NOT NULL,
  "userId" int4 NOT NULL,
  "roleId" int4 NOT NULL,
  "clientRuc" varchar(255) NOT NULL,
  PRIMARY KEY ("clientId"),
  FOREIGN KEY ("userId") REFERENCES "Users" ("userId"),
  FOREIGN KEY ("roleId") REFERENCES "Roles" ("roleId")
);