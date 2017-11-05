package com.example.danielelvis.piefv6drawer;

/**
 * Created by DanielElvis on 02/11/2017.
 */

public class GerenciadorDePagamento {
    private static final GerenciadorDePagamento ourInstance = new GerenciadorDePagamento();

    public static GerenciadorDePagamento getInstance() {
        return ourInstance;
    }

    private GerenciadorDePagamento() {
    }

    public void gerarBoleto(/*Inserir parametros do boleto*/){
        //Retornar imagem, ou pdf, ou php do boleto
        //Enviar boleto por email (utilizar email da conta logada, ou pedir para inserir um email)
    }
}
