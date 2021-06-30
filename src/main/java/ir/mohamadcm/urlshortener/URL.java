package ir.mohamadcm.restservice;

import org.springframework.data.annotation.Id;


public class URL {
    @Id
    private String id;

    private String oldAddress;
    private String newAddress;

    public URL() {
    }

    public URL(String oldAddress, String newAddress) {
        this.oldAddress = oldAddress;
        this.newAddress = newAddress;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public String getOldAddress() {
        return oldAddress;
    }

    @Override
    public String toString(){
        return String.format("URL [old: %s, new: %s, id:%d]", oldAddress, newAddress, id);
    }
}