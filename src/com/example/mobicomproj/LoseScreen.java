package com.example.mobicomproj;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class LoseScreen extends Activity {

	TextView lose_message;
	TextView score_textview;
	TextView user_score;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lose_screen);
		
		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/HoboStd.otf");
		lose_message= (TextView) findViewById(R.id.LoseMessageTextView);
		lose_message.setTypeface(tf);
		
		score_textview= (TextView) findViewById(R.id.scoreTextView);
		score_textview.setTypeface(tf);
		
		user_score = (TextView) findViewById(R.id.loseScoreTextView);
		user_score.setTypeface(tf);
	}

	public void gotoHome(View view){
	//	Intent intent = new Intent(this,MainActivity.class);
	//	startActivity(intent);	
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lose_screen, menu);
		return true;
	}

}
