package com.schoolapp.schoolapp.shopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.schoolapp.schoolapp.R;

import java.util.ArrayList;

public class ShoppingSpinnerAdapter extends BaseAdapter {
  private ArrayList<String> StringList;
  private Context mContext;
 
	public ShoppingSpinnerAdapter(ArrayList<String> buttonList, Context mContext) {
	
	this.StringList = buttonList;
	this.mContext = mContext;
}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return StringList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return StringList.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		  if (convertView==null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.spinner_item,null);
			TextView textView = (TextView) convertView.findViewById(R.id.shoppingSpinnerText);
			textView.setText(StringList.get(position));
			
		}else {
			
		}
		return convertView;
	}

}
