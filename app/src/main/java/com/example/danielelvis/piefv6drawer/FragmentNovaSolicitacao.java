package com.example.danielelvis.piefv6drawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNovaSolicitacao extends Fragment {


    public FragmentNovaSolicitacao() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       /* EditText email = getView().findViewById(R.id.editTextEmail);
        email.setText(GerenciadorDeLogin.getInstance().getAluno().getEmail());
        email.setEnabled(false);*/

        return inflater.inflate(R.layout.fragment_nova_solicitacao, container, false);
    }

    public void createSolicitacao(View view){
        Log.d("myTag",  "create solicitacao");
        String status="Solicitado",
                raAluno = GerenciadorDeLogin.getInstance().getAluno().getLogin(),
                dataAtualizacao = String.valueOf(new Date()),
                dataCriacao = String.valueOf(new Date()),
                codigoBoleto = "",
                codigoSecretario = "",
                tipo,
                mensagem;
        Log.d("myTag",  "Variaveis criadas");
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        Log.d("myTag",  "Spinner criado e setado");
        tipo = spinner.getSelectedItem().toString();
        Log.d("myTag",  "tipo pego do spinner");
        EditText msg = (EditText) view.findViewById(R.id.editTextMsg);
        Log.d("myTag",  "mensagem pega do edit");
        mensagem = msg.getText().toString();
        Log.d("myTag",  "mensagem setada");
        Log.d("myTag",  "Variaveis SETADAS");
        DB db = new DB();
        try {
            db.execute("INSERT INTO solicitacao " +
                    "(`status`, `ra_aluno`, `data_atualizacao`, `tipo`, `texto`, `data_criacao`) " +
                    "VALUES ('" + status + "', " +
                    "'" + raAluno + "', " +
                    "'" + dataAtualizacao + "', " +
                    "'" + tipo + "', " +
                    "'" + mensagem + "', " +
                    "'" + dataCriacao + "')");
        }catch (Exception e){
            Log.d("myTag",  e.getMessage()+" - Problema ao Criar Solicitação");
        }
    }
}
