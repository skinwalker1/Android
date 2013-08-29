package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class DBPref extends DBHelper{

	public DBPref(Context context) {
		super(context);
		
	}
	public void addRecords(String val){
		open();
		ContentValues cv = new ContentValues();
		cv.put("val", val);
		this.db.insert("preferences", null, cv);
	}
	
	public Cursor getVals(){
		open();
		return this.db.query("preferences",new String[]{"val"},null,null,null,null,null);
	}
}
