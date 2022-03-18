package com.selenium.tests;

import com.selenium.GlobalParameters;
import com.selenium.bases.TestBase;
import com.selenium.pages.LoginPage;
import com.selenium.pages.MyViewPage;
import org.junit.Assert;
import org.junit.Test;


public class LoginTests extends TestBase {

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

    @Test
    public void efetuarLoginComUsuarioIncorreto() {

        //Objects instances
        loginPage = new LoginPage();

        //Parameters
        String usuario = "usuario incorreto";
        String senha = GlobalParameters.SENHA_DEFAULT;
        String mensagemDeErroEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";

        //Test
        loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarNoBotaoLogin();

        Assert.assertEquals(mensagemDeErroEsperada, loginPage.retornaMensagemDeErroNoLogin());
    }

    @Test
    public void efetuarLoginComSenhaIncorreta() {

        //Objects instances
        loginPage = new LoginPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = "senha incorreta";
        String mensagemEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";

        //Test
        loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarNoBotaoLogin();

        Assert.assertEquals(mensagemEsperada, loginPage.retornaMensagemDeErroNoLogin());
    }

    @Test
    public void efetuarLoginComUsuarioESenhaIncorretos() {

        //Objects instances
        loginPage = new LoginPage();

        //Parameters
        String usuario = "usuario incorreto";
        String senha = "senha incorreta";
        String mensagemEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";

        //Test
        loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarNoBotaoLogin();

        Assert.assertEquals(mensagemEsperada, loginPage.retornaMensagemDeErroNoLogin());
    }
}
