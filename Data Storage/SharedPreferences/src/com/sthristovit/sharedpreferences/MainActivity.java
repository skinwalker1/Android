package com.sthristovit.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et = (EditText) findViewById(R.id.et_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onPause() {
		super.onPause();

		SharedPreferences pref = getSharedPreferences("MainActivity", 0);
		SharedPreferences.Editor edit = pref.edit();
		edit.putString("text_value", et.getText().toString());
		edit.commit();

	}

	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences pref = getSharedPreferences("MainActivity", 0);
		String textValue = pref.getString("text_value", null);
		if (et != null) {
			et.setText(textValue);
		}

	}

}
