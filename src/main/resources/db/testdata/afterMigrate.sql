SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM customer;
DELETE FROM address;

SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE customer AUTO_INCREMENT = 1;
ALTER TABLE address AUTO_INCREMENT = 1;

INSERT INTO address (id, street, city, state, zip) VALUES
                                                       (1, '123 Cherry Lane', 'Springfield', 'IL', '62701'),
                                                       (2, '456 Maple Ave', 'Lincoln', 'NE', '68508'),
                                                       (3, '789 Oak Blvd', 'Madison', 'WI', '53703');

INSERT INTO customer (id, name, email, phone, address_id) VALUES
                                                              (1, 'Mike Portnoy', 'mike.portnoy@example.com', '555-1234', 1),
                                                              (2, 'John Petrucci', 'john.petrucci@example.com', '555-5678', 2),
                                                              (3, 'Jordan Rudess', 'jordan.rudess@example.com', '555-8765', 3);