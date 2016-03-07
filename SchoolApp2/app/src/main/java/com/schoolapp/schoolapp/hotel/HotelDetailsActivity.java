package com.schoolapp.schoolapp.hotel;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.schoolapp.schoolapp.R;

public class HotelDetailsActivity extends AppCompatActivity {

    private ImageView hotalImge;
    private TextView  hotalLocation;
    private TextView hotalPhone;
    private TextView hotalService;
    private TextView hotalPrice;

    private LinearLayout ll_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
        Intent intent = getIntent();
        initViews();
        initData(intent);
    }
    public void initViews(){
        hotalImge = (ImageView) findViewById(R.id.hotal_detail_image);
        hotalLocation= (TextView) findViewById(R.id.hotal_detail_location);
        hotalPhone= (TextView) findViewById(R.id.hotal_detail_phone);
        hotalService= (TextView) findViewById(R.id.hotal_detal_service);
        hotalPrice= (TextView) findViewById(R.id.hotal_detal_price);
        ll_phone= (LinearLayout) findViewById(R.id.ll_phoneInhotelDetails);
    }

    public void initData(Intent intent){
        ll_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "你点击了电话按钮！", Toast.LENGTH_SHORT).show();
                String number=((TextView) findViewById(R.id.hotal_detail_phone)).getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });
        hotalImge.setImageBitmap(BitmapFactory.decodeResource(getResources(), intent.getIntExtra("hotalImageId", 0)));
        hotalLocation.setText(intent.getStringExtra("hotalLocation"));
        hotalPhone.setText(intent.getStringExtra("hotalPhone"));
        hotalService.setText(intent.getStringExtra("hotalService"));
        hotalPrice.setText(intent.getStringExtra("hotalServiceprice"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hotel_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
