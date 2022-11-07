package com.example.bobing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt_rule,bt_one,bt_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_rule=this.findViewById(R.id.button_rule);
        bt_one=this.findViewById(R.id.button_one);
        bt_more=this.findViewById(R.id.button_more);
        bt_rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RuleActivity.class);
                startActivity(intent);
            }
        });
        bt_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,OneActivity.class);
                startActivity(intent);
            }
        });
        bt_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MoreActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (0 != (Intent.FLAG_ACTIVITY_CLEAR_TOP&intent.getFlags())) {
            finish();
        }

    }

}