package com.will.parcial2;

public class Rate {
    private String id;
    private String rate;
    private String nq;

    public Rate() {
    }

    public Rate(String id, String rate,String nq) {
        this.id = id;
        this.rate = rate;
        this.nq=nq;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getNq() {
        return nq;
    }

    public void setNq(String nq) {
        this.nq = nq;
    }
}


