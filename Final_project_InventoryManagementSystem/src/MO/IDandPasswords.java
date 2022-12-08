package MO;

import java.util.HashMap;

public class IDandPasswords {
    private HashMap<String,String> logininfo = new HashMap<>();         //use HashMap to store account and password in logininfo

    public IDandPasswords(){

        logininfo.put("Admin","password");          //accounts and password
        logininfo.put("12","12");
        logininfo.put("account","password123");

    }

    public HashMap getLoginInfo(){

        return logininfo;

    }
}
