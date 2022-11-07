package com.example.bobing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MoreActivity extends AppCompatActivity {
    Button bt_sure;
    EditText et_number;
    int person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        bt_sure = this.findViewById(R.id.button_sure);
        et_number = this.findViewById(R.id.et_input);
        bt_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et_number.getText().toString().equals("")) {
                    person = Integer.parseInt(et_number.getText().toString());
                    if (person >= 2 && person <= 10) {
                        Intent intent = new Intent();
                        intent.putExtra("person", person);
                        intent.setClass(MoreActivity.this, MoreActivity2.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MoreActivity.this, "请输入2-10的数字", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MoreActivity.this, "请输入2-10的数字", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}