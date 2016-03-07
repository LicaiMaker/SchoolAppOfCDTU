package com.schoolapp.schoolapp.scenery;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.schoolapp.schoolapp.R;
import com.schoolapp.schoolapp.foods.FoodDetailsActivty;

public class SceneryDetailsActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout ll_food1InSDetails;
    private LinearLayout ll_food2InSDetails;
    private LinearLayout ll_phoneInSdetails;
    private Button btn_comment;
    private ImageView IV_scenery;
    private Intent intent;
    private int pageNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scenery_details);
        Log.d("test", "onCreate");
        ll_food1InSDetails= (LinearLayout) findViewById(R.id.ll_food1InSDetails);
        ll_food1InSDetails.setOnClickListener(this);
        ll_food2InSDetails= (LinearLayout) findViewById(R.id.ll_food2InSDetails);
        ll_food2InSDetails.setOnClickListener(this);
        ll_phoneInSdetails = (LinearLayout) findViewById(R.id.ll_phoneInSdetails);
        ll_phoneInSdetails.setOnClickListener(this);
        IV_scenery = (ImageView) findViewById(R.id.IV_scenery);
        btn_comment = (Button) findViewById(R.id.btn_comment);
        btn_comment.setOnClickListener(this);
        intent = getIntent();
        if (intent != null) {
            pageNum = intent.getExtras().getInt("pageNum");
            if (pageNum == 0)
                IV_scenery.setImageResource(R.drawable.scenery1);
            else if (pageNum == 1)
                IV_scenery.setImageResource(R.drawable.scenery2);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scenery_details, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test", "onDestroy");
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    String comment = data.getStringExtra("comment");
                    if (comment!= null&&!("".equals(comment.trim())))
                        ((TextView) findViewById(R.id.TV_comment1)).setText("游客3：" + comment);
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_comment:
                Toast.makeText(getApplicationContext(), "你点击了评论按钮！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SceneryDetailsActivity.this, CommentActivity.class);
                intent.putExtra("imageNum", pageNum);
                startActivityForResult(intent, 0);
                break;

            case R.id.ll_phoneInSdetails:
                Toast.makeText(getApplicationContext(), "你点击了电话按钮！", Toast.LENGTH_SHORT).show();
                String number=((TextView) findViewById(R.id.TV_phoneNumInSceneryPage)).getText().toString();
                Intent intent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+number));
                startActivity(intent2);
                break;
            case R.id.ll_food1InSDetails:
                Intent intent3=new Intent(SceneryDetailsActivity.this,FoodDetailsActivty.class);
                intent3.putExtra("pageNum",0);
                startActivity(intent3);
                break;
            case R.id.ll_food2InSDetails:
                Intent intent4=new Intent(SceneryDetailsActivity.this,FoodDetailsActivty.class);
                intent4.putExtra("pageNum",1);
                startActivity(intent4);
                break;
        }
    }
}
