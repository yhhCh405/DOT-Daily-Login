package com.yhh.dl;

import android.app.*;
import android.content.*;
import android.os.*;
import android.webkit.*;
import android.net.*;
import android.widget.*;
import android.view.*;
import android.graphics.*;
import android.text.*;

public class bt1 extends Activity 
{
	private WebView web;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
        setContentView(R.layout.wv);
    
		String DefaultLoading = "<html><title>No Network</title><body><center><b>Please make sure your device's internet is on.</b></center></body></html>";
		
	    web = (WebView) findViewById(R.id.wb);
		web.getSettings().setJavaScriptEnabled(true);
		web.getSettings().setJavaScriptEnabled(true);
		web.getSettings().setDisplayZoomControls(true);
		web.setWebViewClient(new loading()); //to load url inside app
		web.setWebChromeClient(new WebChromeClient(){
			public void onReceivedTitle(WebView view, String title){
				super.onReceivedTitle(view,title);
				Toast.makeText(bt1.this,title,Toast.LENGTH_SHORT).show();
			}
		});
		if (!isNetworkStatusAvaliable(getApplicationContext())){
		    web.loadData(DefaultLoading,"text/html","UTF-8");
		}
		else{
			web.loadUrl("http://secure2.playpark.com/DOTDailyLogin/getItemcode.aspx");
		}
    }

	//Refresh Menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inf = getMenuInflater();
		inf.inflate(R.menu.refresh,menu);
		// TODO: Implement this method
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId()){
			case R.id.refresh_button:
				web.reload();
		}
		// TODO: Implement this method
		return super.onOptionsItemSelected(item);
	}
	
	
	

	//Network status checking
	public static boolean isNetworkStatusAvaliable(Context Context){
		ConnectivityManager cm = (ConnectivityManager) Context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(cm != null){
			NetworkInfo nf = cm.getActiveNetworkInfo();
			if(nf != null)
				if(nf.isConnected())
					return true;
		}
		return false;
	}
	
	

	private class loading extends WebViewClient
	{
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon)
		{


			findViewById(R.id.wb).setVisibility(View.GONE);
			findViewById(R.id.pgb).setVisibility(View.VISIBLE);
			// TODO: Implement this method
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onPageFinished(WebView view, String url)
		{

			findViewById(R.id.wb).setVisibility(View.VISIBLE);
			findViewById(R.id.pgb).setVisibility(View.GONE);
			// TODO: Implement this method
			super.onPageFinished(view, url);
		}

	}
}
