CREATE TABLE address (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         street VARCHAR(255),
                         city VARCHAR(255),
                         state VARCHAR(100),
                         zip VARCHAR(20)
);

CREATE TABLE customer (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255),
                          email VARCHAR(255),
                          phone VARCHAR(50),
                          address_id BIGINT,
                          FOREIGN KEY (address_id) REFERENCES address(id)
);