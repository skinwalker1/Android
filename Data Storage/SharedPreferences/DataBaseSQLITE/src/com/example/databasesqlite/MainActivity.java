package com.example.databasesqlite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	Button saveButton;
	EditText textET;
	DataBase db = new DataBase(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		saveButton = (Button) findViewById(R.id.button1);
		textET = (EditText) findViewById(R.id.editText1);
		
		saveButton.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId() == saveButton.getId()){
			db.storeText(textET.getText().toString());
			
		}
		
	}

	

}
