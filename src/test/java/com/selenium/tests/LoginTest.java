package com.selenium.tests;

import com.selenium.GlobalParameters;
import com.selenium.bases.TestBase;
import com.selenium.pages.LoginPage;
import com.selenium.pages.MyViewPage;
import org.junit.Assert;
import org.junit.Test;


public class LoginTest extends TestBase {
    //Objects
    LoginPage loginPage;
    MyViewPage myViewPage;

    //Tests
    @Test
    public void efetuarLoginComSucesso() {

        //Obejects instances
        loginPage = new LoginPage();
        myViewPage = new MyViewPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String paginaInicialEsperada = "https://mantis-prova.base2.com.br/my_view_page.php";

        loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarNoBotaoLogin();

        Assert.assertEquals(paginaInicialEsperada, myViewPage.retornaURLPaginaInicial());
    }
}
