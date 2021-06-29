package ir.mohamadcm.restservice;


public class URL {
    private final String oldAddress;
    private final String newAddress;
    public URL(String oldAddress, String newAddress){
        this.oldAddress = oldAddress;
        this.newAddress = newAddress;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public String getOldAddress() {
        return oldAddress;
    }
}