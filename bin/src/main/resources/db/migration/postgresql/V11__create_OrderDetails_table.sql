CREATE TABLE IF NOT EXISTS migrations."OrderDetails" (
  "orderDetailId" int4 NOT NULL,
  "orderId" int4 NOT NULL,
  "productId" int4 NOT NULL,
  "productQuantity" int4 NOT NULL,
  "quantityPrice" int4,
  PRIMARY KEY ("orderDetailId"),
  FOREIGN KEY ("orderId") REFERENCES "Orders" ("orderId"),
  FOREIGN KEY ("productId") REFERENCES "Products" ("productId")
);