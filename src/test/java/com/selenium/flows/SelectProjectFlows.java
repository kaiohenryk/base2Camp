package com.selenium.flows;

import com.selenium.pages.SelectProjectPage;

public class SelectProjectFlows {

    //Objects and constructor
    SelectProjectPage selectProjectPage;

    public SelectProjectFlows(){
        //Page and Steps Objects
        selectProjectPage = new SelectProjectPage();
    }

    //Flows
    public void selecionarProjeto(String projeto){
        selectProjectPage.selecionarProjeto(projeto);
        selectProjectPage.clicarNoBotaoSelecionarProjeto();
    }
}
