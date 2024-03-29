package com.java.basic.chap15_IO.io;

import java.io.*;

public class FileMerge {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE : java FileMerge filename");
            System.exit(0);
        }

        String mergeFileName = args[0];

        try {
            File tempFile = File.createTempFile("~mergetemp", ".tmp", new File("D://Study//javaBasic"));
            tempFile.deleteOnExit();

            FileOutputStream fos = new FileOutputStream(tempFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            BufferedInputStream bis = null;

            int number = 1;

            File f = new File(mergeFileName + "_." + number);

            while (f.exists()) {
                f.setReadOnly();
                bis = new BufferedInputStream(new FileInputStream(f));

                int data = 0;
                while ((data = bis.read()) != -1) {
                    bos.write(data);
                }

                f = new File(mergeFileName + "_." + ++number);
            }

            bos.close();

            File oldFile = new File(mergeFileName);
            if (oldFile.exists()) {
                oldFile.delete();
            }
            tempFile.renameTo(oldFile);
        } catch (IOException e) {}
    }
}
