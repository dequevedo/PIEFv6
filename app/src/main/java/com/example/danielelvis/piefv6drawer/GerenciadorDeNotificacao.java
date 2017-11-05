package com.example.danielelvis.piefv6drawer;

public class GerenciadorDeNotificacao {
    private static final GerenciadorDeNotificacao ourInstance = new GerenciadorDeNotificacao();

    public static GerenciadorDeNotificacao getInstance() {
        return ourInstance;
    }

    private GerenciadorDeNotificacao() {
    }

    public void enviarNotificacao(){
        //Enviar Notificação utilizando o Firebase da google
    }
}
