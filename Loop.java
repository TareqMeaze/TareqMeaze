package com.meaze.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class Loop extends AppCompatActivity {

    GridView gridView;
    HashMap<String,String> hashMap;
    ArrayList<HashMap<String,String>> arrayList= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);

        myAlbum();
        gridView = findViewById(R.id.gridView);
        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);


    }

    private class MyAdapter extends BaseAdapter{

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

            LayoutInflater layoutInflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.layoutdash,viewGroup,false);

            hashMap= arrayList.get(i);

            ImageView tvImage = myView.findViewById(R.id.tvImage);
            TextView tvTitle = myView.findViewById(R.id.tvTitle);
            TextView tvDes = myView.findViewById(R.id.tvDes);
            LinearLayout layItem00= myView.findViewById(R.id.layItem00);

            String sImage= hashMap.get("imgUrl");
            String sTitle= hashMap.get("SongName");
            String sDes= hashMap.get("SongTitle");

            tvTitle.setText(sTitle);
            tvDes.setText(sDes);
            Picasso.get().load(sImage)
                    .placeholder(R.drawable.pp)
                    .into(tvImage);

            layItem00.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (sTitle.contains("Atif Aslam")){
                        
                        //startActivity(new Intent(Loop.this,Pdf.class));
                    }

                   
                }
            });


            return myView;
        }
    }


    private void myAlbum (){

        hashMap = new HashMap<>();
        hashMap.put("SongName","Atif Aslam");
        hashMap.put("SongTitle","Full Video Album Song ");
        hashMap.put("imgUrl","https://upload.wikimedia.org/wikipedia/commons/2/2d/Atif_Aslam_at_Badlapur_%28cropped%29.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("SongName","Kabir Sing");
        hashMap.put("SongTitle","Kabir Singh Full Album Song");
        hashMap.put("imgUrl","https://www.pinkvilla.com/files/styles/amp_metadata_content_image/public/shahid-kapoor-throwback-pic-from-kabir-singh.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("SongName","Shakira ");
        hashMap.put("SongTitle","Sakira Full Album Song");
        hashMap.put("imgUrl","https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTgwMTgyMTgzOTk3MDg4ODkw/gettyimages-483195065.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("SongName","Zunayed Evan");
        hashMap.put("SongTitle","Zunayed Evan Full Album Song");
        hashMap.put("imgUrl","https://live.staticflickr.com/1475/25174902495_524cf2ff2b_b.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("SongName","Tasrif Khan");
        hashMap.put("SongTitle","Tasrif khan Full Album Song");
        hashMap.put("imgUrl","https://networthidea.com/wp-content/uploads/2020/12/131270141_1782244341932853_4522504482826837233_o.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("SongName","Minar Rahman ");
        hashMap.put("SongTitle","Minar Rahman Full Album Song");
        hashMap.put("imgUrl","https://upload.wikimedia.org/wikipedia/commons/d/d1/Minar_Rahman_portrait_2017.jpg");
        arrayList.add(hashMap);


    }

}
