package com.example.databasesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBase extends SQLiteOpenHelper {

	private static final String DB_NAME = "notes";
	private static final int DB_VERSION = 1;
	private Context context;
	public DataBase(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table my_field_table " + "(_id integer primary key autoincrement,field text not null)";
		
		db.execSQL(sql);
		Toast.makeText(context, "Created", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}
	public void storeText(String txt){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("field",txt);
		db.insert("my_field_table", null, values);
		
		db.close();
	}

}
