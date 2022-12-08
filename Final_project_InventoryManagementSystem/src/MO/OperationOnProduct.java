package MO;

import com.toedter.calendar.JDateChooser;

public class OperationOnProduct {
    
    private Product product;                //create variables
    private JDateChooser jDateChooser;
    private int transactionQuantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {           //set product
        this.product = product;
    }

    public JDateChooser getOperationDate() {
        return jDateChooser;
    }

    public void setOperationDate(JDateChooser jDateChooser) {           //set date
        this.jDateChooser = jDateChooser;
    }

    public int getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(int transactionQuantity) {       //set transaction quantity
        this.transactionQuantity = transactionQuantity;
    }
}
