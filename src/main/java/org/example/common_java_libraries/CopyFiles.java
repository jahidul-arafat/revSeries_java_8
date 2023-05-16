package org.example.common_java_libraries;


import java.io.*;
import java.nio.file.*;

public class CopyFiles {
    public static void main(String[] args) {
        // Project named copyFile which read from a file and create a copy of that file
        // to a new file.
        String source = "src/main/java/org/example/common_java_libraries/sample.txt";
        String destination = "src/main/java/org/example/common_java_libraries/copy_sample.txt";


        // Approach-01
        // file copy using FileReader and FileWriter methods
        // read the byte stream from the source and write to the destination
        // fileCopyUsingReader(source, destination);

        // Approach-02
        // more short and clean code
        fileCopyUsingPath(source, destination);

    }

    private static void fileCopyUsingPath(String source, String destination) {
        // copy the source file to destination using Path
        // copy the files
        Path sourcePath = Paths.get(source);
        Path destinationPath = Paths.get(destination);  // will create the destination file

        // force delete the file if exists
        try {
            //Files.deleteIfExists(destinationPath);  // so, if you don't delete the file, then it will throw a FileAlreadyExists exception
            // finally copy the source path to the destination path
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied to " + destination);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    private static void fileCopyUsingReader(String source, String destination) {
        // try with resources auto closable
        try (
                FileReader sourceFileReader = new FileReader(source);
                FileWriter destinationFileWriter = new FileWriter(destination); // this will auto create the destination file
        ) {
            // copy the file
            int read = sourceFileReader.read(); // read data from source file as a stream of bytes
            System.out.printf("Initial Read >> %s\n",read);
            while (read!= -1) { // read method returns -1 if the end of the file is reached.
                destinationFileWriter.write(read);
                read = sourceFileReader.read();
                System.out.printf("Next Read >> %s\n",read);

                // convert the integer into an ascii character
                char readChar = (char) read;
                System.out.printf("Read Char >> %s\n",readChar);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
