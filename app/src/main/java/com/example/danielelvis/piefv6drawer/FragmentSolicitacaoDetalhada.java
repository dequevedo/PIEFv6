package com.example.danielelvis.piefv6drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentSolicitacaoDetalhada extends Fragment {

    public FragmentSolicitacaoDetalhada() {
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


        // Inflate the layout for this fragment
        return view;
    }

}
