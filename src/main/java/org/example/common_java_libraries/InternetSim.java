package org.example.common_java_libraries;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 *  @author <a href="mailto:jahidapon@gmail.com">
 *  This source code downloads files from remote sources and handles <b>HTTP301 redirection</b>
 */
public class InternetSim {
    public static void main(String[] args) {
        // read the contents of the file from Internet and save it to a destination file
        String sourceUrl = "http://services.hanselandpetal.com/feeds/flowers.xml";

        // absolute file path given. Relative path raise FileNotFoundException while executing the JAR
        // command to execute a jar file
        // java -jar <fileName>.jar
        String destinationPath = "/Users/jarotball/study/java_revision_2023/Learning_Java_8/files/downloaded.xml";
        System.out.println("Downloading file from " + sourceUrl + " to " + destinationPath);

        // Approach-01
        fileDownloaderHTTP301SB(sourceUrl, destinationPath);

        // Approach-02
        //fileDownlodHTTP301ByteStream(sourceUrl, destinationPath);

        // Approach-03
        // this is the standard code, but when connecting to the remote server to download the file, its throwing HTTP 301 redirection error
        //fileDownloadNoHTTP301(destinationPath);

    }

    private static void fileDownloadNoHTTP301(String sourceUrl,String destinationPath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(sourceUrl).openStream()));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(destinationPath), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) { // until reading line ends
                content.append(line).append(System.lineSeparator());
            }

            writer.write(content.toString());

            System.out.println("File saved successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileDownlodHTTP301ByteStream(String sourceUrl, String destinationPath) {
        try {
            URL url = new URL(sourceUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setInstanceFollowRedirects(false); // Disable automatic redirection

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                String newLocation = conn.getHeaderField("Location");
                conn = (HttpURLConnection) new URL(newLocation).openConnection();
            }

            try (InputStream in = conn.getInputStream();
                 FileOutputStream out = new FileOutputStream(destinationPath);
                 ) {
                StringBuilder stringBuilder = new StringBuilder();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                    stringBuilder.append(new String(buffer, 0, bytesRead));
                }

                System.out.println("File downloaded successfully.");
                System.out.println("File contents:\n" + stringBuilder.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Adding Java Docs
    /**
     *
     * @param sourceUrl - source url to read the contents from
     * @param destinationPath - destination file path to save the downloaded contents
     */
    private static void fileDownloaderHTTP301SB(String sourceUrl, String destinationPath) {
        try {
            URL url = new URL(sourceUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Handle HTTP 301 redirection
            /*
            In this updated version, we use HttpURLConnection to establish the connection with the source URL.
            If the response code is HTTP_MOVED_PERM (301) or HTTP_MOVED_TEMP (302), indicating a redirection,
            we extract the new URL from the response headers using connection.getHeaderField("Location").
            Then, we open a new connection using the new URL.
            By handling the redirection, we ensure that the content is downloaded from the correct location
            without encountering the HTTP 301 redirection error.
             */
            if (connection.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM
                    || connection.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
                String newUrl = connection.getHeaderField("Location");
                connection = (HttpURLConnection) new URL(newUrl).openConnection();
            }

            try (InputStream inputStream = connection.getInputStream()) {
                StringBuilder content = new StringBuilder();

                int data;
                while ((data = inputStream.read()) != -1) {
                    content.append((char) data);
                }

                // Save content to the destination file
                Files.writeString(Path.of(destinationPath), content.toString(),
                        StandardCharsets.UTF_8, StandardOpenOption.CREATE);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred... cant download!!!");;
            e.printStackTrace();
        }
    }
}
