package com.selenium.tests;

import com.selenium.GlobalParameters;
import com.selenium.bases.TestBase;
import com.selenium.flows.LoginFlows;
import com.selenium.pages.BugReportPage;
import com.selenium.pages.MyViewPage;
import com.selenium.pages.SelectProjectPage;
import org.junit.Assert;
import org.junit.Test;

public class BugReportTest extends TestBase {
    //Objects
    LoginFlows loginFlows;
    MyViewPage myViewPage;
    SelectProjectPage selectProjectPage;
    BugReportPage bugReportPage;

    //Tests
    @Test
    public void reportarBug() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectPage = new SelectProjectPage();
        bugReportPage = new BugReportPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_PADRAO;
        String senha = GlobalParameters.SENHA_PADRAO;
        String projeto = "Fabiana Carvalho´s Project";
        String categoria = "[All Projects] Teste";
        String reprodutibilidade = "random";
        String severidade = "major";
        String prioridade = "urgent";
        String perfil = "Desktop Windows 10";
        String pessoaAtribuida = "caio.carvalho";
        String resumo = "Teste do Caio";
        String descricao = "Projeto final do Base2camp";
        String mensagemEsperada = "Operation successful.";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarLinkReportIssue();
        selectProjectPage.escolherProjeto(projeto);
        selectProjectPage.clicarBotaoSelectProject();
        bugReportPage.selecionarCategoria(categoria);
        bugReportPage.selecionarReprodutibilidade(reprodutibilidade);
        bugReportPage.selecionarGravidade(severidade);
        bugReportPage.selecionarPrioridade(prioridade);
        bugReportPage.selecionarPerfil(perfil);
        bugReportPage.selecionarPessoaAtribuida(pessoaAtribuida);
        bugReportPage.preencherResumo(resumo);
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.clicarBotaoEnviarRelatorio();

        Assert.assertTrue(bugReportPage.retornaMensagemSucesso().contains(mensagemEsperada));
    }
}
