package com.example.danielelvis.piefv6drawer;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;

public class ActivityMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Set the fragment initially
        FragmentMain fragment = new FragmentMain();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Mensagem de ajuda", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        FillNavigationBarUserHeader();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void FillNavigationBarUserHeader(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View mHeaderView = navigationView.getHeaderView(0);

        TextView nome2 = (TextView) mHeaderView.findViewById(R.id.nav_user_header_nome);
        TextView ra2 = (TextView) mHeaderView.findViewById(R.id.nav_user_header_ra);
        TextView curso2 = (TextView) mHeaderView.findViewById(R.id.nav_user_header_curso);

        nome2.setText(GerenciadorDeLogin.getInstance().getAluno().getNome());
        ra2.setText(GerenciadorDeLogin.getInstance().getAluno().getRa());
        curso2.setText(GerenciadorDeLogin.getInstance().getAluno().getTurma());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void createSolicitacao(View view){
        Log.d("myTag",  "create solicitacao");
        String status="Solicitado",
                raAluno = GerenciadorDeLogin.getInstance().getAluno().getRa(),
                dataAtualizacao = String.valueOf(new Date()),
                dataCriacao = String.valueOf(new Date()),
                codigoBoleto = "",
                codigoSecretario = "",
                tipo,
                mensagem;
        Log.d("myTag",  "Variaveis criadas");
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Log.d("myTag",  "Spinner criado e setado");
        tipo = spinner.getSelectedItem().toString();
        Log.d("myTag",  "tipo pego do spinner");
        EditText msg = (EditText) findViewById(R.id.editTextMsg);
        Log.d("myTag",  "mensagem pega do edit");
        mensagem = msg.getText().toString();
        Log.d("myTag",  "mensagem setada");
        Log.d("myTag",  "Variaveis SETADAS");
        DB db = new DB();
        try {
            db.execute("INSERT INTO solicitacao " +
                    "(`status`, `ra_aluno`, `data_atualizacao`, `tipo`, `observacao`, `data_criacao`) " +
                    "VALUES ('" + status + "', " +
                    "'" + raAluno + "', " +
                    "'" + dataAtualizacao + "', " +
                    "'" + tipo + "', " +
                    "'" + mensagem + "', " +
                    "'" + dataCriacao + "')");

            Log.d("newSolicitacao",  " Solicitação criada");
            Snackbar.make(view, "Solicitação criada", Snackbar.LENGTH_LONG).show();
        }catch (Exception e){
            Log.d("newSolicitacao",  e.getMessage()+" - Problema ao Criar Solicitação");
            Snackbar.make(view, "Problema ao Criar Solicitação", Snackbar.LENGTH_LONG).show();
        }
        EnviarNotificação();
    }



    public void EnviarNotificação(){
        Intent intent = new Intent();
        PendingIntent pIntent = PendingIntent.getActivity(this,0, intent, 0);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String tipo = spinner.getSelectedItem().toString();


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_facamp_logo)
                .setContentTitle(tipo)
                .setContentText("Status atualizado para: EM ANÁLISE")
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {
            //Set the fragment initially
            FragmentMain fragment = new FragmentMain();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_nova_solicitacao) {
            //Set the fragment initially
            FragmentNovaSolicitacao fragment = new FragmentNovaSolicitacao();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_solicitacoes) {
            //Set the fragment initially
            FragmentSolicitacoes fragment = new FragmentSolicitacoes();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_send) {
            startActivity(new Intent(getApplicationContext(), ActivityLogin.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onNovaSolicitacaoButton(View view){
        //Set the fragment initially
        FragmentNovaSolicitacao fragment = new FragmentNovaSolicitacao();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    public void onTodasSolicitacoesButton(View view){
        //Set the fragment initially
        FragmentSolicitacoes fragment = new FragmentSolicitacoes();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
