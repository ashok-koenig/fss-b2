# Order Fullfillment System
# 1. Strategic Design
## 1.1 Collaboration between business experts and technical team
- Supplychain experts - Warehouse and shipping rules.
- Logistic Partners - Integrate delivery status
- Technical team - Conduct event storming

## 1.2 Identify Core, Supporting and Generic Domains
- Order Management - Core domain
- Customer Management - Supporting domain
- Inventory Management - Supporting domain
- Shipping Management - Supporting domain
- Payment Processing - Generic domain

## 1.3 Identify Bounded Contexts
- Order Management context
- Customer management context
- Inventory management context
- Shipping and Logistics context
- Payment processing context.

## 1.4 Context Mapping
### Event-Driven Architecture (EDA) 
Order Management <-> Inventory Management <-> Shipping & Logistics <-> Payment Processing

# 2. Tactical Design
## 2.1 Order Management - Domain Model
- **Entity**: Order(OrderID, OrderDate, OrderAmount, CustomerID, Status...)
- **Value Object**: OrderDetail(Details of each product in the order)
-  **Aggregate**: OrderAggregate (Ensures business rules of order)
- **Repository**: OrderRepository (Handles order storage and retrieval)
- **Domain Events**: OrderPlanced, OrderCompleted

## 2.2 Inventory Management - Domain Model
- **Entity**: Product (ProductID, Name, Stock, Price....)
- **Value Object**: StockQuanity
-  **Aggregate**: InventoryAggregate (Ensures stock updates)
- **Repository**: InventoryRepository (Handles inventory storage and retrival)
- **Domain Events**: InventoryChecked, StockUpdated

## 2.3 OrderAggregate Rules
- When OrderPlaced, check if stock is available
- If stock is available, proceed with payment. 
- If payment is successful, mark order as confirmed. 
- Send OrderShipped event to trigger shipping. 

## 2.4 InventoryReposity
- Find product stock by product id
- Update stock when an order is placed.
- Emit StockUpdated Event after stock changes. 

## 2.5 Handle Domain Events (Workflow for Order fulfillment)
- Customer Places an order -> *OrderPlaced* event is emitted.
- Inventory Service received *OrderPlaced* -> Checks stock and emits *InventoryChecked*
- Payment Service receives *OrderPlaced* -> Process payment and emits *PaymentProcessed*
- Order Service updates order status -> emits *OrderConfirmed*
- Shipping service received *OrderConfirmed* -> Ships order and emits *OrderShipped*