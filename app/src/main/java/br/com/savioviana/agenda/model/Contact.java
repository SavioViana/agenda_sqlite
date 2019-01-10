package br.com.savioviana.agenda.model;

public class Contact {

    private int contact_id;
    private String name;
    private String address;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String site;
    private float avaible;

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public float getAvaible() {
        return avaible;
    }

    public void setAvaible(float avaible) {
        this.avaible = avaible;
    }

    @Override
    public String toString(){
        return name;
    }

}
