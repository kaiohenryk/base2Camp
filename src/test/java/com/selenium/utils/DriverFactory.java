package com.selenium.utils;

import com.selenium.GlobalParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver INSTANCE = null;

    public static void createInstance() {
        String browser = GlobalParameters.BROWSER_DEFAULT;
        String execution = GlobalParameters.EXECUTION;

        if (INSTANCE == null) {
            if (execution.equals("local")) {
                if (browser.equals("chrome")) {
                    INSTANCE = new ChromeDriver();

                } else if (browser.equals("firefox")) {
                    INSTANCE = new FirefoxDriver();
                } else {
                    try {
                        throw new Exception("O browser informado não existe ou não é suportado pela automação");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void quitInstance() {
        INSTANCE.quit();
        INSTANCE = null;
    }
}
