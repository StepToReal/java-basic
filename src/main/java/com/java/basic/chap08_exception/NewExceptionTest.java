package com.java.basic.chap08_exception;

public class NewExceptionTest {
    public static void main (String[] args) {
        try {
            startInstall();
        } catch (SpaceException e) {
            System.out.println("Error msg :" + e.getMessage());
            e.printStackTrace();
            System.out.println("Please free up space and reinstall");
        } catch (MemoryException e) {
            System.out.println("Error msg :" + e.getMessage());
            e.printStackTrace();
            System.gc();
            System.out.println("Please reinstall");
        } finally {
            System.out.println("Delete temp files");
        }
    }

    private static void startInstall() throws SpaceException, MemoryException {
        if (!enoughSpace()) {
            throw new SpaceException("install space lask");
        }

        if (!enoughMemory()) {
            throw new MemoryException("memory lack");
        }
    }

    static boolean enoughSpace() {
        return true;
    }

    static boolean enoughMemory() {
        return false;
    }
}

class SpaceException extends Exception {
    SpaceException(String msg) {
        super(msg);
    }
}

class MemoryException extends RuntimeException {
    MemoryException(String msg) {
        super(msg);
    }
}
