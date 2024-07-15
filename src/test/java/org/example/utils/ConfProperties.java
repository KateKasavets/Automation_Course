package org.example.utils;
import org.example.UnreadableFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private static FileInputStream fileInputStream;
    private static Properties properties = new Properties();

    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            try {
                throw new UnreadableFile("Error: Unable to read the file.", e);
            } catch (UnreadableFile ue) {
                System.err.println(ue.getMessage());
                ue.printStackTrace();
            }
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}