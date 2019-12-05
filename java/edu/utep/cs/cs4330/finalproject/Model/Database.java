package edu.utep.cs.cs4330.finalproject.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

/**
 * @author Julio Hernandez
 * SQL Lite Database implemented
 */
public class Database extends SQLiteOpenHelper {
    public static final String databaseName = "scores.db";
    public static final String tableName = "scoreTable";
    public static final String col0 = "id";
    public static final String col1 = "rank";
    public static final String col2 = "name";
    public static final String col3 = "score";


    public Database(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableName +" (id INTEGER PRIMARY KEY AUTOINCREMENT, rank INT, name TEXT,score INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS " + tableName);
    onCreate(db);
    }

    public void insertData(Score score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(col1, score.rank);
        content.put(col2, score.name);
        content.put(col3, score.score);
        db.insert(tableName, null, content);
    }

    public Cursor getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from "+tableName,null);
        return data;
    }

    public void deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tableName, "id = ?",new String[] {id});
    }
}
