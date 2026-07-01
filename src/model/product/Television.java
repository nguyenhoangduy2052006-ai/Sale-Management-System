
package model.product;

public class Television extends Product {
    private String screenSize;
    private String resolution;
    
    public Television (String productId, String productName, String category, double price, int quantity, String screenSize, String resolution) {
        super(productId, productName, category, price, quantity);
        this.screenSize=screenSize;
        this.resolution=resolution;
        
    }
    
    public String getScreenSize () {
        return screenSize;
    }
    public String getResolution () {
        return resolution;
    }
    
    public void setScreenSize (String screenSize) {
        this.screenSize=screenSize;
    }
    public void setResolution (String resolution) {
        this.resolution=resolution;
    }
    
    @Override 
    public String getIdPrefix () {
        return "TV";
    }
    @Override
    public String toString () {
        return super.toString() + String.format("| Screen Size: %s | Resolution: %s |", 
                screenSize, resolution);
    }
}
