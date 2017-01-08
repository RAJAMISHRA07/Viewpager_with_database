package com.example.admin.viewpager_with_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 1/7/2017.
 */
public class MyDatabase {
    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;
    public  MyDatabase (Context c){myHelper=new MyHelper(c,"techpalle.db",null,1);}
    public  void  open(){sqLiteDatabase=myHelper.getWritableDatabase();}
    public void insertStudent(String sname,String ssub,String email){
        ContentValues contentValues=new ContentValues();
        contentValues.put("sname",sname);
        contentValues.put("ssub",ssub);
        contentValues.put("email",email);
        sqLiteDatabase.insert("student",null,contentValues);
    }
    public Cursor queryStudent() {
        Cursor c = null;

        c=sqLiteDatabase.query("student",null,null,null,null,null,null);

        return c;
    }
 public  void close(){
     sqLiteDatabase.close();
 }

    public class  MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table student(_id Integer primary key,sname text,ssub text,email text);");
        }



        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
