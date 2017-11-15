package com.example.danielelvis.piefv6drawer;

import android.app.Activity;
import android.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciadorDeSolicitacao extends _Default{
    private static final GerenciadorDeSolicitacao ourInstance = new GerenciadorDeSolicitacao();

    public static GerenciadorDeSolicitacao getInstance() {
        return ourInstance;
    }

    //private ArrayList<Solicitacao> listaSolicitacoes = new ArrayList<Solicitacao>();

    ///Tutorial

    private ListView lvSolicitacao;
    private SolicitacaoListAdapter adapter;
    private List<Solicitacao> mSolicitacaoList;
    private String login = "";
    private String nome = "";

    private GerenciadorDeSolicitacao() {
    }

    public ArrayList<Solicitacao> getSolicitacoesFromDB() {
            DB db = new DB();
            ArrayList<Solicitacao> listaSolicitacao = new ArrayList<>();
            try{
                ResultSet resultSet = db.select("SELECT * FROM solicitacao INNER JOIN " +
                        "aluno AS A ON A.ra = solicitacao.ra_aluno AND A.login = '"+login+"'");

                    while(resultSet.next()){
                        String codBoleto=" ";
                        String loginSecretario=" ";

                        Log.d("myTag",  "Login-Base: "+resultSet.getString("ra_aluno"));
                        Log.d("myTag",  "Uma Solicitação encontrada");

                        //caso não seja null, substitui a variavel
                        if(resultSet.getString("codboleto") != null)
                            codBoleto=resultSet.getString("codboleto");
                        if(resultSet.getString("loginsecretario") != null)
                            loginSecretario=resultSet.getString("loginsecretario");

                        //salva os atributos da solicitação encontrada em um obj
                        Solicitacao obj = new Solicitacao(resultSet.getString("protocolo"),
                                resultSet.getString("status"),
                                resultSet.getString("ra_aluno"),
                                resultSet.getString("data_atualizacao"),
                                resultSet.getString("data_criacao"),
                                codBoleto,
                                loginSecretario,
                                resultSet.getString("tipo"),
                                resultSet.getString("observacao"));
                        Log.d("myTag",  "ra_aluno:"+resultSet.getString("ra_aluno"));
                        listaSolicitacao.add(obj);
                    }

            }catch (Exception e) {
                this.menssagem = e.getMessage();
                Log.d("myTag", this.menssagem + " - lista de solicitacoes");
                this.status = false;
            }
        return listaSolicitacao;
    }

    public void novaSolicitacao(){
        //Pegar dados inseridos pelo usuário no app e gerar uma nova solicitação
        //Adicionar solicitação à lista
        //Adicionar solicitação ao banco de dados
        //Enviar Mensagem de sucesso
    }

    public void setInfo(String login, String nome){
        this.login = login;
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public List<Solicitacao> getmSolicitacaoList() {
        return mSolicitacaoList;
    }
}
