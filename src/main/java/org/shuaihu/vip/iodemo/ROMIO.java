package org.shuaihu.vip.iodemo;

import java.io.*;

public class ROMIO {
    public OutputStream outputStream;
    public byte[] bytes;
    public InputStream inputStream;
    public ROMIO(){}
    public ROMIO(OutputStream outputStream,InputStream inputStream){
        this.inputStream=inputStream;
        this.outputStream=outputStream;

    }
    public void toUpper() throws IOException {
        int len=0;
        while((len=this.inputStream.read())!=-1){
            this.outputStream.write(Character.toUpperCase(len));
        }
        System.out.println(this.outputStream);
        this.outputStream.close();
        this.inputStream.close();

    }
}
