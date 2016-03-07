package com.schoolapp.schoolapp.hotel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.schoolapp.schoolapp.R;

import java.util.List;

/**
 * Created by LiCai on 2015/12/7.
 */
public class HotelAdapter extends BaseAdapter {
    private List<HotelBean> hotalList;
    private Context context;
    private int mwidth;
    private int mScale = 10;

    public HotelAdapter(List<HotelBean> hotalList, Context context) {
        this.hotalList = hotalList;
        this.context = context;
        mwidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                120, context.getResources().getDisplayMetrics());
    }

    @Override
    public int getCount() {

        return hotalList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return hotalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
			/*LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			params.setMargins(0, 10, 0, 0);*/
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.row_of_hotel, null);

            holder = new Holder();
            holder.hotalImageView = (ImageView) convertView
                    .findViewById(R.id.IV_imgInhotelPage);
            holder.hotalName = (TextView) convertView
                    .findViewById(R.id.TV_NameInhotelPage);
            holder.hotalPrice = (TextView) convertView
                    .findViewById(R.id.TV_priceInhotelPage);
            holder.hotalDistance = (TextView) convertView
                    .findViewById(R.id.TV_distanceInhotelpage);
            BitmapFactory.Options options = new BitmapFactory.Options();
            BitmapFactory.decodeResource(context.getResources(),
                    hotalList.get(position).getHotalImageId(), options);
            options.inJustDecodeBounds = true;
            int height = options.outHeight;
            int width = options.outWidth;
            int scaleX = width / mwidth;
            int scaleY = height / mwidth;
            if ((scaleX > scaleY) && scaleY > 1) {
                mScale = scaleX;
            } else if ((scaleY > scaleX) && scaleX > 1) {
                mScale = scaleY;
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = mScale;
            Bitmap bitmap = BitmapFactory.decodeResource(
                    context.getResources(), hotalList.get(position)
                            .getHotalImageId(), options);

            holder.hotalImageView.setImageBitmap(bitmap);
            holder.hotalImageView.setImageResource( hotalList.get(position).getHotalImageId());
            holder.hotalName.setText(hotalList.get(position).getHotalName());
            holder.hotalPrice.setText(hotalList.get(position).getHotalPrice());
            holder.hotalDistance.setText(hotalList.get(position)
                    .getHotalDistance());
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        return convertView;
    }

    private class Holder {
        ImageView hotalImageView;
        TextView hotalName;
        TextView hotalPrice;
        TextView hotalDistance;

    }
}
