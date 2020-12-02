CREATE TABLE IF NOT EXISTS migrations."Stock" (
  "stockId" int4 NOT NULL,
  "productId" int4 NOT NULL,
  "productQuantity" int4 NOT NULL,
  PRIMARY KEY ("stockId"),
  FOREIGN KEY ("productId") REFERENCES "Products" ("productId")
);