package com.example.danielelvis.piefv6drawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ActivitySolicitacaoListAdapterDetalhado extends AppCompatActivity {
    private Solicitacao sol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao_list_adapter_detalhado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.getString("protocolo") != null){
                Toast.makeText(getApplicationContext(), "Protocolo =" + bundle.getString("protocolo"), Toast.LENGTH_SHORT).show();

                sol = null;


                for(Solicitacao x : GerenciadorDeSolicitacao.getInstance().getSolicitacoesFromDB()){
                    int protocolo = 0;
                    try {
                        protocolo = Integer.parseInt(bundle.getString("protocolo"));
                    } catch(NumberFormatException nfe) {
                    }

                    if(x.getProtocolo() == protocolo){
                        sol = x;
                    }
                }

                /*
                //Pegar solicitação (apenas uma unica solicitação) com base no protocolo recebido acima no BD
                Solicitacao sol = new Solicitacao(
                        "3",
                        "Incompleto",
                        "201611220",
                        String.valueOf(new Date()),
                        String.valueOf(new Date()),
                        "456447" ,
                        "98789546",
                        "Declarações diversas",
                        "mensagem lokasjhaskjhaskjhshamensagem lokasjhaskjhaskjhshamensagem lokasjhaskjhaskjhshamensagem " +
                                "lokasjhaskjhaskjhshamensagem lokasjhaskjhaskjhshamensagem lokasjhaskjhaskjhsha");*/

                //Exibe os dados dessa solicitação na tela

                TextView tvTipo = (TextView)findViewById(R.id.tv_tipo);
                TextView tvStatus = (TextView)findViewById(R.id.tv_status);
                TextView tvDataCriacao = (TextView)findViewById(R.id.tv_dataCriacao);
                TextView tvDataAtualizacao = (TextView)findViewById(R.id.tv_dataAtualizacao);
                TextView protocolo = (TextView)findViewById(R.id.protocolo);
                TextView codBoleto = (TextView)findViewById(R.id.codigo_boleto);
                TextView raAluno = (TextView)findViewById(R.id.ra_aluno);
                TextView codSecretario = (TextView)findViewById(R.id.codigo_secretario);
                TextView message = (TextView) findViewById(R.id.mensagem);

                tvTipo.setText(String.valueOf(sol.getTipo()));
                tvStatus.setText(String.valueOf(sol.getStatus()));
                tvDataCriacao.setText(String.valueOf(sol.getDataCriacao()));
                tvDataAtualizacao.setText(String.valueOf(sol.getDataAtualizacao()));
                protocolo.setText(String.valueOf(sol.getProtocolo()));
                codBoleto.setText(String.valueOf(sol.getCodigoBoleto()));
                raAluno.setText(String.valueOf(sol.getRaAluno()));
                codSecretario.setText(String.valueOf(sol.getCodigoSecretario()));
                message.setText(String.valueOf(sol.getMensagem()));

                //verifica se existe boleto para a solicitação e libera ou não o botão Gerar Boleto
                TextView text =  findViewById(R.id.textBoleto);
                if(!sol.getStatus().equals("FINALIZADO")) {
                    if (sol.getCodigoBoleto().equals("0")) {
                        Log.d("myTag", "NÃO É NECESSÁRIO PAGAMENTO");
                        findViewById(R.id.bGerarBoleto).setVisibility(View.INVISIBLE);
                        text.setText("NÃO É NECESSÁRIO PAGAMENTO");
                    } else {
                        Log.d("myTag", "NECESSARIO PAGAMENTO");
                        findViewById(R.id.bGerarBoleto).setVisibility(View.VISIBLE);
                        text.setText("PAGAMENTO NECESSÁRIO: R$" + sol.getCodigoBoleto() + ",00");
                    }
                }
                else {
                    text.setText("SOLICITAÇÃO FINALIZADA");
                    findViewById(R.id.bGerarBoleto).setVisibility(View.INVISIBLE);
                }
                //pega o nome do funcionario
                /*DB db = new DB();
                ResultSet resultSet = db.select("SELECT nome FROM usuario WHERE login='"+String.valueOf(sol.getCodigoSecretario()));
                try {
                    if(resultSet.next())
                    codSecretario.setText(resultSet.getString("nome").toString());
                } catch (SQLException e) {
                }*/
            }
        }
    }

    public void openBoleto(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+new DB().getHost()+":8090" +
                "/boletophp/boleto_santander_banespa.php" +
                "?1="+GerenciadorDeLogin.getInstance().getAluno().getNome()+"" +
                "&2="+sol.getTipo()+"" +
                "&3="+sol.getCodigoBoleto()));
        startActivity(intent);
    }

}
