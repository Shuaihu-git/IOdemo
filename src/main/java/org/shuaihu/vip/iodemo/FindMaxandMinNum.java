package org.shuaihu.vip.iodemo;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FindMaxandMinNum {
    public static int getInt(String title){
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int num=0;
        String  str;
        boolean flag=true;
        while (flag){
            System.out.print(title);
            try {
                str= bufferedReader.readLine();
                if (str.matches("\\d+")){
                    num=Integer.parseInt(str);
                    flag=false;
                }else {
                    System.out.println("输入有误，输入的不是数字！");
                }
            } catch (IOException e) {
                System.out.println("输入有误，输入的不是数字！");
            }
//            Scanner scanner=new Scanner(System.in);
//            System.out.print(title);
//            if (scanner.hasNext("\\d+")){
//                num=Integer.parseInt(scanner.next("\\d+"));
//                flag=false;
//            }else {
//                System.out.println("输入有误，输入的不是数字！");
//            }
        }
        return num;

    }
}
