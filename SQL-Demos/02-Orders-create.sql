CREATE TABLE Orders(
	OrderID INT PRIMARY KEY,
	CustomerID INT,
	OrderDate DATE NOT NULL,
	Amount DECIMAL(10,2) CHECK (Amount >0),
	FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
	)