package com.example.bobing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class OneActivity extends AppCompatActivity {
    GridView gv;
    Button bt_start,bt_back;
    int number[],imageID[];
    TextView price,price2;
    MyGridViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        gv = this.findViewById(R.id.gridView);
        bt_start= this.findViewById(R.id.button_start);
        bt_back = this.findViewById(R.id.button_back);
        number =new int [6];
        price = findViewById(R.id.price);
        price2 = findViewById(R.id.price2);
        imageID=new int[]{R.drawable.dice1,R.drawable.dice1,R.drawable.dice1,R.drawable.dice1,R.drawable.dice1,R.drawable.dice1};
        adapter = new MyGridViewAdapter(OneActivity.this,imageID);
        gv.setAdapter(adapter);
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
                String str =Check();
                price=OneActivity.this.findViewById(R.id.price);
                price2=OneActivity.this.findViewById(R.id.price2);
                price.setText(str);
                price2.setText("");
                if(!str.equals("????????????")&&!str.equals("??????")&&!str.equals("??????")&&!str.equals("??????")&&!str.equals("??????")&&!str.equals("??????")&&!str.equals("??????")){
                    price2.setText("??????");
                }
            }
        });
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
            return "???????????????";
        } else if (numOfFour == 6) {
            return "?????????";
        } else if (numOfOne == 6) {
            return "?????????";
        } else if (numOfTwo == 6) {
            return "?????????(2)";
        } else if (numOfThree == 6) {
            return "?????????(3)";
        } else if (numOfFive == 6) {
            return "?????????(5)";
        } else if (numOfSix == 6) {
            return "?????????(6)";
        } else if (numOfFour == 5) {
            if (numOfOne == 1) {
                return "??????(1)";
            } else if (numOfTwo == 1) {
                return "??????(2)";
            } else if (numOfThree == 1) {
                return "?????????3???";
            } else if (numOfFive == 1) {
                return "?????????5???";
            } else if (numOfSix == 1) {
                return "?????????6???";
            }else{
                return null;
            }
        } else if (numOfOne == 5) {
            return "????????????(1)";
        } else if (numOfTwo == 5) {
            return "???????????????2???";
        } else if (numOfThree == 5) {
            return "???????????????3???";
        } else if (numOfFive == 5) {
            return "???????????????5???";
        } else if (numOfSix == 5) {
            return "???????????????6???";
        } else if (numOfFour == 4) {
            return "??????";
        } else if (numOfOne == 1 && numOfTwo == 1 && numOfThree == 1 && numOfFour == 1 && numOfFive == 1 && numOfSix == 1) {
            return "??????";
        } else if (numOfFour == 3) {
            return "??????";
        } else if (numOfOne == 4 || numOfTwo == 4 || numOfThree == 4 || numOfFive == 4 || numOfSix == 4) {
            return "??????";
        } else if (numOfFour == 2) {
            return "??????";
        } else if (numOfFour == 1) {
            return "??????";
        } else {
            return "????????????";
        }
    }
}