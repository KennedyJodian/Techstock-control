-- Insert Brands first

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


-- Insert Products using brand_id

INSERT INTO product 
(product_name, description, price, model_number, warranty_date, brand_id, product_type, created_at)
VALUES
('Dell Inspiron Laptop',
 '15 inch business laptop with Intel processor',
 899.99,
 'DELL-INS-500',
 '2027-05-15',
 1,
 'Laptop',
 CURRENT_TIMESTAMP);


INSERT INTO product 
(product_name, description, price, model_number, warranty_date, brand_id, product_type, created_at)
VALUES
('Samsung Galaxy S25',
 'Latest Samsung smartphone with high resolution camera',
 999.99,
 'SAM-S25-2025',
 '2028-01-10',
 2,
 'Smartphone',
 CURRENT_TIMESTAMP);


INSERT INTO product 
(product_name, description, price, model_number, warranty_date, brand_id, product_type, created_at)
VALUES
('HP 27 Inch Monitor',
 'Full HD LED computer monitor',
 249.99,
 'HP-MON27',
 '2027-09-20',
 3,
 'Monitor',
 CURRENT_TIMESTAMP);


INSERT INTO product 
(product_name, description, price, model_number, warranty_date, brand_id, product_type, created_at)
VALUES
('Apple Magic Keyboard',
 'Wireless keyboard accessory',
 129.99,
 'APPLE-MK2',
 '2026-12-01',
 4,
 'Accessory',
 CURRENT_TIMESTAMP);