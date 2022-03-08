package com.selenium.tests;

import com.selenium.GlobalParameters;
import com.selenium.bases.TestBase;
import com.selenium.flows.BugReportFlows;
import com.selenium.flows.LoginFlows;
import com.selenium.pages.BugUpdatePage;
import com.selenium.pages.MyViewPage;
import com.selenium.pages.SelectProjectPage;
import com.selenium.pages.ViewAllBugPage;
import org.junit.Assert;
import org.junit.Test;

public class BugUpdateTest extends TestBase {
    //Objects
    LoginFlows loginFlows;
    MyViewPage myViewPage;
    SelectProjectPage selectProjectPage;
    BugReportFlows bugReportFlows;
    ViewAllBugPage viewAllBugPage;
    BugUpdatePage bugUpdatePage;

    //Tests
    @Test
    public void editarResumoDeBugReportado() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectPage = new SelectProjectPage();
        bugReportFlows = new BugReportFlows();
        viewAllBugPage = new ViewAllBugPage();
        bugUpdatePage = new BugUpdatePage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String projeto = "Fabiana Carvalho´s Project";
        String categoria = "[All Projects] Teste";
        String reprodutibilidade = "random";
        String severidade = "major";
        String prioridade = "urgent";
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

        Assert.assertTrue(bugUpdatePage.resumoAlterado().contains(novoResumo));
    }
}
