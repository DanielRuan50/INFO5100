package MO;

public class Product {

    private String name, code;                      //create variables
    private int totalQuantity, reorderLevel;

    public Product() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {              //set inventory name
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {              //set inventory code
        this.code = code;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {       //set total quantity
        this.totalQuantity = totalQuantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {         //set reorder level
        this.reorderLevel = reorderLevel;
    }

    @Override
    public String toString() {                              //return product list as string
        return name + " || Code: " + code + " Qty: " + totalQuantity;
    }
}
