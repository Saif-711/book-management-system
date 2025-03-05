-- Insert data into the Author table
INSERT INTO author (name, biography)
VALUES
    ('saif', 'aadaodpqJDINNdnsajdnqwoadnqwipwfd'),
    ('khaled', 'ajdfoiwehfuwauidajdjaJDBAFQQBB');
-- Insert data into the Book table, linking each Book to the appropriate Author's ID
INSERT INTO book (title, isbn, price, author_id)
VALUES
    ('Hello World', '123-asdd-asda-SWA-12W', 12344, 1),  -- Linking to Author with ID 1 (Saif)
    ('Quran-Messages', '123l-saddawdcad', 1200, 1);  -- Linking to Author with ID 1 (Saif)
INSERT INTO customer (name, email, password)
VALUES
    ('John Doe', 'john.doe@example.com', 'password123'),
    ('Jane Smith', 'jane.smith@example.com', 'securepass');
INSERT INTO orders(customer_id, order_date)
VALUES
    (1, '2025-03-03'),  -- Order by John Doe
    (2, '2025-03-03');  -- Order by Jane Smith
insert into order_items (order_id,book_id,quantity)
VALUES (1,1,3),
       (1,2,1),
       (1,1,1);