package org.shuaihu.vip.iodemo;

import java.io.*;

public class FileCopy {
    private File srcFile;
    private File desFile;
    public FileCopy(File srcFile,File desFile){
        this.desFile=desFile;
        this.srcFile=srcFile;
    }
    public FileCopy(String srcFile,String desFile){
        this(new File(srcFile),new File(desFile));
    }
    public boolean copyDirImp()throws Exception{

        try {
            this.copyImp(this.srcFile);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    private boolean copyImp(File file)throws Exception{
        if (file.isDirectory()){
            File results[]=file.listFiles();
                if (results!=null){
                    for (int i = 0; i < results.length; i++) {
                    this.copyImp(results[i]);
                    }
                }

        }else {
            System.out.println(file);
            String newPath=file.getPath().replace(this.srcFile.getPath()+File.separator,"");
            File newFile=new File(this.desFile,newPath);
            this.copyFileImp(file,newFile);
        }
        return false;
    }

    private boolean copyFileImp(File srcFile,File desFile)throws Exception{
        if (!desFile.getParentFile().exists()){
            desFile.getParentFile().mkdirs();
        }
        InputStream inputStream=null;
        OutputStream outputStream=null;
        byte data[]=new byte[1024];
        int length=0;

        try {

            inputStream=new FileInputStream(srcFile);
            outputStream=new FileOutputStream(desFile);
            while ((length=inputStream.read(data))!=-1){
                System.out.println(length);
                outputStream.write(data,0,length);
            }
            return true;
        }catch (Exception e){
            throw e;
        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
            if (outputStream!=null){
                outputStream.close();
            }
        }

    }
    public boolean copy() throws Exception {
        if (!this.srcFile.exists()) {
            System.out.println("源路径不存在！");
            return false;
        }
        return this.copyFileImp(this.srcFile,this.desFile);

    }

}
