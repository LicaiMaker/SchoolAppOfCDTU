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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.schoolapp.schoolapp.R;

public class CommentActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView TV_phoneNumInCommentPage;
    private LinearLayout ll_phoneInSComment;
    private EditText ET_comment;
    private ImageView IV_sceneryInCommentPage;
    private Button btn_submit;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment);
//        TV_phoneNumInCommentPage= (TextView) findViewById(R.id.TV_phoneNumInCommentPage);
        ll_phoneInSComment= (LinearLayout) findViewById(R.id.ll_phoneInSComment);
        ll_phoneInSComment.setOnClickListener(this);
        ET_comment= (EditText) findViewById(R.id.ET_comment);
        btn_submit= (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);
        IV_sceneryInCommentPage= (ImageView) findViewById(R.id.IV_sceneryInCommentPage);
        //根据上衣界面传过来的图片编号，在本activity显示相应的图片
        intent=getIntent();
        if(intent!=null) {
            int imageNumber = intent.getExtras().getInt("imageNum");
            if (imageNumber == 0)
                IV_sceneryInCommentPage.setImageResource(R.drawable.scenery1);
            else if (imageNumber == 1)
                IV_sceneryInCommentPage.setImageResource(R.drawable.scenery2);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_comment, menu);
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
    public void onClick(View v) {

       switch(v.getId()){
            case R.id.btn_submit:
//                Toast.makeText(getApplicationContext(),"发表成功",Toast.LENGTH_SHORT);
                Log.d("test", "你点击里评论提交按钮");
                Intent intent=new Intent();
                intent.putExtra("comment", ET_comment.getText().toString());
                setResult(RESULT_OK,intent);
//                Intent intent2 =new Intent(CommentActivity.this,SceneryDetailsActivity.class);
//                startActivity(intent2);
                this.finish();
                break;
           case R.id.ll_phoneInSComment:
               Toast.makeText(getApplicationContext(), "你点击了电话按钮！", Toast.LENGTH_SHORT).show();
               String number=((TextView) findViewById(R.id.TV_phoneNumInCommentPage)).getText().toString();
               Intent intent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
               startActivity(intent2);
        }
    }
}
