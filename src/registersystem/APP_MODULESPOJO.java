/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registersystem;

/**
 *
 * @author Akshai
 */
public class APP_MODULESPOJO {
  private int MODULEID;
    private String MODULENAME;
    private Double VERSION;
    private char ENABLED;

    public int getMODULEID() {
        return MODULEID;
    }

    public void setMODULEID(int MODULEID) {
        this.MODULEID = MODULEID;
    }

    public String getMODULENAME() {
        return MODULENAME;
    }

    public void setMODULENAME(String MODULENAME) {
        this.MODULENAME = MODULENAME;
    }

    public Double getVERSION() {
        return VERSION;
    }

    public void setVERSION(Double VERSION) {
        this.VERSION = VERSION;
    }

    public char getENABLED() {
        return ENABLED;
    }

    public void setENABLED(char ENABLED) {
        this.ENABLED = ENABLED;
    }
    
}
