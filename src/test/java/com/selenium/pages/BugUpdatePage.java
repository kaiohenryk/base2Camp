package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class BugUpdatePage extends PageBase {
    //Mapping
    By summaryField = By.name("summary");
    By updateInformationButton = By.cssSelector("input[value='Update Information']");
    //By changedText = By.xpath("//td[.='Summary']/../td[contains(text(), 'Teste de edição')]");
    By priorityComboBox = By.name("priority");

    //Actions
    public void apagarResumo() {
        clear(summaryField);
    }

    public void preencherNovoResumo(String novoResumo) {
        sendKeys(summaryField, novoResumo);
    }

    public void clicarAtualizarInformacao() {
        click(updateInformationButton);
    }

//    public String retornaResumo() {
//        return getText(changedText);
//    }

    public void selecionarNovoNivelPrioridade(String prioridade){
        comboBoxSelectByVisibleText(priorityComboBox, prioridade);
    }
}
