package com.example.danielelvis.piefv6drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
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

        ArrayList<Solicitacao> mSolicitacaoList = GerenciadorDeSolicitacao.getInstance().getSolicitacoes("201610703");
        Log.d("myTag", "retornou p/ main");
        for (Solicitacao solicitacao : mSolicitacaoList) {
            Log.d("myTag", String.valueOf(solicitacao.getRaAluno()));
        }

        /*mSolicitacaoList.add(new Solicitacao(7899, "Incompleta", new Date(2019,2,20),new Date(2019,2,20), 20520520, "Rematricula", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(4687, "Completa", new Date(2019,2,20),new Date(2019,2,20), 20520520, "Reserva de Sala", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(6789, "Em andamento", new Date(2019,2,20),new Date(2019,2,20), 20520520, "Revisão de prova", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(7814, "Incompleta", new Date(2019,2,20),new Date(2019,2,20), 20950520, "Rematricula", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(6818, "Em andamento", new Date(2019,2,20),new Date(2019,2,20), 20520520, "Reserva de Sala", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(8112, "Em andamento", new Date(2019,2,20),new Date(2019,2,20), 20150520, "Rematricula", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(9872, "Incompleta", new Date(2019,2,20),new Date(2019,2,20), 20520520, "Rematricula", 201612004, 10699));
        mSolicitacaoList.add(new Solicitacao(1665, "Completa", new Date(2019,2,20),new Date(2019,2,20), 20579520, "Rematricula", 201612004, 10699));
*/
        //Init Adapter
        SolicitacaoListAdapter adapter = new SolicitacaoListAdapter(view.getContext(), mSolicitacaoList);
        lvSolicitacao.setAdapter(adapter);


        // Inflate the layout for this fragment
        return view;
    }

}
