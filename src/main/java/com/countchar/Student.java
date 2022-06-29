package com.countchar;

import org.shuaihu.vip.iodemo.Person;

import java.io.BufferedReader;
import java.util.Arrays;

public class Student implements Comparable<Student> {
    private String name;
    private double grade;
    private String contentData;
    public Student(){}

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        if (this.grade>o.grade){
            return -1;
        }else if (this.grade<o.grade){
            return 1;
        }else {
            return (int) (this.grade - o.grade);
        }

    }

    public void inPut() {

        boolean flag = true;
        while (flag) {
            String str = Factory.getICharCountImplInstance().getStringNotNull("请输入格式为：“姓名:成绩|姓名:成绩|……“的数据");
            if (str.matches("(([\\u4E00-\\u9FA5]+):(\\d+\\.?\\d{0,3})\\|?)+")) {//匹配输入格式
                this.contentData = str;
                flag = false;
            } else {
                System.out.println("输入的形式不对，请重新输入。");
            }
        }
    }
    public void Sort(){
        //格式分离和按成绩从大到小的方式排列对象
        if (this.contentData!=null){
            String students[]=this.contentData.split("\\|");
            Student [] student=new Student[students.length];
            for (int i = 0; i < student.length; i++) {
                String returnData[]=students[i].split("\\:");
                student[i]=new Student(returnData[0],Double.parseDouble(returnData[1]));
            }
            Arrays.sort(student);
            System.out.println(Arrays.toString(student));

        }else{
            this.inPut();
        }
    }

    @Override
    public String toString() {
        return "姓名:"+this.name+"、"+"成绩:"+this.grade;
    }
}
