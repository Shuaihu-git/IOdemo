package org.shuaihu.vip.iodemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IFileSave {
    private static BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    public String getString(String prom){
        boolean flag=true;
        String str= null;

        while (flag){
            System.out.println(prom);
            try {
                str = bufferedReader.readLine();
                if (!"".equals(str)){
                    flag=false;

                }else {
                    System.out.println("输入不能为空！");
                }
            } catch (IOException e) {
                System.out.println("输入不能为空！");
            }finally {
                bufferedReader.close();
            }

        }
        return str;
    }

}
