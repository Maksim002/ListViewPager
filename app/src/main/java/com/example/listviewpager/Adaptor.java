package com.example.listviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adaptor extends PagerAdapter {

    private List<Model> list;
    private LayoutInflater layoutInflater;
    private Context context;
    private Listener listener;

    public Adaptor(List<Model> list, Context context, Listener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container,false);

        final ImageView imageView;
        TextView title, dsc;

        imageView = view.findViewById(R.id.imageView);
        title = view.findViewById(R.id.title);
        dsc = view.findViewById(R.id.desc);

        imageView.setImageResource(list.get(position).getImage());
        title.setText(list.get(position).getTitle());
        dsc.setText(list.get(position).getDesc());


        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemSelectodClicc(list.get(position));
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);

    }
}
