package com.selenium.utils;

import com.selenium.GlobalParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {

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

            } else if (execution.equals("grid")) {
                if (browser.equals("chrome")) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    try {
                        INSTANCE = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                } else if (browser.equals("firefox")) {
                    try {
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        INSTANCE = new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions);
                    } catch (MalformedURLException e) {
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
