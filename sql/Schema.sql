/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Steven
 * Created: Nov 14, 2016
 */

DROP DATABASE IF EXISTS COMP31A2;
CREATE DATABASE COMP31A2;
USE COMP31A2;

DROP TABLE IF EXISTS cateringorder;
DROP TABLE IF EXISTS productreview;
DROP TABLE IF EXISTS productcategory;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS userrole;
DROP TABLE IF EXISTS cateringorder_product;
DROP TABLE IF EXISTS paymentmethod;

CREATE TABLE userroles (
    role_id INT PRIMARY KEY,
    role_description VARCHAR(64) NOT NULL
);

CREATE TABLE customer (
    customer_id VARCHAR(100) PRIMARY KEY,
    username VARCHAR(64) NOT NULL UNIQUE,   
    role_id INT, 
    password VARCHAR(32), 
    first_name VARCHAR(64),
    last_name VARCHAR(64),

    FOREIGN KEY (role_id)
        REFERENCES userroles(role_id)
); 

CREATE TABLE paymentmethod (
    payment_method_id VARCHAR(100) PRIMARY KEY,
    customer_id VARCHAR(100),
    card_number VARCHAR(64),
    card_cvv VARCHAR(3),
    date_to DATETIME,
    isPreferred BOOLEAN DEFAULT FALSE,
    payment_type ENUM('Visa', 'PayPal', 'MasterCard', 'AmericanExpress') DEFAULT NULL,

    FOREIGN KEY (customer_id)
        REFERENCES customer(customer_id)
);

CREATE TABLE productcategory (
    category_id INT PRIMARY KEY,
    name VARCHAR(64)
);

CREATE TABLE product (
    product_id VARCHAR(100) PRIMARY KEY,
    category_id INT,
    price decimal(5,2),
    product_name VARCHAR(64),

    FOREIGN KEY (category_id)
        REFERENCES productcategory(category_id)
);

CREATE TABLE cateringorder (
    catering_id VARCHAR(100) PRIMARY KEY,
    customer_id VARCHAR(100),
    payment_method_id VARCHAR(100),
    date_created DATETIME,
    delivery_date DATETIME,
    
    FOREIGN KEY (payment_method_id)
        REFERENCES paymentmethod(payment_method_id),
    FOREIGN KEY (customer_id) 
        REFERENCES customer(customer_id)
);

CREATE TABLE cateringorder_product (
    catering_id VARCHAR(100),
    product_id VARCHAR(100),
    quantity INT,

    PRIMARY KEY(catering_id, product_id),
    FOREIGN KEY (product_id)
        REFERENCES product(product_id),
    FOREIGN KEY (catering_id)
        REFERENCES cateringorder(catering_id)
);

CREATE TABLE productreview (
    review_id VARCHAR(100) PRIMARY KEY,
    customer_id VARCHAR(100),
    product_id VARCHAR(100),
    review_text VARCHAR(6000),
    review_date DATETIME,
    number_stars INT,

    FOREIGN KEY (customer_id) 
        REFERENCES customer(customer_id),
    FOREIGN KEY (product_id)
        REFERENCES product(product_id)
);


INSERT INTO userroles VALUES(1, "customer"),(2, "admin");

INSERT INTO productcategory VALUES (1, "Cake"),(2, "Muffin"),(3, "Pie");

INSERT INTO customer VALUES (UUID(), "default customer",  1, "pwd1", "User F Name", "User L Name");
INSERT INTO customer VALUES (UUID(), "test customer1",  1, "pwd1", "Test1 F Name", "Test1 L Name");
INSERT INTO customer VALUES (UUID(), "test customer2",  1, "pwd1", "Test2 F Name", "Test2 L Name");

