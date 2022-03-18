package com.selenium.pages;

import com.selenium.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {

    //Mapping
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.cssSelector("input[value='Login']");
    By errorMessage = By.xpath("//div//font[@color='red']");

    //Actions
    public void preencherUsuario(String usuario) {
        sendKeys(usernameField, usuario);
    }

    public void preencherSenha(String senha) {
        sendKeys(passwordField, senha);
    }

    public void clicarNoBotaoLogin() {
        click(loginButton);
    }

    public String retornaMensagemDeErroNoLogin() {
        return getText(errorMessage);
    }
}
