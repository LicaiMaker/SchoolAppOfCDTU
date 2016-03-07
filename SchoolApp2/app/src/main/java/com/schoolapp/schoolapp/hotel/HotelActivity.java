package com.schoolapp.schoolapp.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.schoolapp.schoolapp.PlaceSelectActivity;
import com.schoolapp.schoolapp.R;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView LV_hotelsList;
    private LinearLayout ll_placeSelectinHotel;
    private List<HotelBean> hotelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        ll_placeSelectinHotel= (LinearLayout) findViewById(R.id.ll_placeSelectinHotel);
        ll_placeSelectinHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotelActivity.this, PlaceSelectActivity.class);
                startActivity(intent);
            }
        });
        LV_hotelsList= (ListView) findViewById(R.id.LV_HotelsList);
        HotelAdapter adapter=new HotelAdapter(getHotelList(),this);
        LV_hotelsList.setAdapter(adapter);
        LV_hotelsList.setOnItemClickListener(this);
    }
    public List<HotelBean> getHotelList(){
        hotelList = new ArrayList<HotelBean>();
        HotelBean hotel = new HotelBean();
        hotel.setHotalName("成功大酒店");
        hotel.setHotalPrice("￥250-￥280");
        hotel.setHotalDistance("0.1km");
        hotel.setHotalImageId(R.drawable.hotal1);
        hotel.setHotalLocation("郫县中信大道1号");
        hotel.setHotalPhone("1113244");
        hotel.setHotalService("按摩，保健");
        hotel.setHotalServiceprice("我们的优惠价格:1 按摩300 块一个小时，2 大保健400块一个小时");

        HotelBean hotal2 = new HotelBean();
        hotal2.setHotalName("郫县大酒店");
        hotal2.setHotalPrice("20");
        hotal2.setHotalDistance("10km");
        hotal2.setHotalImageId(R.drawable.hotal2);
        hotal2.setHotalLocation("郫县红光");
        hotal2.setHotalPhone("123456789");
        hotal2.setHotalService("按摩，保健");
        hotal2.setHotalServiceprice("我们的优惠价格:1 按摩10块一个小时，2 大保健4块一个小时");
        HotelBean hotal3 = new HotelBean();
        hotal3.setHotalName("山石酒店");
        hotal3.setHotalPrice("108");
        hotal3.setHotalDistance("6km");
        hotal3.setHotalImageId(R.drawable.hotal3);
        hotal3.setHotalLocation("郫县中信大道1号");
        hotal3.setHotalPhone("1113244");
        hotal3.setHotalService("按摩，保健");
        hotal3.setHotalServiceprice("我们的优惠价格:1 按摩300 块一个小时，2 大保健400块一个小时");
        hotelList.add(hotel);
        hotelList.add(hotal2);
        hotelList.add(hotal3);
        HotelBean hotal4= new HotelBean();
        hotal4.setHotalName("山石酒店");
        hotal4.setHotalPrice("108");
        hotal4.setHotalDistance("6km");
        hotal4.setHotalImageId(R.drawable.hotal1);
        hotal4.setHotalLocation("郫县中信大道1号");
        hotal4.setHotalPhone("1113244");
        hotal4.setHotalService("按摩，保健");
        hotal4.setHotalServiceprice("我们的优惠价格:1 按摩300 块一个小时，2 大保健400块一个小时");
        HotelBean hotal5 = new HotelBean();
        hotal5.setHotalName("山石酒店");
        hotal5.setHotalPrice("108");
        hotal5.setHotalDistance("6km");
        hotal5.setHotalImageId(R.drawable.hotal2);
        hotal5.setHotalLocation("郫县中信大道1号");
        hotal5.setHotalPhone("1113244");
        hotal5.setHotalService("按摩，保健");
        hotal5.setHotalServiceprice("我们的优惠价格:1 按摩300 块一个小时，2 大保健400块一个小时");
        hotelList.add(hotal4);
        hotelList.add(hotal5);
        return hotelList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hotel, menu);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(HotelActivity.this,HotelDetailsActivity.class);
        Bundle bundle=new Bundle();
        intent.putExtra("hotalLocation", hotelList.get(position).getHotalLocation());
        intent.putExtra("hotalPhone", hotelList.get(position).getHotalPhone());
        intent.putExtra("hotalImageId", hotelList.get(position).getHotalImageId());
        intent.putExtra("hotalService", hotelList.get(position).getHotalService());
        intent.putExtra("hotalServiceprice", hotelList.get(position).getHotalServiceprice());
        startActivity(intent);
    }
}
