package com.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalParameters {
    public static String BROWSER_DEFAULT;
    public static String EXECUTION;
    public static String URL_DEFAULT;
    public static String USUARIO_PADRAO;
    public static String SENHA_PADRAO;

    private Properties properties;

    public GlobalParameters() {
        properties = new Properties();
        InputStream input;

        try {
            input = new FileInputStream("globalParameters.properties");
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BROWSER_DEFAULT = properties.getProperty("browser.default");
        EXECUTION = properties.getProperty("execution");
        URL_DEFAULT = properties.getProperty("url.default");
        USUARIO_PADRAO = properties.getProperty("usuarioPadrao");
        SENHA_PADRAO = properties.getProperty("senhaPadrao");
    }
}
