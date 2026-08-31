package cityelectronics;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        int prodId = 6;
        int orderId = 3;

        products.add(new Product("1", "Laptop", 150000,30));
        products.add(new Product("2", "Smartphone", 75000,40));
        products.add(new Product("3", "Printer", 25000,45));
        products.add(new Product("4", "Headphones", 10000,70));
        products.add(new Product("5", "Monitor", 40000,25));

        Order order1 = new Order("1");
        order1.addProduct(products.get(0), 1); // Laptop x1
        order1.addProduct(products.get(1), 2); // Smartphone x2

        Order order2 = new Order("2");
        order2.addProduct(products.get(2), 1); // Printer x1
        order2.addProduct(products.get(4), 1); // Monitor x1

        orders.add(order1);
        orders.add(order2);

        String validAdminUsername = "admin";
        String validAdminPassword = "pass";
        String validCusUsername = "cus";
        String validCusPassword = "pass";

        while (true) {
        System.out.println("Welcome to City Electronics");
        System.out.println("Are you a staff / customer ?");
        System.out.println("1.Staff | 2.Customer |3.Exit");
        String loginChoice = input.nextLine();
        
            switch (loginChoice) {
                case "1":
                    boolean adminLoginStatus = false;
                    int adminLoginAttempt = 0;
                    while (adminLoginAttempt < 3) {
                        System.out.print("Enter admin username: ");
                        String username = input.nextLine();
                        System.out.print("Enter password: ");
                        String password = input.nextLine();

                        if (username.equals(validAdminUsername) && password.equals(validAdminPassword)) {
                            adminLoginStatus = true;
                            System.out.println("Login successful!");
                            AdminDashboard admin = new AdminDashboard(input, products, orders, prodId);
                            admin.show();
                            break;
                        } else {
                            adminLoginAttempt++;
                            System.out.println("Invalid login, try again.");
                        }
                        
                    }
                    if(adminLoginStatus == false){
                    System.out.println("Too many attempts, account locked!");
                    return;
                    }
                    break;

                case "2":
                    boolean cusLoginStatus = false;
                    int cusLoginAttempt = 0;
                    while (cusLoginAttempt < 3) {
                        System.out.print("Enter customer username: ");
                        String username = input.nextLine();
                        System.out.print("Enter password: ");
                        String password = input.nextLine();

                        if (username.equals(validCusUsername) && password.equals(validCusPassword)) {
                            cusLoginStatus = true;
                            System.out.println("Login successful!");
                            CustomerDashboard customer = new CustomerDashboard(input, products, orders, orderId);
                            customer.show();
                            break;
                        } else {
                            cusLoginAttempt++;
                            System.out.println("Invalid login, try again.");
                        }
                        
                    }
                    if(cusLoginStatus == false){
                        System.out.println("Too many attempts, account locked!");
                    return;
                    }
                    break;

                case "3":
                    System.out.println("Thank You for visiting City Electronics.");
                    return;
                default:
                    System.out.println("Invalid role choice. Select an option: 1 - 3.");
            }
        }
    }
}
