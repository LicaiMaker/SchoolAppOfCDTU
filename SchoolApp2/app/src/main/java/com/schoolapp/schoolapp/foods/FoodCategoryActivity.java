package com.schoolapp.schoolapp.foods;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.schoolapp.schoolapp.PlaceSelectActivity;
import com.schoolapp.schoolapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FoodCategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private final static String TAG="test";
    private LinearLayout ll_placeSelectOInFood;
    private ListView foodsListView;//listview
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodcategory);
        ll_placeSelectOInFood= (LinearLayout) findViewById(R.id.ll_placeSelectOInFood);
        ll_placeSelectOInFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodCategoryActivity.this, PlaceSelectActivity.class);
                startActivity(intent);
            }
        });
        foodsListView = (ListView) findViewById(R.id.FoodsList);
        SimpleAdapter adapter = new SimpleAdapter(this, getFoodsData(), R.layout.listviewrow,
                new String[]{"img", "address", "price", "distance"}, new int[]{R.id.IV_img, R.id.TV_address, R.id.TV_price, R.id.TV_distance});
        foodsListView.setAdapter(adapter);
        foodsListView.setOnItemClickListener(this);

    }

    private List<Map<String, Object>> getFoodsData() {
        Map<String, Object> map = new HashMap<String, Object>();//创建hashmap来存放每项的数据
        map.put("img", R.drawable.food1);
        map.put("address", "成都工业学院好友来");
        map.put("price", "人均消费：￥20");
        map.put("distance", "距离你3km");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.food2);
        map.put("address", "成都工业学院二食堂");
        map.put("price", "人均消费：￥33");
        map.put("distance", "距离你0.8km");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.food1);
        map.put("address", "成都工业学院好友来");
        map.put("price", "人均消费：￥20");
        map.put("distance", "距离你3km");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.food2);
        map.put("address", "成都工业学院二食堂");
        map.put("price", "人均消费：￥33");
        map.put("distance", "距离你0.8km");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.food1);
        map.put("address", "成都工业学院好友来");
        map.put("price", "人均消费：￥20");
        map.put("distance", "距离你3km");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.food2);
        map.put("address", "成都工业学院二食堂");
        map.put("price", "人均消费：￥33");
        map.put("distance", "距离你0.8km");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.food1);
        map.put("address", "成都工业学院好友来");
        map.put("price", "人均消费：￥20");
        map.put("distance", "距离你3km");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.food2);
        map.put("address", "成都工业学院二食堂");
        map.put("price", "人均消费：￥33");
        map.put("distance", "距离你0.8km");
        list.add(map);
        return list;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food_category, menu);
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
        int page=position%2;
        switch(page){
            case 0:
                Log.e(TAG, " food1");
                Intent intent=new Intent(FoodCategoryActivity.this,FoodDetailsActivty.class);
                intent.putExtra("pageNum",0);
                startActivity(intent);
//                ((ImageView)(view.findViewById(R.id.IV_foodDetails))).setImageResource(R.drawable.food1);
                break;
            case 1:
                Log.e(TAG, " food2");
                Intent intent2=new Intent(FoodCategoryActivity.this,FoodDetailsActivty.class);
                intent2.putExtra("pageNum", 1);
                startActivity(intent2);
//                ((ImageView)(view.findViewById(R.id.IV_foodDetails))).setImageResource(R.drawable.food2);
                break;
        }
    }
}
