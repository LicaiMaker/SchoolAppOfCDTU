package com.schoolapp.schoolapp.shopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.schoolapp.schoolapp.R;

import java.util.ArrayList;

public class ShoppingIndexActivity extends Activity {
	private ArrayList<String> mSpinnerText;
	private Spinner spinner;
	private ShoppingSpinnerAdapter adapter;
    private  ImageButton imageButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.shoppingindex);
		spinner = (Spinner) findViewById(R.id.shopping_top_spinner);
		imageButton = (ImageButton) findViewById(R.id.imageButton);
		imageButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShoppingIndexActivity.this,GoodsDetailActivity.class);
				startActivity(intent);
			}
		});
		mSpinnerText = new ArrayList<String>();
		mSpinnerText.add("请选择");
		mSpinnerText.add("单品");
		mSpinnerText.add("店铺");
		adapter = new ShoppingSpinnerAdapter(mSpinnerText, this);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (arg2 == 1) {
					Intent intent = new Intent(ShoppingIndexActivity.this,
							ShoppingIndexActivity.class);
					startActivity(intent);
				} else if (arg2 == 2) {
					Intent intent = new Intent(ShoppingIndexActivity.this,
							StoreActivity.class);
					startActivity(intent);
				}

			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		

	}
}
