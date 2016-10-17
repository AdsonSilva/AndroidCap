package com.example.huawei.notepad.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by huawei on 30/09/16.
 */

public class DB extends SQLiteOpenHelper {


    public DB(Context context) {

        super(context, "NOTAS", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(getCreateNote());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String getCreateNote(){

        StringBuilder sb = new StringBuilder();

        sb.append(" CREATE TABLE IF NOT EXISTS NOTA ( ");
        sb.append("_id     INTEGER      NOT NULL ");
        sb.append("PRIMARY KEY AUTOINCREMENT, ");
        sb.append("TITULO           VARCHAR (200), ");
        sb.append("NOTA             VARCHAR (255) ");
        sb.append(");");

        return sb.toString();
    }
}
