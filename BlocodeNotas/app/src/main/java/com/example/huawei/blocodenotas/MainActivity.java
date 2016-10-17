package com.example.huawei.blocodenotas;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {

    private GridView gridNotas;
    private FloatingActionButton addButton;

    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.gridNotas = (GridView) findViewById(R.id.gridNotes);
        this.addButton = (FloatingActionButton) findViewById(R.id.addButton);
        db = new DataBase();

        testInsert();
        gridNotas.setAdapter(db.getNotes(this));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewNote.class));
            }
        });


    }

    private void testInsert(){

        for(int i = 0; i < 6; i++){
            db.insertNote("Teste");
        }

    }

}
