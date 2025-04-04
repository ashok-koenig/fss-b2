CREATE TRIGGER trg_ValidateStock
ON OrderDetails
AFTER INSERT
AS
BEGIN
	IF EXISTS (
		SELECT 1 FROM inserted i
		JOIN Products p ON i.ProductID = p.ProductID
		WHERE p.Stock - i.Quantity < 0
		)
		BEGIN
			PRINT 'Error: Not enough stock available';
			ROLLBACK TRANSACTION;
		END
END;