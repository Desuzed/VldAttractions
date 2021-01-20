package com.example.vldattractions;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;
import android.widget.ViewSwitcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.vldattractions.utils.factory.ArraysFactory;
import com.example.vldattractions.utils.factory.Category;

public class ListContentActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {
    private TextView textView;
    private ImageSwitcher imageSwitcher;
    private Toolbar toolbar;
    private Typeface typeface;
    private Category category;
    private ArraysFactory factory = new ArraysFactory(this);
    private int categoryIndex = 0;
    private int position = 0;
    private ImageButton backImgBtn, fwdImgBtn;
    private static final String TAG = "ListContentActivity";
    private String[] picsArray;
    private int length;
    private int index = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);
        init();
        receiveIntent();
    }

    private void receiveIntent() {
        Intent i = getIntent();
        String caption = "VldAttractions2";
        if (i != null) {
            categoryIndex = i.getIntExtra("categoryIndex", 0);
            position = i.getIntExtra("position", 0);
            caption = i.getStringExtra("caption");
           // caption = i.getStringExtra("caption", "VldAttractions");
        }
        category = factory.getCategory(categoryIndex);
        picsArray = category.getContentPics(position);
        toolbar.setTitle(caption);
        setActionBar(toolbar);
        length = picsArray.length;
        int[] textArray = category.getTextArray();
        textView.setText(textArray[position]);
        loadImgWithGlide();

    }

    private void init() {
        textView = findViewById(R.id.textContentView);
        imageSwitcher = findViewById(R.id.imageSwitcher);
        backImgBtn = findViewById(R.id.back_btn_content);
        toolbar = (Toolbar) findViewById(R.id.toolbarContent);
       // toolbar.setTitle("1111");

        fwdImgBtn = findViewById(R.id.fwd_btn_content);
        imageSwitcher.setFactory(this);
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/PTMono-Regular.ttf");
        textView.setTypeface(typeface);
        Animation inAnimation = new AlphaAnimation(0, 1);
        inAnimation.setDuration(500);
        Animation outAnimation = new AlphaAnimation(1, 0);
        outAnimation.setDuration(500);
        imageSwitcher.setInAnimation(inAnimation);
        imageSwitcher.setOutAnimation(outAnimation);
    }

    private void setIndexPrev() {
//        imageSwitcher.setInAnimation(this, R.anim.from_right);
//        imageSwitcher.setOutAnimation(this, R.anim.to_left);
        index--;
        if (index < 0) {
            index = length - 1;
        }
    }

    //TODO Glide не кэширует изображения и каждый раз грузит заново при нажатии на кнопки вперед и назад
    public void onBackClick(View view) {
        setIndexPrev();
        Log.i(TAG, "onBackClick: " + index + " length: " + length);
        loadImgWithGlide();
    }

    private void setIndexFwd() {
//        imageSwitcher.setInAnimation(this, R.anim.from_left);
//        imageSwitcher.setOutAnimation(this, R.anim.to_right);
        index++;
        if (index > length - 1) {
            index = 0;
        }
    }

    public void onFwdClick(View view) {
        setIndexFwd();
        Log.i(TAG, "onFwdClick: " + index + " length: " + length);
        loadImgWithGlide();
    }

    private void loadImgWithGlide() {
        Glide
                .with(this)
                .asBitmap()
                .load(picsArray[index])
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        imageSwitcher.setImageDrawable(new BitmapDrawable(getResources(), resource));
                        return true;
                    }
                })
                .into((ImageView) imageSwitcher.getCurrentView());
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new
                ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        return imageView;
    }
}
