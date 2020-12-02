CREATE TABLE IF NOT EXISTS migrations."Admins" (
  "adminId" int4 NOT NULL,
  "userId" int4 NOT NULL,
  "roleId" int4 NOT NULL,
  PRIMARY KEY ("adminId"),
  FOREIGN KEY ("userId") REFERENCES "Users" ("userId"),
  FOREIGN KEY ("roleId") REFERENCES "Roles" ("roleId")
);