package com.example.danielelvis.piefv6drawer;

public class Solicitacao {
    private int protocolo;
    private String status;
    private int raAluno;
    private String dataAtualizacao;
    private String dataCriacao;
    private int codigoBoleto;
    private String tipo;
    private int codigoSecretario;
    private String mensagem;

    public Solicitacao(String protocolo,
                       String status,
                       String raAluno,
                       String dataAtualizacao,
                       String dataCriacao,
                       String codigoBoleto,
                       String codigoSecretario,
                       String tipo,
                       String mensagem) {
        this.protocolo = Integer.parseInt(protocolo);
        this.status = status;
        this.raAluno = Integer.parseInt(raAluno);
        this.dataAtualizacao = dataAtualizacao;
        this.dataCriacao = dataCriacao;
        this.codigoBoleto = Integer.parseInt(codigoBoleto);
        this.codigoSecretario = Integer.parseInt(codigoSecretario);
        this.tipo = tipo;
        this.mensagem = mensagem;
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

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
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
