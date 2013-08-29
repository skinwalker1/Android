package com.example.lyndasp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	public SharedPreferences settings;
	public static final String prefsName = "myFileName";
	private Button savePrefs;
	private Button showPrefs;
	private EditText userName_et;
	private TextView prefs_result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		savePrefs = (Button) findViewById(R.id.set_prefs);
		showPrefs = (Button) findViewById(R.id.show_prefs);
		userName_et = (EditText) findViewById(R.id.username_et);
		prefs_result = (TextView) findViewById(R.id.prefs_result);
		settings = this.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
		
		savePrefs.setOnClickListener(this);
		showPrefs.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == savePrefs.getId()){
			setPrefs();
		}
		if(v.getId() == showPrefs.getId()){
			showPrefs();
		}
		
	}
	
	public void setPrefs(){
		SharedPreferences.Editor editor = settings.edit();
		String prefsValue = userName_et.getText().toString();
		editor.putString("user_name_key", prefsValue);
		editor.commit();
		Toast.makeText(getApplicationContext(), "Preferences saved", Toast.LENGTH_SHORT).show();
	}
	public void showPrefs(){
		String prefValue = settings.getString("user_name_key", "Not found");
		prefs_result.setText(prefValue);
	}

	

}
