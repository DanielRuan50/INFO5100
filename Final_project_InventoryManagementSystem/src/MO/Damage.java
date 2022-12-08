package MO;


public class Damage extends OperationOnProduct {
    
    private String cause;

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {            //set damage cause
        this.cause = cause;
    }
}
