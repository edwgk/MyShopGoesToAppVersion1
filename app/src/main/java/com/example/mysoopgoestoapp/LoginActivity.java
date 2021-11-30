package com.example.mysoopgoestoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et1,et2;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1=(EditText) findViewById(R.id.editTextTextPersonName);
        et2=(EditText) findViewById(R.id.editTextTextPassword);
        tv1=(TextView) findViewById(R.id.textView3);
        tv2=(TextView) findViewById(R.id.textView4);
        tv1.setClickable(true);
        tv2.setClickable(true);
        String texto1="<a href=''>Recordar contraseña</a>";
        tv1.setText(Html.fromHtml(texto1));
        String texto2="<a href=''>Ir a registro</a>";
        tv2.setText(Html.fromHtml(texto2));

    }
    // metodo para ir a otra actividad
    public void goToRegistroActivity(View view){
        Intent newIntent=new Intent(this,Registro_Activity.class);
        startActivity(newIntent);
    }

    //Validar login
    public void login (View view){
        String user=et1.getText().toString();
        String pass=et2.getText().toString();
        if(!user.equals("") && !pass.equals("")){
            if(user.equals("ShopAdmins1")&&pass.equals("Admins01")){
                Intent newIntent=new Intent(this,MainActivity.class);
                startActivity(newIntent);
                Toast.makeText(this, "Login Correcto ", Toast.LENGTH_SHORT).show();
                finish();
            }
            else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                et1.requestFocus();
            }
        }
        else{
            if(user.equals("")){
                et1.requestFocus();
                Toast.makeText(this, "Por favor, ingrese el usuario", Toast.LENGTH_SHORT).show();

            }
            else if(pass.equals("")){
                et2.requestFocus();
                Toast.makeText(this, "Por favor, ingrese la contraseña", Toast.LENGTH_SHORT).show();
            }
        }

    }
}