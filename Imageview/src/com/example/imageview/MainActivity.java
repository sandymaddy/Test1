package com.example.imageview;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	//imageview 1
	ImageView 	img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		img		=	(ImageView) findViewById(R.id.imageView1);
		new Image_Async().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class Image_Async extends AsyncTask<Bitmap,Bitmap,Bitmap>
	{

		@Override
		protected Bitmap doInBackground(Bitmap... arg0) {
			// TODO Auto-generated method stub
			Bitmap	bmp=	null;
			try {
				URL	url	=	new URL("http://cdn.adnxs.com/p/01/9a/ca/e9/019acae9b3c248679eed489ac153c4d5.jpg");
				try {

					bmp	=	BitmapFactory.decodeStream(url.openConnection().getInputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bmp;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			img.setImageBitmap(result);
			super.onPostExecute(result);
		}
		
	}
	
}
