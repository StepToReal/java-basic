package com.java.basic.chap07_oop2;

public class CaptionTvTest {
    public static void main(String[] args) {
        CaptionTv captionTv = new CaptionTv();
    
        captionTv.channel = 10;
    }
}

class Tv {
    boolean power;
    int channel;

    void power() { power = !power; }
    void channelUp() { channel++; }
    void channelDown() { channel--; }
}

class CaptionTv extends Tv {
    boolean caption;

    void displayCaption(String text) {
        if (caption) {
            System.out.println(text);
        }
    }
}