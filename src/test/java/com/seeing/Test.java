package com.seeing;

import org.apache.commons.codec.*;

import java.io.*;

public class Test {

    public void Path() throws IOException {


//        InputStream s1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("var/code");
        System.out.println(System.getProperty("user.dir"));
        String s = System.getProperty("user.dir");
        String s2 = "\\picture\\";
        String s3 = "m.png";

        String path =  s + s2 + s3;
        File file = new File(path);
        if( !file.isFile() ){
            file.createNewFile();
        }

        String c1  ="D:\\Seeing&lucky\\文档\\springboot_mybatis.png";

        FileInputStream in = new FileInputStream(c1);

        FileOutputStream on = new FileOutputStream(file);

        int l = 0;
        byte[] buffer = new byte[256];
        while ( (l = in.read(buffer) ) != -1){
            on.write(buffer);
        }

    }

    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.Path();
        }catch (Exception e){

        }
    }


}
