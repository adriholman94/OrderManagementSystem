CREATE TABLE IF NOT EXISTS migrations."PurchaseRecordDetails" (
  "purchaseRecordDetailId" int4 NOT NULL,
  "purchaseRecordId" int4 NOT NULL,
  "productSupplierId" int4 NOT NULL,
  "productQuantity" varchar(255) NOT NULL,
  "unitPrice" int4,
  "totalPrice" int4,
  PRIMARY KEY ("purchaseRecordDetailId"),
  FOREIGN KEY ("productSupplierId") REFERENCES "ProductSuppliers" ("productSupplierId"),
  FOREIGN KEY ("purchaseRecordId") REFERENCES "PurchaseRecords" ("purchaseRecordId")
);