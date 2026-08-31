City Electronics – Java Electronics Store Management System

A simple Java-based electronics store management and billing system with separate Admin and Customer dashboards. The system allows administrators to manage products and view customer orders, while customers can browse products, place orders, and view their order details.

Features
+Admin Dashboard
+Add new products
+Modify product name, price, and quantity
+Delete products
+View all products
+View customer orders
+Logout
+Customer Dashboard
+View all available products
+Search for products by name when placing an order
+Add multiple products to an order
+Check product stock availability
+Automatically update product quantity after an order
+View placed orders
+Logout
+Login System
+Separate login for Admin and Customer
+Username and password verification
+Maximum of 3 login attempts
+Account access is denied after unsuccessful login attempts

Technologies Used
+Java
+ArrayList
+Scanner
+Object-Oriented Programming (OOP)
+OOP Concepts Demonstrated

This project demonstrates several Java and OOP concepts, including:

+Classes and Objects
+Encapsulation
+Constructors
+Getters and Setters
+ArrayLists
+Methods
+Conditional Statements
+Loops
+Switch Statements
+User Input Handling

Project Structure
CityElectronics/
│
├── Main.java
├── AdminDashboard.java
├── CustomerDashboard.java
├── Product.java
└── Order.java

Class Overview

Main.java

Starts the application
Initializes products and sample orders
Handles user role selection and login

AdminDashboard.java

Handles admin operations
Manages products
Displays customer orders

CustomerDashboard.java

Handles customer operations
Allows customers to browse products and place orders

Product.java

Stores product information such as ID, name, price, and quantity
Provides methods for updating and displaying product details

Order.java

Stores order information
Keeps track of products and quantities
Calculates the total order value
Login Credentials
Admin
Username: admin
Password: pass

Customer
Username: cus
Password: pass


Note: These credentials are hard-coded for demonstration purposes and should not be used in a real-world application.

How to Run
1. Clone the repository
git clone <your-repository-url>

2. Open the project

Open the project in a Java-compatible IDE such as:

IntelliJ IDEA
Eclipse
NetBeans
Visual Studio Code
3. Run the application

Run:

Main.java


The application will display the main menu:

Welcome to City Electronics
Are you a staff / customer ?
1. Staff | 2. Customer | 3. Exit


Select the appropriate option and log in using the credentials provided above.

Example Workflow
Admin
Login
  ↓
Admin Dashboard
  ↓
Add / Modify / Delete / View Products
  ↓
View Customer Orders
  ↓
Logout

Customer
Login
  ↓
Customer Dashboard
  ↓
View Products
  ↓
Place Order
  ↓
Select Products & Quantities
  ↓
View Order
  ↓
Logout

Author

[Balachandran Reanujhan]

This project was developed as a Java programming/OOP project to demonstrate the implementation of a simple electronics store management and ordering system.
