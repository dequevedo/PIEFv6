package com.example.danielelvis.piefv6drawer;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;

import java.sql.ResultSet;

public class ActivityLogin extends AppCompatActivity {

    private EditText Login;
    private EditText Senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginButton(View view){
        DB db = new DB();
        Login = (EditText) findViewById(R.id.loginField);
        Senha = (EditText) findViewById(R.id.passwordField);

        try{
            ResultSet resultSet = db.select("SELECT * FROM usuario WHERE login = '"
                    + Login.getText() + "' AND senha = MD5('" + Senha.getText() + "')");
            if(resultSet.next()) {
                //inicializa os dados do aluno que logou
                GerenciadorDeLogin.getInstance().DefinirDadosAluno(String.valueOf(Login.getText()));

                AlertDialog.Builder alerta = new AlertDialog.Builder(this);
                alerta.setTitle("Logado com sucesso!");
                alerta.setMessage("\n"+resultSet.getString("nome"));
                alerta.show();
                GerenciadorDeSolicitacao.getInstance().setInfo(resultSet.getString("login"), resultSet.getString("nome"));
                startActivity(new Intent(getApplicationContext(), ActivityMain.class));
            }
            else if(!resultSet.next()){
                AlertDialog.Builder alerta = new AlertDialog.Builder(this);
                alerta.setTitle("Acesso Negado!");
                alerta.setMessage("\nVerifique seu login e senha. " +
                        "\nUtilize o login e a senha do Sagres.");
                alerta.show();
            }
        }catch (Exception e){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setMessage("Erro ao fazer login");
            alerta.show();
        }

    }
}
