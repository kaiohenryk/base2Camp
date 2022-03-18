package com.selenium.flows;

import com.selenium.pages.LoginPage;

public class LoginFlows {

    //Objects and constructor
    LoginPage loginPage;

    public LoginFlows() {
        //Page and Steps Objects
        loginPage = new LoginPage();
    }

    //Flows
    public void efetuarLogin(String usuario, String senha) {
        loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarNoBotaoLogin();
    }
}
