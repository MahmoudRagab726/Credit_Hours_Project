
package Model;

// this is a model class to store my Data 

import java.util.HashSet;

public class Model {
    private String SSN,PSW;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String name;
    

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getPSW() {
        return PSW;
    }

    public void setPSW(String PSW) {
        this.PSW = PSW;
    }
   
    private HashSet<String> viewList;

    public HashSet<String> getViewList() {
        return viewList;
    }

    public void setViewList(HashSet<String> viewList) {
        this.viewList = viewList;
    }

    

    
    

  
    
}
