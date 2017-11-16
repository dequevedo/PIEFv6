package com.example.danielelvis.piefv6drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class FragmentSolicitacoes extends Fragment {

    public FragmentSolicitacoes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_solicitacoes, container, false);

        ListView lvSolicitacao = (ListView) view.findViewById(R.id.listview_solicitacoes);

        //We can get data from DB here
        ArrayList<Solicitacao> mSolicitacaoList = GerenciadorDeSolicitacao.getInstance().getSolicitacoesFromDB();

        //Init Adapter
        SolicitacaoListAdapter adapter = new SolicitacaoListAdapter(view.getContext(), mSolicitacaoList);
        lvSolicitacao.setAdapter(adapter);

        lvSolicitacao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Do something, ex: display msg
                Intent in = new Intent(view.getContext(), ActivitySolicitacaoListAdapterDetalhado.class);
                in.putExtra("protocolo", String.valueOf(view.getTag()));
                startActivity(in);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
