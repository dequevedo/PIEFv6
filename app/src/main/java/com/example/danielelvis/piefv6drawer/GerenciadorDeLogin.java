package com.example.danielelvis.piefv6drawer;

public class GerenciadorDeLogin {
    private static final GerenciadorDeLogin ourInstance = new GerenciadorDeLogin();
    public static GerenciadorDeLogin getInstance() {
        return ourInstance;
    }
    private Aluno aluno;

    private GerenciadorDeLogin() {
    }

    public void DefinirDadosAluno(String login){

        /*
        String senha = //Pegar do DB
        String nome = //Pegar do DB
        String ra = //Pegar do DB
        String turma = //Pegar do DB
        String cpf = //Pegar do DB


        aluno = new Aluno(login, senha, nome, ra, turma, cpf);*/
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void VerificarSintaxe(){
        //Verificar se os dados inseridos pelo usuario nao contèm caracteres proibidos etc
    }

    public void VerificarLogin(){
        //Comparar dados inseridos com o Hash contido no BD
    }
}
