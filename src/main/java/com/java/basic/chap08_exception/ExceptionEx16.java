package com.java.basic.chap08_exception;

import java.io.File;

public class ExceptionEx16 {
    public static void main(String[] args) {
        try {
            File f = createFile(args[0]);
            System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " 다시 입력해 주시기 바랍니다.");
        }
    }

    /*
    ExceptionEx15, 16 차이 -
    15 : 메서드 내부에서 기본 이름을 부여하여 처리 -> 내부 처리
    16 : 메서드 외부에서 이름을 다시 받아옴 -> 예외 던짐
     */
    static File createFile(String fileName) throws Exception {
        if (fileName == null || fileName.equals("")) {
            throw new Exception("파일 이름이 유효하지 않습니다.");
        }

        File f = new File(fileName);
        f.createNewFile();
        return f;
    }
}
