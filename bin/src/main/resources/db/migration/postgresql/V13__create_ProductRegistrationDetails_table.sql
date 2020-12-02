CREATE TABLE IF NOT EXISTS migrations."ProductRegistrationDetail" (
  "productRegistrationDetailId" int4 NOT NULL,
  "productRegistrarionId" int4 NOT NULL,
  "productSupplierId" int4 NOT NULL,
  "productQuantity" varchar(255) NOT NULL,
  "unitPrice" int4,
  "totalPrice" int4,
  PRIMARY KEY ("productRegistrationDetailId"),
  FOREIGN KEY ("productSupplierId") REFERENCES "ProductSuppliers" ("producSupplierId"),
  FOREIGN KEY ("productRegistrarionId") REFERENCES "ProductRegistration" ("productRegistrationId")
);