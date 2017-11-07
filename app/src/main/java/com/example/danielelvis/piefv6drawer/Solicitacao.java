package com.example.danielelvis.piefv6drawer;

public class Solicitacao {
    private int protocolo;
    private String status;
    private String raAluno;
    private String dataAtualizacao;
    private String dataCriacao;
    private String codigoBoleto;
    private String tipo;
    private String codigoSecretario;
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
        this.raAluno = raAluno;
        this.dataAtualizacao = dataAtualizacao;
        this.dataCriacao = dataCriacao;
        this.codigoBoleto = codigoBoleto;
        this.codigoSecretario = codigoSecretario;
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

    public String getCodigoBoleto() {
        return codigoBoleto;
    }

    public void setCodigoBoleto(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(String raAluno) {
        this.raAluno = raAluno;
    }

    public String getCodigoSecretario() {
        return codigoSecretario;
    }

    public void setCodigoSecretario(String codigoSecretario) {
        this.codigoSecretario = codigoSecretario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
