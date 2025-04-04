SELECT c.Name,o.OrderDate, sum(od.Quantity* p.Price) as OrderAmount
	FROM Customers c
	JOIN Orders o ON c.CustomerID = o.CustomerID
	JOIN OrderDetails od ON o.OrderID = od.OrderID
	JOIN Products p ON od.ProductID = p.ProductID
	GROUP BY c.CustomerID,c.Name, o.OrderDate