package com.countchar;

public class Factory {
    public static ICharCountImpl getICharCountImplInstance(){
        return new ICharCountImpl();
    }
}
