CREATE TABLE Products (
	ProductID INT PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(100) NOT NULL,
	Price DECIMAL(10,2) NOT NULL CHECK (Price > 0 ),
	Stock INT NOT NULL CHECK (Stock >= 0)
	);