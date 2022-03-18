package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class BugReportPage extends PageBase {

    //Mapping
    By categoryComboBox = By.name("category_id");
    By reproducibilityComboBox = By.name("reproducibility");
    By severityComboBox = By.name("severity");
    By priorityComboBox = By.name("priority");
    By selectProfileComboBox = By.name("profile_id");
    By assignToComboBox = By.name("handler_id");
    By summaryField = By.name("summary");
    By descriptionTextArea = By.name("description");
    By submitReportButton = By.cssSelector("input[value='Submit Report']");
    By successMessage = By.xpath("//div[contains(text(),'Operation successful.')]");

    //Actions
    public void selecionarCategoria(String categoria) {
        comboBoxSelectByVisibleText(categoryComboBox, categoria);
    }

    public void selecionarReprodutibilidade(String reprodutibilidade) {
        comboBoxSelectByVisibleText(reproducibilityComboBox, reprodutibilidade);
    }

    public void selecionarSeveridade(String severidade) {
        comboBoxSelectByVisibleText(severityComboBox, severidade);
    }

    public void selecionarPrioridade(String prioridade) {
        comboBoxSelectByVisibleText(priorityComboBox, prioridade);
    }

    public void selecionarPerfil(String perfil) {
        comboBoxSelectByVisibleText(selectProfileComboBox, perfil);
    }

    public void selecionarPessoaAtribuida(String pessoaAtribuida) {
        comboBoxSelectByVisibleText(assignToComboBox, pessoaAtribuida);
    }

    public void preencherResumo(String resumo) {
        sendKeys(summaryField, resumo);
    }

    public void preencherDescricao(String descricao) {
        sendKeys(descriptionTextArea, descricao);
    }

    public void clicarNoBotaoEnviarRelatorio() {
        click(submitReportButton);
    }

    public String retornaMensagemSucesso() {
        return getText(successMessage);
    }
}
