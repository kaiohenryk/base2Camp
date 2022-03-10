package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class ViewPage extends PageBase {
    //Mapping
    By priorityField = By.xpath("//table//td[.='urgent']");
    By summaryField = By.xpath("//td[.='Summary']/../td[contains(text(), 'Teste de edição')]");
    By statusField = By.xpath("//table//td[.='resolved']");
    By statusClosedField = By.xpath("//table//td[.='closed']");
    By statusComboBox = By.name("new_status");
    By changeStatusButton = By.cssSelector("input[value='Change Status To:']");
    By closeButton = By.cssSelector("input[value='Close']");

    //Actions
    public String retornaResumoDoBug() {
        return getText(summaryField);
    }

    public String retornaPrioridadeDoBug() {
        return getText(priorityField);
    }

    public String retornaStatusDoBug() {
        return getText(statusField);
    }

    public String retornaStatusAtualDoBug() {
        return getText(statusClosedField);
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

}
