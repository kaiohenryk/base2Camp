package com.selenium.suites;

import com.selenium.tests.BugTests;
import com.selenium.tests.LoginTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTests.class,
        BugTests.class
})
public class TestSuite {
}
