package br.edu.ifsp.arq.dmos5_2020s1.loginhardcode.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.arq.dmos5_2020s1.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usuarioEditText;
    private EditText senhaEditText;
    private Button loginButton;

    public static final String KEY_USUARIO = "usuario";
    public static final String KEY_SENHA = "senha";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioEditText = findViewById(R.id.edittext_usuario);
        senhaEditText = findViewById(R.id.edittext_senha);
        loginButton = findViewById(R.id.button_login);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == loginButton){
            inicio();
        }

    }

    public void inicio(){
        int usuario, senha;

        try{
            usuario = Integer.parseInt(usuarioEditText.getText().toString());
            senha = Integer.parseInt(senhaEditText.getText().toString());

        }catch (NumberFormatException ex){
            usuario = 0;
            senha = 0;
        }

        if(usuario != 0 && senha != 0) {
            Bundle args = new Bundle();
            args.putInt(KEY_USUARIO, usuario);
            args.putInt(KEY_SENHA, senha);

            final Context context = this;

            Intent intent = new Intent(context, InicioActivity.class);
            intent.putExtras(args);
            startActivity(intent);
        }else{
            alert("usuario e senha tem que ser preenchidos");
        }
    }

    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}