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
public class APPLOCATIONS_POJO {
    private int Location_id, Incharge;
    private String Location_name, Physical_location, phone, Service_center;
    private char DELETED, ENABLED;

    public int getLocation_id() {
        return Location_id;
    }

    public void setLocation_id(int Location_id) {
        this.Location_id = Location_id;
    }

    public int getIncharge() {
        return Incharge;
    }

    public void setIncharge(int Incharge) {
        this.Incharge = Incharge;
    }

    public String getLocation_name() {
        return Location_name;
    }

    public void setLocation_name(String Location_name) {
        this.Location_name = Location_name;
    }

    public String getPhysical_location() {
        return Physical_location;
    }

    public void setPhysical_location(String Physical_location) {
        this.Physical_location = Physical_location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getService_center() {
        return Service_center;
    }

    public void setService_center(String Service_center) {
        this.Service_center = Service_center;
    }

    public char getDELETED() {
        return DELETED;
    }

    public void setDELETED(char DELETED) {
        this.DELETED = DELETED;
    }

    public char getENABLED() {
        return ENABLED;
    }

    public void setENABLED(char ENABLED) {
        this.ENABLED = ENABLED;
    }
    
}
