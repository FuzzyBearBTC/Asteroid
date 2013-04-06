package com.alban42.asteroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.alban42.asteroid.R;
import com.alban42.asteroid.R.id;
import com.alban42.asteroid.R.layout;
import com.alban42.asteroid.R.menu;
import com.alban42.asteroid.R.string;
import com.alban42.dialog.CustomDialog;

public class MainActivity extends Activity {

	private Button play;
	private Button settings;
	private Button about;
	private Button exit;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.play = (Button) findViewById(R.id.ButtonStart);
		this.play.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				displayGameActivity();
			}
		});

		this.settings = (Button) findViewById(R.id.ButtonSettings);
		this.settings.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				displaySettingsActivity();
			}
		});

		this.about = (Button) findViewById(R.id.ButtonAbout);
		this.about.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				displayAboutActivity();
			}
		});

		this.exit = (Button) findViewById(R.id.ButtonExit);
		this.exit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				finish();
			}
		});
	}

	/**
	 * 
	 */
	protected void displayGameActivity() {
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_about:
			displayAboutActivity();
			break;
		case R.id.menu_settings:
			displaySettingsActivity();
			break;
		}
		return true;
	}

	/**
	 * Display the about dialog.
	 */
	protected void displayAboutActivity() {
		CustomDialog dialog = new CustomDialog(this,
				CustomDialog.INFORMATION_DIALOG);
		dialog.setOkButton();
		dialog.setTitle(R.string.about);
		dialog.setMessage(R.string.about_text);
		dialog.show();

	}

	/**
	 * Display the Settings Activity.
	 */
	protected void displaySettingsActivity() {
		Intent intent = new Intent(this, SettingsActivity.class);
		startActivity(intent);
	}

}
