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

    private ArrayList<Solicitacao> listaSolicitacoes = new ArrayList<Solicitacao>();

    ///Tutorial

    private ListView lvSolicitacao;
    private SolicitacaoListAdapter adapter;
    private List<Solicitacao> mSolicitacaoList;


    private GerenciadorDeSolicitacao() {
    }

    public ArrayList<Solicitacao> getSolicitacoes(String login) {
            DB db = new DB();
            ArrayList<Solicitacao> listaSolicitacao = new ArrayList<>();
            try{
                ResultSet resultSet = db.select("SELECT * FROM solicitacao WHEN login = '"+login+"'");
                if(resultSet != null){
                    while(resultSet.next()){
                        Solicitacao obj = new Solicitacao(resultSet.getString("cod_solicitacao"),
                                resultSet.getString("status"),
                                resultSet.getString("ra_aluno"),
                                resultSet.getString("data_atualizacao"),
                                resultSet.getString("data_criacao"),
                                resultSet.getString("codboleto"),
                                resultSet.getString("codsecretario"),
                                resultSet.getString("tipo"),
                                resultSet.getString("texto"));
                        listaSolicitacao.add(obj);
                    }
                }
            }catch (Exception e) {
                this.menssagem = e.getMessage();
                Log.d("myTag", this.menssagem + " - This is my message");
                this.status = false;
            }
        return listaSolicitacoes;
    }

    public void novaSolicitacao(){
        //Pegar dados inseridos pelo usuário no app e gerar uma nova solicitação
        //Adicionar solicitação à lista
        //Adicionar solicitação ao banco de dados
        //Enviar Mensagem de sucesso
    }



   /* protected void FillSolicitacaoList(Activity a) {

        final Activity activity = a;

        lvSolicitacao = (ListView) activity.findViewById(R.id.listview_solicitacoes);

        //Add sample data for list
        //We can get data from DB here
        mSolicitacaoList = new ArrayList<>();
        mSolicitacaoList.add(new Solicitacao(7899, "Incompleta", new Date(2019,2,20),new Date(2019,2,20), 20520520, "Rematricula", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(4687, "Completa", new Date(2019,2,20),new Date(2019,2,20), 20520520, "Reserva de Sala", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(6789, "Em andamento", new Date(2019,2,20),new Date(2019,2,20), 20520520, "Revisão de prova", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(7814, "Incompleta", new Date(2019,2,20),new Date(2019,2,20), 20950520, "Rematricula", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(6818, "Em andamento", new Date(2019,2,20),new Date(2019,2,20), 20520520, "Reserva de Sala", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(8112, "Em andamento", new Date(2019,2,20),new Date(2019,2,20), 20150520, "Rematricula", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(9872, "Incompleta", new Date(2019,2,20),new Date(2019,2,20), 20520520, "Rematricula", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(1665, "Completa", new Date(2019,2,20),new Date(2019,2,20), 20579520, "Rematricula", 201612004, 10699));

        //Init Adapter
        adapter = new SolicitacaoListAdapter(activity.getApplicationContext(), mSolicitacaoList);
        lvSolicitacao.setAdapter(adapter);


        /*
        lvSolicitacao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Do something, ex: display msg
                Toast.makeText(activity.getApplicationContext(), "Clicked product id =" + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });

    }*/
}
