package com.java.basic.chap16.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer4 implements Runnable{
    ServerSocket serverSocket;
    Thread[] threadArr;

    public static void main(String[] args) {
        TcpIpServer4 server = new TcpIpServer4(5);
        server.start();
    }

    public TcpIpServer4 (int num) {
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + " server is ready");

            threadArr = new Thread[num];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        for (int i = 0; i < threadArr.length; i++) {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }

    public void run() {
        while (true) {
            try {
                String threadName = Thread.currentThread().getName();

                System.out.println(getTime() + threadName + "가 연결 요청을 기다립니다.");

                Socket socket = serverSocket.accept();
                System.out.println(getTime() + threadName + "-" + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF(threadName + "-" + "[Notice] Test Message1 from Server.");
                System.out.println(getTime() + threadName + "-" + "데이터를 전송 했습니다.");

                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
