package com.meaze.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculator extends AppCompatActivity {

    EditText edName,edName1,edName2;
    Button button,button1,button2;
    TextView tvDisplay,tvDisplay1,tvDisplay2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        edName = findViewById(R.id.edName);
        button = findViewById(R.id.button);
        tvDisplay = findViewById(R.id.tvDisplay);
        edName1 = findViewById(R.id.edName1);
        button1 = findViewById(R.id.button1);
        tvDisplay1 = findViewById(R.id.tvDisplay1);
        edName2 = findViewById(R.id.edName2);
        button2 = findViewById(R.id.button2);
        tvDisplay2 = findViewById(R.id.tvDisplay2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int sNumber = Integer.parseInt(edName.getText().toString());

                if (sNumber%5==0 & sNumber%11==0){
                    tvDisplay.setText("Number is divisible by 5 & 11");
                }else {
                    tvDisplay.setText("Number is not divisible by 5 & 11");
                }


            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LeapYear();


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Week();
            }
        });



    }


    public void LeapYear (){
        int sLeapyear=Integer.parseInt(edName1.getText().toString());
        if (sLeapyear%400==0){
            tvDisplay1.setText(sLeapyear+" is a leapYear");
        }else if (sLeapyear%4==0&& sLeapyear%100!=0){
            tvDisplay1.setText(sLeapyear+" is a leapYear");
        }else {
            tvDisplay1.setText(sLeapyear+" is Not a leapYear");
        }
    }

    private  void Week(){

        int sWeek = Integer.parseInt(edName2.getText().toString());
        if (sWeek==1){
            tvDisplay2.setText("Today is Sunday");
        }else if (sWeek==2){
            tvDisplay2.setText("Today is Monday");
        }else if (sWeek==3){
            tvDisplay2.setText("Today is Tuesday");
        }else if (sWeek==4){
            tvDisplay2.setText("Today is Wednesday");
        }else if (sWeek==5){
            tvDisplay2.setText("Today is Thursday");
        }else if (sWeek==6){
            tvDisplay2.setText("Today is Friday");
        }else if (sWeek==7){
            tvDisplay2.setText("Today is Saturday");
        }else {
            tvDisplay2.setText("কাকা ১ সপ্তাহ = ৭ দিন ");
        }

    }

}