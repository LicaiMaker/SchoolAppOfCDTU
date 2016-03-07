package com.schoolapp.schoolapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlaceSelectActivity extends AppCompatActivity {

    private Button btn_way;
    private EditText et_sourcePlace;
    private EditText et_destinationPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_select);
        et_sourcePlace= (EditText) findViewById(R.id.ET_SourcePlace);
        et_destinationPlace= (EditText) findViewById(R.id.ET_destinationPlace);
        btn_way= (Button) findViewById(R.id.btn_way);
        btn_way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(et_sourcePlace.getText().toString())||"".equals(et_destinationPlace.getText().toString()))
                    Toast.makeText(getApplicationContext(),"起始地址或目的地址不能为空！",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"已生成"+et_sourcePlace.getText().toString()+"到"+et_destinationPlace.getText().toString()+"的路线图",
                            Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_place_select, menu);
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
