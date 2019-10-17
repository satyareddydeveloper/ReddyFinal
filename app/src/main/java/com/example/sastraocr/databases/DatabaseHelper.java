package com.example.sastraocr.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sastraocr.javaclasses.Contacts;

public class DatabaseHelper extends SQLiteOpenHelper {

    private	static final int DATABASE_VERSION =	5;
    private	static final String	DATABASE_NAME = "contact";
    private	static final String TABLE_CONTACTS = "contacts";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "contactname";
    private static final String COLUMN_NO = "phno";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String	CREATE_CONTACTS_TABLE = "CREATE	TABLE " + TABLE_CONTACTS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT "  + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }
    public boolean addContacts(Contacts contacts){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, contacts.getName());
        SQLiteDatabase db = this.getWritableDatabase();
      long result =   db.insert(TABLE_CONTACTS, null, values);


        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_CONTACTS,null);
        return res;
    }
}
