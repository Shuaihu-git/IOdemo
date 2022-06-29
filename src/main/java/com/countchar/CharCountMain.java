package com.countchar;

public class CharCountMain {
    public static void main(String [] args){
        StaticCharOddAndEven staticCharOddAndEven=new StaticCharOddAndEven();
        staticCharOddAndEven.Input();
        staticCharOddAndEven.Count();
        System.out.println("奇数个数"+staticCharOddAndEven.getEven()+"偶数个数"+staticCharOddAndEven.getOdd());
        String str="小张:99.5|小刘:99.5|小虎:120.5";
        String test="小张:99.5";
        String num="99.1";
        String string="|";
        if (string.matches("\\|?")){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        if (num.matches("\\d+\\.\\d+")){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        if (test.matches("([\\u4E00-\\u9FA5]+):(\\d+\\.\\d{0,3})")){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        if (str.matches("(([\\u4E00-\\u9FA5]+):(\\d+\\.?\\d{0,3})\\|?)+")){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        Student student=new Student();
        student.inPut();
        student.Sort();
    }
}
