package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewAllBugPage extends PageBase {

    //Mapping
    By editPartialLink = By.cssSelector("#buglist td > a[href^='bug_update_page']");
    By idPartialLink = By.cssSelector("#buglist td > a[href^='/view.php?id=']");
    By assignedToLink = By.id("handler_id_filter");
    By searchField = By.name("search");
    By applyFilterButton = By.name("filter");
    By bugTableRecords = By.cssSelector("#buglist tr[border='1']");
    By bugSummary = By.cssSelector("#buglist tr[border='1'] > td[class='left']");
    By assignedToComboBox = By.name("handler_id[]");
    By assignedStatusLink = By.cssSelector("#buglist td a[href='https://mantis-prova.base2.com.br/view_user_page.php?id=314']");

    //Actions
    public void clicarEmEditarBug() {
        clickPartialLink(editPartialLink);
    }

    public void clicarNoIdDoBug() {
        clickPartialLink(idPartialLink);
    }

    public void clicarEmAtribuidoA() {
        clickLinkText(assignedToLink);
    }

    public void clicarEmAplicarFiltro() {
        click(applyFilterButton);
    }

    public void preencherCampoProcurar(String texto) {
        sendKeys(searchField, texto);
    }

    public String obterIdDoBug() {
        return getText(idPartialLink);
    }

    public List<String> idsDosBugsCadastrados() {
        return getTextList(idPartialLink);
    }

    public List<String> resumosDosBugsCadastrados() {
        return getTextList(bugSummary);
    }

    public List<String> pessoasAtribuidasParaOsBugs() {
        return getTextList(assignedStatusLink);
    }

    public List<WebElement> quantidadeDeRegistrosEncontrados() {
        return getListOfElements(bugTableRecords);
    }

    public void selecionarPessoaAtribuida(String pessoaAtribuida) {
        comboBoxSelectByVisibleText(assignedToComboBox, pessoaAtribuida);
    }
}
