DELIMITER //
CREATE TRIGGER trg_ValidateStock
BEFORE INSERT ON OrderDetails
FOR EACH ROW
BEGIN
	DECLARE available_stock INT;
    SELECT Stock INTO available_stock FROM PRODUCTS WHERE ProductID = NEW.ProductID;
    IF available_stock IS NULL OR available_stock < NEW.Quantity THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: Not Enough stock available';
	END IF;
END;
//
DELIMITER ;