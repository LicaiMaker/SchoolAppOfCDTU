package com.schoolapp.schoolapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.schoolapp.schoolapp.dao.HttpCallBackListener;
import com.schoolapp.schoolapp.foods.FoodCategoryActivity;
import com.schoolapp.schoolapp.forum.forumActivity;
import com.schoolapp.schoolapp.hotel.HotelActivity;
import com.schoolapp.schoolapp.scenery.SceneryIndexActivity;
import com.schoolapp.schoolapp.shopping.ShoppingIndexActivity;
import com.schoolapp.schoolapp.shopping.StoreActivity;
import com.schoolapp.schoolapp.utils.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "test";
    private LinearLayout ll_food;
    private LinearLayout ll_scenery;
    private LinearLayout ll_forum;
    private LinearLayout ll_placeSelect;
    private LinearLayout ll_hotel;
    private ListView LV_IndexListView;
    private LinearLayout ll_shopping;
    private LinearLayout ll_shoppingStore;
    private LinearLayout ll_travle;
    private LinearLayout ll_other;

    private final static String DOWNLOADURL="http://192.168.43.74:8080/lifeapp/hotel?method=list&from=app";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();

//        Log.d(TAG, "onCreate()");
    }

    /**
     * 初始化View
     */
    private void initViews(){
        LV_IndexListView = (ListView) findViewById(R.id.LV_IndexListView);//listview
        ll_travle= (LinearLayout) findViewById(R.id.ll_travle);//找到主界面的旅游功能区界面
        ll_other= (LinearLayout) findViewById(R.id.ll_other);//找到主界面的其它功能区界面
        ll_shopping= (LinearLayout) findViewById(R.id.ll_shopping);//找到主界面的购物功能区界面
        ll_shoppingStore= (LinearLayout) findViewById(R.id.ll_shoppingstore);//找到主界面的店铺功能区界面
        ll_placeSelect = (LinearLayout) findViewById(R.id.ll_placeSelect);//找到主界面的选择地点功能区界面
        ll_food = (LinearLayout) this.findViewById(R.id.ll_food);//找到主界面的美食功能区的布局界面
        ll_hotel = (LinearLayout) findViewById(R.id.ll_hotel);//找到主界面的酒店食功能区的布局界面
        ll_scenery = (LinearLayout) findViewById(R.id.ll_scenery);//找到主界面的景区功能区的布局界面
        ll_forum = (LinearLayout) findViewById(R.id.ll_forum);

    }

    /**
     * 初始化事件
     */
    private void initEvents(){
        ll_travle.setOnClickListener(this);
        ll_other.setOnClickListener(this);
        ll_shoppingStore.setOnClickListener(this);//为店铺功能区界面注册点击监听事件
        ll_shopping.setOnClickListener(this);//为购物功能区界面注册点击监听事件
        ll_placeSelect.setOnClickListener(this);//为选择地点功能区界面注册点击监听事件
        ll_forum.setOnClickListener(this);//为论坛布局界面注册点击监听事件
        ll_food.setOnClickListener(this);//为美食布局界面注册点击监听事件
        ll_hotel.setOnClickListener(this);//为酒店布局界面注册点击监听事件
        ll_scenery.setOnClickListener(this);//为风景布局界面注册点击监听事件

        LV_IndexListView.setAdapter(getAdapter(this,getData()));
    }
    public SimpleAdapter getAdapter(Context context ,List<Map<String,Object>> list){
        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.listviewrow,
                new String[]{"img", "address", "price", "distance"}, new int[]{R.id.IV_img, R.id.TV_address, R.id.TV_price, R.id.TV_distance});


        return adapter;
    }
    public List<Map<String,Object>> getData(){
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();//创建hashmap来存放每项的数据
        map.put("img", R.drawable.food1);
        map.put("address", "成都工业学院好友来");
        map.put("price", "人均消费：￥20");
        map.put("distance", "距离你3km");
        list.add(map);
        map= new HashMap<String, Object>();
        map.put("img", R.drawable.hotal1);
        map.put("address", "成功大酒店");
        map.put("price", "人均消费：￥250-￥280");
        map.put("distance", "距离你0.1km");
        list.add(map);
        map= new HashMap<String, Object>();
        map.put("img", R.drawable.scenery1);
        map.put("address", "成都工业学院体育馆");
        map.put("price", "订票价格：￥20");
        map.put("distance", "距离你0.5km");
        list.add(map);
        map= new HashMap<String, Object>();
        map.put("img", R.drawable.food1);
        map.put("address", "成都工业学院好友来");
        map.put("price", "人均消费：￥20");
        map.put("distance", "距离你3km");
        list.add(map);
        map= new HashMap<String, Object>();
        map.put("img", R.drawable.hotal1);
        map.put("address", "成功大酒店");
        map.put("price", "人均消费：￥250-￥280");
        map.put("distance", "距离你0.1km");
        list.add(map);
        map= new HashMap<String, Object>();
        map.put("img", R.drawable.scenery1);
        map.put("address", "成都工业学院体育馆");
        map.put("price", "订票价格：￥20");
        map.put("distance", "距离你0.5km");
        list.add(map);
        return list;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {

        super.onStart();
//        ll_food.setBackgroundColor(getResources().getColor(R.color.linen));
//        ll_food.setBackgroundResource(R.drawable.text_border);
//        ll_scenery.setBackgroundColor(getResources().getColor(R.color.linen));
//        ll_scenery.setBackgroundResource(R.drawable.text_border);
        Log.e(TAG, "onStart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onClick(View view) {

        Intent intent = null;
//        intent.setAction(Intent.ACTION_VIEW);
        switch (view.getId()) {
            case R.id.ll_food:
//                ll_food.setBackgroundColor(getResources().getColor(R.color.tan));
//                ll_food.setBackgroundResource(R.drawable.text_border);
//                intent.addCategory("com.school.schoolapp.foods.FoodCategoryActivity");
                intent = new Intent(MainActivity.this, FoodCategoryActivity.class);
                startActivity(intent);
                Log.d(TAG, "点击美食界面");
                break;
            case R.id.ll_scenery:
//                ll_scenery.setBackgroundColor(getResources().getColor(R.color.tan));
//                ll_scenery.setBackgroundResource(R.drawable.text_border);
                intent = new Intent(MainActivity.this, SceneryIndexActivity.class);
                startActivity(intent);
                Log.d(TAG, "点击风景界面");
                break;
            case R.id.ll_forum:
                intent = new Intent(MainActivity.this, forumActivity.class);
                startActivity(intent);
                Log.d(TAG, "点击论坛界面");
                break;
            case R.id.ll_hotel:
                intent = new Intent(MainActivity.this, HotelActivity.class);
                startActivity(intent);
                Log.d(TAG, "点击酒店界面");
                break;
            case R.id.ll_placeSelect:
                intent = new Intent(MainActivity.this, PlaceSelectActivity.class);
                startActivity(intent);
                Log.d(TAG, "点击选择地点界面");
                break;
            case R.id.ll_shopping:
                intent = new Intent(MainActivity.this, ShoppingIndexActivity.class);
                startActivity(intent);
                Log.d(TAG, "点击购物界面");
                break;
            case R.id.ll_shoppingstore:
                intent = new Intent(MainActivity.this, StoreActivity.class);
                startActivity(intent);
                Log.d(TAG, "点击选择店铺界面");
                break;
            case R.id.ll_travle:
                HttpUtils.getJsonStr(DOWNLOADURL, "POST", new HttpCallBackListener() {
                    @Override
                    public void OnFinish(String response) {
                        Log.d("TAG","获取到的字符串："+response);
                    }

                    @Override
                    public void OnError(Exception e) {
                        Log.d("TAG","获取失败："+e.getMessage());
                    }
                });
//                Toast.makeText(this,"还在努力开发中！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_other:
                Toast.makeText(this,"还在努力开发中！",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
