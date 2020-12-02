CREATE TABLE IF NOT EXISTS migrations."ProductRegistration" (
  "productRegistrationId" int4 NOT NULL,
  "date" date NOT NULL,
  "finalPrice" int4,
  PRIMARY KEY ("productRegistrationId")
);