package com.example.jazz.foocider.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jazz.foocider.Objects.Suggestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jazz on 12/9/17.
 */

public class SuggestionDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "reviewDB";

    private static final String TABLE_SUG       = "suggestion";
    private static final String SUG_ID          = "id";
    private static final String SUG_NAME        = "name";
    private static final String SUG_NUM_VISITED = "visited";
    private static final String SUG_PREFERENCE  = "preference";


    private static final String CREATE_SUG_TABLE = "CREATE TABLE " + TABLE_SUG + "("
            + SUG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + SUG_NAME + " TEXT, "
            + SUG_NUM_VISITED + " INTEGER, "
            + SUG_PREFERENCE + " REAL)";

    public SuggestionDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_SUG_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_SUG);

        onCreate(sqLiteDatabase);
    }

    public void addSuggestion(Suggestion suggestion){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SUG_NAME, suggestion.getName());
        values.put(SUG_NUM_VISITED, suggestion.getVisted());
        values.put(SUG_PREFERENCE, suggestion.getPreference());

        db.insert(TABLE_SUG, null, values);
        db.close();
    }


    public List<Suggestion> getAllSuggestions(){

        List<Suggestion> list = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_SUG;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Suggestion suggestion = new Suggestion(cursor.getString(cursor.getColumnIndex(SUG_NAME)),
                        null,
                        cursor.getInt(cursor.getColumnIndex(SUG_NUM_VISITED)),
                        cursor.getDouble(cursor.getColumnIndex(SUG_PREFERENCE)));

                list.add(suggestion);
            }while (cursor.moveToNext());
        }

        return list;
    }
}
