package com.example.bobing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoreActivity3 extends AppCompatActivity {
    GridView gv;
    Button bt_start;
    int number[],imageID[];
    String[] name;
    int person, loop, rank;
    TextView tv_name, more_price, more_price2;
    List<Person> p;
    MyGridViewAdapter adapter;

    @Override
    protected void onResume () {
        super.onResume();
        gv = this.findViewById(R.id.more_gridView);
        bt_start= this.findViewById(R.id.button_moreStart);
        name = getIntent().getStringArrayExtra("name");
        person = getIntent().getIntExtra("person", -1);
        bt_start = findViewById(R.id.button_moreStart);
        tv_name = findViewById(R.id.tv_moreName);
        tv_name.setText(name[0] + "的回合");
        loop = 0;
        p = new ArrayList();
        for (int i = 0; i < person; i++) {
            p.add(new Person(name[i]));
        }
        more_price = MoreActivity3.this.findViewById(R.id.more_price);
        more_price2 = MoreActivity3.this.findViewById(R.id.more_price2);
        imageID=new int[]{R.drawable.dice1,R.drawable.dice1,R.drawable.dice1,R.drawable.dice1,R.drawable.dice1,R.drawable.dice1};
        adapter = new MyGridViewAdapter(MoreActivity3.this,imageID);
        gv.findViewById(R.id.more_gridView);
        gv.setAdapter(adapter);
        more_price.setText("");
        more_price2.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more3);
        number = new int[6];
        name = getIntent().getStringArrayExtra("name");
        person = getIntent().getIntExtra("person", -1);
        bt_start = findViewById(R.id.button_moreStart);
        tv_name = findViewById(R.id.tv_moreName);
        tv_name.setText(name[0] + "的回合");
        loop = 0;
        imageID=new int[]{R.drawable.dice1,R.drawable.dice1,R.drawable.dice1,R.drawable.dice1,R.drawable.dice1,R.drawable.dice1};
        gv = this.findViewById(R.id.more_gridView);
        adapter = new MyGridViewAdapter(MoreActivity3.this,imageID);
        gv.setAdapter(adapter);
        p = new ArrayList();
        for (int i = 0; i < person; i++) {
            p.add(new Person(name[i]));
        }
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                for (int i = 0; i < 6; i++) {
                    int randNumber = rand.nextInt(6) + 1;
                    number[i] = randNumber;
                    switch (randNumber) {
                        case 1:
                            imageID[i] = R.drawable.dice1;
                            break;
                        case 2:
                            imageID[i] = R.drawable.dice2;
                            break;
                        case 3:
                            imageID[i] = R.drawable.dice3;
                            break;
                        case 4:
                            imageID[i] = R.drawable.dice4;
                            break;
                        case 5:
                            imageID[i] = R.drawable.dice5;
                            break;
                        case 6:
                            imageID[i] = R.drawable.dice6;
                            break;
                    }
                }
                adapter.imageID=imageID;
                gv.setAdapter(adapter);
                String str = Check();
                more_price = MoreActivity3.this.findViewById(R.id.more_price);
                more_price2 = MoreActivity3.this.findViewById(R.id.more_price2);
                more_price.setText(str);
                more_price2.setText("");
                if (!str.equals("再接再厉") && !str.equals("秀才") && !str.equals("举人") && !str.equals("进士") && !str.equals("探花") && !str.equals("榜眼") && !str.equals("状元")) {
                    more_price2.setText("状元");
                }
                if (loop == person) {
                    Intent intent = new Intent(MoreActivity3.this, ResultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("person", (Serializable) p);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    p.get(loop).setScore(rank);
                    p.get(loop).setResult(str);
                    tv_name.setText(name[loop] + "的回合");
                    loop++;
                }
            }
        });
    }

    public String Check() {
        int numOfOne = 0;
        int numOfTwo = 0;
        int numOfThree = 0;
        int numOfFour = 0;
        int numOfFive = 0;
        int numOfSix = 0;
        for (int i = 0; i < 6; i++) {
            switch (number[i]) {
                case 1:
                    numOfOne++;
                    break;
                case 2:
                    numOfTwo++;
                    break;
                case 3:
                    numOfThree++;
                    break;
                case 4:
                    numOfFour++;
                    break;
                case 5:
                    numOfFive++;
                    break;
                case 6:
                    numOfSix++;
                    break;
            }
        }
        if (numOfFour == 4 && numOfOne == 2) {
            rank = 21;
            return "状元插金花";
        } else if (numOfFour == 6) {
            rank = 20;
            return "六杯红";
        } else if (numOfOne == 6) {
            rank = 19;
            return "遍地锦";
        } else if (numOfTwo == 6) {
            rank = 15;
            return "六杯黑(2)";
        } else if (numOfThree == 6) {
            rank = 16;
            return "六杯黑(3)";
        } else if (numOfFive == 6) {
            rank = 17;
            return "六杯黑(5)";
        } else if (numOfSix == 6) {
            rank = 18;
            return "六杯黑(6)";
        } else if (numOfFour == 5) {
            if (numOfOne == 1) {
                rank = 10;
                return "五王(1)";
            } else if (numOfTwo == 1) {
                rank = 11;
                return "五王(2)";
            } else if (numOfThree == 1) {
                rank = 12;
                return "五王（3）";
            } else if (numOfFive == 1) {
                rank = 13;
                return "五王（5）";
            } else if (numOfSix == 1) {
                rank = 14;
                return "五王（6）";
            } else {
                return null;
            }
        } else if (numOfOne == 5) {
            rank = 7;
            return "五子登科(1)";
        } else if (numOfTwo == 5) {
            rank = 6;
            return "五子登科（2）";
        } else if (numOfThree == 5) {
            rank = 7;
            return "五子登科（3）";
        } else if (numOfFive == 5) {
            rank = 8;
            return "五子登科（5）";
        } else if (numOfSix == 5) {
            rank = 9;
            return "五子登科（6）";
        } else if (numOfFour == 4) {
            rank = 6;
            return "状元";
        } else if (numOfOne == 1 && numOfTwo == 1 && numOfThree == 1 && numOfFour == 1 && numOfFive == 1 && numOfSix == 1) {
            rank = 5;
            return "榜眼";
        } else if (numOfFour == 3) {
            rank = 4;
            return "探花";
        } else if (numOfOne == 4 || numOfTwo == 4 || numOfThree == 4 || numOfFive == 4 || numOfSix == 4) {
            rank = 3;
            return "进士";
        } else if (numOfFour == 2) {
            rank = 2;
            return "举人";
        } else if (numOfFour == 1) {
            rank = 1;
            return "秀才";
        } else {
            rank = 0;
            return "再接再厉";
        }
    }
}
