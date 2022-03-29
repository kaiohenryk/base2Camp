package com.selenium.tests;

import com.selenium.GlobalParameters;
import com.selenium.bases.TestBase;
import com.selenium.flows.LoginFlows;
import com.selenium.pages.*;
import org.junit.Assert;
import org.junit.Test;

public class BugTests extends TestBase {

    //Objects
    LoginFlows loginFlows;
    MyViewPage myViewPage;
    SelectProjectPage selectProjectPage;
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
        selectProjectPage = new SelectProjectPage();
        bugReportPage = new BugReportPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String projeto = "Fabiana Carvalho´s Project";
        String categoria = "[All Projects] Teste Caio";
        String reprodutibilidade = "random";
        String severidade = "major";
        String prioridade = "urgent";
        String perfil = "Desktop Windows 10";
        String pessoaAtribuida = "caio.carvalho";
        String resumo = "Projeto Base2Camp - Caio Carvalho";
        String descricao = "Projeto final";
        String passoAPasso = "1- Fazer o meu melhor no base2Camp\n2- Entrar para o time da base2\n3- Caio Feliz =) ";
        String mensagemEsperada = "Operation successful.";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmReportarProblema();
        selectProjectPage.selecionarProjeto(projeto);
        selectProjectPage.clicarNoBotaoSelecionarProjeto();
        bugReportPage.selecionarCategoria(categoria);
        bugReportPage.selecionarReprodutibilidade(reprodutibilidade);
        bugReportPage.selecionarSeveridade(severidade);
        bugReportPage.selecionarPrioridade(prioridade);
        bugReportPage.selecionarPerfil(perfil);
        bugReportPage.selecionarPessoaAtribuida(pessoaAtribuida);
        bugReportPage.preencherResumo(resumo);
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.preencherPassoAPasso(passoAPasso);
        bugReportPage.clicarNoBotaoEnviarRelatorio();

