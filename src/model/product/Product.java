
package model.product;

public abstract class Product { // Abstract giup xac dinh cu the tung san pham
    // tìm hi?u lai absstract
    // Product ID
    // LTxxx: ID Laptop
    // SPxxx: ID smartphone
    // TVxxx: ID Television

    private final String productId; // final make for each product only has a unique id
    private String productName;
    private String category; // category co nghia la Danh muc hoac duoc dung de phan loai san pham
    private double price;
    private int quantity;

    public Product(String productId, String productName, String category, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = (price >= 0) ? price : 0;
        this.quantity = (quantity >= 0) ? quantity : 0;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setProductName(String productName) {
        this.productName = (productName == null || productName.trim().isEmpty()) ? "Error Product name!" : productName;
    }

    public void setCategory(String category) {
        this.category = (category == null || category.trim().isEmpty()) ? "Error. Can not empty" : category;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Price must be greater than 0.");
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Error. Quantity must be greater than 0 or equal 0.");
        }
    }
    @Override
    public String toString () {
        return String.format("ProductId= %s, Product Name = %s, Category= %s, Price= %.2f, Quantity= %d",
                productId, productName, category, price, quantity);
    }

}
