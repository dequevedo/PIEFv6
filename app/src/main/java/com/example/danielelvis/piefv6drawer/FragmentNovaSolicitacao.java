package com.example.danielelvis.piefv6drawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNovaSolicitacao extends Fragment {


    public FragmentNovaSolicitacao() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       /* EditText email = getView().findViewById(R.id.editTextEmail);
        email.setText(GerenciadorDeLogin.getInstance().getAluno().getEmail());
        email.setEnabled(false);*/

        return inflater.inflate(R.layout.fragment_nova_solicitacao, container, false);
    }
}
