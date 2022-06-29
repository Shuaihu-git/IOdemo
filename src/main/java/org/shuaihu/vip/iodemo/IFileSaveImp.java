package org.shuaihu.vip.iodemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class IFileSaveImp implements IFileSave{
    private String name;
    private String content;

    public IFileSaveImp(){

        this.name=FileSave.getString("请输入文件名称");
        this.content=FileSave.getString("请输入文件内容");

    }
    @Override
    public boolean save() {
        File file=new File(IFileSave.DirPath+this.name);
        try {
            PrintWriter printWriter=new PrintWriter(new FileOutputStream(file));
            printWriter.print(this.content);
            printWriter.close();
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }
}
