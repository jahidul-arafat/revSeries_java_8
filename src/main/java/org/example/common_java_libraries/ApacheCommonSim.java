package org.example.common_java_libraries;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ApacheCommonSim {
    public static void main(String[] args) {
        // define the source file and destination file of type File
        File sourceFile = new File("files/sample.txt");
        File destinationFile = new File("files/copy_sample.txt");


        // copy a source file to destination using FileUtils
        try {
            FileUtils.copyFile(sourceFile, destinationFile);
            System.out.println("File Copied to " + destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
