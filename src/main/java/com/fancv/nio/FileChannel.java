package com.fancv.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/12/8 16:09
 * @Description
 */
class MyFileChannel {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fosRef = new FileOutputStream(new File("D:\\data\\nio\\nio.txt"));
        FileChannel fileChannel = fosRef.getChannel();
        try {

            String  mychinese="测试nio对于中文的支持程度，最大的字符串的中文支持";
            ByteBuffer buffer = ByteBuffer.wrap(mychinese.getBytes());
            Charset.forName("UTF-8").decode(buffer);
            System.out.println("A fileChannel.position()=" + fileChannel.position());
            System.out.println("write() 1 返回值：" + fileChannel.write(buffer));
            System.out.println("B fileChannel.position()=" + fileChannel.position());
            fileChannel.position(2);
            buffer.rewind(); // 注意：还原buffer的position为0
            // 然后在当前位置position中再进行写入
            System.out.println("write() 2 返回值：" + fileChannel.write(buffer));
            System.out.println("C fileChannel.position()=" + fileChannel.position());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileChannel.close();
        fosRef.close();
    }
}
