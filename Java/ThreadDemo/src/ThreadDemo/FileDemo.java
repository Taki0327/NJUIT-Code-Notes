package ThreadDemo;

import java.io.File;

public class FileDemo
{
    public static void main(String[] args) {
        search("D:/test/");
    }
    public static void search(String path){
        File dir=new File(path);
        File[] files=dir.listFiles();
        for(File subFile:files){
            if(subFile.getName().endsWith(".JPG"))
            {
                System.out.println(subFile.getName());
            }
        }
    }
}