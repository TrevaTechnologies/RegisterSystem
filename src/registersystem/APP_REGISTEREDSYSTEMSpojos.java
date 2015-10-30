/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registersystem;

import java.util.Date;

/**
 *
 * @author Akshai
 */
public class APP_REGISTEREDSYSTEMSpojos {

    private String SYSNAME, IP, USERACCOUNTNAME, SERVICECENTERS, OS;
    private int SYSID, LOCATIONID, OWNERID;
    private char ISCASHCOUNTER, ENABLED, DELETED;
    private Date DATEOFREGISTRATION;

    public String getSYSNAME() {
        return SYSNAME;
    }

    public void setSYSNAME(String SYSNAME) {
        this.SYSNAME = SYSNAME;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getUSERACCOUNTNAME() {
        return USERACCOUNTNAME;
    }

    public void setUSERACCOUNTNAME(String USERACCOUNTNAME) {
        this.USERACCOUNTNAME = USERACCOUNTNAME;
    }

    public String getSERVICECENTERS() {
        return SERVICECENTERS;
    }

    public void setSERVICECENTERS(String SERVICECENTERS) {
        this.SERVICECENTERS = SERVICECENTERS;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getSYSID() {
        return SYSID;
    }

    public void setSYSID(int SYSID) {
        this.SYSID = SYSID;
    }

    public int getLOCATIONID() {
        return LOCATIONID;
    }

    public void setLOCATIONID(int LOCATIONID) {
        this.LOCATIONID = LOCATIONID;
    }

    public int getOWNERID() {
        return OWNERID;
    }

    public void setOWNERID(int OWNERID) {
        this.OWNERID = OWNERID;
    }

    public char getISCASHCOUNTER() {
        return ISCASHCOUNTER;
    }

    public void setISCASHCOUNTER(char ISCASHCOUNTER) {
        this.ISCASHCOUNTER = ISCASHCOUNTER;
    }

    public char getENABLED() {
        return ENABLED;
    }

    public void setENABLED(char ENABLED) {
        this.ENABLED = ENABLED;
    }

    public char getDELETED() {
        return DELETED;
    }

    public void setDELETED(char DELETED) {
        this.DELETED = DELETED;
    }

    public Date getDATEOFREGISTRATION() {
        return DATEOFREGISTRATION;
    }

    public void setDATEOFREGISTRATION(Date DATEOFREGISTRATION) {
        this.DATEOFREGISTRATION = DATEOFREGISTRATION;
    }

}
