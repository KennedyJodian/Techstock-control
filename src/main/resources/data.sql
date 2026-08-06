
-- BRANDS --

INSERT INTO brand
(brand_name, made_in_origin)
VALUES
('Dell', 'USA');

INSERT INTO brand
(brand_name, made_in_origin)
VALUES
('Samsung', 'South Korea');

INSERT INTO brand
(brand_name, made_in_origin)
VALUES
('HP', 'USA');

INSERT INTO brand
(brand_name, made_in_origin)
VALUES
('Apple', 'USA');



-- PRODUCTS --


INSERT INTO product 
(product_name, description, price, model_number, warranty_date, brand_id, product_type, created_at)
VALUES
(
'Dell Inspiron Laptop',
'15 inch business laptop with Intel processor',
899.99,
'DELL-INS-500',
'2027-05-15',
1,
'Laptop',
CURRENT_TIMESTAMP
);


INSERT INTO product 
(product_name, description, price, model_number, warranty_date, brand_id, product_type, created_at)
VALUES
(
'Samsung Galaxy S25',
'Latest Samsung smartphone with high resolution camera',
999.99,
'SAM-S25-2025',
'2028-01-10',
2,
'Smartphone',
CURRENT_TIMESTAMP
);


INSERT INTO product 
(product_name, description, price, model_number, warranty_date, brand_id, product_type, created_at)
VALUES
(
'HP 27 Inch Monitor',
'Full HD LED computer monitor',
249.99,
'HP-MON27',
'2027-09-20',
3,
'Monitor',
CURRENT_TIMESTAMP
);


INSERT INTO product 
(product_name, description, price, model_number, warranty_date, brand_id, product_type, created_at)
VALUES
(
'Apple Magic Keyboard',
'Wireless keyboard accessory',
129.99,
'APPLE-MK2',
'2026-12-01',
4,
'Accessory',
CURRENT_TIMESTAMP
);


-- USERS --

DELETE FROM users;


INSERT INTO users
(username,email,password,role,enabled)
VALUES
(
'admin',
'admin@techstock.com',
'$2a$10$TnGeIknTy2cJQUDcN2ygGOHaCFfQhHQ7kbN8s0rmwu9slPesTldre',
'ROLE_ADMIN',
true
);


INSERT INTO users
(username,email,password,role,enabled)
VALUES
(
'manager',
'manager@techstock.com',
'$2a$10$ZbEYW7JglYkg58b0woljXOTZld0qzZiynmT4vFO8LybNJHB7ZtQmC',
'ROLE_MANAGER',
true
);


INSERT INTO users
(username,email,password,role,enabled)
VALUES
(
'staff',
'staff@techstock.com',
'$2a$10$55b/0RPv1Q2vVeL7zF6jXeedeo1i0RD8M2ed3knM7YogT.7SCaPnO',
'ROLE_STAFF',
true
);