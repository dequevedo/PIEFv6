package com.example.danielelvis.piefv6drawer;

import android.util.Log;

import java.sql.ResultSet;

public class GerenciadorDeLogin {
    private static final GerenciadorDeLogin ourInstance = new GerenciadorDeLogin();
    public static GerenciadorDeLogin getInstance() {
        return ourInstance;
    }
    private Aluno aluno;

    private GerenciadorDeLogin() {
    }

    public void DefinirDadosAluno(String login){
        String senha = "";
        String nome = "";
        String ra = "";
        String turma = "";
        String cpf = "";

        DB db = new DB();
       try {
           ResultSet resultSet = db.select("SELECT * FROM usuario WHERE login = '"+login+"'");
           if (resultSet.next()) {
               senha = resultSet.getString("senha");
               nome = resultSet.getString("nome");
           }
       } catch (Exception e){
           Log.d("myTag",  "Falha ao Buscar os atributos Senha e Nome");
       }

       try{
           ResultSet resultSet2 = db.select("SELECT * FROM aluno WHERE login = '"+login+"'");

           if (resultSet2.next()) {
               ra = resultSet2.getString("ra");
               Log.d("batag",  "####RA:" + ra);
               turma = resultSet2.getString("turma");
               cpf = resultSet2.getString("cpf");
           }
       }catch (Exception e){
           Log.d("myTag",  "Falha ao Buscar os atributos RA, Turma e CPF");
       }
        aluno = new Aluno(login, senha, nome, ra, turma, cpf);
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
