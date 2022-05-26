package com.example.slidertimerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.slidertimerapplication.util.customviewpager.ViewPagerCustomDuration;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {


    CircleIndicator indicator;
    ViewPagerCustomDuration viewpager;
    List<SliderDetailModel> sliderList = new ArrayList<>();
    TextView txt_slider_title;
    int sliderListSize=0;
    int sliderCurrentPosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        setSlider();
    }

    private void initView() {

        viewpager = findViewById(R.id.viewpager);
        indicator = findViewById(R.id.indicator);
        txt_slider_title = findViewById(R.id.txt_slider_title);

    }


    private void setSlider() {

        sliderList = new ArrayList<>();
        sliderList.add(new SliderDetailModel("slider 1" , "https://pngimg.com/uploads/mario/mario_PNG125.png"));
        sliderList.add(new SliderDetailModel("slider 2" , "https://onlinejpgtools.com/images/examples-onlinejpgtools/sunflower.jpg"));
        sliderList.add(new SliderDetailModel("slider 3" , "https://upload.wikimedia.org/wikipedia/commons/c/c9/Moon.jpg"));


//        SliderViewpagerAdapter adapter = new SliderViewpagerAdapter(getChildFragmentManager(), sliderList);  // for using in fragment
        SliderViewpagerAdapter adapter = new SliderViewpagerAdapter(getSupportFragmentManager(), sliderList);  // for using in activity

        viewpager.setAdapter(adapter);
        indicator.setViewPager(viewpager);
        sliderListSize = sliderList.size();
        sliderCurrentPosition = 0;




        txt_slider_title.setText("slider 1");

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int positionScrolled, float positionOffset, int positionOffsetPixels) {
                sliderCurrentPosition = positionScrolled;
                startSliderTimer();
            }

            @Override
            public void onPageSelected(int position) {

                txt_slider_title.setText(sliderList.get(position).title);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("TAG", "onPageScrollStateChanged: ");
            }
        });

    }


    final Handler sliderHandler = new Handler(Looper.getMainLooper());
    private void startSliderTimer() {

            if(sliderHandler != null){
                // to stop counting
                sliderHandler.removeCallbacksAndMessages(null);
            }

            if(sliderCurrentPosition < sliderListSize-1){
                sliderCurrentPosition++;
            }else{
                sliderCurrentPosition = 0;
            }

            sliderHandler.postDelayed(() -> {
                // here you check the value of getActivity() and break up if needed
                if (this == null)
                    return;
                this.runOnUiThread(() -> {

                    if (sliderCurrentPosition == 0) {
                        Log.i("TAG", "run: ");
                        viewpager.setScrollDurationFactor(0.0);
                    } else {
                        viewpager.setScrollDurationFactor(3);
                    }

                    txt_slider_title.setText(sliderList.get(sliderCurrentPosition).title);
                    viewpager.setCurrentItem(sliderCurrentPosition);
                });

            }, 3000);

    }
}