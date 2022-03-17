package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class BugUpdatePage extends PageBase {
    //Mapping
    By summaryField = By.name("summary");
    By updateInformationButton = By.cssSelector("input[value='Update Information']");
    By priorityComboBox = By.name("priority");
    By descriptionTextArea = By.name("description");

    //Actions
    public void preencherResumo(String novoResumo) {
        clear(summaryField);
        sendKeys(summaryField, novoResumo);
    }

    public void preencherDescricao(String descricao) {
        clear(descriptionTextArea);
        sendKeys(descriptionTextArea, descricao);
    }

    public void clicarEmAtualizarInformacao() {
        click(updateInformationButton);
    }

    public void selecionarPrioridade(String prioridade) {
        comboBoxSelectByVisibleText(priorityComboBox, prioridade);
    }
}
