CREATE TABLE IF NOT EXISTS Products (
    product_id BIGINT PRIMARY KEY,
    type VARCHAR(255),
    name VARCHAR(255),
    current_balance DECIMAL,
    investorId INT,
    FOREIGN KEY (investor_id) REFERENCES Investors(investor_id)
);