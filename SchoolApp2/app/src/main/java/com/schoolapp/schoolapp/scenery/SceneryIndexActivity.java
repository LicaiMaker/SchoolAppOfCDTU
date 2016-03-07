package com.schoolapp.schoolapp.scenery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.schoolapp.schoolapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SceneryIndexActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private final static String TAG = "test";
    private ListView lv_scenery;
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scenery_index);
        lv_scenery = (ListView) findViewById(R.id.LV_scenery);
        SimpleAdapter adapter = new SimpleAdapter(this, getScneryData(), R.layout.listviewrow, new String[]{"img", "address", "price", "distance"},
                new int[]{R.id.IV_img, R.id.TV_address, R.id.TV_price, R.id.TV_distance});
        lv_scenery.setAdapter(adapter);
        lv_scenery.setOnItemClickListener(this);
    }


    public List<Map<String, Object>> getScneryData() {
        Map<String, Object> map = new HashMap<String, Object>();//创建hashmap来存放每项的数据
        map.put("img", R.drawable.scenery1);
        map.put("address", "成都工业学院图书馆");
        map.put("price", "订票价格：￥20");
        map.put("distance", "距离你3km");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.scenery2);
        map.put("address", "成都工业学院体育馆");
        map.put("price", "订票价格：￥33");
        map.put("distance", "距离你0.8km");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.scenery1);
        map.put("address", "成都工业学院图书馆");
        map.put("price", "订票价格：￥20");
        map.put("distance", "距离你3km");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.scenery2);
        map.put("distance", "距离你0.8km");
        map.put("address", "成都工业学院体育馆");
        map.put("price", "订票价格：￥33");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.scenery1);
        map.put("address", "成都工业学院图书馆");
        map.put("price", "订票价格：￥20");
        map.put("distance", "距离你3km");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.scenery2);
        map.put("distance", "距离你0.8km");
        map.put("address", "成都工业学院体育馆");
        map.put("price", "订票价格：￥33");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.scenery1);
        map.put("address", "成都工业学院图书馆");
        map.put("price", "订票价格：￥20");
        map.put("distance", "距离你3km");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.scenery2);
        map.put("distance", "距离你0.8km");
        map.put("address", "成都工业学院体育馆");
        map.put("price", "订票价格：￥33");
        list.add(map);
        return list;
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
        int page = position % 2;
        switch (page) {
            case 0:
                Log.e(TAG, " scenery1");
                Toast.makeText(getApplicationContext(), "Scenery1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SceneryIndexActivity.this, SceneryDetailsActivity.class);
                intent.putExtra("pageNum", 0);
                startActivity(intent);
                break;
            case 1:
                Log.e(TAG, " scenery2");
                Toast.makeText(getApplicationContext(), "Scenery2", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(SceneryIndexActivity.this, SceneryDetailsActivity.class);
                intent2.putExtra("pageNum", 1);
                startActivity(intent2);
                break;
        }
    }
}
