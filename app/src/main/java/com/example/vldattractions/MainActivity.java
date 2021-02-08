package com.example.vldattractions;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import com.example.vldattractions.factory.VldObject;
import com.example.vldattractions.utils.Bookmarks;
import com.example.vldattractions.utils.RecViewAdapter;
import com.example.vldattractions.factory.CategoriesFactory;
import com.example.vldattractions.factory.Category;
import com.example.vldattractions.factory.Food;
import com.example.vldattractions.factory.Hotels;
import com.example.vldattractions.factory.Places;
import com.example.vldattractions.factory.RusIsland;
import com.example.vldattractions.factory.Swimming;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecViewAdapter recViewAdapter;
    private CategoriesFactory factory = new CategoriesFactory(this);
    private Category category;
    // private Switch themeSwitch;
    private ArrayList<VldObject> vldObjectList = new ArrayList<>();
    private Bookmarks bookmarks = Bookmarks.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_places);
        toggle.syncState();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_places:
                createObjects(R.string.menu_places, Places.INDEX);
                break;
            case R.id.nav_food:
                createObjects(R.string.menu_catering, Food.INDEX);
                break;
            case R.id.nav_hotels:
                createObjects(R.string.menu_hotels, Hotels.INDEX);
                break;
            case R.id.nav_swimming:
                createObjects(R.string.menu_swimming, Swimming.INDEX);
                break;
            case R.id.nav_rus_island:
                createObjects(R.string.menu_rus_island, RusIsland.INDEX);
                break;
            case R.id.nav_about:
                launchActivityAbout();
                break;
            case R.id.nav_bookmarks:
                launchBookmarks();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void createObjects(int title, int index) {
        category = factory.getCategory(index);
        vldObjectList = new ArrayList<>();
        for (int i = 0; i < category.getCaptionArray().length; i++) {//TODO Сделать так, чтобы списки не создавались каждый раз заново
            VldObject v = category.getVldObject(i);
            if (bookmarks.getBookmarksSet().contains(v)){
                v.setBookmarked(true);
            }
            vldObjectList.add(v);
        }
        toolbar.setTitle(title);
        //recViewAdapter.clearItems();
        recViewAdapter.setItems(vldObjectList);
    }

    private void init() {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recViewAdapter = RecViewAdapter.getInstance(getApplicationContext());
        recyclerView.setAdapter(recViewAdapter);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.menu_places);
        setSupportActionBar(toolbar);
        bookmarks.setBookmarksSet(readBookmarksSet());
        createObjects(R.string.menu_places, Places.INDEX);
        drawer = findViewById(R.id.drawer_layout);
        //  themeSwitch = (Switch) findViewById(R.id.switchDarkNight);
//        if  (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO){
//            themeSwitch.setChecked(true);
//        }

//        int currentNightMode = getResources().getConfiguration().uiMode
//                & Configuration.UI_MODE_NIGHT_MASK;
//        if (currentNightMode==Configuration.UI_MODE_NIGHT_YES){
//            themeSwitch.setChecked(true);
//        }
//        switch (currentNightMode) {
//            case Configuration.UI_MODE_NIGHT_NO:
//
//            case Configuration.UI_MODE_NIGHT_YES:
//                // Night mode is active, we're at night!
//            case Configuration.UI_MODE_NIGHT_UNDEFINED:
//                // We don't know what mode we're in, assume notnight
//        }
//        themeSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//              //  navigationView.setCheckedItem(R.id.nav_places);
////                finish();
////                startActivity(new Intent(MainActivity.this, MainActivity.this.getClass()));
//            }
//        });
    }

//    public void onSwitchClick (View view){
//        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//         //   themeSwitch.setChecked(true);
//        }
//
//    }

    private void launchActivityAbout() {
        Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
        startActivity(intent);
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

    private void launchBookmarks() {
        TreeSet<VldObject> set = bookmarks.getBookmarksSet();
        toolbar.setTitle(R.string.menu_bookmarks);
        recViewAdapter.clearItems();
        recViewAdapter.setItems(new ArrayList(set));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}

