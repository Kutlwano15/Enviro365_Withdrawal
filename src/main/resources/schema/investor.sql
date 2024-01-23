CREATE TABLE Investors (
    investorId   INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    lastName     VARCHAR(255) NOT NULL,
    age          INTEGER NOT NULL,
    address      VARCHAR(255) NOT NULL,
    contact      VARCHAR(20) NOT NULL
);