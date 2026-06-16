package manager;

import model.product.Product;
import java.util.ArrayList;

public class ProductManager {

    private ArrayList<Product> productList; // Khai bao bien

    public ProductManager() {
        this.productList = new ArrayList<>();
    }

    // findProductById Function 
    public Product findProductById(String productId) {
        for (Product p : productList) {
            if (p.getProductId().equalsIgnoreCase(productId)) {
                return p;
            }
        }
        return null;
    }

    // addNewProduct fuction
    public boolean addNewProduct(Product newProduct) {
        if (findProductById(newProduct.getProductId()) != null) {
            System.out.println("Error. Productt Id existed: " + newProduct.getProductId());
            return false;
        } else {
            this.productList.add(newProduct);
            return true;
        }
    }

    // updateProductInfo
    public boolean updateProductInfo(String productId, String newName, String category, double newPrice, int newQuantity) {
        Product p = findProductById(productId);
        if (p == null) {
            System.out.println("Error. Not found product to update.");
            return false;
        } else {
            p.setProductName(newName);
            p.setPrice(newPrice);
            p.setCategory(category);
            p.setQuantity(newQuantity);
            return true;
        }
    }

    //removeProduct
    public boolean removeProduct(String productId) {
        Product p = findProductById(productId);
        if (p == null) {
            System.out.println("Error. Not found product to delete: " + productId);
            return false;
        } else {
            this.productList.remove(p);
            return true;
        }
    }

    // displayProductList function
    public void displayProductList() {
        for (Product p : this.productList) {
            System.out.println(p.toString());
        }
    }

}
