package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class BugChangeStatusPage extends PageBase {

    //Mapping
    By resolutionComboBox = By.name("resolution");
    By addNoteTextArea = By.name("bugnote_text");
    By resolveIssueButton = By.cssSelector("input[value='Resolve Issue']");
    By closeIssueButton = By.cssSelector("input[value='Close Issue']");

    //Actions
    public void selecionarTipoDaResolucao(String tipoResolucao) {
        comboBoxSelectByVisibleText(resolutionComboBox, tipoResolucao);
    }

    public void adicionarNota(String nota) {
        sendKeys(addNoteTextArea, nota);
    }

    public void clicarEmResolverProblema() {
        click(resolveIssueButton);
    }

    public void clicarEmFecharProblema() {
        click(closeIssueButton);
    }
}
