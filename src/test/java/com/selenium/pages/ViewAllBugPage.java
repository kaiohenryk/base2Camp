package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class ViewAllBugPage extends PageBase {
    //Mapping
    By partialLinkEdit = By.xpath("//table[@id='buglist']//a[contains(@href, 'bug_update_page')]");
    By partialLinkId = By.xpath("//table[@id='buglist']//a[contains(@href, '/view.php?id=')]");

    //Actions
    public void clicarEmEditar(){
       clickPartialLink(partialLinkEdit);
    }

    public void clicarNoIdDoBug(){
        clickPartialLink(partialLinkId);
    }
}
