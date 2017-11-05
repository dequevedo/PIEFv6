package com.example.danielelvis.piefv6drawer;

    import android.util.Log;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;

/**
 * Created by Asceifer on 02/11/2017.
 */

public class DB extends _Default implements Runnable {

    private Connection conn;
    private String host = "192.168.0.103";
    private String db = "solicitafacamp";
    private int port = 3306;
    private String user = "root";
    private String pass = "123456";
    private String url = "jdbc:mysql://%s:%d/%s";

    public DB() {
        super();
        this.url = String.format(this.url, this.host, this.port, this.db);
    }

    @Override
    public void run() {
        if(this.conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
                Log.d("myTag", this.menssagem + " - (DB run) CONECTOU");

            } catch (Exception e) {
                this.menssagem = e.getMessage();
                Log.d("myTag", this.menssagem + " - This is my message (não conectou)");
                this.status = false;
            }
        }
    }

    private void conecta(){
        Thread thread = new Thread(this);
        thread.start();
        Log.d("myTag", this.menssagem + " - Nova Thread de Conexão BD");
        try{
            thread.join();
        }catch (Exception e){
            this.menssagem = e.getMessage();
            this.status = false;
        }
    }

    private void desconecta(){
        try{
            this.conn.close();
            Log.d("myTag", this.menssagem+" - (DB) DESCONECTOU ");
        }catch (Exception e){
            Log.d("myTag", this.menssagem+" - erro ao desconectar ");
        }finally {
            this.conn = null;
        }
    }

    public ResultSet select(String query){
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query, "Query").execute().get();
            Log.d("myTag", this.menssagem+" - Executou a Query Select");
        } catch (Exception e){
            this.status = false;
            this.menssagem = e.getMessage();
            Log.d("myTag", this.menssagem+" - Não Executou a Query Select");
        }
        this.desconecta();
        return resultSet;
    }

    public ResultSet execute(String query){
        this.desconecta();
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query, "Update").execute().get();
            Log.d("myTag", this.menssagem+" - Executou a query: "+query);
        } catch (Exception e){
            this.status = false;
            this.menssagem = e.getMessage();
            Log.d("myTag", this.menssagem+" - Não executou a query");
        }
        return resultSet;
    }
}
