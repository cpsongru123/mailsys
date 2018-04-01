package com.pltm.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSaveUtil {
    public static String saveFiletoBaseDir(String oriFileName, byte[] bytes){
        String type = null;
        if(oriFileName.lastIndexOf(".")==-1)
            type = "";
        else type = oriFileName.substring(oriFileName.lastIndexOf('.'),oriFileName.length());
        System.out.println("type: "+type);
        String baseDir = "F:\\attachments\\";
        long l = System.currentTimeMillis();
        FileOutputStream fo = null;
        String storedFileName = baseDir +l+type;
        try {
            fo= new FileOutputStream(storedFileName);
            fo.write(bytes);
            fo.flush();
            fo.close();
            System.out.println("save file: "+storedFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storedFileName;
    }
}
