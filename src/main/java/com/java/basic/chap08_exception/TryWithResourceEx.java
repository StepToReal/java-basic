package com.java.basic.chap08_exception;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class TryWithResourceEx {
    public static void main(String[] args) {

        //2개 이상 resource 사용은 아래와 같다.
        try (FileInputStream fis = new FileInputStream("test.dat");
             DataInputStream dis = new DataInputStream(fis)) {

        } catch (Exception e) {

        }

        // printStackTrace 에 의한 예외 스택 호출은 비동기로 동작하는듯 하다.
        // 그냥 실행 시켰을때 예외로그가 뒤에 몰아 나오는 형태가 된다.
        // 참고로 printStackTrace 는 System.err을 이용해 출력하고 시스템 스택을 뒤지기 때문에 성능에 부담을 준다.
        try (CloseableResource cr = new CloseableResource()) {
            cr.exceptionWork(false); //예외 발생 안함.
        } catch (WorkException e) {
            e.printStackTrace();
        } catch (CloseException e) {
            e.printStackTrace();
        }

        System.out.println();

        try (CloseableResource cr = new CloseableResource()) {
            cr.exceptionWork(true); //예외 발생 함.
        } catch (WorkException e) {
            e.printStackTrace();
        } catch (CloseException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            CloseableResource cr = new CloseableResource();
            cr.exceptionWork(false);
            cr.close();
        } catch (WorkException e) {
            e.printStackTrace();
        } catch (CloseException e) {
            e.printStackTrace();
        }
    }
}

class CloseableResource implements AutoCloseable {

    public void exceptionWork(boolean exception) throws WorkException {
        System.out.println("exceptionWork (" + exception + ") was called");

        if (exception) {
            throw new WorkException ("WorkException occurred!");
        }
    }

    @Override
    public void close() throws CloseException {
        System.out.println("close() was called");        
        throw new CloseException("CloseException occurred");
    }
}

class WorkException extends Exception {
    WorkException (String msg) {
        super(msg);
    }
}

class CloseException extends Exception {
    CloseException (String msg) {
        super(msg);
    }
}