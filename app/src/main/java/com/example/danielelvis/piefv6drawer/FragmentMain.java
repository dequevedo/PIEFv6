package com.example.danielelvis.piefv6drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class FragmentMain extends Fragment {

    public FragmentMain() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView lvSolicitacao = (ListView) view.findViewById(R.id.listview_solicitacoes);

        //We can get data from DB here
        ArrayList<Solicitacao> mSolicitacaoList = GerenciadorDeSolicitacao.getInstance().getSolicitacoesFromDB();
        Collections.reverse(mSolicitacaoList);

        Log.d("myTag", "retornou p/ main");
        for (Solicitacao solicitacao : mSolicitacaoList) {
            Log.d("myTag", String.valueOf(solicitacao.getRaAluno()));
        }

        //Preencher cabeçario com dados do usuario
        FillUserHeader(view);

        //Init Adapter
        SolicitacaoListAdapter adapter = new SolicitacaoListAdapter(view.getContext(), mSolicitacaoList);
        lvSolicitacao.setAdapter(adapter);

        return view;
    }

    public void FillUserHeader(View v){
        TextView nome = (TextView) v.findViewById(R.id.userHeader_nome);
        TextView ra = (TextView) v.findViewById(R.id.userHeader_ra);
        TextView curso = (TextView) v.findViewById(R.id.userHeader_curso);

        nome.setText(GerenciadorDeLogin.getInstance().getAluno().getNome());
        ra.setText(GerenciadorDeLogin.getInstance().getAluno().getRa());
        curso.setText(GerenciadorDeLogin.getInstance().getAluno().getTurma());
    }

}
