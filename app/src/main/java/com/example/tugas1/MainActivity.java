package com.example.tugas1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayImage();
    }

    protected void displayImage(){
        LinearLayout container = findViewById(R.id.container);
        String[] listImgName = {"kucing1", "kucing2","kucing3", "kucing4"};
        for (String imgName: listImgName) {
            addImageView(imgName, container);
            addTextView(imgName, container);
        }
    }

    protected void addImageView(String key, LinearLayout layout){
        int id = getResources().getIdentifier(key,"drawable",getPackageName());
        ImageView imgView = new ImageView(this);
        imgView.setImageResource(id);
        layout.addView(imgView);
        imgView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, key + ": Nyan Nyan Nyan", Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    protected void addTextView(String key, LinearLayout layout){
        int id = getResources().getIdentifier(key,"drawable",getPackageName());
        TextView textView = new TextView(this);
        textView.setText(key);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setTextSize(20);
        textView.setPadding(0,0,0,100);
        layout.addView(textView);
    }
}