package com.countchar;

public class StaticCharOddAndEven {
    private int odd;
    private int even;
    private String returnData;

    public StaticCharOddAndEven(){}
    public void Input(){
        boolean flag=true;
        while (flag){
            String str=Factory.getICharCountImplInstance().getStringNotNull("请输入一串数字：");
            if (str.matches("\\d+")){
                flag=false;
                this.returnData=str;
            }else {
                System.out.println("输入的不为数字，请输入一串数字。");
            }
        }
    }
    public void Count(){
        if (this.returnData!=null){
            char data[]=this.returnData.toCharArray();
            for (int i = 0; i < data.length; i++) {
                if (data[i]=='0'||data[i]=='2'||data[i]=='4'||data[i]=='6'||data[i]=='8'){
                    this.even++;
                }else {
                    this.odd++;
                }
            }
        }
    }
    public int getEven() {
        return even;
    }

    public int getOdd() {
        return odd;
    }
}
