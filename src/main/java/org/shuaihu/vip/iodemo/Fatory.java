package org.shuaihu.vip.iodemo;

public class Fatory {
    public static RetrunMaxandMinImpl getInstance(){
        return new RetrunMaxandMinImpl();
    }
    public static IFileSaveImp getIFileSave(){
        return new IFileSaveImp();
    }
}
