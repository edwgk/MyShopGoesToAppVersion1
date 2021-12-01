package com.example.mysoopgoestoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro_Activity extends AppCompatActivity {


    private MyDBSQLiteHelper admin;
    private SQLiteDatabase db;
    private ContentValues cv;
    private Cursor fila;
    private EditText et_nombres,et_apellidos,et_ndi,et_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        admin=new MyDBSQLiteHelper(this,vars.bd, null,vars.ver);

        et_nombres=findViewById(R.id.inputRegistroNuevoNombre);
        et_apellidos=findViewById(R.id.inputREgistroNuevoApellido);
        et_ndi=findViewById(R.id.inputRegistroNuevoDI);
        et_email=findViewById(R.id.inputRegistroNuevoEmailAddress);




    }

    public void agregarUsuarios(View view){

        String nom=et_nombres.getText().toString();
        String ape=et_apellidos.getText().toString();
        String doc=et_ndi.getText().toString();
        String mail=et_email.getText().toString();
        if(!nom.equals("")&&!ape.equals("")&&!doc.equals("")&&!mail.equals("")){
            db=admin.getWritableDatabase();
            cv=new ContentValues();
            cv.put("nombres",et_nombres.getText().toString());
            cv.put("apellidos",et_apellidos.getText().toString());
            cv.put("ndi",et_ndi.getText().toString());
            cv.put("email",et_email.getText().toString());
            long reg =db.insert("usuariosapp",null,cv);
            if(reg!=-1){
                Toast.makeText(this, "Registro almacenado", Toast.LENGTH_SHORT).show();
                et_nombres.setText("");
                et_apellidos.setText("");
                et_ndi.setText("");
                et_email.setText("");
            }
            else{
                Toast.makeText(this, "No se pudo agregar el registro", Toast.LENGTH_SHORT).show();
            }
        }else
            Toast.makeText(this, "No se pudo agregar el registro", Toast.LENGTH_SHORT).show();




    }


    public void listarDatos(View view){

        db=admin.getReadableDatabase();
        fila=db.rawQuery("SELECT * FROM usuariosapp",null);
        while (fila.moveToNext()){

            Toast.makeText(this, fila.getInt(0) + "-" + fila.getString(1) + " " + fila.getString(2)+fila.getString(3)+" "+fila.getString(4)+" ", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

}