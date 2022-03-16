package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewAllBugPage extends PageBase {
    //Mapping
    //By partialLinkEdit = By.xpath("//table[@id='buglist']//a[contains(@href, 'bug_update_page')]");
    By partialLinkEdit = By.cssSelector("a[href^='bug_update_page']");
    //By partialLinkId = By.xpath("//table[@id='buglist']//a[contains(@href, '/view.php?id=')]");
    By partialLinkId = By.cssSelector("td > a[href^='/view.php?id=']");
    By bugTable = By.id("buglist");

    //Actions
    public void clicarEmEditar(){
       clickPartialLink(partialLinkEdit);
    }

    public void clicarNoIdDoBug(){
        clickPartialLink(partialLinkId);
    }

    public String obterIDDoBug(){
        return getText(partialLinkId);
    }

    public List<String> listaDeBugsCadastrados(){
        return getTextList(bugTable);
    }
}
