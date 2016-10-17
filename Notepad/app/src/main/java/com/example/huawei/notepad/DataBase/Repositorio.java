package com.example.huawei.notepad.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.huawei.notepad.R;

/**
 * Created by huawei on 04/10/16.
 */

public class Repositorio {

    private SQLiteDatabase conn;

    public Repositorio(SQLiteDatabase conn){
        this.conn = conn;
    }

    public void testInsert(){

        for (int i = 0; i < 5; i++){
            Log.d("1","1");
            ContentValues values = new ContentValues();
            values.put("TITULO", "Não sou da corvinal");
            conn.insertOrThrow("NOTA", null, values);
        }

    }

    public ArrayAdapter<String> buscaNotas(Context context){
        ArrayAdapter<String> adpNotas = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.query("NOTA", null, null, null, null, null, null);

        Log.d("CURSOR", ""+cursor.getCount());
        if (cursor.getCount() > 0){
                Log.d("CURSOR", cursor.getString(1));
                //String titulo = cursor.getString(cursor.getColumnIndex("NOTA"));
                //adpNotas.add(titulo);

        }

        return adpNotas;
    }

}
