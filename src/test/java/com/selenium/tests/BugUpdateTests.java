package com.selenium.tests;

import com.selenium.GlobalParameters;
import com.selenium.bases.TestBase;
import com.selenium.flows.BugReportFlows;
import com.selenium.flows.LoginFlows;
import com.selenium.pages.*;
import org.junit.Assert;
import org.junit.Test;

public class BugUpdateTests extends TestBase {
    //Objects
    LoginFlows loginFlows;
    MyViewPage myViewPage;
    SelectProjectPage selectProjectPage;
    BugReportFlows bugReportFlows;
    ViewAllBugPage viewAllBugPage;
    BugUpdatePage bugUpdatePage;
    ViewPage viewPage;

    //Tests
    @Test
    public void editarResumoDoBug() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectPage = new SelectProjectPage();
        bugReportFlows = new BugReportFlows();
        viewAllBugPage = new ViewAllBugPage();
        bugUpdatePage = new BugUpdatePage();
        viewPage = new ViewPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String projeto = "Fabiana Carvalho´s Project";
        String categoria = "[All Projects] Teste Caio";
        String reprodutibilidade = "random";
        String severidade = "major";
        String prioridade = "normal";
        String perfil = "Desktop Windows 10";
        String pessoaAtribuida = "caio.carvalho";
        String resumo = "Teste do Caio";
        String descricao = "Projeto final do Base2camp";
        String novoResumo = "Teste de edição";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarLinkReportIssue();
        selectProjectPage.escolherProjeto(projeto);
        selectProjectPage.clicarNoBotaoSelecionarProjeto();
        bugReportFlows.reportarBug(categoria, reprodutibilidade, severidade, prioridade, perfil, pessoaAtribuida, resumo, descricao);
        viewAllBugPage.clicarLinkEdicao();
        bugUpdatePage.apagarResumo();
        bugUpdatePage.preencherNovoResumo(novoResumo);
        bugUpdatePage.clicarAtualizarInformacao();

        Assert.assertTrue(viewPage.retornaResumo().contains(novoResumo));
    }

    @Test
    public void editarPrioridadeDoBug() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectPage = new SelectProjectPage();
        bugReportFlows = new BugReportFlows();
        viewAllBugPage = new ViewAllBugPage();
        bugUpdatePage = new BugUpdatePage();
        viewPage = new ViewPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String projeto = "Fabiana Carvalho´s Project";
        String categoria = "[All Projects] Teste Caio";
        String reprodutibilidade = "random";
        String severidade = "major";
        String prioridade = "normal";
        String perfil = "Desktop Windows 10";
        String pessoaAtribuida = "caio.carvalho";
        String resumo = "Teste do Caio";
        String descricao = "Projeto final do Base2camp";
        String novoNivelPrioridade = "immediate";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarLinkReportIssue();
        selectProjectPage.escolherProjeto(projeto);
        selectProjectPage.clicarNoBotaoSelecionarProjeto();
        bugReportFlows.reportarBug(categoria, reprodutibilidade, severidade, prioridade, perfil, pessoaAtribuida, resumo, descricao);
        viewAllBugPage.clicarLinkEdicao();
        bugUpdatePage.selecionarNovoNivelPrioridade(novoNivelPrioridade);
        bugUpdatePage.clicarAtualizarInformacao();

        Assert.assertEquals(novoNivelPrioridade, viewPage.retornaNivelPrioridade());
    }
}
