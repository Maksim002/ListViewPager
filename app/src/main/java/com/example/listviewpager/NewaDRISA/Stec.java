package com.example.listviewpager.NewaDRISA;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Property;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listviewpager.Model;
import com.example.listviewpager.R;

import java.util.ArrayList;

public class Stec extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stec);

        ImageView imageView = findViewById(R.id.icon);

        TextView textView = findViewById(R.id.text1);
        TextView textView1 = findViewById(R.id.spisoc);



        Intent intent = getIntent();
        Model property = intent.getParcelableExtra("Property");
        String streetName = property.getTitle();
        String streetNumber = property.getDesc();

        int image = property.getImage();
        Integer imageID = (Integer) this.getResources().getIdentifier(String.valueOf(image), "drawable", this.getPackageName());

        String address = streetName;
        String address1 = streetNumber;

        textView.setText(address);
        textView1.setText(address1);
        imageView.setImageResource(imageID);
    }
}
