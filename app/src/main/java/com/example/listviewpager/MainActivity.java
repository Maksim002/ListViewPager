package com.example.listviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.listviewpager.NewaDRISA.Brochore;
import com.example.listviewpager.NewaDRISA.Stec;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Listener {

    private ViewPager viewPager;
    private Adaptor adaptor;
    private Integer[] colors = null;
    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add(new Model(R.drawable.ic_launcher_background,"Brochore"," pdf file downloaded by my app is created successfully and I am able to open it successfully from any File Manager (ES File Explorer now) but not from my app"));
        list.add(new Model(R.drawable.ic_launcher_background,"Stec"," pdf file downloaded by my app is created successfully and I am able to open it successfully from any File Manager (ES File Explorer now) but not from my app"));
        list.add(new Model(R.drawable.ic_launcher_background,"Broch"," pdf file downloaded by my app is created successfully and I am able to open it successfully from any File Manager (ES File Explorer now) but not from my app"));
        list.add(new Model(R.drawable.ic_launcher_background,"hmara"," pdf file downloaded by my app is created successfully and I am able to open it successfully from any File Manager (ES File Explorer now) but not from my app"));
        list.add(new Model(R.drawable.ic_launcher_background,"clara"," pdf file downloaded by my app is created successfully and I am able to open it successfully from any File Manager (ES File Explorer now) but not from my app"));

        adaptor = new Adaptor(list,this,this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adaptor);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adaptor.getCount() - 1) && position < (colors.length - 1)){
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position],colors[position + 1]));
                }else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onItemSelectodClicc(Model model) {
        Intent intent = new Intent(MainActivity.this, Stec.class);
        intent.putExtra("STRING_I", model.getImage());
        startActivity(intent);
    }
}
