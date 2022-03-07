package com.selenium.bases;

import com.selenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    //Global variables
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Construtor
    public PageBase() {
        driver = DriverFactory.INSTANCE;
        wait = new WebDriverWait(DriverFactory.INSTANCE, Duration.ofSeconds(30));
    }

    //Custom Actions
    protected WebElement waitForElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected void click(By locator) {
        waitForElement(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        waitForElement(locator).sendKeys(text);
    }

    protected String getUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    protected void clickLink(By locator) {
        waitForElement(locator).click();
    }

    protected void comboBoxSelectByVisibleText(By locator, String text) {
        Select comboBox = new Select(waitForElement(locator));
        comboBox.selectByVisibleText(text);
    }

    protected String getPageSource() {
        String pageSource = driver.getPageSource();
        return pageSource;
    }
}
