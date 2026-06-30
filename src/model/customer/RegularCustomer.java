package model.customer;

public class RegularCustomer extends Customer {

    private double regularDiscount;
    private int rewardPoints;

    public RegularCustomer(String customerID, String customerName,
                           String phoneNumber, String address,
                           double totalPurchase,
                           double regularDiscount,
                           int rewardPoints) {
        super(customerID, customerName, phoneNumber, address, totalPurchase);
        this.regularDiscount = regularDiscount;
        this.rewardPoints = rewardPoints;
    }

    public double getRegularDiscount() {
        return regularDiscount;
    }

    public void setRegularDiscount(double regularDiscount) {
        this.regularDiscount = regularDiscount;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nCustomer Type: Regular"
                + "\nRegular Discount: " + regularDiscount
                + "\nReward Points: " + rewardPoints;
    }
}
