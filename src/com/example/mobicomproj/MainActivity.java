package com.example.mobicomproj;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.style.IconMarginSpan;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {
	MediaPlayer mp;
	MediaPlayer bgMusic;
	Boolean flag = true;
	BackgroundSound bg = new BackgroundSound();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
	//	mp = MediaPlayer.create(MainActivity.this, R.raw.bubbleclick);
		bgMusic = MediaPlayer.create(MainActivity.this, R.raw.bgmusic);	
		bgMusic.start();
	}
	
	public void playButton(View view){
		Intent intent;
		
//		Intent intent = new Intent(this,LevelSelect.class);
		if(flag){
		intent = new Intent(this,WinScreen.class);
		flag = false;
		}
		else{
			intent = new Intent(this,LoseScreen.class);
			flag = true;
		}
		bgMusic.pause();
//		mp.start();
		startActivity(intent);
	}

	public void settingsButton(View view){
		Intent intent = new Intent(this,Settings.class);
//		mp.start();
		startActivity(intent);
	}

	public void onResume(){
		super.onResume();
//		bgMusic.reset();
		bgMusic.start();
		
	}
	
	public void onDestroy(){
		super.onDestroy();
		bgMusic.release();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class BackgroundSound extends AsyncTask<Void, Void, Void>{
		@Override
		protected Void doInBackground(Void... params) {
			MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.bgmusic);
			player.setLooping(true); // Set looping 
	        player.setVolume(100,100); 
	        player.start(); 

			return null;
		}
	}

}

