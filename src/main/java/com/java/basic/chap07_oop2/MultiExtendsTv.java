package com.java.basic.chap07_oop2;

/*
 인터페이스를 이용하여 다중 상속처럼 구현 하였다.
 사실 MultiExtendsVCR 객체를 인스턴스 변수로 넣은걸로 충분하지만
 인스턴스를 추가하여 상속과 구현을 동시에 진행한 경우 다형성을 사용할 수 있다는 장점이 있다.
 */
class MultiExtendsTVCR extends MultiExtendsTv implements IVCR {
    MultiExtendsVCR vcr = new MultiExtendsVCR();

    @Override
    public void play() {
        vcr.play();
    }

    @Override
    public void stop() {
        vcr.stop();
    }

    @Override
    public void reset() {
        vcr.reset();
    }

    @Override
    public int getCounter() {
        return vcr.getCounter();
    }

    @Override
    public void setCounter(int c) {
        vcr.setCounter(c);
    }
}

public class MultiExtendsTv {
    protected boolean power;
    protected int channel;
    protected int volume;

    public void power() { power = !power; }
    public void channelUp() { channel++; }
    public void channelDown() { channel--; }
    public void volumeUp() { volume++; }
    public void volumeDown() { volume--; }
}

class MultiExtendsVCR {
    protected int counter;

    public void play() {}
    public void stop() {}
    public void reset() { counter = 0; }
    public int getCounter() { return counter; }
    public void setCounter(int counter) { this.counter = counter; }
}

interface IVCR {
    void play();
    void stop();
    void reset();
    int getCounter();
    void setCounter(int c);
}



