package com.yhh.dl;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	Button b1;
	Button b2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
        b1 = (Button) findViewById(R.id.se2);
		b2 = (Button) findViewById(R.id.se3);
		
	
		
		//change class
		b1.setOnClickListener(new OnClickListener(){
			public void onClick(View p1){
				Intent i = new Intent(MainActivity.this, bt1.class);
				startActivity(i);
			}
		});
	
		b2.setOnClickListener(new OnClickListener(){
			public void onClick(View p){
				Intent j = new Intent(MainActivity.this,bt2.class);
				startActivity(j);
			}
		});
		
	}
	//Menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inf = getMenuInflater();
		inf.inflate(R.menu.menu,menu);
		// TODO: Implement this method
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId()){
			case R.id.fdb:
				Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","yehtethein59@gmail.com",null));
				i.putExtra(Intent.EXTRA_SUBJECT, "DOT Daily Login App Report");
				i.putExtra(Intent.EXTRA_TEXT, "(Please write your Feedback below. Thanks for your action. ;))");
				startActivity(Intent.createChooser(i, "Send Email"));

		}
		// TODO: Implement this method
		return super.onOptionsItemSelected(item);
	}
    
}
