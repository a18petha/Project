package com.example.project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;


public class Scoredetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        Intent intent = getIntent();

        TextView test = (TextView) findViewById(R.id.world);
        TextView test1 = (TextView) findViewById(R.id.world1);
        TextView test2 = (TextView) findViewById(R.id.world2);
        TextView test3 = (TextView) findViewById(R.id.world3);
        TextView test4 = (TextView) findViewById(R.id.world4);
        TextView test5 = (TextView) findViewById(R.id.world5);
        TextView test6 = (TextView) findViewById(R.id.world6);
        TextView test7 = (TextView) findViewById(R.id.world7);
        ImageView image1 = (ImageView) findViewById(R.id.imageView1);
        ImageView image2 = (ImageView) findViewById(R.id.imageView2);

        String id = intent.getStringExtra("id");
        String location = intent.getStringExtra("location");
        String league = intent.getStringExtra("league");
        String lagett = intent.getStringExtra("lagett");
        String lagtvå = intent.getStringExtra("lagtvå");
        String date = intent.getStringExtra("date");
        String imageone = intent.getStringExtra("imageone");
        String imagetwo = intent.getStringExtra("imagetwo");

        int lagettpoints = intent.getIntExtra("lagettpoints", 0);
        int lagtvåpoint = intent.getIntExtra("lagtvåpoint", 0);

        test.setText("Stadium: " +location);
        test1.setText(""+id);
        test2.setText("" + league);
        test3.setText("" +lagett);
        test4.setText(""+lagtvå);
        test5.setText("Datum: " + date);
        test6.setText("" +lagettpoints);
        test7.setText(""+lagtvåpoint);

        int imageresource = getResources().getIdentifier("drawable/"+imageone ,null, this.getPackageName());
        image1.setImageResource(imageresource);

        int imageresourcetwo = getResources().getIdentifier("drawable/"+imagetwo ,null, this.getPackageName());
        image2.setImageResource(imageresourcetwo);

    }
}
