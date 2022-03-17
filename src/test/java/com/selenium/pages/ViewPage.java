package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class ViewPage extends PageBase {
    //Mapping
    By statusComboBox = By.name("new_status");
    By changeStatusButton = By.cssSelector("input[value='Change Status To:']");
    By closeButton = By.cssSelector("input[value='Close']");
    By deleteButton = By.cssSelector("input[value='Delete']");

    //Actions
    private By locatorDoResumoDoBug(String resumo) {
        return By.xpath("//td[.='Summary']/../td[contains(text(), '" + resumo + "')]");
    }

    public String retornaResumoDoBug(String resumo) {
        return getText(locatorDoResumoDoBug(resumo));
    }

    private By locatorDaPrioridadeDoBug(String prioridade) {
        return By.xpath("//table//td[.='" + prioridade + "']");
    }

    public String retornaPrioridadeDoBug(String prioridade) {
        return getText(locatorDaPrioridadeDoBug(prioridade));
    }

    private By locatorDoStatusDoBug(String status) {
        return By.xpath("//table//td[.='" + status + "']");
    }

    public String retornaStatusAtualDoBug(String status) {
        return getText(locatorDoStatusDoBug(status));
    }

    public void selecionarStatus(String status) {
        comboBoxSelectByVisibleText(statusComboBox, status);
    }

    public void clicarEmAlterarStatus() {
        click(changeStatusButton);
    }

    public void clicarEmFechar() {
        click(closeButton);
    }

    public void clicarEmExcluir() {
        click(deleteButton);
    }
}
