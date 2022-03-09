package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class ViewPage extends PageBase {
    //Mapping
    By priorityField = By.xpath("//table//td[.='immediate']");
    By summaryField = By.xpath("//td[.='Summary']/../td[contains(text(), 'Teste de edição')]");

    //Actions
    public String retornaResumo() {
        return getText(summaryField);
    }

    public String retornaNivelPrioridade() {
        return getText(priorityField);
    }
}
