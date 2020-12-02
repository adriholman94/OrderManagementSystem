CREATE TABLE IF NOT EXISTS migrations."ProductSuppliers" (
  "producSupplierId" int4 NOT NULL,
  "supplierId" int4 NOT NULL,
  "productId" int4 NOT NULL,
  PRIMARY KEY ("producSupplierId"),
  FOREIGN KEY ("productId") REFERENCES "Products" ("productId"),
  FOREIGN KEY ("supplierId") REFERENCES "Suppliers" ("supplierId")
);