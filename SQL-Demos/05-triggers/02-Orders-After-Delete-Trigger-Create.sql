CREATE TRIGGER trg_AfterDelete on Orders
AFTER DELETE
AS
BEGIN
	INSERT INTO OrderHistory(OrderID, CustomerID, DeletedAt)
			SELECT OrderID, CustomerID, GETDATE() FROM deleted;
END