package com.example.danielelvis.piefv6drawer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Spinner;

import java.util.ArrayList;

public class GerenciadorDeNotificacao extends Thread {

    /*
    private static final GerenciadorDeNotificacao ourInstance = new GerenciadorDeNotificacao();
    public static GerenciadorDeNotificacao getInstance() {
        return ourInstance;
    }
    private GerenciadorDeNotificacao() {}*/

    public Context c;

    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(10);
                CheckSolicitacoesListDifferences();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Solicitacao> dbSolicitacaoList;
    private ArrayList<Solicitacao> mSolicitacaoList;
    private GerenciadorDeSolicitacao gerenciador = GerenciadorDeSolicitacao.getInstance();;

    private void CheckSolicitacoesListDifferences(){
        dbSolicitacaoList = gerenciador.getSolicitacoesFromDB();
        mSolicitacaoList = gerenciador.getSolicitacaoList();

        if( mSolicitacaoList != null && dbSolicitacaoList != null){
            Log.d("size" , "Size:" + mSolicitacaoList.size());
            for(int i = 0; i < mSolicitacaoList.size(); i++){

                String status1 = dbSolicitacaoList.get(i).getStatus();
                String status2 = mSolicitacaoList.get(i).getStatus();


                Log.d("comparar" , "----------------------------------------------------------");
                Log.d("comparar" , "ID: " +  i);
                Log.d("comparar" , "Protocolo: " +  mSolicitacaoList.get(i).getProtocolo());
                Log.d("comparar" , "Status: " + mSolicitacaoList.get(i).getStatus());
                Log.d("comparar" , "_");
                Log.d("comparar" , "Protocolo: " +  dbSolicitacaoList.get(i).getProtocolo());
                Log.d("comparar" , "Status: " + dbSolicitacaoList.get(i).getStatus());

                if(status1.equals(status2)){
                    Log.d("banco2" , "Nao Mudou");
                } else {
                    EnviarNotificação(dbSolicitacaoList.get(i).getTipo(), dbSolicitacaoList.get(i).getStatus());
                    Log.d("banco1", "Atualizou de: " + mSolicitacaoList.get(i).getStatus() + " Para: "+ dbSolicitacaoList.get(i).getStatus());
                }
            }
        }
    }

    public void EnviarNotificação(String titulo, String statusDepois){
        Intent intent = new Intent();
        PendingIntent pIntent = PendingIntent.getActivity(c,0, intent, 0);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(c)
                .setSmallIcon(R.drawable.ic_facamp_logo)
                .setContentTitle(titulo)
                .setContentText("Status atualizado para: " + statusDepois)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pIntent);
        NotificationManager notificationManager = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}
