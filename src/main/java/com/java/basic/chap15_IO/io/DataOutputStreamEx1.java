package com.java.basic.chap15_IO.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx1 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream("src/main/java/com/java/basic/chap15/files/sample.dat");
            dos = new DataOutputStream(fos);
            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
