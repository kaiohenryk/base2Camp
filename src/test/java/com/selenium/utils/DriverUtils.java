package com.selenium.utils;

import com.selenium.GlobalParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
        String grid = GlobalParameters.URL_GRID;
        String browserErrorMessage = "O browser informado não existe ou não é suportado pela automação";
        String gridErrorMessage = "Falha na conexão com o grid, verifique a URL informada";
        String executionErrorMessage = "O método de execução informado não existe ou não é suportado pela automação";

        if (INSTANCE == null) {
            if (execution.equals("local")) {
                if (browser.equals("chrome")) {
                    INSTANCE = new ChromeDriver();
                }

                else if (browser.equals("firefox")) {
                    INSTANCE = new FirefoxDriver();
                }

                else if (browser.equals("edge")) {
                    INSTANCE = new EdgeDriver();
                }

                else {
                    try {
                        throw new Exception(browserErrorMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            else if (execution.equals("grid")) {
                if (browser.equals("chrome")) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    try {
                        INSTANCE = new RemoteWebDriver(new URL(grid), chromeOptions);
                    } catch (MalformedURLException e) {
                        System.err.println(gridErrorMessage);
                        e.printStackTrace();
                    }
                }

                else if (browser.equals("firefox")) {
                    try {
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        INSTANCE = new RemoteWebDriver(new URL(grid), firefoxOptions);
                    } catch (MalformedURLException e) {
                        System.err.println(gridErrorMessage);
                        e.printStackTrace();
                    }
                }

                else if (browser.equals("edge")) {
                    EdgeOptions edgeOptions = new EdgeOptions();
                    try {
                        INSTANCE = new RemoteWebDriver(new URL(grid), edgeOptions);
                    } catch (MalformedURLException e) {
                        System.err.println(gridErrorMessage);
                        e.printStackTrace();
                    }
                }

                else {
                    try {
                        throw new Exception(browserErrorMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            else {
                try {
                    throw new Exception(executionErrorMessage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void quitInstance() {
        INSTANCE.quit();
        INSTANCE = null;
    }
}
