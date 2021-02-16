package edu.javacourse.studentProj.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";
    public static final String DB_LIMIT = "db.limit";
    public static final String CR_URL = "cr.url";

    private static Properties properties = new Properties();

    public static String getProperty(String name) {
        if(properties == null) {

            try (InputStream is = Config.class.getClassLoader().getResourceAsStream("edu/javacourse/studentProj/resources/config.properties")) {

                properties.load(is);

            } catch (IOException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        return properties.getProperty(name);
    }
}
