package com.example.vldattractions;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.vldattractions.utils.Bookmarks;
import com.example.vldattractions.utils.MapsFragment;
import com.example.vldattractions.factory.VldObject;
import com.example.vldattractions.utils.RecViewAdapter;
import com.example.vldattractions.utils.ToolbarPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VldContentActivity extends AppCompatActivity {
    private TextView tvDescription, tvAddress, tvInfo, tvLink;
    private FloatingActionButton fab;
    private ToolbarPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private Typeface typeface;
    private VldObject vldObject;
    private static final String TAG = "VldContentActivity";
    private String[] picsArray;
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
        createMapFragment();
    }

    private void receiveIntent() {
        Intent i = getIntent();
        if (i != null) {
            position = i.getIntExtra("position", 0);
        }
        vldObject = adapter.getVldObjectList().get(position);
        picsArray = vldObject.getContentPics();
        pagerAdapter = new ToolbarPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, picsArray);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                final float opacity = Math.abs(Math.abs(position) - 1);
                page.setAlpha(opacity);
            }
        });
        tvDescription.setText(vldObject.getDescriptionTextRes());
        tvDescription.setTypeface(typeface);
        toolbar.setTitle(vldObject.getCaption());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvAddress.setText("Адрес объекта: " + vldObject.getAddress());
        tvLink.setText(vldObject.getUrlInfo());
        if (vldObject.isBookmarked()) {
            fab.setSelected(true);
        } else {
            fab.setSelected(false);
        }
    }

    private void createMapFragment() {
        mapsFragment = new MapsFragment(vldObject.getCoordinates(), vldObject.getCaption());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mapsFragment, null)
                .commit();
    }

    private void init() {
        viewPager = findViewById(R.id.viewPagerToolbar);
        tvDescription = findViewById(R.id.tvContentDescribtion);
        tvAddress = findViewById(R.id.tvAddress);
        tvInfo = findViewById(R.id.tvInfo);
        tvLink = findViewById(R.id.tvLink);
        adapter = RecViewAdapter.getInstance(getApplicationContext());
        toolbar = findViewById(R.id.toolbarContent);
        fab = findViewById(R.id.fabContent);
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/PTMono-Regular.ttf");
    }

    public void onFabClick (View view){
        editBookmarks();
    }
    
    private void editBookmarks() {
        if (vldObject.isBookmarked()) {
            setBookmarked(false);
            bookmarks.removeBookmark(vldObject, getSharedPreferences("sharedPref", MODE_PRIVATE));
            if (MainActivity.isBookmarkActivity){
                adapter.removeObject(position);
            }
            Toast.makeText(this, "Объект \"" + vldObject.getCaption() + "\" удален из закладок", Toast.LENGTH_SHORT).show();
        } else {
            setBookmarked(true);
            bookmarks.addBookmark(vldObject);
            bookmarks.saveBookmarksToSP(getSharedPreferences("sharedPref", MODE_PRIVATE));
            if (MainActivity.isBookmarkActivity){
                adapter.setObject(position, vldObject);
            }
            Toast.makeText(this, "Объект \"" + vldObject.getCaption() + "\" добавлен в закладки", Toast.LENGTH_SHORT).show();
        }
    }

    private void setBookmarked (boolean b){
        vldObject.setBookmarked(b);
        adapter.getVldObjectList().get(position).setBookmarked(b);
        fab.setSelected(b);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
