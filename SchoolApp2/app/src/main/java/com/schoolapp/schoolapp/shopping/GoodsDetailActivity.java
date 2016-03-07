package com.schoolapp.schoolapp.shopping;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Spinner;

import com.schoolapp.schoolapp.R;

import java.util.ArrayList;

public class GoodsDetailActivity extends Activity {
	private ShoppingSpinnerAdapter madapter;
	private Spinner mSpinner;
	private ArrayList<String> mlist;
 @Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.shopping_goods_detail);
	mSpinner = (Spinner) findViewById(R.id.shopping_goodsdetail_spinner);
	mlist =  new ArrayList<String>();
	mlist.add("排序方式");
	mlist.add("价格");
	mlist.add("销量");
	mlist.add("信誉");
	madapter = new ShoppingSpinnerAdapter(mlist, this);
	mSpinner.setAdapter(madapter);
	
}
}
