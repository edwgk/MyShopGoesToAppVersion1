package com.example.mysoopgoestoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBSQLiteHelper extends SQLiteOpenHelper {
    public MyDBSQLiteHelper(Context contex, String nombre, SQLiteDatabase.CursorFactory f, int version){
        super(contex,nombre,f,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE usuariosapp(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT, ndi TEXT, email TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int verAnterior, int verNueva){
        db.execSQL("DROP TABLE IF EXISTS usuariosapp");
        db.execSQL("CREATE TABLE usuariosapp(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT, ndi TEXT, email TEXT)");

    }

}
