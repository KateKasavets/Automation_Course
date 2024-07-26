package org.example.utils;

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

    private static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getLogin1() {
        return getProperty("login1");
    }

    public static String getPasswd1() {
        return getProperty("passwd1");
    }

    public static String getLoginPageUrl() {
        return getProperty("loginpageurl");
    }

    public static String getChromeDriverPath() {
        return getProperty("chromedriverpath");
    }
    public static String getloginPageDemoTool() {
        return getProperty("loginPageDemoTool");
    }
    public static String getRegistrationPage(){
        return getProperty("registrationPage");
    }
}
