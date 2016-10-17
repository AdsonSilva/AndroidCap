package com.example.huawei.notepad;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.huawei.notepad.DataBase.DB;
import com.example.huawei.notepad.DataBase.Repositorio;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addButton;

    private DB dataBase;
    private SQLiteDatabase conn;
    private GridView gridNotes;
    private Repositorio repo;

    private ArrayAdapter<String> adpNotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (FloatingActionButton)findViewById(R.id.addButton);
        gridNotes = (GridView) findViewById(R.id.gridNotes);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewNote.class));
            }
        });

        dataBase = new DB(this);
        conn = dataBase.getWritableDatabase();
        repo = new Repositorio(conn);
        repo.testInsert();

        adpNotas = repo.buscaNotas(this);
        gridNotes.setAdapter(adpNotas);

    }

}
