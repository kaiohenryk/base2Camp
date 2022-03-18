package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class ViewPage extends PageBase {

    //Mapping
    By statusComboBox = By.name("new_status");
    By assignToComboBox = By.name("handler_id");
    By changeStatusButton = By.cssSelector("input[value='Change Status To:']");
    By assignToButton = By.cssSelector("input[value='Assign To:']");
    By closeButton = By.cssSelector("input[value='Close']");
    By deleteButton = By.cssSelector("input[value='Delete']");

    //Actions
    private By locatorDoResumoDoBug(String resumo) {
        return By.xpath("//td[.='Summary']/../td[contains(text(), '" + resumo + "')]");
    }

    public String retornaResumoDoBug(String resumo) {
        return getText(locatorDoResumoDoBug(resumo));
    }

    private By locatorDinamico(String textoDesejado) {
        return By.xpath("//table//td[.='" + textoDesejado + "']");
    }

    public String retornaDescricaoDoBug(String descricao) {
        return getText(locatorDinamico(descricao));
    }

    public String retornaPrioridadeDoBug(String prioridade) {
        return getText(locatorDinamico(prioridade));
    }

    public String retornaStatusDoBug(String status) {
        return getText(locatorDinamico(status));
    }

    public String retornaPessoaAtribuidaDoBug(String pessoaAtribuida) {
        return getText(locatorDinamico(pessoaAtribuida));
    }

    public void selecionarStatus(String status) {
        comboBoxSelectByVisibleText(statusComboBox, status);
    }

    public void selecionarPessoaAtribuida(String pessoaAtribuida) {
        comboBoxSelectByVisibleText(assignToComboBox, pessoaAtribuida);
    }

    public void clicarEmAlterarStatus() {
        click(changeStatusButton);
    }

    public void clicarEmAtribuir() {
        click(assignToButton);
    }

    public void clicarEmFechar() {
        click(closeButton);
    }

    public void clicarEmExcluir() {
        click(deleteButton);
    }
}
