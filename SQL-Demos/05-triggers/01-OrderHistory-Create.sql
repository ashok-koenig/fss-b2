CREATE TABLE OrderHistory (
	OrderID INT,
	CustomerID INT,
	DeletedAt DATETIME DEFAULT GETDATE()
	);