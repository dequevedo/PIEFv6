package com.example.danielelvis.piefv6drawer;

public class Aluno {
    private String login;
    private String senha;
    private String nome;
    private String ra;
    private String turma;
    private String cpf;

    public Aluno(String login, String senha, String nome, String ra, String turma, String cpf) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.ra = ra;
        this.turma = turma;
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
