CREATE TABLE IF NOT EXISTS migrations."PurchaseRecords" (
  "purchaseRecordId" int4 NOT NULL,
  "date" date NOT NULL,
  "finalPrice" int4,
  PRIMARY KEY ("purchaseRecordId")
);