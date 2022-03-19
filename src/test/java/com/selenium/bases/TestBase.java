package com.selenium.bases;

import com.selenium.GlobalParameters;
import com.selenium.utils.DriverFactory;
import com.selenium.utils.FileUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

public class TestBase {

    @Rule
    public TestName testName = new TestName();

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

    @After
    public void afterTest() {
        FileUtil.screenshot(testName);
        DriverFactory.quitInstance();
    }
}
