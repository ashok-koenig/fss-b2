CREATE VIEW CustomerOrdersView AS
SELECT Orders.*,
		Customers.Name,
		Customers.Email 
		from Orders, Customers 
		WHERE Orders.CustomerID=Customers.CustomerID;