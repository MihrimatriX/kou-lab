package com.asansor.thread;

public class binakatlari {
    private int[] toplamhedefistegi;
    private int[] varanyolcular;
    private int[] yolcuistekleri;
    private int yaklasan_asansor;

    public binakatlari() {
        toplamhedefistegi = new int[5];
        varanyolcular = new int[5];
        yolcuistekleri = new int[5];
        yaklasan_asansor = -1;
    }

    public void setYaklasan_asansor(int n) {
        this.yaklasan_asansor = n;
    }

    public void increaseArrivedPassengers(int from, int n) {
        this.varanyolcular[from] = this.varanyolcular[from] + n;
    }

    public void increasePassengersRequests(int floor, int n) {
        this.yolcuistekleri[floor] = this.yolcuistekleri[floor] + n;
        this.toplamhedefistegi[floor] = this.toplamhedefistegi[floor] + n;
    }

    public int[] getToplamhedefistegi() {
        return this.toplamhedefistegi;
    }

    public int[] getVaranyolcular() {
        return this.varanyolcular;
    }

    public int getYaklasan_asansor() {
        return this.yaklasan_asansor;
    }

    public int[] getYolcuistekleri() {
        return this.yolcuistekleri;
    }

    public void setYolcuistekleri(int[] yolcuistekleri) {
        this.yolcuistekleri = yolcuistekleri;
    }

    public boolean yolcuisteklerini_al() {
        for (int i = 0; i < yolcuistekleri.length; i++) {
            if (yolcuistekleri[i] != 0) {
                return true;
            }
        }
        return false;
    }
}
