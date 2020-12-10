package coursera.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";


	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";

	// Lifecycle counters

	// TODO:
	// Create variables named
	// mCreate, mRestart, mStart and mResume
	// to count calls to onCreate(), onRestart(), onStart() and
	// onResume(). These variables should not be defined as static.

	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called.
	TextView  mTvCreate;
	TextView 	mTvStart;
	TextView 	mTvResume;
	TextView  mTvRestart;
	// TODO: Create variables for each of the TextViews
	// named mTvCreate, mTvRestart, mTvStart, mTvResume.
	// for displaying the current count of each counter variable
	public int mCreate = 0;
	public int mStart = 0;
	public int mResume = 0;
	public int mRestart = 0;



	private void startIntent(){
		Intent intent = new Intent(this,ActivityTwo.class);
		startActivity(intent);

	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);




		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		  mTvCreate = (TextView)findViewById(R.id.create);
		  mTvRestart = (TextView)findViewById(R.id.restart);
		  mTvResume= (TextView)findViewById(R.id.resume);
		  mTvStart =(TextView)findViewById(R.id.start);
		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO:
				// Launch Activity Two
				// Hint: use Context's startActivity() method
			//	textView1.setText(onCreateCounter);
				// Create an intent stating which Activity you would like to
				// start
				startIntent();

				// Launch the Activity using the intent

			}
		});

		// Has previous state been saved?
		if (savedInstanceState != null) {
			mCreate = savedInstanceState.getInt("onCreate");
			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable

		}

		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");
		mCreate = mCreate +1;
		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		displayCounts();
	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");
		mStart= mStart+1;

		displayCounts();

		// TODO:
		// Update the appropriate count variable
		// Update the user interface

	}

	@Override
	public void onResume() {
		super.onResume();
		mResume+=1;
		// Emit LogCat message
		Log.i(TAG, "Entered the onResume() method");
		displayCounts();
		// TODO:
		// Update the appropriate count variable
		// Update the user interface

	}

	@Override
	public void onPause() {
		super.onPause();

		// Emit LogCat message
		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();
		mRestart=+1;
		// Emit LogCat message
		Log.i(TAG, "Entered the onRestart() method");
		displayCounts();
		// TODO:
		// Update the appropriate count variable
		// Update the user interface

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Emit LogCat message
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// TODO:
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		savedInstanceState.putInt("onCreate", mCreate);

	}

	// Updates the displayed counters
	// This method expects that the counters and TextView variables use the
	// names
	// specified above
	public void displayCounts() {
		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);

		// TODO - uncomment these lines
	/*
		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	*/
	}
}
