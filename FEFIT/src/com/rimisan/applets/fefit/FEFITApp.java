/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimisan.applets.fefit;

import java.io.File;

/**
 *
 * @author Glauco Basilio
 */
public class FEFITApp {
    public static final String TMPL_CAMINHO = "#CAMINHO#";
    public static final String TMPL_NOME = "#NOME#";
    public static final String TMPL_PASTA = "#PASTA#";
    public static  final String TMPL_TAMANHO = "#TAMANHO#";
    
    public static final String ACAO_PADRAO_SUBSTITUICAO = 
            "Caminho completo: "+TMPL_CAMINHO+
                " | Nome do arquivo: "+TMPL_NOME +
                " | Pasta que contém o arquivo: "+TMPL_PASTA +
                " | Tamanho do arquivo: " + TMPL_TAMANHO;
    
    public static final String ACAO_PADRAO_JAVASCRIPT = "arquivo.setReadOnly();";
    
    public static final String CRITERIO_PADRAO_REGEX = "\\.*";
    public static final String CRITERIO_PADRAO_JAVASCRIPT = "return arquivo.getName().contains(\".txt\");";
    
    public FEFITApp()
    {
        
    }
}
