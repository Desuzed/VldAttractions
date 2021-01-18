package com.example.vldattractions;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ListContentActivity extends AppCompatActivity {
    private TextView textView;
    private ImageSwitcher imageSwitcher;
    ImageView imageContent;
    private Typeface typeface;
    private int category = 0;
    private int position = 0;
    private ImageButton backImgBtn, fwdImgBtn;
    private static final String TAG = "ListContentActivity";
    //Массивы с текстовыми ресурсами
    private int[] placesStr;
    private int[] foodStr;
    private int[] hotelsStr;
    private int[] swimmingStr;
    private int[] rusIslandStr;
    //Массивы с png ресурсами
    private String[] placesImg;
    private String[] foodImg;
    private String[] hotelsImg;
    private String[] swimmingImg;
    private String[] rusIslandJpg;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);
        init();
        initResources();
        recieveIntent();
    }

    private void recieveIntent() {
        Intent i = getIntent();
        if (i != null) {
            category = i.getIntExtra("categoryIndex", 0);
            position = i.getIntExtra("position", 0);
        }
        switch (category) {
            case 0:
                loadRes(position, placesImg, placesStr);
                break;
            case 1:
                loadRes(position, foodImg, foodStr);
                break;
            case 2:
                loadRes(position, hotelsImg, hotelsStr);
                break;
            case 3:
                loadRes(position, swimmingImg, swimmingStr);
                break;
            case 4:
                loadRes(position, rusIslandJpg, rusIslandStr);
                break;
        }
    }

    private void loadRes (int position, String [] picsArray, int [] textArray ){
        textView.setText(textArray[position]);
        Glide
                .with(this)
                .load(picsArray[position])
                .into(imageContent);
    }
public void onBackClick(View view){
    Log.i(TAG, "onBackClick: ");
}

public void onFwdClick(View view){
    Log.i(TAG, "onFwdClick: ");
}
    private void init() {
        textView = findViewById(R.id.textContentView);
        imageSwitcher = findViewById(R.id.imageSwitcher);
        backImgBtn = findViewById(R.id.back_btn_content);
        fwdImgBtn = findViewById(R.id.fwd_btn_content);
        imageContent = findViewById(R.id.imageContent);
        //Добавили шрифт, скачанный из Google fonts
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/PTMono-Regular.ttf");
        textView.setTypeface(typeface);
    }

    private void initResources() {
        placesStr = new int[] {R.string.bridges, R.string.sport_embankment, R.string.cesarevich_embankment, R.string.funicular, R.string.zolotoy_rog_bay, R.string.orlinoe_gnezdo_hill, R.string.frigates, R.string.red_pennant, R.string.st_paul_cathedral, R.string.triumph_gate, R.string.egersheld_lighthouse};
        foodStr = new int[] {R.string.zuma, R.string.supra, R.string.phali, R.string.oh_my_crab, R.string.rest_height, R.string.pho_viet, R.string.chi_fan, R.string.brugge_pub, R.string.alaska, R.string.holyhop};
        hotelsStr = new int[] {R.string.marine_wave, R.string.azimut, R.string.lido_central, R.string.holiday_hotel, R.string.pearl_hotel, R.string.kamminn, R.string.apart_hotel_vld, R.string.karmen, R.string.zodiac, R.string.teplo_hotel};
        swimmingStr = new int[] {R.string.shamora, R.string.glass_beach, R.string.egersheld_beach, R.string.anniversary_beach, R.string.kungasny_beach, R.string.silent_bay_beach, R.string.campus_beach};
        rusIslandStr = new int[] {R.string.tobizin_promontory, R.string.vyatlin_promontory, R.string.ayaks_bay, R.string.campus, R.string.ships_graveyard, R.string.novosilc_troop, R.string.oceanarium, R.string.shkot_island};
        //Массивы с jpg ресурсами
        placesImg = getResources().getStringArray(R.array.places_pics_url);
        foodImg = getResources().getStringArray(R.array.food_pics_url);
        hotelsImg = getResources().getStringArray(R.array.hotels_pics_url);
        swimmingImg = getResources().getStringArray(R.array.swimming_pics_url);
        rusIslandJpg = getResources().getStringArray(R.array.rus_island_pics_url);
    }
}
