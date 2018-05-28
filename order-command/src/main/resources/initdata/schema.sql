DROP TABLE IF EXISTS user_order;
DROP TABLE IF EXISTS line_item;

CREATE TABLE user_order (
  user_order_id VARCHAR(64) NOT NULL,
  comment VARCHAR(50) NULL,
  PRIMARY KEY (user_order_id)
);

CREATE TABLE line_item (
  line_item_id VARCHAR(64) NOT NULL,
  user_order_id VARCHAR(64) NOT NULL,
  product_id VARCHAR(64) NOT NULL,
  product_name VARCHAR(50),
  quantity INT,
  unit_price DECIMAL(10,2),
  PRIMARY KEY (line_item_id)
);

COMMIT;