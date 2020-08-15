package br.edu.ifsp.arq.dmos5_2020s1.loginhardcode.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsp.arq.dmos5_2020s1.R;
import br.edu.ifsp.arq.dmos5_2020s1.loginhardcode.model.Usuario;

public class InicioActivity extends AppCompatActivity {

    private TextView viewInicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        viewInicio = findViewById(R.id.textview_viewInicio);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        realizarLogin();

    }

    private void realizarLogin() {
        Intent intent = getIntent();
        Bundle embrulho = intent.getExtras();

        if(embrulho != null) {
            int args1 = embrulho.getInt(MainActivity.KEY_USUARIO);
            int args2 = embrulho.getInt(MainActivity.KEY_SENHA);
            Usuario us = new Usuario(args1, args2);

            boolean a = us.realizaLogin();

            if (a) {
                viewInicio.setText("Bem vindo " + us.getPRONTUARIO());

            } else {
                viewInicio.setText("Erro no login");
            }
        }
    }
}