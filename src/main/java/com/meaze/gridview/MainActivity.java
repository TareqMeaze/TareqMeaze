package com.meaze.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    HashMap<String,String> hashMap;
    ArrayList< HashMap<String,String >> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creatTable();
        gridView = findViewById(R.id.gridView);
        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);



    }

    public class MyAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.layout,viewGroup,false);

            hashMap =arrayList.get(i);

            TextView tvTitle = myView.findViewById(R.id.tvTitle);
            ImageView tvImage = myView.findViewById(R.id.tvImage);
            LinearLayout layItem = myView.findViewById(R.id.layItem);

            String sName = hashMap.get("name");
            String sImage = hashMap.get("image_url");



            tvTitle.setText(sName);
            Picasso.get().load(sImage)
                    .placeholder(R.drawable.beef)
                    .into(tvImage);

            layItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (sName.contains("BMI")){
                        startActivity(new Intent(MainActivity.this,BMICalculator.class));
                    }else if (sName.contains("Result")){
                        startActivity(new Intent(MainActivity.this,Test.class));
                    }else if (sName.contains("Politics")){
                        startActivity(new Intent(MainActivity.this,SportsDetails.class));
                    }else if (sName.contains("Election")){
                        startActivity(new Intent(MainActivity.this,Loop.class));
                    }else if (sName.contains("AUDIO")){
                        startActivity(new Intent(MainActivity.this,Audio.class));
                    }

                    //startActivity(new Intent(MainActivity.this,Test.class));


                }
            });






            return myView;
        }
    }

    private void creatTable(){

       hashMap = new HashMap<>();
       hashMap.put("name","BMI");
       hashMap.put("image_url","https://i.pinimg.com/736x/4b/e2/1d/4be21da301a4126539b4938f9bacd003.jpg");
       arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Result");
        hashMap.put("image_url","https://cdn.news24bd.tv/public/news_images/2022/06/08/1654703639-Hasina.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Politics");
        hashMap.put("image_url","https://cdn.news24bd.tv/public/news_images/2022/06/08/1654693008-Bahrain.JPG");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Election");
        hashMap.put("image_url","https://cdn.news24bd.tv/public/news_images/2022/06/07/1654611481-00002.jpg");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","AUDIO");
        hashMap.put("image_url","https://cdn.news24bd.tv/public/news_images/2022/06/06/1654521894-messi.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","PDF");
        hashMap.put("image_url","https://cdn.news24bd.tv/public/news_images/2022/06/16/1655390808-0144.jpg");
        arrayList.add(hashMap);


    }


}