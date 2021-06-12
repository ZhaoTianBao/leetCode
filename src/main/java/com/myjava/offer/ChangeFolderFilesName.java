package com.myjava.offer;

import java.io.File;

public class ChangeFolderFilesName {


    public static void main(String[] args) {
        String path = "E:\\2021最新Java面试题60K！";

        File file = new File(path);
        File[] array = file.listFiles();

        for(int i = 0; i < array.length; i++){
            if(array[i].isFile()){
                File currentFile = array[i];
                String originName = currentFile.getName();
                int start = originName.indexOf("！");
                if (start >= 0){
                    String newName = originName.substring(originName.indexOf("！") + 2);
                    currentFile.renameTo(new File(newName));
                    //修改后 原目录文件小消失，移动到项目当前目录
                    System.out.println(newName + "  修改成功!");
                }
            }else if(array[i].isDirectory()){
                System.out.println("错误了");
            }
        }
    }

}
