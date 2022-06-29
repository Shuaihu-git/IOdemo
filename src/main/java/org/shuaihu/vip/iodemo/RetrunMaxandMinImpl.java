package org.shuaihu.vip.iodemo;

public class RetrunMaxandMinImpl implements ReturnMaxandMin{
    @Override
    public int[] getReslut(int count) {
        int results[]=new int[2];
        int data [] =new int[count];
        for (int i = 0; i < data.length; i++) {
            data[i]=FindMaxandMinNum.getInt("请输入第“"+(i+1)+"”个数字");
        }
        results[0]=data[0];
        results[1]= data[0];
        for (int i = 0; i < data.length; i++) {
            if (results[0]<data[i]){
                results[0]=data[i];
            }
            if (results[1]>data[i]){
                results[1]=data[i];
            }
        }

        return results;
    }
}
