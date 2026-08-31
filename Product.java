package cityelectronics;

public class Product {

    private String productId;
    private String productName;
    private int productPrice;
    private int productQuantity;
    
    //constructor of this class
    public Product(String productId, String productName, int productPrice, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productPrice) {
        if (productPrice > 0) {
            this.productPrice = productPrice;
        } else {
            System.out.println("Invalid price. Must be positive.");
        }
    }
//Ensures product quantity is not negative.
    public void setProductQuantity(int productQuantity) {
        if (productQuantity >= 0) {
            this.productQuantity = productQuantity;
        } else {
            System.out.println("Invalid quantity.");
        }
    }
//Displays product information in a formatted manner.
    public void displayProduct() {
        System.out.println(String.format(
                "%-25s%-30s%-30s%-15s",
                "Product ID: " + productId,
                "| Product Name: " + productName,
                "| Product Price: Rs " + productPrice,
                "|Quantity: " + productQuantity));
    }
}
