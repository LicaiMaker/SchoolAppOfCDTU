package com.schoolapp.schoolapp.shopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.Spinner;

import com.schoolapp.schoolapp.R;

import java.util.ArrayList;

public class StoreActivity extends Activity {
	private ArrayList<String> mSpinnerText;
	private Spinner spinner;
	private ShoppingSpinnerAdapter adapter;
	private ListView mlistView;
	private StoreAdapter mAdapter;
	private ArrayList<Store> mStoreList;
 @Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.store);
	mlistView = (ListView) findViewById(R.id.storeList);
	mStoreList = new ArrayList<Store>();
	Store store = new Store(R.drawable.clothes, "二星级店铺", 2);
	Store store1 = new Store(R.drawable.clothes, "三星级店铺", 3);
	Store store2 = new Store(R.drawable.clothes, "四星级店铺", 4);
	Store store3 = new Store(R.drawable.clothes, "五星级店铺", 5);
	Store store4 = new Store(R.drawable.clothes, "五星级店铺", 5);
	mStoreList.add(store);
	mStoreList.add(store1);
	mStoreList.add(store2);
	mStoreList.add(store3);
	mStoreList.add(store4);
	mAdapter = new StoreAdapter(mStoreList, this);
	mlistView.setAdapter(mAdapter);
	mlistView.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Intent intent = new Intent(StoreActivity.this,StoreDetailActivity.class);
			startActivity(intent);
			
		}
	});
	spinner = (Spinner) findViewById(R.id.shopping_top_spinner);
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
				Intent intent = new Intent(StoreActivity.this,
						ShoppingIndexActivity.class);
				startActivity(intent);
			} else if (arg2 == 2) {
				Intent intent = new Intent(StoreActivity.this,
						StoreActivity.class);
				startActivity(intent);
			}

		}

		public void onNothingSelected(AdapterView<?> arg0) {

		}
	});

	
}
}
