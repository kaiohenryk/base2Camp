package com.selenium.flows;

import com.selenium.pages.BugReportPage;

public class BugReportFlows {
    //Objects and constructor
    BugReportPage bugReportPage;

    public BugReportFlows() {
        //Page and Steps Objects
        bugReportPage = new BugReportPage();
    }

    //Flows
    public void reportarBug(String categoria, String reprodutibilidade, String severidade, String prioridade,
                            String perfil, String pessoaAtribuida, String resumo, String descricao) {
        bugReportPage.selecionarCategoria(categoria);
        bugReportPage.selecionarReprodutibilidade(reprodutibilidade);
        bugReportPage.selecionarSeveridade(severidade);
        bugReportPage.selecionarPrioridade(prioridade);
        bugReportPage.selecionarPerfil(perfil);
        bugReportPage.selecionarPessoaAtribuida(pessoaAtribuida);
        bugReportPage.preencherResumo(resumo);
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.clicarNoBotaoEnviarRelatorio();
    }
}
