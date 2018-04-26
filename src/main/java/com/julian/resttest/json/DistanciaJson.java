package com.julian.resttest.json;

public class DistanciaJson {

    private String startAddress;
    private String endAddress;
    private long inMeters;
    
    public String getStartAddress() {
        return startAddress;
    }
    
    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }
    
    public String getEndAddress() {
        return endAddress;
    }
    
    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }
    
    public long getInMeters() {
        return inMeters;
    }
    
    public void setInMeters(long inMeters) {
        this.inMeters = inMeters;
    }
    
}
