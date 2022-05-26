package com.example.slidertimerapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.elyeproj.loaderviewlibrary.LoaderImageView;


public class SliderFragment extends Fragment implements View.OnClickListener {


    TextView txt_title;
    LoaderImageView img_slider;
    int position;
    RelativeLayout root;
    SliderDetailModel sliderDetailNew;

    Context context;

    public SliderFragment() {
        // Required empty public constructor
    }


    public static SliderFragment newInstance(int position, SliderDetailModel sliderDetailNew) {
        SliderFragment fragment = new SliderFragment();

        fragment.position = position;
        fragment.sliderDetailNew = sliderDetailNew;

        return fragment;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_slider, container, false);


        initView(view);
        onClickListener();

//        Glide.with(getContext())
//                .load(sliderDetailNew.imgUrl)
//                .placeholder(R.color.blue)
//                .transition(DrawableTransitionOptions.withCrossFade())
//                .into(img_slider);


//            Glide.with(context).load(sliderDetailNew.imgUrl).transition(DrawableTransitionOptions.withCrossFade()).into(img_slider);



            if(position==0){
                img_slider.setImageDrawable(getResources().getDrawable(R.drawable.image1));
            }else if(position==1){
                img_slider.setImageDrawable(getResources().getDrawable(R.drawable.image2));
            }else if(position==2){
                img_slider.setImageDrawable(getResources().getDrawable(R.drawable.image3));
            }





        return view;
    }

    private void onClickListener() {
        img_slider.setOnClickListener(this);

    }

    private void initView(View view) {

        txt_title = view.findViewById(R.id.txt_title);
        root = view.findViewById(R.id.root_slider);
        img_slider = view.findViewById(R.id.img_slider);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.img_slider) {
            Toast.makeText(context, "clicked " +position+1, Toast.LENGTH_SHORT).show();
        }
    }



}