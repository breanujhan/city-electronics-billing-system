package cityelectronics;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDashboard {

    private Scanner input;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    private int orderId;

    public CustomerDashboard(Scanner input, ArrayList<Product> products, ArrayList<Order> orders, int orderId) {
        this.input = input;
        this.products = products;
        this.orders = orders;
        this.orderId = orderId;
    }

    //displays customer dashboard
    public void show() {
        int menu;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("|             Customer Dashboard             |");
            System.out.println("----------------------------------------------");
            System.out.println("1. View all products");
            System.out.println("2. Place an order");
            System.out.println("3. View orders");
            System.out.println("4. Logout");
            System.out.println("Select an option 1 - 4: ");
            System.out.println("----------------------------------------------");

            menu = input.nextInt();
            input.nextLine();
            switch (menu) {
                case 1: //viewing products list
                    if (products.isEmpty()) {
                        System.out.println("No products found.");
                    } else {
                        System.out.println("|| All products ||");
                        for (Product p : products) {
                            p.displayProduct();
                        }
                    }
                    break;

                case 2: //placing an order
                    String addMore;
                    Order order = new Order(String.valueOf(orderId));

                    do {
                        System.out.print("Enter the product name: ");
                        String searchProdName = input.nextLine();
                        boolean found = false;

                        for (Product p : products) {
                            if (p.getProductName().equalsIgnoreCase(searchProdName)) {
                                found = true;
                                System.out.println("Product found:");
                                p.displayProduct();

                                System.out.println("Enter Product Quantity:");
                                int qty = input.nextInt();
                                input.nextLine();
                                if (qty <= p.getProductQuantity()) {
                                    order.addProduct(p, qty);
                                    System.out.println("Product added to order.");
                                    int currentQuantity = p.getProductQuantity() - qty;
                                    p.setProductQuantity(currentQuantity);
                                } else {
                                    System.out.println("Insufficient stock");
                                    break;
                                }
                                break;
                            }
                        }

                        if (found == false) {
                            System.out.println("Product not found.");
                        }

                        System.out.println("Do you want to add more products? Yes / No");
                        addMore = input.nextLine();

                    } while (addMore.equalsIgnoreCase("Yes"));

                    orders.add(order);
                    order.displayOrder();
                    orderId++;
                    break;

                case 3: //viewing placed orders
                    if (orders.isEmpty()) {
                        System.out.println("No orders found.");
                    } else {
                        for (Order o : orders) {
                            o.displayOrder();
                        }
                    }
                    break;

                case 4: //log out
                    System.out.println("Logging out. Thank you for visiting City Electronics.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (menu != 4);
    }
}

