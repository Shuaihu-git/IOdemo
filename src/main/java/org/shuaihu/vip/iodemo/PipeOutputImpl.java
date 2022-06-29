package org.shuaihu.vip.iodemo;

import java.io.IOException;
import java.io.PipedOutputStream;

public class PipeOutputImpl implements Runnable{
    private PipedOutputStream pipedOutputStream;
    public PipeOutputImpl(){
        this.pipedOutputStream=new PipedOutputStream();
    }

    public PipedOutputStream getPipedOutputStream() {
        return pipedOutputStream;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                this.pipedOutputStream.write(("("+"发送端"+")"+(i+1)+Thread.currentThread().getName()+"\n").getBytes());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            this.pipedOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
