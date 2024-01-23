CREATE TABLE IF NOT EXISTS withdrawals (
    withdrawal_id INT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE NOT NULL,
    investor_id INT,
    FOREIGN KEY (investor_id) REFERENCES investors (investor_id)
);

