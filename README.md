# E-commerce System

A Java-based e-commerce system that simulates online shopping with products, customers, shopping carts, and shipping functionality.

## Test Result 
![image](https://github.com/user-attachments/assets/254bd7c8-b9bc-45d2-adb5-d84ced39cb8c)

## Overview

This system demonstrates object-oriented programming principles including inheritance, interfaces, and polymorphism. It supports different types of products (perishable and non-perishable), customer management, shopping cart operations, and shipping calculations.

## Features

- **Product Management**: Support for various product types (Cheese, TV, Mobile Scratch Cards, Biscuits)
- **Customer Management**: Customer registration with balance tracking
- **Shopping Cart**: Add products to cart with quantity validation
- **Inventory Management**: Stock tracking and availability checking
- **Expiration Handling**: Automatic expiration checking for perishable items
- **Shipping System**: Weight-based shipping calculations and shipment tracking
- **Payment Processing**: Balance deduction and transaction validation

## Project Structure

```
src/
├── Main.java                 # Entry point and demo
├── Product.java              # Abstract base class for all products
├── Shippable.java            # Interface for items requiring shipping
├── Cheese.java               # Perishable dairy product
├── TV.java                   # Electronic product
├── Mobile.java               # Mobile phone product
├── MobileScratchCard.java    # Digital scratch card (no shipping)
├── Biscuits.java             # Perishable snack product
├── Customer.java             # Customer information and balance
├── Cart.java                 # Shopping cart functionality
├── CartItem.java             # Individual cart item
├── ECommerceSystem.java      # Main checkout processing
└── ShippingService.java      # Shipping calculations and tracking
```

## Class Hierarchy

### Product Hierarchy
- `Product` (abstract base class)
  - `Cheese` (implements `Shippable`)
  - `TV` (implements `Shippable`)
  - `Mobile` (implements `Shippable`)
  - `Biscuits` (implements `Shippable`)
  - `MobileScratchCard` (digital product, no shipping)

### Interfaces
- `Shippable`: For products that require physical shipping

## Key Classes

### Product (Abstract Base Class)
- Properties: name, price, quantity
- Abstract methods: `isExpired()`, `requiresShipping()`
- Methods: inventory management, availability checking

### Shippable Interface
- `getName()`: Get product name
- `getWeight()`: Get shipping weight
- `getQuantity()`: Get available quantity

### Customer
- Properties: name, balance
- Methods: balance management, payment processing

### Cart
- Manages collection of `CartItem` objects
- Validates product availability and expiration
- Calculates subtotals

### ECommerceSystem
- Main checkout processing logic
- Handles payment validation
- Manages shipping calculations
- Generates receipts

### ShippingService
- Calculates shipping fees based on weight
- Generates shipment notices
- Shipping rate: ₹30 per kg

## Usage

### Running the Application

1. **Compile all Java files:**
   ```bash
   javac src/*.java
   ```

2. **Run the main class:**
   ```bash
   java -cp src Main
   ```


## Product Types

### Perishable Products
- **Cheese**: Dairy product with expiration date and weight
- **Biscuits**: Snack product with expiration date and weight

### Non-Perishable Products
- **TV**: Electronic item with weight for shipping
- **Mobile**: Phone device with weight for shipping
- **Mobile Scratch Card**: Digital product (no shipping required)

## Error Handling

The system handles various error scenarios:
- Empty cart checkout
- Insufficient customer balance
- Out of stock products
- Expired products
- Unregistered customers

## Requirements

- Java 8 or higher (uses `java.time.LocalDate`)
- No external dependencies required

## Development

### Adding New Product Types

1. Extend the `Product` abstract class
2. Implement required abstract methods:
   - `isExpired()`: Return expiration status
   - `requiresShipping()`: Return shipping requirement
3. Optionally implement `Shippable` interface if shipping is required
4. Add constructor with appropriate parameters

### Extending Functionality

- **Discounts**: Add discount calculations in product classes
- **Payment Methods**: Extend customer payment options
- **Shipping Options**: Add different shipping methods
- **Order History**: Track customer purchase history

## License

This project is for educational purposes and demonstrates Java OOP concepts.
