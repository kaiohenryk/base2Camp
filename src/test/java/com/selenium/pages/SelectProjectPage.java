package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class SelectProjectPage extends PageBase {

    //Mapping
    By projectComboBox = By.name("project_id");
    By selectProjectButton = By.cssSelector("input[value='Select Project']");

    //Actions
    public void selecionarProjeto(String projeto) {
        comboBoxSelectByVisibleText(projectComboBox, projeto);
    }

    public void clicarNoBotaoSelecionarProjeto() {
        click(selectProjectButton);
    }
}
