package com.selenium.tests;

import com.selenium.GlobalParameters;
import com.selenium.utils.DriverFactory;
import org.junit.jupiter.api.Test;

public class test {

    @Test
    public void inicial() {
        new GlobalParameters();
        DriverFactory.createInstance();
        DriverFactory.INSTANCE.manage().window().maximize();
        DriverFactory.INSTANCE.navigate().to(GlobalParameters.URL_DEFAULT);
    }
}
