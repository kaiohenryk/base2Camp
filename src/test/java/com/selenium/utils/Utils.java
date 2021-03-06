package com.selenium.utils;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static void screenshot(TestName testName) {
        File file = ((TakesScreenshot) DriverUtils.INSTANCE).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
