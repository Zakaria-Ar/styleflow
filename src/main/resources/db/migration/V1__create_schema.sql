CREATE TABLE category (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(200) NOT NULL,
                         description VARCHAR(500),
                         price DECIMAL(10,2) NOT NULL CHECK (price > 0),
                         stock_quantity INTEGER NOT NULL CHECK (stock_quantity >= 0),
                         category_id INTEGER REFERENCES category(id) ON DELETE SET NULL
);

CREATE INDEX idx_product_category ON product(category_id);