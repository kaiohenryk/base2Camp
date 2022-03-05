package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class MyViewPage extends PageBase {
    //Mapping
    By linkText = By.linkText("Report Issue");

    //Actions
    public void clicarLinkReportIssue() {
        clickLink(linkText);
    }
}
