package com.selenium.bases;

import com.selenium.GlobalParameters;
import com.selenium.utils.DriverUtils;
import com.selenium.utils.Utils;
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
        DriverUtils.createInstance();
        DriverUtils.INSTANCE.manage().window().maximize();
        DriverUtils.INSTANCE.navigate().to(GlobalParameters.URL_DEFAULT);
    }

    @After
    public void afterTest() {
        Utils.screenshot(testName);
        DriverUtils.quitInstance();
    }
}
