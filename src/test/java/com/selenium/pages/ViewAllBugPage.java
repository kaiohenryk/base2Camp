package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class ViewAllBugPage extends PageBase {
    //Mapping
    By partialLink = By.xpath("//table[@id='buglist']//a[contains(@href, 'bug_update_page')]");

    //Actions
    public void clicarLinkEdicao(){
       clickPartialLink(partialLink);
    }
}
