package com.will.parcial2;

public class Nquestion {
    private String id;
    private String nq;

    public Nquestion() {
    }

    public Nquestion(String id, String nq) {
        this.id = id;
        this.nq = nq;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNq() {
        return nq;
    }

    public void setNq(String nq) {
        this.nq = nq;
    }
}


