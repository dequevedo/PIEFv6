package com.example.danielelvis.piefv6drawer;

public class GerenciadorDeLogin {
    private static final GerenciadorDeLogin ourInstance = new GerenciadorDeLogin();

    public static GerenciadorDeLogin getInstance() {
        return ourInstance;
    }

    private GerenciadorDeLogin() {
    }

    public void VerificarSintaxe(){
        //Verificar se os dados inseridos pelo usuario nao contèm caracteres proibidos etc
    }

    public void VerificarLogin(){
        //Comparar dados inseridos com o Hash contido no BD
    }
}
