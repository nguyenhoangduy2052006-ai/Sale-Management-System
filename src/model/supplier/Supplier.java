package model.supplier;

public class Supplier {

    private final String supplierID;
    private String supplierName;
    private String contactName;
    private String phoneNumber;

    public Supplier(String supplierID, String supplierName, String contactName, String phoneNumber) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getSupplierID() {
        return supplierID;
    }
    // HÀM setSupplierID() ĐÃ ĐƯỢC XÓA BỎ ĐỂ ĐẢM BẢO TÍNH ĐÓNG GÓI CHUẨN OOP

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-25s | %-20s | %-15s |", supplierID, supplierName, contactName, phoneNumber);
    }
}
