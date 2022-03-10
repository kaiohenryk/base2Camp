package com.selenium.suite;

import com.selenium.tests.BugTests;
import com.selenium.tests.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        BugTests.class
})
public class SuiteTest {
}
