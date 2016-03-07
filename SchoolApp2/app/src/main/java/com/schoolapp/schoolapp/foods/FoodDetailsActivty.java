package com.schoolapp.schoolapp.foods;

import android.content.Intent;
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

public class FoodDetailsActivty extends AppCompatActivity {

    private ImageView iv_fooddetails;
    private LinearLayout ll_phoneInFoodDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fooddetails);
        ll_phoneInFoodDetails= (LinearLayout) findViewById(R.id.ll_phoneInFoodDetails);
        ll_phoneInFoodDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "你点击了电话按钮！", Toast.LENGTH_SHORT).show();
                String number=((TextView) findViewById(R.id.TV_PhoneNumInFoodDetails)).getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });
        iv_fooddetails = (ImageView) findViewById(R.id.IV_foodDetails);
        Intent intent = getIntent();
        if (intent != null) {
            int pageNum = intent.getExtras().getInt("pageNum");
            if (pageNum == 0)
                iv_fooddetails.setImageResource(R.drawable.food1);
            else if (pageNum == 1)
                iv_fooddetails.setImageResource(R.drawable.food2);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food_details_activty, menu);
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
