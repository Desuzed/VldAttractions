package com.example.vldattractions;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.vldattractions.utils.Bookmarks;
import com.example.vldattractions.utils.MapsFragment;
import com.example.vldattractions.factory.VldObject;
import com.example.vldattractions.utils.RecViewAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.TreeSet;

public class VldContentActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {
    private TextView tvDescription, tvAddress, tvInfo, tvLink;
    private ImageSwitcher imageSwitcher;
    private Toolbar toolbar;
    private Typeface typeface;
    private VldObject vldObject;
    private static final String TAG = "VldContentActivity";
    private String[] picsArray;
    private int index = 0;
    private MapsFragment mapsFragment;
    private Bookmarks bookmarks = Bookmarks.getInstance();
    private RecViewAdapter adapter;
    private int position = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);
        init();
        receiveIntent();
        createFragment();
    }

    private void createFragment() {
        mapsFragment = new MapsFragment(vldObject.getCoordinates(), vldObject.getCaption());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mapsFragment, null)
                .commit();
    }

    private void receiveIntent() {
        Intent i = getIntent();
        if (i != null) {
            vldObject = (VldObject) i.getParcelableExtra("vldObject");
            boolean b = i.getBooleanExtra("isBookmarked", false);
            vldObject.setBookmarked(b);
            position = i.getIntExtra("position", 0);
        }
        picsArray = vldObject.getContentPics();
        toolbar.setTitle(vldObject.getCaption());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int descriptionText = vldObject.getDescriptionTextRes();
        tvDescription.setText(descriptionText);
        loadImgWithGlide();
        tvAddress.setText("Адрес объекта: " + vldObject.getAddress());
        tvInfo.setText("Дополнительную информацию можно посмотреть по ссылке:");
        tvLink.setText(vldObject.getUrlInfo());
    }

    private void init() {
        tvDescription = findViewById(R.id.tvContentDescribtion);
        tvAddress = findViewById(R.id.tvAddress);
        tvInfo = findViewById(R.id.tvInfo);
        tvLink = findViewById(R.id.tvLink);
        imageSwitcher = findViewById(R.id.imageSwitcher);
        adapter = RecViewAdapter.getInstance(getApplicationContext());
        toolbar = findViewById(R.id.toolbarContent);
        imageSwitcher.setFactory(this);
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/PTMono-Regular.ttf");
        tvDescription.setTypeface(typeface);
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
            index = picsArray.length - 1;
        }
    }

    public void onBackClick(View view) {
        setIndexPrev();
        loadImgWithGlide();
    }

    private void setIndexFwd() {
//        imageSwitcher.setInAnimation(this, R.anim.from_left);
//        imageSwitcher.setOutAnimation(this, R.anim.to_right);
        index++;
        if (index > picsArray.length - 1) {
            index = 0;
        }
    }

    public void onFwdClick(View view) {
        setIndexFwd();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_content, menu);
        MenuItem item = menu.findItem(R.id.set_bookmark);
        ImageView image = new ImageView(this);
        image.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        image.setPadding(8, 8, 8, 8);
        image.setImageResource(R.drawable.bookmark_selector);
        if (vldObject.isBookmarked()) {
            image.setSelected(true);
        } else {
            image.setSelected(false);
        }
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBookmarked(image);
            }
        });
        item.setActionView(image);
        return true;
    }

    private void setBookmarked(ImageView image) {
        if (vldObject.isBookmarked()) {
            vldObject.setBookmarked(false);
            adapter.getVldObjectList().get(position).setBookmarked(false);
            bookmarks.removeBookmark(vldObject);
            image.setSelected(false);
            removeBookmark(vldObject);
            Toast.makeText(this, "Объект \"" + vldObject.getCaption() + "\" удален из закладок", Toast.LENGTH_SHORT).show();
        } else {
            vldObject.setBookmarked(true);
            adapter.getVldObjectList().get(position).setBookmarked(true);
            bookmarks.addBookmark(vldObject);
            image.setSelected(true);
            saveBookmarks();
            Toast.makeText(this, "Объект \"" + vldObject.getCaption() + "\" добавлен в закладки", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveBookmarks() {
        SharedPreferences sp = getSharedPreferences("sharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String json = gson.toJson(bookmarks.getBookmarksSet());
        editor.putString("bookmarks", json);
        editor.apply();
    }

    private void removeBookmark(VldObject o) {
        TreeSet<VldObject> set = readBookmarksSet();
        set.remove(o);
        saveBookmarks();
    }

    private TreeSet<VldObject> readBookmarksSet() {
        SharedPreferences sp = getSharedPreferences("sharedPref", MODE_PRIVATE);
        String json = sp.getString("bookmarks", "");
        Gson gson = new Gson();
        Type type = new TypeToken<TreeSet<VldObject>>() {
        }.getType();
        TreeSet<VldObject> set = gson.fromJson(json, type);
        if (set == null) {
            set = new TreeSet<VldObject>();
        }
        return set;
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