        Assert.assertTrue(bugReportPage.retornaMensagemDeSucesso().contains(mensagemEsperada));
    }

    @Test
    public void alterarResumoDoBug() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();
        bugUpdatePage = new BugUpdatePage();
        viewPage = new ViewPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String resumo = "Editando o resumo do Bug";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmVerProblemas();
        viewAllBugPage.clicarEmEditarBug();
        bugUpdatePage.preencherResumo(resumo);
        bugUpdatePage.clicarEmAtualizarInformacao();

        Assert.assertTrue(viewPage.retornaResumoDoBug(resumo).contains(resumo));
    }

    @Test
    public void alterarDescricaoDoBug() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();
        bugUpdatePage = new BugUpdatePage();
        viewPage = new ViewPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String descricao = "Alterando a descrição do Bug";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmVerProblemas();
        viewAllBugPage.clicarEmEditarBug();
        bugUpdatePage.preencherDescricao(descricao);
        bugUpdatePage.clicarEmAtualizarInformacao();

        Assert.assertEquals(descricao, viewPage.retornaDescricaoDoBug(descricao));
    }

    @Test
    public void alterarPessoaAtribuidaDoBug() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();
        viewPage = new ViewPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String pessoaAtribuida = "Treinamento07";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmVerProblemas();
        viewAllBugPage.clicarNoIdDoBug();
        viewPage.selecionarPessoaAtribuida(pessoaAtribuida);
        viewPage.clicarEmAtribuirA();

        Assert.assertEquals(pessoaAtribuida, viewPage.retornaPessoaAtribuidaDoBug(pessoaAtribuida));
    }

    @Test
    public void alterarPrioridadeDoBugParaUrgente() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();
        bugUpdatePage = new BugUpdatePage();
        viewPage = new ViewPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String prioridade = "urgent";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmVerProblemas();
        viewAllBugPage.clicarEmEditarBug();
        bugUpdatePage.selecionarPrioridade(prioridade);
        bugUpdatePage.clicarEmAtualizarInformacao();

        Assert.assertEquals(prioridade, viewPage.retornaPrioridadeDoBug(prioridade));
    }

    @Test
    public void alterarStatusDoBugParaResolvido() {
        //MASSA DE DADOS: Necessário inserir um BUG com status diferente de resolved.

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();
        viewPage = new ViewPage();
        bugChangeStatusPage = new BugChangeStatusPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String status = "resolved";
        String resolucao = "fixed";
        String nota = "A equipe corrigiu o Bug";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmVerProblemas();
        viewAllBugPage.clicarNoIdDoBug();
        viewPage.selecionarStatus(status);
        viewPage.clicarEmAlterarStatus();
        bugChangeStatusPage.selecionarTipoDaResolucao(resolucao);
        bugChangeStatusPage.adicionarNota(nota);
        bugChangeStatusPage.clicarEmResolverProblema();

        Assert.assertEquals(status, viewPage.retornaStatusDoBug(status));
    }

    @Test
    public void fecharBugComSucesso() {
        //MASSA DE DADOS: Necessário inserir um BUG com status diferente de closed.

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();
        viewPage = new ViewPage();
        bugChangeStatusPage = new BugChangeStatusPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String resolucao = "fixed";
        String nota = "Bug corrigido";
        String status = "closed";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmVerProblemas();
        viewAllBugPage.clicarNoIdDoBug();
        viewPage.clicarEmFechar();
        bugChangeStatusPage.selecionarTipoDaResolucao(resolucao);
        bugChangeStatusPage.adicionarNota(nota);
        bugChangeStatusPage.clicarEmFecharProblema();

        Assert.assertEquals(status, viewPage.retornaStatusDoBug(status));
    }

    @Test
    public void excluirBug() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();
        viewPage = new ViewPage();
        bugActionGroupPage = new BugActionGroupPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String idDoBug;

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmVerProblemas();
        idDoBug = viewAllBugPage.obterIdDoBug();
        viewAllBugPage.clicarNoIdDoBug();
        viewPage.clicarEmExcluir();
        bugActionGroupPage.clicarEmExcluirProblema();

        Assert.assertFalse(viewAllBugPage.idsDosBugsCadastrados().contains(idDoBug));
    }

    @Test
    public void filtrarBugPorId() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String idDoBug;
        int quantidadeDeRegistrosEsperados = 1;

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmVerProblemas();
        idDoBug = viewAllBugPage.obterIdDoBug();
        viewAllBugPage.preencherCampoProcurar(idDoBug);
        viewAllBugPage.clicarEmAplicarFiltro();

        Assert.assertEquals(quantidadeDeRegistrosEsperados, viewAllBugPage.quantidadeDeRegistrosEncontrados().size());
        Assert.assertTrue(viewAllBugPage.idsDosBugsCadastrados().contains(idDoBug));
    }

    @Test
    public void filtrarBugPorResumo() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String resumo = "Teste do Caio";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmVerProblemas();
        viewAllBugPage.preencherCampoProcurar(resumo);
        viewAllBugPage.clicarEmAplicarFiltro();

        Assert.assertTrue(viewAllBugPage.resumosDosBugsCadastrados().contains(resumo));
    }

    @Test
    public void filtrarBugPorPessoaAtribuida() {

        //Objects instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();

        //Parameters
        String usuario = GlobalParameters.USUARIO_DEFAULT;
        String senha = GlobalParameters.SENHA_DEFAULT;
        String pessoaAtribuida = "caio.carvalho";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        myViewPage.clicarEmVerProblemas();
        viewAllBugPage.clicarEmAtribuidoA();
        viewAllBugPage.selecionarPessoaAtribuida(pessoaAtribuida);
        viewAllBugPage.clicarEmAplicarFiltro();

        Assert.assertTrue(viewAllBugPage.pessoasAtribuidasParaOsBugs().contains(pessoaAtribuida));
    }
}
