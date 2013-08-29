package com.example.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	Button btnSave;
	Button btnShow;
	EditText etShow;
	EditText etMain;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnSave = (Button) findViewById(R.id.btn_save);
		btnShow = (Button) findViewById(R.id.btn_show);
		etShow = (EditText) findViewById(R.id.et_show);
		etMain = (EditText) findViewById(R.id.et_save);
		
		btnShow.setOnClickListener(this);
		btnSave.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		DBPref pref = new DBPref(MainActivity.this);
		if(v.getId() == btnSave.getId()){
			pref.addRecords(etMain.getText().toString());
		}
		if(v.getId() == btnShow.getId()){
			Cursor c = pref.getVals();
			StringBuilder sb = new StringBuilder();
			if(c.moveToFirst()){
				do{
					sb.append(c.getString(c.getColumnIndex("val")));
					sb.append(" , ");
				}while(c.moveToNext());
			}
			c.close();
			pref.close();
			etShow.setText(sb.toString());
		}
		
	}

	

}
