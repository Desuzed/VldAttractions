package com.example.vldattractions;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class ListContentActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {
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

    private String [] imageList;
    int length;
    int index = 0;

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

    private void init() {
        textView = findViewById(R.id.textContentView);
        imageContent = findViewById(R.id.imageContent);
        imageSwitcher = findViewById(R.id.imageSwitcher);
        backImgBtn = findViewById(R.id.back_btn_content);
        fwdImgBtn = findViewById(R.id.fwd_btn_content);
        imageSwitcher.setFactory(this);
//        Animation inAnimation = new AlphaAnimation(0, 1);
//        inAnimation.setDuration(2000);
//        Animation outAnimation = new AlphaAnimation(1, 0);
//        outAnimation.setDuration(2000);
//        imageSwitcher.setInAnimation(inAnimation);
//        imageSwitcher.setOutAnimation(outAnimation);
       // imageSwitcher.setImageResource();
        //Добавили шрифт, скачанный из Google fonts
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/PTMono-Regular.ttf");
        textView.setTypeface(typeface);
    }
//TODO Glide не кэширует изображения и каждый раз грузит заново при нажатии на кнопки вперед и назад
    public void onBackClick(View view){
        imageSwitcher.setInAnimation(this, R.anim.from_right);
        imageSwitcher.setOutAnimation(this, R.anim.to_left);
      //  imageSwitcher.setImageResource(imageList[index]);
        index--;
        if (index < 0){
            index = length- 1;
        }
        Glide
                .with(this)
                .asBitmap()
                .load(imageList[index])
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }
                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {

                        Log.i(TAG, "onBackClick: " + index  + " length: " + length );
                        imageSwitcher.setImageDrawable(new BitmapDrawable(getResources(), resource));
                        return true;
                    }
                })
                .into((ImageView) imageSwitcher.getCurrentView());
    }

    public void onFwdClick(View view){
        imageSwitcher.setInAnimation(this, R.anim.from_left);
        imageSwitcher.setOutAnimation(this, R.anim.to_right);
        index++;
        if (index > length - 1){
            index = 0;
        }
        Glide
                .with(this)
                .asBitmap()
                .load(imageList[index])
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {

                        Log.i(TAG, "onFwdClick: " + index  + " length: " + length );
                        imageSwitcher.setImageDrawable(new BitmapDrawable(getResources(), resource));
                        return true;
                    }
                })
                .into((ImageView) imageSwitcher.getCurrentView());
       // imageSwitcher.setImageResource(imageList[index]);
    }

    private  void loadImgWithGlide (){

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
        imageList = getResources().getStringArray(R.array.places_pics_url);
        length = imageList.length;
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new
                ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
       // imageView.setBackgroundColor(0xFF000000);
        return imageView;
    }
}
