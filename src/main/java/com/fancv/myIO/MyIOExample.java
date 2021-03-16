package com.fancv.myIO;

import java.io.*;

/**
 * java  IO
 */
public class MyIOExample {

    /**
     * TODO
     * 1.循环写入文件txt
     *
     * @param args
     */
    public static void main(String[] args) {
        Boolean fileAppend = Boolean.TRUE;

        /* out(true);*/
        fileReader();
        /*      in();*/

    }


    /**
     * 按字符读取
     */
    private static void fileReader() {


        File file = new File("D:/new.text");
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);

                if (fileReader.ready()) {

                    char cbuf[] = new char[128];
                    while (fileReader.read(cbuf) > 0) {
                        String result = new String(cbuf);
                        System.out.print(result);
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {

            }

        }
    }


    /**
     * 按字符读取
     */
    private static void in() {
        File outPutFile = new File("D:/new.txt");
        FileInputStream fileInputStream = null;
        if (outPutFile.exists()) {
            try {
                outPutFile.createNewFile();

                fileInputStream = new FileInputStream(outPutFile);

                while (fileInputStream.available() > 0) {
                    byte b[] = new byte[2560];
                    int s = fileInputStream.read(b);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    private static void out(Boolean fileAppend) {
        File outPutFile = new File("D:/new.text");
        FileOutputStream fileOutputStream = null;
        if (outPutFile.exists()) {
            try {
                outPutFile.createNewFile();
                //是否追加的方式写入
                fileOutputStream = new FileOutputStream(outPutFile, fileAppend);

                for (int i = 0; i < 1000000; i++) {
                    StringBuilder lineb = new StringBuilder(" hello word ").append(String.valueOf(i)).append("\n");
                    fileOutputStream.write(lineb.toString().getBytes());
                    System.out.println();

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                outPutFile.createNewFile();
                fileOutputStream = new FileOutputStream(outPutFile);

                for (int i = 0; i < 100; i++) {

                    StringBuffer Bsb = new StringBuffer("hamish");
                    StringBuilder lineb = new StringBuilder("hello word").append(String.valueOf(i));
                    fileOutputStream.write(lineb.toString().getBytes());

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
