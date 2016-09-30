package com.example.huawei.notepad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewNote extends AppCompatActivity {

    private Button saveButton;
    private EditText noteTitle, note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        saveButton = (Button) findViewById(R.id.saveButton);
        noteTitle = (EditText) findViewById(R.id.edtTitle);
        note = (EditText) findViewById(R.id.edtNote);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote(noteTitle.getText().toString(), note.getText().toString());
                finish();
            }
        });
    }

    private void saveNote(String titulo, String nota){
        SharedPreferences notes = getSharedPreferences("notes", 0);
        SharedPreferences.Editor editor = notes.edit();
        editor.putString(titulo, nota);
    }
}
