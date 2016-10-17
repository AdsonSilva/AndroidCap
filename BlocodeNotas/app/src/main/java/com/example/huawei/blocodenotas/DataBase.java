package com.example.huawei.blocodenotas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import java.util.Locale;

/**
 * Created by huawei on 05/10/16.
 */
public class DataBase extends AppCompatActivity{

    private SQLiteDatabase db;
    final String CREATE_TABLE_NOTES = "CREATE TABLE notas (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "texto TEXT);";


    public DataBase(){
        this.createDB();
    }

    public void createDB() {
        this.db = openOrCreateDatabase("Notas.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);
        db.execSQL(CREATE_TABLE_NOTES);
    }

    public void insertNote(String texto){
        ContentValues values = new ContentValues();
        values.put("texto", texto);
        db.insertOrThrow("notas", null,values);
    }

    public ArrayAdapter<String> getNotes(Context context){

        ArrayAdapter<String> adpNotas = new ArrayAdapter<String>(context, R.layout.activity_main);

        Cursor cursor = db.query("notas", null, null, null, null, null, null);

        if (cursor.getCount() > 0){
            String texto = cursor.getString(cursor.getColumnIndex("texto"));
            adpNotas.add(texto);
        }
        return adpNotas;
    }


}
