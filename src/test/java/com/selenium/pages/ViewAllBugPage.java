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
    By searchField = By.name("search");
    By applyFilterButton = By.name("filter");
    By bugTableRecords = By.xpath("//table[@id='buglist']//tr[@border='1']");

    //Actions
    public void clicarEmEditar() {
        clickPartialLink(partialLinkEdit);
    }

    public void clicarNoIdDoBug() {
        clickPartialLink(partialLinkId);
    }

    public String obterIdDoBug() {
        return getText(partialLinkId);
    }

    public List<String> listaDeBugsCadastrados() {
        return getTextList(bugTable);
    }

    public void preencherCampoProcurar(String idDoBug) {
        sendKeys(searchField, idDoBug);
    }

    public void clicarEmAplicarFiltro() {
        click(applyFilterButton);
    }

    public List<WebElement> quantidadeDeRegistrosEncontrados() {
        return listOfElements(bugTableRecords);
    }
}
