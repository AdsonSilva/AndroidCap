package com.example.huawei.notepad;

/**
 * Created by Adson on 30/09/16.
 */

public class Note {

    private String title;
    private String note;

    public Note(String title, String note){
        this.title = title;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(title);
        sb.append(System.lineSeparator());
        sb.append(note);

        return sb.toString();
    }
}
