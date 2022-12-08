package MO;

import java.util.ArrayList;
import com.toedter.calendar.JDateChooser;
import java.util.List;


public class Shop {

    private List<Product> productList;                  //create variables
    private List<Purchase> purchaseList;
    private List<Sale> salesList;
    private List<Damage> damageList;
    private static Shop aShop;
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {             //set product list
        this.productList = productList;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {           //set purchase list
        this.purchaseList = purchaseList;
    }

    public List<Sale> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sale> salesList) {                    //set sales list
        this.salesList = salesList;
    }

    public List<Damage> getDamageList() {
        return damageList;
    }

    public void setDamageList(List<Damage> damageList) {                //set damage list
        this.damageList = damageList;
    }

    public Shop() {
        productList = new ArrayList<Product>();                         //new arraylists
        purchaseList = new ArrayList<Purchase>();
        salesList = new ArrayList<Sale>();
        damageList = new ArrayList<Damage>();
    }
    public static Shop getShop() {
        if (aShop == null) {
            aShop = new Shop();
        }

        return aShop;
    }

    public static Shop getShop(List<Product> seedProducts) {
        Shop shop = getShop();
        shop.productList = seedProducts;
        return shop;
    }

    public String enlistProduct(Product aProduct) {
        for (Product product1 : productList) {                          //check if product is enlisted
            if (product1.getCode() == aProduct.getCode()) {
                return "This product code is already enlisted.";
            } else if (product1.getName() == aProduct.getName()) {
                return "Product name is already enlisted.";
            }
        }

        productList.add(aProduct);
        return "Product is enlisted.";
    }

    public String addSale(Sale aSale) {                                   //update sale
        for (Product aProduct : productList) {
            if (aProduct.getCode() == aSale.getProduct().getCode()) {
                if (aProduct.getTotalQuantity() >= aSale.getTransactionQuantity()) {
                    aProduct.setTotalQuantity(aProduct.getTotalQuantity() - aSale.getTransactionQuantity());
                } else {
                    return "Sorry, you don't have enough quantity to sell.";
                }
            }
        }
        
        salesList.add(aSale);
        return "Sale has been updated.";
    }

    public String addPurchase(Purchase aPurchase) {                         //update purchase
        for (Product aProduct : productList) {
            if (aProduct.getCode() == aPurchase.getProduct().getCode()) {
                aProduct.setTotalQuantity(aProduct.getTotalQuantity() + aPurchase.getTransactionQuantity());
            }
        }
        
        purchaseList.add(aPurchase);
        return "Purchase has been updated.";
    }

    public String addDamage(Damage aDamage) {                               //update damage
        for (Product aProduct : productList) {
            if (aProduct.getCode() == aDamage.getProduct().getCode()) {
                if (aProduct.getTotalQuantity() >= aDamage.getTransactionQuantity()) {
                    aProduct.setTotalQuantity(aProduct.getTotalQuantity() - aDamage.getTransactionQuantity());
                } else {
                    return "Damage quantity can't exceed total quantity.";
                }
            }
        }
        damageList.add(aDamage);
        return "Damage has been updated.";
    }

    public List<Sale> getSalesOfADate(JDateChooser jDateChooser) {          //get sales date
        List<Sale> salesOfADate = new ArrayList<Sale>();
        for (Sale aSale : salesList) {
            if (aSale.getOperationDate().getDate().getMonth() == jDateChooser.getDate().getMonth()
                    && aSale.getOperationDate().getDate().getDate() == jDateChooser.getDate().getDate()
                    && aSale.getOperationDate().getDate().getYear() == jDateChooser.getDate().getYear()) {
                salesOfADate.add(aSale);
            }
        }

        return salesOfADate;
    }

    public List<Purchase> getPurchaseOfADate(JDateChooser jDateChooser) {       //get purchase date
        List<Purchase> purchaseOfADate = new ArrayList<Purchase>();
        for (Purchase aPurchase : purchaseList) {
            if (aPurchase.getOperationDate().getDate().getMonth() == jDateChooser.getDate().getMonth()
                    && aPurchase.getOperationDate().getDate().getDate() == jDateChooser.getDate().getDate()
                    && aPurchase.getOperationDate().getDate().getYear() == jDateChooser.getDate().getYear()) {
                purchaseOfADate.add(aPurchase);
            }
        }

        return purchaseOfADate;
    }

    public List<Damage> getDamageOfADate(JDateChooser jDateChooser) {           //get damage date
        List<Damage> damageOfADate = new ArrayList<Damage>();
        for (Damage aDamage : damageList) {
            if (aDamage.getOperationDate().getDate().getMonth() == jDateChooser.getDate().getMonth()
                    && aDamage.getOperationDate().getDate().getDate() == jDateChooser.getDate().getDate()
                    && aDamage.getOperationDate().getDate().getYear() == jDateChooser.getDate().getYear()) {
                damageOfADate.add(aDamage);
            }
        }

        return damageOfADate;
    }
}
