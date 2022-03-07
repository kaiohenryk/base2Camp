package com.selenium.bases;

import com.selenium.GlobalParameters;
import com.selenium.utils.DriverFactory;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void beforeSuite() {
        new GlobalParameters();
    }

    @Before
    public void beforeTest() {
        DriverFactory.createInstance();
        DriverFactory.INSTANCE.manage().window().maximize();
        DriverFactory.INSTANCE.navigate().to(GlobalParameters.URL_DEFAULT);
    }
}
