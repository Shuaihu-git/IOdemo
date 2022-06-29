package org.shuaihu.vip.iodemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;

public class PipeInputImpl implements Runnable{
    private PipedInputStream pipedInputStream;
    public PipeInputImpl(){
        this.pipedInputStream=new PipedInputStream();
    }

    public PipedInputStream getPipedInputStream() {
        return pipedInputStream;
    }

    @Override
    public void run() {
            int len=0;
            byte data[]=new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            try {
                while ((len=this.pipedInputStream.read(data))!=-1) {
                    byteArrayOutputStream.write(data,0,len);
                }
                System.out.println("[接收端]"+Thread.currentThread().getName()+"接收内容：{"+new String(byteArrayOutputStream.toByteArray())+"}");
                byteArrayOutputStream.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                this.pipedInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


    }
}
