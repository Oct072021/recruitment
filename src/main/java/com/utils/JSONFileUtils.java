package com.utils;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JSONFileUtils {

    public static String readFile(String filepath) throws IOException {
        FileInputStream fis = new FileInputStream(filepath);
        return IOUtils.toString(fis);
    }

    public static void writeFile(String data, String filepath) throws IOException {
        FileOutputStream fos = new FileOutputStream(filepath);
        IOUtils.write(data, fos);
    }

}
