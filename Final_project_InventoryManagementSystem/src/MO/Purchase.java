package MO;

public class Purchase extends OperationOnProduct {

    private String vendorName;                          //create variables
    private double totalAmount;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {      //set vendor name
        this.vendorName = vendorName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {        //set total amount
        this.totalAmount = totalAmount;
    }
}
