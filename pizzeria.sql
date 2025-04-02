-- -------------------------------------------------------------
-- TablePlus 6.4.2(600)
--
-- https://tableplus.com/
--
-- Database: pizzeria
-- Generation Time: 2025-04-02 13:39:37.3810
-- -------------------------------------------------------------




-- This script only contains the table creation statements and does not fully represent the table in the database. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."customer" (
    "id_customer" varchar(255) NOT NULL,
    "address" varchar(150) NOT NULL,
    "email" varchar(100) NOT NULL,
    "name" varchar(100) NOT NULL,
    "phone_number" varchar(15) NOT NULL,
    PRIMARY KEY ("id_customer")
);

-- This script only contains the table creation statements and does not fully represent the table in the database. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."order_item" (
    "id_item" int4 NOT NULL,
    "id_order" int4 NOT NULL,
    "id_pizza" int4 NOT NULL,
    "price" numeric(6,2) NOT NULL,
    "quantity" int4 NOT NULL,
    PRIMARY KEY ("id_item","id_order")
);

-- This script only contains the table creation statements and does not fully represent the table in the database. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."pizza" (
    "id_pizza" int4 NOT NULL,
    "available" bool,
    "description" varchar(150) NOT NULL,
    "name" varchar(45) NOT NULL,
    "price" numeric(5,2) NOT NULL,
    "vegan" bool,
    "vegetarian" bool,
    "created_date" timestamp,
    "modified_date" timestamp,
    PRIMARY KEY ("id_pizza")
);

-- This script only contains the table creation statements and does not fully represent the table in the database. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."pizza_order" (
    "id_order" int4 NOT NULL,
    "additional_notes" varchar(200),
    "date" timestamp NOT NULL,
    "id_customer" varchar(15) NOT NULL,
    "method" varchar(1) NOT NULL,
    "total" numeric(6,2) NOT NULL,
    PRIMARY KEY ("id_order")
);

INSERT INTO "public"."customer" ("id_customer", "address", "email", "name", "phone_number") VALUES
('110410415', 'Ap #720-1833 Curabitur Av.', 'mercedesbalorclub@hotmail.com', 'Mercedes Balor', '(688) 944-6619'),
('182120056', 'Ap #268-1749 Id St.', 'heymanboss@hotmail.com', 'Matthew Heyman', '(185) 738-9267'),
('192758012', '705-6031 Aliquam Street', 'wangwatson@icloud.com', 'Drew Watson', '(362) 881-5943'),
('262132898', '241-9121 Fames St.', 'stonecold@icloud.com', 'Karl Austin', '(559) 596-3381'),
('303265780', 'Ap #206-5413 Vivamus St.', 'figthowens@platzi.com', 'Shelton Owens', '(821) 880-6661'),
('363677933', 'Ap #937-4424 Vestibulum. Street', 'bianca0402@platzi.com', 'Bianca Neal', '(792) 406-8858'),
('394022487', 'P.O. Box 341, 7572 Odio Rd.', 'beckytwobelts@icloud.com', 'Becky Alford', '(559) 398-7689'),
('474771564', '925-3988 Purus. St.', 'johareigns@outlook.com', 'Johanna Reigns', '(801) 370-4041'),
('531254932', '461-4278 Dignissim Av.', 'wyattplay@google.co', 'Clarke Wyatt', '(443) 263-8555'),
('617684636', 'Ap #732-8087 Dui. Road', 'aleximorgan@hotmail.com', 'Alexa Morgan', '(830) 212-2247'),
('644337170', 'Ap #308-4700 Mollis Av.', 'elgenerico@outlook.com', 'Sami Rollins', '(508) 518-2967'),
('762085429', '177-1125 Consequat Ave', 'codyforchamp@google.com', 'Cody Rollins', '(740) 271-3631'),
('782668115', 'Ap #696-6846 Ullamcorper Avenue', 'amityrogers@outlook.com', 'Charlotte Riddle', '(744) 344-7768'),
('863264988', 'P.O. Box 136, 4534 Lacinia St.', 'draketheory@hotmail.com', 'Drake Theory', '(826) 607-2278'),
('885583622', '9063 Aliquam, Road', 'brockalford595@platzi.com', 'Brock Alford', '(732) 218-4844');

INSERT INTO "public"."order_item" ("id_item", "id_order", "id_pizza", "price", "quantity") VALUES
(1, 1, 1, 23.00, 1),
(1, 2, 2, 18.50, 1),
(1, 3, 3, 22.00, 1),
(1, 4, 8, 42.00, 2),
(1, 5, 10, 11.00, 1),
(1, 6, 11, 23.00, 1),
(2, 1, 4, 19.95, 1),
(2, 2, 6, 24.00, 1),
(2, 5, 12, 9.50, 1),
(3, 2, 7, 19.50, 1);

