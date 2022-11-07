package com.example.bobing;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MoreActivity2 extends AppCompatActivity {
    Button bt_sure;
    EditText et_name;
    String name[];
    int person, i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more2);
        person = getIntent().getIntExtra("person", -1);
        try {
            name = new String[person];
        } catch (Exception e) {
            e.printStackTrace();
        }
        bt_sure = this.findViewById(R.id.button_sure2);
        et_name = this.findViewById(R.id.et_name);
        i = 0;
        bt_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et_name.getText().toString().equals("")) {
                    name[i] = et_name.getText().toString();
                } else {
                    name[i] = "玩家" + (i + 1);
                }
                if (i == person - 1) {
                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("person", person);
                    intent.setClass(MoreActivity2.this, MoreActivity3.class);
                    startActivity(intent);
                }
                if (i < person - 1) {
                    et_name.setText("");
                    et_name.setHint("请输入玩家" + (i + 2) + "的名字");
                    i++;
                }
            }
        });
    }
}