package com.selenium.tests;

import com.selenium.GlobalParameters;
import com.selenium.bases.TestBase;
import com.selenium.flows.BugReportFlows;
import com.selenium.flows.LoginFlows;
import com.selenium.flows.SelectProjectFlows;
import com.selenium.pages.*;
import org.junit.Assert;
import org.junit.Test;

public class BugTests extends TestBase {
    //Objects
    LoginFlows loginFlows;
    MyViewPage myViewPage;
    SelectProjectFlows selectProjectFlows;
    BugReportFlows bugReportFlows;
    BugReportPage bugReportPage;
    ViewAllBugPage viewAllBugPage;
    BugUpdatePage bugUpdatePage;
    ViewPage viewPage;
    BugChangeStatusPage bugChangeStatusPage;
    BugActionGroupPage bugActionGroupPage;

    //Tests
    @Test
    public void reportarBugComSucesso() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectFlows = new SelectProjectFlows();
        bugReportPage = new BugReportPage();

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
        String mensagemEsperada = "Operation successful.";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmReportarProblema();
        selectProjectFlows.selecionarProjeto(projeto);
        bugReportPage.selecionarCategoria(categoria);
        bugReportPage.selecionarReprodutibilidade(reprodutibilidade);
        bugReportPage.selecionarSeveridade(severidade);
        bugReportPage.selecionarPrioridade(prioridade);
        bugReportPage.selecionarPerfil(perfil);
        bugReportPage.selecionarPessoaAtribuida(pessoaAtribuida);
        bugReportPage.preencherResumo(resumo);
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.clicarNoBotaoEnviarRelatorio();

