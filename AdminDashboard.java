package cityelectronics;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminDashboard {

    private Scanner input;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    private int prodId;

    public AdminDashboard(Scanner input, ArrayList<Product> products, ArrayList<Order> orders, int prodId) {
        this.input = input;
        this.products = products;
        this.orders = orders;
        this.prodId = prodId;
    }

    //displays admin dashboard
    public void show() {
        int menu;
        do {
            System.out.println("------------------------------------------------");
            System.out.println("| Staff Dashboard |");
            System.out.println("1. Add a product");
            System.out.println("2. Modify product details");
            System.out.println("3. Delete a product");
            System.out.println("4. View all products");
            System.out.println("5. View customer orders");
            System.out.println("6. Logout");
            System.out.print("Select an option 1 - 6: ");

            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1: //adding a product
                    String choice;
                    do {
                        System.out.println("Enter product name:");
                        String name = input.nextLine();

                        System.out.println("Enter product price:");
                        int price = input.nextInt();
                        if (price < 1) {
                            System.out.println("Invalid product price");
                            input.nextLine();
                            break;
                        }
                        System.out.println("Enter the product quantity");
                        int quantity = input.nextInt();
                        input.nextLine();
                        if (quantity < 0) {
                            System.out.println("Invalid product quantity");
                            break;
                        }
                        Product newProduct = new Product(String.valueOf(prodId), name, price, quantity);
                        products.add(newProduct);
                        System.out.println("Product added successfully.");
                        System.out.println("------------------------------------------------------------------------------------------------------");
                        newProduct.displayProduct();
                        System.out.println("------------------------------------------------------------------------------------------------------");
                        prodId++;

                        System.out.println("Do you want to add more products? yes/no");
                        choice = input.nextLine();
                    } while (choice.equalsIgnoreCase("yes"));
                    break;

                case 2: //modifying product details
                    System.out.println("Search the modifying product using: 1. Name | 2. ID");
                    String searchChoice = input.nextLine();

                    Product foundProduct = null;
                    if (searchChoice.equals("1")) {
                        System.out.print("Enter product name: ");
                        String modProdName = input.nextLine();
                        for (Product p : products) {
                            if (p.getProductName().equalsIgnoreCase(modProdName)) {
                                foundProduct = p;
                                break;
                            }
                        }
                    } else if (searchChoice.equals("2")) {
                        System.out.print("Enter product ID: ");
                        String modProdId = input.nextLine();
                        for (Product p : products) {
                            if (p.getProductId().equals(modProdId)) {
                                foundProduct = p;
                                break;
                            }
                        }
                    } else {
                        System.out.println("Invalid option. Returning to menu.");
                        break;
                    }

                    if (foundProduct != null) {
                        System.out.println("Product found:");
                        foundProduct.displayProduct();

                        System.out.println("Which information do you want to update?");
                        System.out.println("1. Product Name");
                        System.out.println("2. Product Price");
                        System.out.println("3. Product Quantity");
                        System.out.println("4. All Product name, price, and quantity");
                        System.out.print("Select 1 - 4: ");
                        int modChoice = input.nextInt();
                        input.nextLine();

                        switch (modChoice) {
                            case 1:
                                System.out.println("Enter the updated name:");
                                String updatedName = input.nextLine();
                                foundProduct.setProductName(updatedName);
                                break;
                            case 2:
                                System.out.println("Enter the updated price:");
                                int updatedPrice = input.nextInt();
                                input.nextLine();
                                foundProduct.setProductPrice(updatedPrice);
                                break;
                            case 3:
                                System.out.println("Enter the updated quantity:");
                                int updatedQuantity = input.nextInt();
                                input.nextLine();
                                foundProduct.setProductQuantity(updatedQuantity);
                                break;
                            case 4:
                                System.out.println("Enter the updated name:");
                                updatedName = input.nextLine();
                                foundProduct.setProductName(updatedName);
                                System.out.println("Enter the updated price:");
                                updatedPrice = input.nextInt();
                                foundProduct.setProductPrice(updatedPrice);
                                System.out.println("Enter the updated quantity:");
                                updatedQuantity = input.nextInt();
                                input.nextLine();
                                foundProduct.setProductQuantity(updatedQuantity);
                                break;
                            default:
                                System.out.println("Invalid option. Please select 1-4.");
                        }

                        System.out.println("Updated product details:");
                        foundProduct.displayProduct();
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3: //deleting a product
                    System.out.println("Search the deleting product using: 1.Name | 2.ID:");
                    String delSearchChoice = input.nextLine();
                    Product foundDelProduct = null;
                    if (delSearchChoice.equals("1")) {
                        System.out.print("Enter product name: ");
                        String delProdName = input.nextLine();
                        for (Product p : products) {
                            if (p.getProductName().equalsIgnoreCase(delProdName)) {
                                foundDelProduct = p;
                                break;
                            }
                        }
                    } else if (delSearchChoice.equals("2")) {
                        System.out.print("Enter product ID: ");
                        String delProdId = input.nextLine();
                        for (Product p : products) {
                            if (p.getProductId().equals(delProdId)) {
                                foundDelProduct = p;
                                break;
                            }
                        }
                    } else {
                        System.out.println("Invalid option. Returning to menu.");
                        break;
                    }
                    if (foundDelProduct != null) {
                        System.out.println("Product found.");
                        foundDelProduct.displayProduct();

                        System.out.println("Are you sure you want to delete? Yes/No");
                        String delConfirm = input.nextLine();

                        if (delConfirm.equalsIgnoreCase("Yes")) {
                            products.remove(foundDelProduct);
                            System.out.println("Product deleted successfully.");
                        } else if (delConfirm.equalsIgnoreCase("No")) {
                            System.out.println("Deletion cancelled.");
                        } else {
                            System.out.println("Invalid choice.");
                        }
                        break;
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4: //view products list
                    if (products.isEmpty()) {
                        System.out.println("No products found.");
                    } else {
                        System.out.println("All products:");
                        for (Product p : products) {
                            p.displayProduct();
                        }
                    }
                    break;

                case 5: //view customer orders
                    if (orders.isEmpty()) {
                        System.out.println("No Orders placed yet.");
                    } else {
                        System.out.println("All Orders:");
                        for (Order o : orders) {
                            o.displayOrder();
                        }
                    }
                    break;

                case 6: //logging out
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid choice. Please select from 1 to 6.");
            }

        } while (menu != 6);
    }
}
