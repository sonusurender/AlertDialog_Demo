package com.android_alertdialog_demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Implementing click listeners on all buttons
		findViewById(R.id.show_dialog1).setOnClickListener(this);
		findViewById(R.id.show_dialog2).setOnClickListener(this);
		findViewById(R.id.show_dialog3).setOnClickListener(this);
		findViewById(R.id.show_dialog4).setOnClickListener(this);
		findViewById(R.id.show_dialog5).setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.show_dialog1:

			// Calling Neutral button dialog
			showNeutralButtonDialog();
			break;

		case R.id.show_dialog2:

			// Calling Positive button dialog
			showPositiveButtonDialog();
			break;

		case R.id.show_dialog3:

			// Calling Negative button dialog
			showNegativeButtonDialog();
			break;

		case R.id.show_dialog4:

			// Calling List Item dialog
			showListItemsDialog();
			break;

		case R.id.show_dialog5:

			// Calling Custom dialog
			showCustomDialog();
			break;
		case R.id.custom_button1:

			// Showing a toast on custom dialog button click
			Toast.makeText(MainActivity.this, "Custom Button 1 Presses",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.custom_button2:
			Toast.makeText(MainActivity.this, "Custom Button 2 Presses",
					Toast.LENGTH_SHORT).show();
			break;
		}

	}

	// Neutral button Dialog method
	void showNeutralButtonDialog() {

		// Making instance of alert dialog
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

		// Setting title for dialog
		builder.setTitle("Neutral Button Dialog");

		// Setting icon for dialog
		builder.setIcon(R.drawable.ic_warning_amber_36dp);

		// Setting true/false if we want to dismiss dialog on back pressing or
		// touching outside the dialog
		builder.setCancelable(true);

		// Setting message to be displayed inside dialog
		builder.setMessage("Press neutral button below.");

		// Implementing Neutral button and click listener over it
		builder.setNeutralButton("Neutral Button",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// Showing a toast on button click
						Toast.makeText(MainActivity.this,
								"Neutral Button Pressed.", Toast.LENGTH_SHORT)
								.show();
					}
				});

		// Creating alert dialog and showing it
		AlertDialog dialog = builder.create();
		dialog.show();

	}

	// Positive button Dialog method
	void showPositiveButtonDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("Two Button Dialog");
		builder.setIcon(R.drawable.ic_warning_amber_36dp);
		builder.setCancelable(true);
		builder.setMessage("This dialog contains 2 buttons.");

		// Implementing Neutral button and click listener over it
		builder.setNeutralButton("Neutral Button",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,
								"Neutral Button Pressed.", Toast.LENGTH_SHORT)
								.show();
					}
				});

		// Implementing Positive button and click listener over it
		builder.setPositiveButton("Positive Button",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,
								"Positive Button Pressed.", Toast.LENGTH_SHORT)
								.show();
					}
				});
		AlertDialog dialog = builder.create();
		dialog.show();

	}

	// Negative button Dialog method
	void showNegativeButtonDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("Three Button Dialog");
		builder.setIcon(R.drawable.ic_warning_amber_36dp);
		builder.setCancelable(true);
		builder.setMessage("This dialog contains 3 buttons.");

		// Implementing Neutral button and click listener over it
		builder.setNeutralButton("Neutral Button",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,
								"Neutral Button Pressed.", Toast.LENGTH_SHORT)
								.show();
					}
				});

		// Implementing Positive button and click listener over it
		builder.setPositiveButton("Positive Button",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,
								"Positive Button Pressed.", Toast.LENGTH_SHORT)
								.show();
					}
				});

		// Implementing Negative button and click listener over it
		builder.setNegativeButton("Negative Button",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,
								"Negative Button Pressed.", Toast.LENGTH_SHORT)
								.show();
					}
				});
		AlertDialog dialog = builder.create();
		dialog.show();

	}

	// List Item Dialog
	void showListItemsDialog() {

		// Items to be displayed in list
		String[] listItems = { "Items 1", "Items 2", "Items 3" };
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("List Items Dialog");
		builder.setIcon(R.drawable.ic_warning_amber_36dp);
		builder.setCancelable(true);

		// Setting list items over dialog and there should be no message
		builder.setItems(listItems, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int pos) {
				Toast.makeText(MainActivity.this, "Item positon : " + pos,
						Toast.LENGTH_SHORT).show();

			}
		});

		AlertDialog dialog = builder.create();
		dialog.show();

	}

	// Custom Dialog
	void showCustomDialog() {

		// Layout inflater for inflating layout
		LayoutInflater inflater = this.getLayoutInflater();

		// Inflating layout
		View dialogView = inflater.inflate(R.layout.custom_dialog, null);

		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

		// Setting custom view over dialog
		builder.setView(dialogView);

		// Implementing click listeners over custom buttons
		dialogView.findViewById(R.id.custom_button1).setOnClickListener(this);
		dialogView.findViewById(R.id.custom_button2).setOnClickListener(this);

		AlertDialog dialog = builder.create();
		dialog.show();

	}

}
