CREATE TABLE Orders (
	OrderID INT PRIMARY KEY AUTO_INCREMENT,
	CustomerID INT NOT NULL,
	OrderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT FK_Orders_Customers 
		FOREIGN KEY (CustomerID) 
		REFERENCES Customers(CustomerID) 
		ON DELETE CASCADE
	);