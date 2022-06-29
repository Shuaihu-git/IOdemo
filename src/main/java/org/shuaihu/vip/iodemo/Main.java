package org.shuaihu.vip.iodemo;

import jdk.nashorn.internal.ir.SplitReturn;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;

class MathUtil{
    private MathUtil(){}
    public static double getScale(double num,int scale){
        return Math.round(Math.pow(10,scale)*num)/ Math.pow(10,scale);
    }

}

/**
 * 列出所有的文件
 */
class ListAllFile{
    private ListAllFile(){}
    public static void getAllFile(File file){
        if (file.isDirectory()){
            File [] results=file.listFiles();
            if (results!=null){
                for (int i = 0; i < results.length; i++) {
                    getAllFile(results[i]);
                }
            }
        }
        System.out.println(file);
    }
}
/**
 * 将文件重命名为.txt文件
 */
class RenameAllFiles{
    public static void renameFile(File file){
        if (file.isDirectory()){
            File [] results=file.listFiles();
            if (results!=null){
                for (int i = 0; i < results.length; i++) {
                    renameFile(results[i]);
                }
            }
        }else {
            if (file.isFile()){
//
                String filename=null;
                if (file.getName().contains(".")){
                    filename=file.getName().substring(0,file.getName().lastIndexOf("."))+".txt";
                }else {
                    filename=file.getName()+".txt";
                }
                File newFile=new File(file.getParentFile(),filename);
                file.renameTo(newFile);
            }
        }

    }

}
public class Main {
    static {
        File file=new File(IFileSave.DirPath);
        if (!file.exists()){
            file.mkdirs();
        }
    }
    private static final File PERSONINFO=new File("d:"+File.separator+"person.person");
    public static void main(String[] args) throws Exception {
        File file=new File("D:"+File.separator+"基于Android开发的招聘信息推送APP的设计与实现.pdf");
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(MathUtil.getScale(file.length()/(double)1024/1024,1));
        File listfile=new File("D:"+File.separator);
//        if (listfile.isDirectory()){
//            File [] list=listfile.listFiles();
//            for (int i = 0; i < list.length; i++) {
//                System.out.println(list[i]+" 最后修订时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(list[i].lastModified()));
//            }
//        }
//        ListAllFile.getAllFile(listfile);
        File file1=new File("D:"+File.separator+"HelloOutputStream"+File.separator+"shuaihu.txt");
        if(!file1.getParentFile().exists()){
            file1.getParentFile().mkdirs();
        }
        try(OutputStream outputStream=new FileOutputStream(file1,true)) {
            String str="www.shuaihu.vip\r\n";
            outputStream.write(str.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
        InputStream inputStream=new FileInputStream(file1);
        byte [] bytes=new byte[1024];
        int length=inputStream.read(bytes);
        System.out.println("{"+new String(bytes,0,length)+"}");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "C:\\Users\\张帅虎\\Desktop" + File.separator + "tset.bat";
                try {
                    OutputStream outputStream=new FileOutputStream(path);
                    outputStream.write("set name=root\r\nssh %name%@47.114.179.92 -i C:\\Users\\张帅虎\\.ssh\\sshkey.pem".getBytes("GBK"));
                    Runtime runtime = Runtime.getRuntime();
                    Process process = runtime.exec("cmd /k start " + path);
                    InputStream inputStream1 = process.getInputStream();
                    while (inputStream1.read() != -1) {
                        System.out.println(inputStream1.read());
                    }
                    inputStream1.close();
                    process.waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        File file2=new File("D:"+File.separator+"HelloOutPutStream"+File.separator+"writer.txt");
        if (!file2.getParentFile().exists()){
            file2.getParentFile().mkdirs();
        }
        Writerimplements(file2);
        File file3=new File("D:"+File.separator+"HelloOutPutStream"+File.separator+"reader.txt");
        System.out.println(file3.getName());
        Readerimplements(file3);

//        long start =System.currentTimeMillis();
//        FileCopy fileCopy=new FileCopy("D:"+File.separator+"电影","D:"+File.separator+"FileCopy");
//        try {
//            System.out.println(fileCopy.copyDirImp()?"拷贝成功。":"拷贝失败。");
//            long end =System.currentTimeMillis();
//            System.out.println("用时"+(end-start)+"ms");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        ListSystemInfo listSystemInfo=new ListSystemInfo();
        OutputStream outputStream=new FileOutputStream("D:"+File.separator+"hello.txt");
        outputStream.write("@一枚程序员www.shuaihu.vip".getBytes("UTF-8"));
        outputStream.close();
        ROMIO romio=new ROMIO(new ByteArrayOutputStream(),new ByteArrayInputStream("www.shuaihu.vip".getBytes()));
        romio.toUpper();
        PipeOutputImpl pipeOutput=new PipeOutputImpl();
        PipeInputImpl pipeInput=new PipeInputImpl();
        pipeOutput.getPipedOutputStream().connect(pipeInput.getPipedInputStream());
        new Thread(pipeInput,"Recivice").start();
        new Thread(pipeOutput,"Send").start();
        File randomFile=new File("D:"+File.separator+"random.txt");
//        OutputStream outputStream1=new FileOutputStream(randomFile);
//        outputStream1.write("".getBytes());
        RandomAccessFile randomAccessFile=new RandomAccessFile(new File("D:"+File.separator+"random.txt"),"rw");
//        String [] title=new String[]{"HTTPS->","HTTP ->","SSH  ->"};
//        int port [] =new int[]{443,80,22};
//        for (int i = 0; i < title.length; i++) {
//            randomAccessFile.write(title[i].getBytes());
//            randomAccessFile.writeInt(port[i]);
//        }


//        randomAccessFile.seek(0);
        {
            System.out.println(randomAccessFile.getFilePointer());
            System.out.println(randomAccessFile.length());

//            randomAccessFile.seek(0);
            randomAccessFile.skipBytes(0);
            byte byterandom[] = new byte[7];
            int len = randomAccessFile.read(byterandom);
            System.out.println(new String(byterandom, 0, len) +randomAccessFile.readInt());
            randomAccessFile.close();

        }
        OutputStream outputStream1=new FileOutputStream("d:"+File.separator+"print.txt");
        PrintWriter printWriter=new PrintWriter(outputStream1);
        printWriter.println("qq:1583139786");
        printWriter.format("website %s,port %d,dimain %s","47.114.179.92",80,"www.shuaihu.vip");
        printWriter.close();
        Scanner scanner=new Scanner(Files.newInputStream(Paths.get("d:" + File.separator + "143.txt")));
        scanner.useDelimiter("\n");
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
        Scanner scanner1=new Scanner(System.in);
        if (scanner1.hasNext("\\d{4}-\\d{2}-\\d{2}")){
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(scanner1.next()));
        }
        writerSer(new Person("张珊",28));
        System.out.println(loadSer());


        int results[] =Fatory.getInstance().getReslut(5);
        System.out.println("Max="+results[0]+"Min="+results[1]);

        //FileSave
        IFileSaveImp iFileSaveImp=Fatory.getIFileSave();
        System.out.println(iFileSaveImp.save());




    }
    public static void writerSer(Object object) throws Exception{
        try {
           ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PERSONINFO));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object loadSer() throws Exception{
        try {
            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(PERSONINFO));
            Object object=objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void Writerimplements(File file){
        try {
            Writer writer=new FileWriter(file,true);
            writer.append("bash for linux\r\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void Readerimplements(File file){
        try {
            Reader reader=new FileReader(file);
            char [] results=new char[1024];
            int length=reader.read(results);
            System.out.println("reader"+"{"+new String(results,0,length)+"}");
            System.out.println(Arrays.toString(results));
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}