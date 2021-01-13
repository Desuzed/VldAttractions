package com.example.vldattractions;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListContentActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Typeface typeface;
    private int category = 0;
    private int position = 0;
    //Массивы с текстовыми ресурсами
    private int[] placesStr = {R.string.bridges, R.string.sport_embankment, R.string.cesarevich_embankment, R.string.funicular, R.string.zolotoy_rog_bay, R.string.orlinoe_gnezdo_hill, R.string.frigates, R.string.red_pennant, R.string.st_paul_cathedral, R.string.triumph_gate, R.string.egersheld_lighthouse};
    private int[] restaurantsStr = {R.string.zuma, R.string.supra, R.string.phali, R.string.oh_my_crab, R.string.rest_height, R.string.pho_viet, R.string.chi_fan, R.string.brugge_pub, R.string.alaska, R.string.holyhop};
    private int[] hotelsStr = {R.string.marine_wave, R.string.azimut, R.string.lido_central, R.string.holiday_hotel, R.string.pearl_hotel, R.string.kamminn, R.string.apart_hotel_vld, R.string.karmen, R.string.zodiac, R.string.teplo_hotel};
    private int[] beachesStr = {R.string.shamora, R.string.glass_beach, R.string.egersheld_beach, R.string.anniversary_beach, R.string.kungasny_beach, R.string.silent_bay_beach, R.string.campus_beach};
    private int[] rusIslandStr = {R.string.tobizin_promontory, R.string.vyatlin_promontory, R.string.ayaks_bay, R.string.campus, R.string.ships_graveyard, R.string.novosilc_troop, R.string.oceanarium, R.string.shkot_island};
    //Массивы с png ресурсами
    private int [] placesPng = {R.drawable.rus_island_bridge, R.drawable.sport_embankment, R.drawable.cesarevic_emb, R.drawable.funicular, R.drawable.zolotoy_rog_bay, R.drawable.eagle_hill, R.drawable.frigates, R.drawable.red_pennant, R.drawable.st_paul_cathedral, R.drawable.triumph_gates, R.drawable.lighthouse };
    private int [] restaurantsPng = {};
    private int [] hotelsPng = {};
    private int [] beachesPng = {};
    private int [] rusIslandPng = {};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_content);
        init();
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
                textView.setText(placesStr[position]);
                imageView.setImageResource(placesPng[position]);
                break;
            case 1:
                textView.setText(restaurantsStr[position]);
                break;
            case 2:
                textView.setText(hotelsStr[position]);
                break;
            case 3:
                textView.setText(beachesStr[position]);
                break;
            case 4:
                textView.setText(rusIslandStr[position]);
                break;
        }
    }
    private void init(){
        textView = findViewById(R.id.textContentView);
        imageView = findViewById(R.id.imageContent);
        //Добавили шрифт, скачанный из Google fonts
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/PTMono-Regular.ttf");
        textView.setTypeface(typeface);
    }
}
