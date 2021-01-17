package com.example.vldattractions;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Toast;

import com.example.vldattractions.utils.RecViewAdapter;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private String[] captionsArray;
    private String[] picsArray;
    public static int categoryIndex = 0;
    private Toolbar toolbar;
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private RecViewAdapter recViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
        if (id == R.id.nav_places) {
            Toast.makeText(this, "Places", Toast.LENGTH_SHORT).show();
            fillArray(R.string.menu_places, R.array.array_places, R.array.places_pics_url, 0);
        } else if (id == R.id.nav_food) {
            Toast.makeText(this, "Food", Toast.LENGTH_SHORT).show();
            fillArray(R.string.menu_catering, R.array.array_food, R.array.food_pics_url, 1);
        } else if (id == R.id.nav_hotels) {
            Toast.makeText(this, "Hotels", Toast.LENGTH_SHORT).show();
            fillArray(R.string.menu_hotels, R.array.array_hotels, R.array.hotels_pics_url, 2);
        } else if (id == R.id.nav_swimming) {
            Toast.makeText(this, "Swimming", Toast.LENGTH_SHORT).show();
            fillArray(R.string.menu_swimming, R.array.array_swimming, R.array.swimming_pics_url, 3);
        } else if (id == R.id.nav_rus_island) {
            Toast.makeText(this, "Russky Island", Toast.LENGTH_SHORT).show();
            fillArray(R.string.menu_rus_island, R.array.array_rus_island, R.array.rus_island_pics_url, 4);
        } else if (id == R.id.nav_about) {
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
            categoryIndex = 5;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void fillArray(int title, int captionArray, int picturesArray, int index) {
        categoryIndex = index;
        captionsArray = getResources().getStringArray(captionArray);
        picsArray = getResources().getStringArray(picturesArray);
        recViewAdapter.clearItems();
        recViewAdapter.setItems(captionsArray, picsArray);
        recViewAdapter.notifyDataSetChanged();
        toolbar.setTitle(title);
    }

    private void init() {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recViewAdapter = new RecViewAdapter(getApplicationContext());
        recyclerView.setAdapter(recViewAdapter);

        captionsArray = getResources().getStringArray(R.array.array_places);
        picsArray = getResources().getStringArray(R.array.places_pics_url);

        recViewAdapter.setItems(captionsArray, picsArray);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Что посмотреть");
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);

    }
}

