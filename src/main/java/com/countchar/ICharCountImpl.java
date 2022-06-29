package com.countchar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ICharCountImpl implements ICharCount{
    private BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    @Override
    public String getString(String prom) {
        String str=null;
        boolean flag=true;
        while (flag){
            System.out.print(prom);
            try {
                str=this.bufferedReader.readLine();
            } catch (IOException e) {

            }
        }
        return str;
    }

    @Override
    public String getStringNotNull(String prom) {
        String str=null;
        boolean flag=true;
        while (flag){
            try {
                System.out.print(prom);
                str=this.bufferedReader.readLine();
                if (str!=null||"".equals(str)){
                    flag=false;
                }
                else {
                    System.out.println("字符串不能为空。");
                }
            } catch (IOException e) {

            }
        }
        return str;
    }
}
