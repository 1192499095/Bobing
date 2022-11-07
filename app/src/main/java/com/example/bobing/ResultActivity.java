package com.example.bobing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    List<Person> pList;
    Button bt_return,bt_again;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        pList= (List<Person>) this.getIntent().getSerializableExtra("person");
        bt_return=this.findViewById(R.id.bt_r_return);
        bt_again=this.findViewById(R.id.bt_r_again);
        lv=this.findViewById(R.id.r_listview);
        Collections.sort(pList);
        MyAdapter adapter=new MyAdapter(this,R.layout.lv_item,pList);
        lv.setAdapter(adapter);
        bt_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(ResultActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        bt_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}