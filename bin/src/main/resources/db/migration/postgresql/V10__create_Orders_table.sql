CREATE TABLE IF NOT EXISTS migrations."Orders" (
  "orderId" int4 NOT NULL,
  "clientId" int4 NOT NULL,
  "orderDate" date NOT NULL,
  "finalPrice" int4,
  "orderState" bool,
  PRIMARY KEY ("orderId"),
  FOREIGN KEY ("clientId") REFERENCES "Clients" ("clientId")
);