package com.example.sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {
	static final String DB_NAME = "mydb";
	static final int DB_CURRENT_VERSION = 1;
	protected SQLiteDatabase db;
	
	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_CURRENT_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table preferences (_id integer primary key autoincrement, "
				+ "val text not null);");
		Log.d("C3","Createdb");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}
	
	public void open()throws SQLException{
		db = getWritableDatabase();
	}
	public void close(){
		db.close();
	}

}