insert into product (product_id, category_id, price, product_name) values ('74005a8c-25b2-4bb7-89e2-3586ad1a5c82', 2, 137.78, 'Crangeberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('2cedaffd-ee02-4868-aff6-afcb234fbc0f', 1, 56.11, 'Apple Cake');
insert into product (product_id, category_id, price, product_name) values ('cdbc3b26-792b-4d08-96cf-c86dd65cbd83', 1, 10.32, 'Apple Cake');
insert into product (product_id, category_id, price, product_name) values ('bc5f012d-ae5a-4a98-8e88-26c006e0a498', 1, 30.55, 'Raspberry Cake');
insert into product (product_id, category_id, price, product_name) values ('8f89b644-78e9-4976-9c3c-24205fdfbd40', 2, 5.62, 'Orange Muffin');
insert into product (product_id, category_id, price, product_name) values ('b81b1352-5e0f-4f88-802d-6e22254935b3', 1, 78.2, 'Crangeberry Cake');
insert into product (product_id, category_id, price, product_name) values ('6b2236a7-bed9-4de0-9bee-19c738fbb805', 1, 120.4, 'Cherry Cake');
insert into product (product_id, category_id, price, product_name) values ('cbb92ca1-69af-4757-9946-9aad7c0d02d5', 2, 143.17, 'Orange Muffin');
insert into product (product_id, category_id, price, product_name) values ('16f2de96-19df-4080-a9d4-b53203d6d5cd', 2, 149.06, 'Orange Muffin');
insert into product (product_id, category_id, price, product_name) values ('31e4faa0-77b5-460d-9a0b-9dae89b83f43', 2, 31.03, 'Crangeberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('611ffceb-eef4-4527-a78a-8cd786211dd7', 2, 73.21, 'Apple Muffin');
insert into product (product_id, category_id, price, product_name) values ('aefd44d8-e0d5-4a52-b9b8-a5b20902b418', 1, 47.67, 'Apple Cake');
insert into product (product_id, category_id, price, product_name) values ('a35c9237-0330-4f81-912a-30e5f142b84d', 3, 64.33, 'Grape Pie');
insert into product (product_id, category_id, price, product_name) values ('470711a2-230c-432a-b464-e475a8cb275f', 1, 137.14, 'Grape Cake');
insert into product (product_id, category_id, price, product_name) values ('3baa5cb1-86e6-4496-9586-4b4ed00413e3', 2, 93.89, 'Pear Muffin');
insert into product (product_id, category_id, price, product_name) values ('0739e663-2740-4e67-9f81-8976281f3af6', 3, 42.24, 'Grapefruit Cake');
insert into product (product_id, category_id, price, product_name) values ('705cee2a-217f-40ca-b523-5bbd2f80f57e', 3, 41.12, 'Cherry Pie');
insert into product (product_id, category_id, price, product_name) values ('52f6d97c-c3e4-4e92-87e6-f182f9f03e34', 3, 73.56, 'Pear Pie');
insert into product (product_id, category_id, price, product_name) values ('1ce2868d-ab9b-42bb-b3dc-f273acb2d206', 1, 106.21, 'Crangeberry Cake');
insert into product (product_id, category_id, price, product_name) values ('d0092a33-32e6-46c8-8001-81b7a012b81d', 2, 106.17, 'Crangeberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('2e8bc331-b640-48ab-8e8c-4a7c73ba1db3', 2, 67.9, 'Strawberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('ab8dc13e-80d0-4b7f-bd73-f5b31d7e9919', 1, 124.5, 'Raspberry Cake');
insert into product (product_id, category_id, price, product_name) values ('14e08b23-309f-4e72-b94c-5333e819c423', 1, 77.27, 'Pear Cake');
insert into product (product_id, category_id, price, product_name) values ('daaf3348-f071-4bba-b511-f95c08bbc8db', 2, 56.05, 'Crangeberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('21797b17-8f15-4c14-80d0-f38b14fa3a9f', 2, 17.09, 'Grapefruit Muffin');
insert into product (product_id, category_id, price, product_name) values ('ca369e75-c4e6-4cec-89f3-4a4215c8da13', 3, 41.61, 'Crangeberry Pie');
insert into product (product_id, category_id, price, product_name) values ('a07bc3da-ddf1-4eba-abf3-ab620df754b5', 2, 132.98, 'Apple Muffin');
insert into product (product_id, category_id, price, product_name) values ('204a3cba-16de-4cb8-a05a-547536c87ef7', 1, 85.34, 'Apple Cake');
insert into product (product_id, category_id, price, product_name) values ('abf8644c-9652-4e79-ae2b-ab39ebb014a9', 1, 130.57, 'Pear Cake');
insert into product (product_id, category_id, price, product_name) values ('7ae2338e-ba9b-4416-8a38-54d8ab14be19', 2, 134.06, 'Strawberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('93334de6-e068-4cf1-8080-3d6529c970c9', 1, 74.59, 'Apple Cake');
insert into product (product_id, category_id, price, product_name) values ('a223027e-08ad-4bdb-b836-c48e89f4458b', 3, 117.13, 'Strawberry Pie');
insert into product (product_id, category_id, price, product_name) values ('b2789e52-7371-430c-b1fb-50635d7f1e05', 2, 79.19, 'Crangeberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('4a7ca015-c1cb-4d4d-b7b3-e70d2b193a36', 3, 126.65, 'Apple Pie');
insert into product (product_id, category_id, price, product_name) values ('f503c15b-e8d9-4e74-b79d-82fd2c613afa', 2, 67.21, 'Cherry Muffin');
insert into product (product_id, category_id, price, product_name) values ('4db1cf19-78fa-4ec2-93ce-4a0cec4ae9d8', 1, 145.23, 'Raspberry Cake');
insert into product (product_id, category_id, price, product_name) values ('0fe4454f-45e6-4054-8d63-28c732c2517d', 3, 34.96, 'Orange Pie');
insert into product (product_id, category_id, price, product_name) values ('e9149dc6-6295-4899-b83f-d1a5a2ba195a', 1, 70.35, 'Grapefruit Cake');
insert into product (product_id, category_id, price, product_name) values ('c19ba393-f060-44c6-be8f-fc35b4eb9395', 3, 25.21, 'Apple Pie');
insert into product (product_id, category_id, price, product_name) values ('93efb79b-67d5-4ea6-9094-9e021ee4ec94', 1, 37.92, 'Crangeberry Cake');
insert into product (product_id, category_id, price, product_name) values ('beb9ca49-18f8-4800-8226-b76cc6f67449', 1, 26.3, 'Cherry Cake');
insert into product (product_id, category_id, price, product_name) values ('6fc9ced3-f7e7-453f-b0d2-0a2ec3c014fd', 2, 56.73, 'Grape Muffin');
insert into product (product_id, category_id, price, product_name) values ('2294dbe5-442e-465a-a8bb-d77183d7de02', 3, 33.15, 'Cherry Pie');
insert into product (product_id, category_id, price, product_name) values ('cbdcb92c-8898-4568-a4d6-c2e8dd15bf92', 1, 69.34, 'Grapefruit Cake');
insert into product (product_id, category_id, price, product_name) values ('e09be8aa-2e12-45c0-84f3-efffb76538ff', 1, 48.46, 'Crangeberry Cake');
insert into product (product_id, category_id, price, product_name) values ('9e9ccd29-465c-4a43-b2e9-575574d6c2a1', 1, 117.78, 'Grape Cake');
insert into product (product_id, category_id, price, product_name) values ('c2ac0963-9fb8-4858-930c-42c4b03d90ad', 1, 111.81, 'Orange Cake');
insert into product (product_id, category_id, price, product_name) values ('79c11202-68f3-4e94-a87f-4bc7b7d25c5c', 2, 145.91, 'Strawberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('14839ec1-67f7-4af9-9c0c-4f2383c10602', 3, 89.68, 'Grape Pie');
insert into product (product_id, category_id, price, product_name) values ('d3400c78-782d-4796-b57c-ee092d82773f', 3, 119.42, 'Orange Pie');
insert into product (product_id, category_id, price, product_name) values ('39cff382-f131-45b2-9b89-6df8a7f65cbb', 1, 144.25, 'Apple Cake');
insert into product (product_id, category_id, price, product_name) values ('31593408-83fe-4b50-a494-6d9f4afd0f13', 1, 137.6, 'Apple Cake');
insert into product (product_id, category_id, price, product_name) values ('7f547abe-2fa6-44fa-9667-bd8b227c013f', 1, 76.3, 'Apple Cake');
insert into product (product_id, category_id, price, product_name) values ('4eb5452c-80b9-426a-b0b4-ee22ce51b0bb', 1, 38.16, 'Crangeberry Cake');
insert into product (product_id, category_id, price, product_name) values ('c5113e7f-2f43-4f86-a81d-9e7a8a9f8c73', 1, 144.33, 'Grapefruit Cake');
insert into product (product_id, category_id, price, product_name) values ('cb7cdb89-8af3-49ec-a99f-8a1f50b0a0b8', 3, 52.93, 'Crangeberry Pie');
insert into product (product_id, category_id, price, product_name) values ('5904bdfd-1a5d-4c6d-a4ff-a7a2dd23e1b5', 3, 116.6, 'Crangeberry Pie');
insert into product (product_id, category_id, price, product_name) values ('8fdae05b-95a0-4883-8b26-9c192fdf0731', 2, 96.07, 'Orange Muffin');
insert into product (product_id, category_id, price, product_name) values ('bf72a1c0-c0ae-4d3a-8000-31544ef3671c', 1, 98.31, 'Grape Cake');
insert into product (product_id, category_id, price, product_name) values ('21356a86-3bd4-4f29-a72a-fc1faffab5bb', 3, 128.15, 'Grapefruit Pie');
insert into product (product_id, category_id, price, product_name) values ('d69eadef-ead4-4831-8249-b88939f37291', 3, 135.51, 'Cherry Pie');
insert into product (product_id, category_id, price, product_name) values ('a0b4bf4f-ccd0-48d0-a9de-1f3bcc309797', 1, 56.73, 'Pear Cake');
insert into product (product_id, category_id, price, product_name) values ('1c6deb1a-0bfe-4664-a883-3543736c73ea', 1, 69.04, 'Crangeberry Cake');
insert into product (product_id, category_id, price, product_name) values ('09755167-4f1c-4650-9555-2bcaaa8df673', 2, 124.4, 'Pear Muffin');
insert into product (product_id, category_id, price, product_name) values ('169741da-0aae-4989-9ded-ec4da87983b2', 3, 140.98, 'Pear Pie');
insert into product (product_id, category_id, price, product_name) values ('ae3c071c-83c0-4aa2-ba87-719eb2f53286', 1, 52.06, 'Apple Cake');
insert into product (product_id, category_id, price, product_name) values ('238b9da5-4514-4c32-b5b3-d9f10d8f2165', 2, 95.45, 'Apple Muffin');
insert into product (product_id, category_id, price, product_name) values ('a51c0d47-7290-45ce-bc08-ffea24f4334c', 2, 125.29, 'Orange Muffin');
insert into product (product_id, category_id, price, product_name) values ('ba5c7136-b1d4-4412-bbec-24505b17cad7', 2, 37.04, 'Cherry Muffin');
insert into product (product_id, category_id, price, product_name) values ('c5a4d747-e2fc-4ca5-8130-eecfade45863', 2, 78.2, 'Strawberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('31306fb3-118b-4634-9769-8aa06f8f3d11', 3, 66.46, 'Raspberry Pie');
insert into product (product_id, category_id, price, product_name) values ('ad9ff2d8-19eb-4990-acac-5625b4ea4c0a', 3, 139.06, 'Pear Pie');
insert into product (product_id, category_id, price, product_name) values ('d3d897c9-0916-46e5-ad59-93b3a96ffa7f', 2, 142.86, 'Orange Muffin');
insert into product (product_id, category_id, price, product_name) values ('a096792a-3214-4fce-8547-41293de89bdc', 3, 108.79, 'Grapefruit Pie');
insert into product (product_id, category_id, price, product_name) values ('d6e6fba7-27d4-4606-991e-5b5788642615', 1, 124.56, 'Crangeberry Cake');
insert into product (product_id, category_id, price, product_name) values ('d44326de-3947-4fce-82f6-e5a3a33d6b5a', 3, 62.99, 'Strawberry Pie');
insert into product (product_id, category_id, price, product_name) values ('ff8ed289-3ef2-47b8-ae62-43a791be1915', 1, 131.22, 'Grape Cake');
insert into product (product_id, category_id, price, product_name) values ('e43c85ea-b3c8-4968-9910-8c9a0453618c', 3, 65.89, 'Crangeberry');
insert into product (product_id, category_id, price, product_name) values ('b15b56e7-bc93-4dd2-aa4c-3de0650eb03c', 1, 148.39, 'Orange Cake');
insert into product (product_id, category_id, price, product_name) values ('ca150584-c43f-41b2-95a3-7e3056d27441', 3, 146.19, 'Apple Pie');
insert into product (product_id, category_id, price, product_name) values ('1ae96d24-3a81-43a3-a73e-261f56d2629c', 2, 24.95, 'Apple Muffin');
insert into product (product_id, category_id, price, product_name) values ('7e93bdfd-885a-4daa-8e70-c7e468c34fe5', 1, 80.55, 'congue Cake');
insert into product (product_id, category_id, price, product_name) values ('7ea7eb56-d94f-4d35-9bd1-198caa5af62c', 3, 73.97, 'Raspberry Pie');
insert into product (product_id, category_id, price, product_name) values ('41f21cb0-0b88-435e-9125-627b1bfaaa0f', 1, 147.46, 'Strawberry Cake');
insert into product (product_id, category_id, price, product_name) values ('6408592e-dcde-4436-b3f7-12431b309ef9', 1, 120.12, 'Raspberry Cake');
insert into product (product_id, category_id, price, product_name) values ('41247a37-883b-4cc7-92ba-9e4a9b774c18', 1, 82.51, 'pulvinar Cake');
insert into product (product_id, category_id, price, product_name) values ('85f8072a-6f81-4215-a117-80e0481dded5', 2, 90.33, 'Orange Muffin');
insert into product (product_id, category_id, price, product_name) values ('9aca15e8-a1f5-4150-80ff-1beb4d127847', 2, 71.74, 'Strawberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('c2d71265-514f-41ce-99fe-ee88d801bf39', 1, 19.7, 'Pear Cake');
insert into product (product_id, category_id, price, product_name) values ('5d9f7f98-58df-49cf-ad6f-4f9f195755c7', 2, 142.83, 'Strawberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('cc567f4e-98fd-430b-afb2-aa7463f967c2', 2, 44.36, 'Apple Muffin');
insert into product (product_id, category_id, price, product_name) values ('300b0f28-4f47-49b5-ac0b-2d8d858ea415', 1, 102.22, 'Apple Cake');
insert into product (product_id, category_id, price, product_name) values ('048053c4-e473-456b-a8ca-9464db9eb06b', 2, 140.32, 'Crangeberry Muffin');
insert into product (product_id, category_id, price, product_name) values ('274babad-99c4-4b29-84b3-4eabf7964df3', 2, 137.23, 'Pear Muffin');
insert into product (product_id, category_id, price, product_name) values ('2c716b12-0407-4f2e-aeb2-7b3c47468bdb', 1, 76.12, 'Crangeberry Cake');
insert into product (product_id, category_id, price, product_name) values ('d0fa10e1-8228-40bf-b710-81ee491c02b5', 2, 5.46, 'Orange Muffin');
insert into product (product_id, category_id, price, product_name) values ('ce11f5e1-512d-45e6-b14c-e629fafd3248', 3, 12.71, 'Crangeberry Pie');
insert into product (product_id, category_id, price, product_name) values ('b7309809-0013-4bac-8ef7-406a64e0227f', 3, 139.19, 'Crangeberry Pie');
insert into product (product_id, category_id, price, product_name) values ('0f58e757-d01f-4db5-b2c3-978634ec91ea', 3, 73.26, 'Orange Pie');
insert into product (product_id, category_id, price, product_name) values ('c29a38e4-ad0a-4280-908e-96e12eebdf24', 1, 74.76, 'Apple Cake');

    