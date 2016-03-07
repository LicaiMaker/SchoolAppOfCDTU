package com.schoolapp.schoolapp.shopping;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Spinner;

import com.schoolapp.schoolapp.R;

import java.util.ArrayList;

public class StoreDetailActivity extends Activity {
	private Spinner mSpinner;
	private ShoppingSpinnerAdapter mAdapter;
	private ArrayList<String> mlist;
 @Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.shopping_store_detal);
	mSpinner = (Spinner) findViewById(R.id.shopping_goodsdetail_spinner);
	mlist =  new ArrayList<String>();
	mlist.add("排序方式");
	mlist.add("价格");
	mlist.add("销量");
	mlist.add("信誉");
	
	mAdapter = new ShoppingSpinnerAdapter(mlist, this);
	mSpinner.setAdapter(mAdapter);
	
}
}
