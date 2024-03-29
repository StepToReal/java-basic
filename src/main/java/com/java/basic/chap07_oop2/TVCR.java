package com.java.basic.chap07_oop2;

public class TVCR extends TV{
    VCR vcr = new VCR();
    int counter = vcr.counter;

    void play() {
        vcr.play();
    }
}

class TV {
    boolean power;
    int channel;

    void power() { power = !power; }
    void channelUp() { channel++; }
    void channelDown() { channel--; }
}

class VCR {
    boolean power;
    int counter = 0;

    void power() { power = !power; }
    void play() {}
    void stop() {}
    void rew() {}
}