INSERT INTO "public"."pizza" ("id_pizza", "available", "description", "name", "price", "vegan", "vegetarian", "created_date", "modified_date") VALUES
(1, 't', 'Pepperoni, Homemade Tomato Sauce & Mozzarella.', 'Pepperoni', 40.10, 'f', 'f', NULL, NULL),
(2, 't', 'Fior de Latte, Homemade Tomato Sauce, Extra Virgin Olive Oil & Basil.', 'Margherita', 1.20, 'f', 't', NULL, NULL),
(3, 't', 'Fior de Latte, Homemade Tomato Sauce, Extra Virgin Olive Oil & Basil.', 'Vegan Margherita', 22.00, 't', 't', NULL, NULL),
(4, 't', 'Hass Avocado, House Red Sauce, Sundried Tomatoes, Basil & Lemon Zest.', 'Avocado Festival', 19.95, 'f', 't', NULL, NULL),
(5, 'f', 'Homemade Tomato Sauce, Mozzarella, Pineapple & Ham.', 'Hawaiian', 20.50, 'f', 'f', NULL, NULL),
(6, 't', 'Portobello Mushrooms, Mozzarella, Parmesan & Goat Cheeses with Alfredo Sauce.', 'Goat Cheese', 24.00, 'f', 'f', NULL, NULL),
(7, 't', 'Artichokes, Roasted Peppers, Rapini, Sundried Tomatoes, Onion, Shaved Green Bell Peppers & Sunny Seasoning.', 'Mother Earth', 19.50, 'f', 't', NULL, NULL),
(8, 't', 'Mild Italian Sausage, Pepperoni, Bacon, Homemade Tomato Sauce & Mozzarella.', 'Meat Lovers', 21.00, 'f', 'f', NULL, NULL),
(9, 'f', 'Marinated Chicken with Cilantro, Red Onions, Gouda, Parmesan & Mozzarella Cheeses.', 'Marinated BBQ Chicken', 20.95, 'f', 'f', NULL, NULL),
(10, 't', 'Wild mushrooms, Baby Kale, Shiitake Bacon & Lemon Vinaigrette. Soy free.', 'Truffle Cashew Cream', 22.00, 't', 't', NULL, NULL),
(11, 't', 'Beef Chorizo, Sundried Tomatoes, Salsa Verde, Pepper, Jalapeno & pistachios', 'Rico Mor', 23.00, 'f', 'f', NULL, NULL),
(12, 't', 'Fresh Spinach, Marinated Artichoke Hearts, Garlic, Fior de Latte, Mozzarella & Parmesan.', 'Spinach Artichoke', 18.95, 'f', 't', NULL, NULL),
(13, 't', 'Pepperoni, Homemade Tomato Sauce & Mozzarella.', 'qwert', 23.00, 'f', 'f', NULL, '2025-03-31 15:47:57.871207'),
(18, 't', 'Pepperoni, Homemade Tomato Sauce & Mozzarella.', 'Peppesss', 23.00, 'f', 'f', '2025-03-31 10:15:50.908144', '2025-03-31 10:15:50.908144'),
(19, 't', 'Pepperoni, Homemade Tomato Sauce & Mozzarella.', 'Peppesss22', 23.00, 'f', 'f', '2025-03-31 10:18:37.713276', '2025-03-31 10:18:37.713276');

INSERT INTO "public"."pizza_order" ("id_order", "additional_notes", "date", "id_customer", "method", "total") VALUES
(1, 'Don''t be late pls.', '2025-06-14 12:00:00', '192758012', 'D', 42.95),
(2, NULL, '2025-02-21 12:56:28.335447', '474771564', 'S', 62.00),
(3, NULL, '2025-02-22 12:56:28.335447', '182120056', 'C', 22.00),
(4, NULL, '2025-02-23 12:56:28.335447', '617684636', 'S', 42.00),
(5, 'Please bring the jalapeños separately.', '2025-02-24 12:56:28.335447', '192758012', 'D', 20.50),
(6, NULL, '2025-02-25 12:56:28.335447', '782668115', 'D', 23.00);

;
ALTER TABLE "public"."order_item" ADD FOREIGN KEY ("id_pizza") REFERENCES "public"."pizza"("id_pizza");
ALTER TABLE "public"."order_item" ADD FOREIGN KEY ("id_order") REFERENCES "public"."pizza_order"("id_order");


-- Indices
CREATE UNIQUE INDEX uk6n1plxa8aecur40e4q2vpcrps ON public.pizza USING btree (name);
ALTER TABLE "public"."pizza_order" ADD FOREIGN KEY ("id_customer") REFERENCES "public"."customer"("id_customer");
