package com.meaze.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Test extends AppCompatActivity {

    EditText edName1,edName2,edName3,edName4,edName5,edName6;
    Button tvCalculate;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        edName1 = findViewById(R.id.edName1);
        edName2 = findViewById(R.id.edName2);
        edName3 = findViewById(R.id.edName3);
        edName4 = findViewById(R.id.edName4);
        edName5 = findViewById(R.id.edName5);
        edName6 = findViewById(R.id.edName6);
        tvCalculate = findViewById(R.id.tvCalculate);
        tvResult = findViewById(R.id.tvResult);

        tvCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edName1.getText().toString().length()>0 && edName2.getText().toString().length()>0 && edName3.getText().toString().length()>0 && edName4.getText().toString().length()>0&& edName5.getText().toString().length()>0 && edName6.getText().toString().length()>0){
                    float bangla = Float.parseFloat(edName1.getText().toString());
                    float english = Float.parseFloat(edName2.getText().toString());
                    float physics = Float.parseFloat(edName3.getText().toString());
                    float math = Float.parseFloat(edName4.getText().toString());
                    float chemistry = Float.parseFloat(edName5.getText().toString());
                    float biology = Float.parseFloat(edName6.getText().toString());



                    float percentage = (float) ((bangla+english+physics+math+chemistry+biology) / 6.00);

                    if (percentage>=80){
                        tvResult.setText(percentage+" \n Your reslt is A+");
                    }else if (percentage>=70){
                        tvResult.setText(percentage+" \n Your reslt is A");
                    }else if (percentage>=60){
                        tvResult.setText(percentage+" \n Your reslt is A-");
                    }else if (percentage>=50){
                        tvResult.setText(percentage+" \n Your reslt is B");
                    }else if (percentage>=40){
                        tvResult.setText(percentage+" \n Your reslt is D");
                    }else {
                        tvResult.setText(percentage+" \n Fail");
                    }
                }else {
                    tvResult.setText("please");
                }


                }


        });



    }




}