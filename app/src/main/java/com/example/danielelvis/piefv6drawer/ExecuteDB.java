package com.example.danielelvis.piefv6drawer;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Asceifer on 02/11/2017.
 */

public class ExecuteDB extends AsyncTask<String, Void, ResultSet>{

    private Connection connection;
    private String query;
    private String tipo;

    public ExecuteDB(Connection connection, String query, String tipo) {
        this.connection = connection;
        this.query = query;
        this.tipo = tipo;
    }

    @Override
    protected ResultSet doInBackground(String... strings) {
        ResultSet resultSet = null;
        try{
            if(connection != null) Log.d("myTag", " - conexão existente em ExecuteDB");
            else Log.d("myTag", " - conexão NÃO existente em ExecuteDB");
            if(tipo.equals("Query")) {
                resultSet = connection.prepareStatement(query).executeQuery();
            }
            else if(tipo.equals("Update")){
                connection.prepareStatement(query).executeUpdate();
            }
            Log.d("myTag", " - (ExecuteClass: Executou a Query: "+query);
        }catch (Exception e){
            Log.d("myTag", e.getMessage()+" - (ExecuteClass - ERRO AO EXECUTAR QUERY");
        }finally {
            try{

            }catch (Exception e){

            }
        }
        return resultSet;
    }

}
