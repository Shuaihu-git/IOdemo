package org.shuaihu.vip.iodemo;

public class ListSystemInfo {
    public ListSystemInfo(){
        System.getProperties().list(System.out);
    }
}
