package com.asansor.thread;

public class AvmCikis implements Runnable {
    public int[] tempKuyruk = {0, 0, 0, 0, 0};

    public int rastgeleKisiSayi;
    public int rastgeleKat;

    public void avmCikisSira() {
        rastgeleKat = (int) (1 + Math.random() * 4);
        rastgeleKisiSayi = (int) (2 + Math.random() * 4);


    }

    @Override
    public void run() {
        while (true) {
            System.out.println("[.AVM CIKIS THREAD CALISIYOR.][----- CIKIS -----]");


            avmCikisSira();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}