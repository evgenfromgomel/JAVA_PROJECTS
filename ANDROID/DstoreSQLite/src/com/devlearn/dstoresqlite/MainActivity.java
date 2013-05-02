package com.devlearn.dstoresqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	
	final String LOG_TAG = "dbLog";
	final String TBL_COL_NAME = "name";
	final String TBL_COL_EMAIL = "email";
	final String TBL_NAME_CELLBOOK = "cellbook";
	
	Button btnAdd, btnRead, btnClear;
	EditText etName, etEmail;
	
	DBHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(this);
		
		btnRead = (Button) findViewById(R.id.btnRead);
		btnRead.setOnClickListener(this);
		
		btnClear = (Button) findViewById(R.id.btnClear);
		btnClear.setOnClickListener(this);
		
		etName = (EditText) findViewById(R.id.etName);
		etEmail = (EditText) findViewById(R.id.etEmail);
		
		dbHelper = new DBHelper(this);	
	}

	@Override
	public void onClick(View v) {
		
		ContentValues cv = new ContentValues();
		
		String name = etName.getText().toString();
		String email = etEmail.getText().toString();
		
		SQLiteDatabase db =  dbHelper.getWritableDatabase();
		
		switch (v.getId()) {
		case R.id.btnAdd:
		Log.d(LOG_TAG, "---Insert value in DB---");
		
		cv.put(TBL_COL_NAME, name);
		cv.put(TBL_COL_EMAIL, email);
		
		long rowID = db.insert(TBL_NAME_CELLBOOK, null, cv);
		Log.d(LOG_TAG, "Row inserted ID = " + rowID);
		break;
		case R.id.btnRead:
			Log.d(LOG_TAG, "---Rows in Cellbook---");
			Cursor c = db.query(TBL_NAME_CELLBOOK, null, null, null, null, null, null);
			
			if(c.moveToFirst()){
				
				int idColInd = c.getColumnIndex("id");
				int nameColInd = c.getColumnIndex(TBL_COL_NAME);
				int emailColIbd = c.getColumnIndex(TBL_COL_EMAIL);
				
				do {
					Log.d(LOG_TAG, "id = " +  c.getInt(idColInd) +
							", name = " + c.getString(nameColInd) +
							", email = " + c.getString(emailColIbd));
				} while (c.moveToNext());
			} else{
				Log.d(LOG_TAG, "0 rows");
			}
			c.close();
			break;
		case R.id.btnClear:
			Log.d(LOG_TAG, "---Clear cellbook---");
			int clrCnt = db.delete(TBL_NAME_CELLBOOK, null, null);
			Log.d(LOG_TAG, "deleted rows count = " + clrCnt);
			break;
		}
		dbHelper.close();
	}
	
	
	class DBHelper extends SQLiteOpenHelper {

		
		public DBHelper(Context context) {
			super(context, "appDB", null, 1);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
	
			Log.d(LOG_TAG, "---onCreate database---");
			
			String sql = "create table cellbook ("
			          + "id integer primary key autoincrement," 
			          + "name text,"
			          + "email text" 
			          + ");";
			
			db.execSQL(sql);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
		
	}


}
