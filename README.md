[README.md](https://github.com/user-attachments/files/30162532/README.md)
# 🛒 Sale Management System
> A console-based Sales Management System built with Java, developed by Group 6 — FPT University.

---

## 📌 Project Overview

This system is designed to help small and medium-sized retail businesses manage their daily operations including product inventory, customer data, sales transactions, and business reporting.

The system is built using **Object-Oriented Programming (OOP)** principles in Java, applying:
- **Encapsulation** — all data is protected via private fields and getter/setter methods
- **Inheritance** — product types and customer types share common base classes
- **Polymorphism** — method overriding across subclasses
- **Abstraction** — abstract classes define shared structure

---

## 👥 Team Members — Group 6

| Member | Responsibilities |
|--------|-----------------|
| Nguyễn Hoàng Duy | Main.java, Product module, Report module, GitHub merge |
| Thảo | Customer module, Voucher module |
| Tùng | Employee module, Supplier module, Inventory module |
| Huy | Transaction module, OrderItem module |

---

## 🗂️ Project Structure

```
SaleManagementSystem/
│
├── src/
│   ├── main/
│   │   └── Main.java                  # Entry point
│   │
│   ├── model/
│   │   ├── product/
│   │   │   ├── Product.java           # Abstract base class
│   │   │   ├── Laptop.java
│   │   │   ├── Smartphone.java
│   │   │   └── Television.java
│   │   ├── customer/
│   │   │   ├── Customer.java
│   │   │   ├── RegularCustomer.java
│   │   │   └── VipCustomer.java
│   │   ├── employee/
│   │   │   └── Employee.java
│   │   ├── supplier/
│   │   │   └── Supplier.java
│   │   ├── inventory/
│   │   │   └── Inventory.java
│   │   ├── transaction/
│   │   │   ├── Transaction.java
│   │   │   └── OrderItem.java
│   │   └── voucher/
│   │       └── Voucher.java
│   │
│   ├── manager/
│   │   ├── ProductManager.java
│   │   ├── CustomerManager.java
│   │   ├── EmployeeManager.java
│   │   ├── SupplierManager.java
│   │   ├── InventoryManager.java
│   │   ├── TransactionManager.java
│   │   └── VoucherManager.java
│   │
│   ├── repository/
│   │   ├── ProductRepository.java
│   │   ├── CustomerRepository.java
│   │   ├── EmployeeRepository.java
│   │   ├── SupplierRepository.java
│   │   ├── InventoryRepository.java
│   │   ├── TransactionRepository.java
│   │   └── VoucherRepository.java
│   │
│   ├── ui/
│   │   ├── MainMenu.java
│   │   ├── ProductMenu.java
│   │   ├── CustomerMenu.java
│   │   ├── EmployeeMenu.java
│   │   ├── SupplierMenu.java
│   │   ├── InventoryMenu.java
│   │   ├── TransactionMenu.java
│   │   ├── VoucherMenu.java
│   │   └── ReportMenu.java
│   │
│   └── util/
│       ├── InputHelper.java
│       ├── FileUtils.java
│       ├── Validation.java
│       └── DateUtils.java
│
├── data/
│   ├── products.txt
│   ├── customers.txt
│   ├── employees.txt
│   ├── suppliers.txt
│   ├── inventory.txt
│   ├── transactions.txt
│   └── vouchers.txt
│
└── README.md
```

---

## ✨ Features

### 🛍️ Product Management
- Add new products: **Laptop**, **Smartphone**, **Television**
- Each product type has unique attributes (e.g. CPU/RAM/Storage for Laptop)
- Product ID validation: `LT` prefix for Laptop, `SP` for Smartphone, `TV` for Television
- Update product information
- Remove products
- Search product by ID
- Display all products

### 👤 Customer Management
- Add new customers: **Regular Customer** and **VIP Customer**
- Regular customers earn reward points
- VIP customers have exclusive discount levels (Gold, Diamond...)
- Update, remove, search customers
- Display all customers

### 💰 Transaction Management
- Create new sales transactions
- Add multiple products (OrderItem) to a single transaction
- Calculate total bill amount automatically
- View transaction history
- Update and delete transactions

### 📦 Inventory Management
- Track physical stock in warehouse
- Add, update, remove inventory items
- Search inventory by ID or item name
- Display all inventory with warehouse location

### 🏭 Supplier Management
- Manage supplier information
- Add, update, delete suppliers
- Search suppliers by ID or name

### 👨‍💼 Employee Management
- Manage employee accounts
- Role-based employee records (Manager, Staff...)
- Search employees by ID or name

### 🎟️ Voucher Management
- Create discount vouchers
- Manage voucher status (Active/Inactive)
- Search and apply vouchers

### 📊 Reporting
- Total products in store
- Total customers
- Total transactions
- Low stock alert (quantity < 5)
- **Top customers** by total purchase value
- **Best-selling products** by total quantity sold

---

## 🏗️ Architecture

The system follows a **4-layer architecture**:

```
┌─────────────────────────────────┐
│         1. UI Layer             │  MainMenu, ProductMenu, ...
│   Handles user interaction      │
├─────────────────────────────────┤
│       2. Manager Layer          │  ProductManager, CustomerManager, ...
│   Business logic & CRUD         │
├─────────────────────────────────┤
│      3. Repository Layer        │  ProductRepository, CustomerRepository, ...
│   File I/O & data conversion    │
├─────────────────────────────────┤
│        4. Model Layer           │  Product, Customer, Transaction, ...
│   Entity classes                │
└─────────────────────────────────┘
         ↕ Read / Write
┌─────────────────────────────────┐
│        5. Data Files            │  products.txt, customers.txt, ...
│   Persistent text file storage  │
└─────────────────────────────────┘
```
Detail of workflow in this link "https://docs.google.com/document/d/1PQ9SdiX04odCMdNSUR6FLeOHqQcqRWV4gSG1Rii7Ep4/edit?usp=sharing"
---

## ⚙️ Business Rules

| Rule | Description |
|------|-------------|
| BR1 | Each Product ID and Customer ID must be unique and cannot be modified |
| BR2 | Product name, price, and stock must not be empty or invalid |
| BR3 | A product must exist before it can be sold |
| BR4 | Stock quantity must be sufficient before completing a transaction |
| BR5 | Quantity sold must be greater than zero |
| BR6 | Total bill = Sum of (price × quantity) of all products |
| BR7 | Stock is reduced immediately after a successful sale |
| BR8 | Transactions must have at least one product |
| BR9 | All inputs must be validated before processing |
| BR10 | Best-selling products are determined by total quantity sold |
| BR11 | Top customers are based on total purchase value |
| BR12 | All data must save to and load from text file |

---

## 🚀 How to Run

### Requirements
- Java JDK 8 or higher
- NetBeans IDE (recommended) or any Java IDE

### Steps
1. Clone the repository:
```bash
git clone https://github.com/nguyenhoangduy2052006-ai/Sale-Management-System
```

2. Open project in NetBeans:
   - File → Open Project → Select `SaleManagementSystem`

3. Run the project:
   - Right-click `Main.java` → Run File

4. The `data/` folder will be created automatically on first run.

---

## 💾 Data Storage

All data is stored in plain text files using `|` as delimiter:

**products.txt** example:
```
LT|LT001|Dell XPS 15|Laptop|25000000.0|5|Intel Core i7|16GB|512GB SSD
SP|SP001|iPhone 15|Smartphone|20000000.0|3|6.1inch|48MP|3500mAh
TV|TV001|Samsung 4K|Television|15000000.0|2|55inch|4K
```

**customers.txt** example:
```
REGULAR|C001|Nguyen Van A|0901234567|Ha Noi|5000000|10.0|100
VIP|C002|Tran Thi B|0912345678|HCM|20000000|20.0|GOLD
```

---

## 📋 OOP Concepts Applied

### Inheritance
```
Product (abstract)
├── Laptop
├── Smartphone
└── Television

Customer
├── RegularCustomer
└── VipCustomer
```

### Polymorphism
Each subclass overrides `toString()` to display its own unique attributes.
`getIdPrefix()` is overridden in each Product subclass to return its specific prefix (`LT`, `SP`, `TV`).

### Encapsulation
All model classes use `private` fields with controlled access through getter and setter methods.

### Abstraction
`Product` is declared as `abstract` — it cannot be instantiated directly. Only concrete subclasses (`Laptop`, `Smartphone`, `Television`) can be created.

---

## 📝 License

This project was developed for educational purposes as part of the **PRO192 course** at **FPT University**.

---

*Group 6 — PRO192 — FPT University*
