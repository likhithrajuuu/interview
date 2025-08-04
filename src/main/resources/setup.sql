CREATE TABLE dev.users (

id SERIAL PRIMARY KEY,
first_name TEXT NOT NULL,
last_name TEXT NOT NULL,
email TEXT NOT NULL,
age INTEGER,

gender TEXT,
state TEXT,
street_address TEXT,
postal_code TEXT,
city TEXT,

country TEXT,
latitude DOUBLE PRECISION,
longitude DOUBLE PRECISION,
traffic_source TEXT,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

 \COPY dev.users(id, first_name, last_name, email, age, gender, state, street_address, postal_code, city, country, latitude, longitude, traffic_source, created_at)
FROM '/Users/likhithrajup/Documents/users.csv'
DELIMITER ','
CSV HEADER;


CREATE TABLE dev.orders (
  order_id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  status TEXT,
  gender TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  returned_at TIMESTAMP,
  shipped_at TIMESTAMP,
  delivered_at TIMESTAMP,
  num_of_item INTEGER );


\COPY dev.orders(order_id, user_id, status, gender, created_at, returned_at, shipped_at, delivered_at, num_of_item)
FROM '/Users/likhithrajup/Documents/orders.csv'
DELIMITER ','
CSV HEADER;


select * from dev.users;
select * from dev.orders;