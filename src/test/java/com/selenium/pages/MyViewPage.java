package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class MyViewPage extends PageBase {

    //Mapping
    By reportIssueLinkText = By.linkText("Report Issue");
    By viewIssuesLinkText = By.linkText("View Issues");

    //Actions
    public String retornaURLPaginaInicial() {
        return getUrl();
    }

    public void clicarEmReportarProblema() {
        clickLinkText(reportIssueLinkText);
    }

    public void clicarEmVerProblemas() {
        clickLinkText(viewIssuesLinkText);
    }
}
