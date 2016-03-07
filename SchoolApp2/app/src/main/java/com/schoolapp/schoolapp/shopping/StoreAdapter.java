package com.schoolapp.schoolapp.shopping;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.schoolapp.schoolapp.R;

import java.util.ArrayList;

public class StoreAdapter extends BaseAdapter {
	private ArrayList<Store> mList;
	private Context mContext;

	public StoreAdapter(ArrayList<Store> mList, Context mContext) {

		this.mList = mList;
		this.mContext = mContext;
	}

	@Override
	public int getCount() {

		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.store_item, null);
			holder = new Holder();
			holder.imageView = (ImageView) convertView.findViewById(R.id.storeImage);
			holder.ratingBar  = (RatingBar) convertView.findViewById(R.id.storeRatingBar);
			holder.storeReputation = (TextView) convertView.findViewById(R.id.storeReputation);
		holder.storeText = (TextView) convertView.findViewById(R.id.storeNumber);
			Bitmap bm = BitmapFactory.decodeResource(mContext.getResources(),
					mList.get(position).getImageId());
			holder.imageView.setImageBitmap(bm);
			holder.storeText.setText("店铺" + (position + 1));
			holder.storeReputation.setText(mList.get(position)
					.getStoreReputaion());
			holder.ratingBar.setRating(mList.get(position).getRatingNumber());
			convertView.setTag(holder);

		} else {
			holder = (Holder) convertView.getTag();
		}
		return convertView;
	}

	private class Holder {
		private TextView storeText;
		private ImageView imageView;
		private TextView storeReputation;
		private RatingBar ratingBar;
	}

}
