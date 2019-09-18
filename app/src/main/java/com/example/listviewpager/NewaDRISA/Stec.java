package com.example.listviewpager.NewaDRISA;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listviewpager.R;

public class Stec extends AppCompatActivity {

    private String newString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stec);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("STRING_I");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I");
        }
    }
}
