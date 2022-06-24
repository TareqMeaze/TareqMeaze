package com.meaze.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class Pdf extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ListView listView;
    HashMap<String,String> hashMap;
    public static String albumName ="";
    public  static  ArrayList<HashMap<String,String>> mainArraylist = new ArrayList<>();

    public  static ArrayList<HashMap<String,String>> atifArraylist = new ArrayList<>();
    public  static ArrayList<HashMap<String,String>> kabirArraylist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        mainDash();
        atifAslam();
        listView = findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);


    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 4;
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
            View myView = layoutInflater.inflate(R.layout.album,viewGroup,false);

            ImageView imagePlay1 = myView.findViewById(R.id.imagePlay1);

//<<<<<<<<<=================================================
            imagePlay1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (imagePlay1.getTag()!=null && imagePlay1.getTag().toString().contains("NOT_PLAYING")){
                        if (mediaPlayer!=null) mediaPlayer.release();

                        mediaPlayer = MediaPlayer.create(Pdf.this,R.raw.music1);
                        mediaPlayer.start();

                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {

                                imagePlay1.setImageResource(R.drawable.play);
                                imagePlay1.setTag("NOT_PLAYING");

                            }
                        });
                        imagePlay1.setImageResource(R.drawable.pause);
                        imagePlay1.setTag("PLAYING");

                    }else {

                        if (mediaPlayer!=null) mediaPlayer.release();
                        imagePlay1.setImageResource(R.drawable.play);
                        imagePlay1.setTag("NOT_PLAYING");
                    }





                }
            });

//==================================>>>>>>>>>>


            return myView;
        }
    }
///<<<<<<<<===========================================
    public void mainDash(){

        hashMap = new HashMap<>();
        hashMap.put("SongName","Atif Aslam");
        hashMap.put("SongTitle","Full Video Album Song ");
        hashMap.put("imgUrl","https://upload.wikimedia.org/wikipedia/commons/2/2d/Atif_Aslam_at_Badlapur_%28cropped%29.jpg");
        mainArraylist.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("SongName","Kabir Sing");
        hashMap.put("SongTitle","Kabir Singh Full Album Song");
        hashMap.put("imgUrl","https://www.pinkvilla.com/files/styles/amp_metadata_content_image/public/shahid-kapoor-throwback-pic-from-kabir-singh.jpg");
        mainArraylist.add(hashMap);


    }
///=============================================>>>>>>>>>

    ///<<<<<<<<===========================================
    public void atifAslam(){

        hashMap = new HashMap<>();
        hashMap.put("SongName","Atif Aslam");
        hashMap.put("SongTitle","Full Video Album Song ");
        hashMap.put("imgUrl","https://upload.wikimedia.org/wikipedia/commons/2/2d/Atif_Aslam_at_Badlapur_%28cropped%29.jpg");
        atifArraylist.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("SongName","Kabir Sing");
        hashMap.put("SongTitle","Kabir Singh Full Album Song");
        hashMap.put("imgUrl","https://www.pinkvilla.com/files/styles/amp_metadata_content_image/public/shahid-kapoor-throwback-pic-from-kabir-singh.jpg");
        atifArraylist.add(hashMap);


    }
///=============================================>>>>>>>>>




}