        Assert.assertTrue(bugReportPage.retornaMensagemSucesso().contains(mensagemEsperada));
    }

    @Test
    public void alterarResumoDoBug() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectFlows = new SelectProjectFlows();
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
        String novoResumo = "Editando";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmReportarProblema();
        selectProjectFlows.selecionarProjeto(projeto);
        bugReportFlows.reportarBug(categoria, reprodutibilidade, severidade, prioridade, perfil, pessoaAtribuida, resumo, descricao);
        viewAllBugPage.clicarEmEditar();
        bugUpdatePage.preencherResumo(novoResumo);
        bugUpdatePage.clicarEmAtualizarInformacao();

        Assert.assertTrue(viewPage.retornaResumoDoBug(novoResumo).contains(novoResumo));
    }

    @Test
    public void alterarPrioridadeDoBugParaUrgente() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectFlows = new SelectProjectFlows();
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
        String novaPrioridade = "urgent";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmReportarProblema();
        selectProjectFlows.selecionarProjeto(projeto);
        bugReportFlows.reportarBug(categoria, reprodutibilidade, severidade, prioridade, perfil, pessoaAtribuida, resumo, descricao);
        viewAllBugPage.clicarEmEditar();
        bugUpdatePage.selecionarPrioridade(novaPrioridade);
        bugUpdatePage.clicarEmAtualizarInformacao();

        Assert.assertEquals(novaPrioridade, viewPage.retornaPrioridadeDoBug(novaPrioridade));
    }

    @Test
    public void alterarStatusDoBugParaResolvido() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectFlows = new SelectProjectFlows();
        bugReportFlows = new BugReportFlows();
        viewAllBugPage = new ViewAllBugPage();
        viewPage = new ViewPage();
        bugChangeStatusPage = new BugChangeStatusPage();

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
        String status = "resolved";
        String resolucao = "fixed";
        String nota = "A equipe corrigiu o Bug";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmReportarProblema();
        selectProjectFlows.selecionarProjeto(projeto);
        bugReportFlows.reportarBug(categoria, reprodutibilidade, severidade, prioridade, perfil, pessoaAtribuida, resumo, descricao);
        viewAllBugPage.clicarNoIdDoBug();
        viewPage.selecionarStatus(status);
        viewPage.clicarEmAlterarStatus();
        bugChangeStatusPage.selecionarTipoDaResolucao(resolucao);
        bugChangeStatusPage.adicionarNota(nota);
        bugChangeStatusPage.clicarEmResolverProblema();

        Assert.assertEquals(status, viewPage.retornaStatusAtualDoBug(status));
    }

    @Test
    public void fecharBugComSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectFlows = new SelectProjectFlows();
        bugReportFlows = new BugReportFlows();
        viewAllBugPage = new ViewAllBugPage();
        viewPage = new ViewPage();
        bugChangeStatusPage = new BugChangeStatusPage();

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
        String resolucao = "fixed";
        String nota = "Bug corrigido";
        String status = "closed";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmReportarProblema();
        selectProjectFlows.selecionarProjeto(projeto);
        bugReportFlows.reportarBug(categoria, reprodutibilidade, severidade, prioridade, perfil, pessoaAtribuida, resumo, descricao);
        viewAllBugPage.clicarNoIdDoBug();
        viewPage.clicarEmFechar();
        bugChangeStatusPage.selecionarTipoDaResolucao(resolucao);
        bugChangeStatusPage.adicionarNota(nota);
        bugChangeStatusPage.clicarEmFecharProblema();

        Assert.assertEquals(status, viewPage.retornaStatusAtualDoBug(status));
    }

    @Test
    public void excluirBug() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectFlows = new SelectProjectFlows();
        bugReportFlows = new BugReportFlows();
        viewAllBugPage = new ViewAllBugPage();
        viewPage = new ViewPage();
        bugActionGroupPage = new BugActionGroupPage();

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
        String idDoBug;

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmReportarProblema();
        selectProjectFlows.selecionarProjeto(projeto);
        bugReportFlows.reportarBug(categoria, reprodutibilidade, severidade, prioridade, perfil, pessoaAtribuida, resumo, descricao);
        idDoBug = viewAllBugPage.obterIdDoBug();
        viewAllBugPage.clicarNoIdDoBug();
        viewPage.clicarEmExcluir();
        bugActionGroupPage.clicarEmExcluirProblema();

        Assert.assertFalse(viewAllBugPage.listaDeBugsCadastrados().contains(idDoBug));
    }

    @Test
    public void filtrarBugPorId() {
        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectFlows = new SelectProjectFlows();
        bugReportFlows = new BugReportFlows();
        viewAllBugPage = new ViewAllBugPage();

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
        String idDoBug;
        int quantidadeDeRegistrosEsperados = 1;

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmReportarProblema();
        selectProjectFlows.selecionarProjeto(projeto);
        bugReportFlows.reportarBug(categoria, reprodutibilidade, severidade, prioridade, perfil, pessoaAtribuida, resumo, descricao);
        idDoBug = viewAllBugPage.obterIdDoBug();
        viewAllBugPage.preencherCampoProcurar(idDoBug);
        viewAllBugPage.clicarEmAplicarFiltro();
        System.out.println(idDoBug);//
        System.out.println(viewAllBugPage.listaDeBugsCadastrados());//

        Assert.assertEquals(quantidadeDeRegistrosEsperados, viewAllBugPage.quantidadeDeRegistrosEncontrados().size());
        Assert.assertTrue(viewAllBugPage.listaDeBugsCadastrados().contains(idDoBug));
    }

    @Test
    public void filtrarBugPorResumo() {
        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        selectProjectFlows = new SelectProjectFlows();
        bugReportFlows = new BugReportFlows();
        viewAllBugPage = new ViewAllBugPage();

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
        String resumo = "Editanduuu";
        String descricao = "Projeto final do Base2camp";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmReportarProblema();
        selectProjectFlows.selecionarProjeto(projeto);
        bugReportFlows.reportarBug(categoria, reprodutibilidade, severidade, prioridade, perfil, pessoaAtribuida, resumo, descricao);
        viewAllBugPage.preencherCampoProcurar(resumo);
        viewAllBugPage.clicarEmAplicarFiltro();

        Assert.assertTrue(viewAllBugPage.ResumoDosBugsCadastrados().contains(resumo));
    }
}
