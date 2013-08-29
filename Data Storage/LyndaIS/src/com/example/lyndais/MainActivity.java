package com.example.lyndais;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button createBtn;
	Button readBtn;
	EditText et;
	TextView result_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		createBtn = (Button) findViewById(R.id.create_btn);
		readBtn = (Button) findViewById(R.id.read_btn);
		et = (EditText) findViewById(R.id.et);
		result_tv = (TextView) findViewById(R.id.output_tv);

		//Get the path of the file
		// File f = getFilesDir();
		// String path = f.getAbsolutePath();
		// result_tv.setText(path);

		createBtn.setOnClickListener(this);
		readBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == createBtn.getId()) {

			createFile();

		} else {
			try {
				readFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void createFile() {
		String text = et.getText().toString();
		try {
			FileOutputStream fos = openFileOutput("myfile.txt", MODE_PRIVATE);
			fos.write(text.getBytes());
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		result_tv.setText("File written to disk");
	}

	public void readFile() throws IOException {

		FileInputStream fis = openFileInput("myfile.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		StringBuffer b = new StringBuffer();
		while (bis.available() != 0) {
			char c = (char) bis.read();
			b.append(c);
		}

		result_tv.setText(b.toString());
		bis.close();
		fis.close();
	}

}
