
package model.product;

public class Laptop extends Product{
    private String ram;
    private  String cpu;
    private String storage;
    
    public Laptop (String productId, String productName, String category, double price, int quantity, String ram, String cpu, String storage) {
        super(productId, productName, category, price, quantity);
        this.ram=ram;
        this.cpu=cpu;
        this.storage=storage;
    }
    public String getRam () {
        return ram;
    }
    public String getCPU () {
        return cpu;
    }
    public String getStorage () {
        return cpu;
    }
    
    public void setRam (String ram) {
        this.ram=ram;
    }
    public void setCPU (String cpu) {
        this.cpu=cpu;
    }
    public void setStorage (String storage) {
        this.storage=storage;
    }
    @Override
    public String toString () {
        return super.toString() + String.format("| RAM: %s || CPU: %s | Storage: %s",
                ram, cpu, storage);
    }
}
