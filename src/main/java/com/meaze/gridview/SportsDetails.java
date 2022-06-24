package com.meaze.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SportsDetails extends AppCompatActivity {

    EditText edUnits;
    Button tvButton;
    TextView tvUnits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_details);


        edUnits = findViewById(R.id.edUnits);
        tvButton = findViewById(R.id.tvButton);
        tvUnits = findViewById(R.id.tvUnits);

        tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sUnit = edUnits.getText().toString();
                if (sUnit.length()>0){
                    float unit = Float.parseFloat(sUnit);
                    float bill =0;


                    if (unit<=50) {
                        bill = (float) (unit*0.50);
                    }else if (unit<=150){
                        bill = (float) (25+(unit-50)*0.75);
                    }else if (unit<=250){
                        bill= (float) (25+75+(unit-150)*1.20);
                    }else {
                        bill= (float) (25+75+120+(unit-250)*1.50);
                    }

                    bill= (float) (bill+bill*0.20);

                    tvUnits.setText("Your Current bill is: "+bill+"Taka");


                }else {
                    edUnits.setError("please input a bill unit");
                }




            }
        });






    }
}