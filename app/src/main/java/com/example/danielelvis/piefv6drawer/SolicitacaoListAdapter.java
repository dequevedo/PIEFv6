package com.example.danielelvis.piefv6drawer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SolicitacaoListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Solicitacao> mSolicitacaoList;

    public SolicitacaoListAdapter(Context mContext, List<Solicitacao> mSolicitacaoList) {
        this.mContext = mContext;
        this.mSolicitacaoList = mSolicitacaoList;
    }

    @Override
    public int getCount() {
        return mSolicitacaoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mSolicitacaoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext, R.layout.listadapter_solicitacao, null);

        TextView tvTipo = (TextView)v.findViewById(R.id.tv_tipo);
        TextView tvStatus = (TextView)v.findViewById(R.id.tv_status);
        TextView tvDataCriacao = (TextView)v.findViewById(R.id.tv_dataCriacao);
        TextView tvDataAtualizacao = (TextView)v.findViewById(R.id.tv_dataAtualizacao);

        //Set text for TextView
        tvTipo.setText(mSolicitacaoList.get(position).getTipo());
        tvStatus.setText(mSolicitacaoList.get(position).getStatus());
        tvDataCriacao.setText(String.valueOf(mSolicitacaoList.get(position).getDataCriacao()));
        tvDataAtualizacao.setText(String.valueOf(mSolicitacaoList.get(position).getDataAtualizacao()));

        //Save product id to tag
        v.setTag(mSolicitacaoList.get(position).getProtocolo());

        return v;
    }
}
