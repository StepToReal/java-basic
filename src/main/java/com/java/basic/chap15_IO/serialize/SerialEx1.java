package com.java.basic.chap15_IO.serialize;

import java.io.*;
import java.util.ArrayList;

public class SerialEx1 {
    public static void main(String[] args) {
        try {
            String fileName = "src/main/java/com/java/basic/chap15/files/UserInfo.ser";
            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            ObjectOutputStream out = new ObjectOutputStream(bos);

            UserInfo u1 = new UserInfo("javaMan", "123", 30);
            UserInfo u2 = new UserInfo("javaWoman", "321", 26);

            ArrayList<UserInfo> list = new ArrayList<>();
            list.add(u1);
            list.add(u2);

            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);
            out.close();
            System.out.println("Serialize is done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
