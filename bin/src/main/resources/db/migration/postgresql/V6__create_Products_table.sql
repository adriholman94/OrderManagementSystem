CREATE TABLE IF NOT EXISTS migrations."Products" (
  "productId" int4 NOT NULL,
  "productName" varchar(255) NOT NULL,
  "productPrice" decimal(10,2) NOT NULL,
  "categoryId" int4 NOT NULL,
  PRIMARY KEY ("productId"),
  FOREIGN KEY ("categoryId") REFERENCES "ProductCategories" ("categoryId")
);