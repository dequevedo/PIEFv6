package com.example.danielelvis.piefv6drawer;

import java.util.Date;

public class Solicitacao {
    private int protocolo;
    private String status;
    private Date dataAtualizacao;
    private Date dataCriacao;
    private int codigoBoleto;
    private String tipo;
    private int raAluno;
    private int codigoSecretario;
    private String mensagem;

    public Solicitacao(int protocolo, String status, Date dataAtualizacao, Date dataCriacao, int codigoBoleto, String tipo, int raAluno, int codigoSecretario) {
        this.protocolo = protocolo;
        this.status = status;
        this.dataAtualizacao = dataAtualizacao;
        this.dataCriacao = dataCriacao;
        this.codigoBoleto = codigoBoleto;
        this.tipo = tipo;
        this.raAluno = raAluno;
        this.codigoSecretario = codigoSecretario;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getCodigoBoleto() {
        return codigoBoleto;
    }

    public void setCodigoBoleto(int codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(int raAluno) {
        this.raAluno = raAluno;
    }

    public int getCodigoSecretario() {
        return codigoSecretario;
    }

    public void setCodigoSecretario(int codigoSecretario) {
        this.codigoSecretario = codigoSecretario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
