package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class ImgUtils {

    public static String generateFilePath(String fileName){
       String[] name = fileName.split("\\.");
       String midName = createFileName();
       String resultName = name[0]+midName+"."+name[1];
       return resultName;


    }
    public static String createFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String data =  simpleDateFormat.format(new Date());
        return data+ UUID.randomUUID();
    }


}
