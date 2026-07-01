
package model.product;

public class Smartphone extends Product {
    private String screenSize;
    private String camera;
    private String battery;
    
    public Smartphone (String productId, String productName, String category, double price, int quantity, String screenSize, String camera, String battery) {
        super(productId, productName, category, price, quantity);
        this.screenSize=screenSize;
        this.camera=camera;
        this.battery=battery;
    }
    
    public String getScreenSize () {
        return screenSize;
    }
    public String getCamera () {
        return camera;
    }
    public String getBattery () {
        return battery;
    }
    
    public void setScreenSize (String screenSize) {
        this.screenSize=screenSize;
    }
    public void setCamera (String camera) {
        this.camera=camera;
    }
    public void setBattery (String battery) {
        this.battery=battery;
    }
    
    @Override
    public String getIdPrefix () {
        return "SP";
    }
    @Override
    public String toString () {
        return super.toString() + String.format("| Screen Size: %s | Camera: %s | Battery: %s |", 
                screenSize, camera, battery);
    }
}
