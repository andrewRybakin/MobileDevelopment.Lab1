package com.example.andrew.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
	private final Random random = new Random();

	private Button buttonFirst;
	private Button buttonSecond;
	private TextView pointsView;

	private int points;
	private int randomNumber1;
	private int randomNumber2;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_main);

		buttonFirst = (Button) findViewById(R.id.button_first);
		buttonSecond = (Button) findViewById(R.id.button_second);
		pointsView = (TextView) findViewById(R.id.points);
		generateRandomValues();

		buttonFirst.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (randomNumber1 > randomNumber2) {
					points++;
					Toast.makeText(MainActivity.this, "Yepeeee", Toast.LENGTH_SHORT).show();
				} else if (randomNumber1 != randomNumber2) {
					points--;
					Toast.makeText(MainActivity.this, "Booooo", Toast.LENGTH_SHORT).show();
				}
				generateRandomValues();
			}
		});

		buttonSecond.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (randomNumber1 < randomNumber2) {
					points++;
					Toast.makeText(MainActivity.this, "Yepeeee", Toast.LENGTH_SHORT).show();
				} else if (randomNumber1 != randomNumber2) {
					points--;
					Toast.makeText(MainActivity.this, "Booooo", Toast.LENGTH_SHORT).show();
				}
				generateRandomValues();
			}
		});
	}

	private void generateRandomValues() {
		randomNumber1 = random.nextInt(10);
		randomNumber2 = random.nextInt(10);

		buttonFirst.setText(String.valueOf(randomNumber1));
		buttonSecond.setText(String.valueOf(randomNumber2));
		pointsView.setText(String.valueOf(points));
	}
}
