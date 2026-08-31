package cityelectronics;

import java.util.ArrayList;

public class Order {

    private String orderId;
    private ArrayList<Product> productList;
    private ArrayList<Integer> quantity;
    private double orderValue;
    private String customerName;

    //constructor of this class
    public Order(String orderId) {
        this.orderId = orderId;
        this.productList = new ArrayList<>();
        this.quantity = new ArrayList<>();
        this.orderValue = 0.0;
        this.customerName = "customer1";
    }

    public void addProduct(Product product, int prodQuantity) {

        if (prodQuantity < 1) {
            System.out.println("Quantity should be above zero.");
        }
        productList.add(product);
        quantity.add(prodQuantity);
        orderValue += product.getProductPrice() * prodQuantity;
    }

    public void displayOrder() {
        System.out.println("**********************************************************************************************************************");
        System.out.print("Order ID: " + orderId + "    |");
        System.out.println("Customer: " + customerName);
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Order List:");

        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            int pQuantity = quantity.get(i);
            double prodTotal = p.getProductPrice() * pQuantity;
            System.out.println(String.format("%-25s%-30s%-30s%-15s%-20s", "Product ID: " + p.getProductId(), "|Product Name: " + p.getProductName(),
                    "|Unit Price: " + p.getProductPrice(), "|Quantity: " + pQuantity, "|Subtotal: " + prodTotal));
        }
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Total Order value: Rs " + orderValue);
        System.out.println("**********************************************************************************************************************");
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public ArrayList<Integer> getProductQuantity() {
        return quantity;
    }
}
