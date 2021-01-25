package com.example.vldattractions;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import com.example.vldattractions.utils.RecViewAdapter;
import com.example.vldattractions.utils.factory.ArraysFactory;
import com.example.vldattractions.utils.factory.Category;
import com.example.vldattractions.utils.factory.Food;
import com.example.vldattractions.utils.factory.Hotels;
import com.example.vldattractions.utils.factory.Places;
import com.example.vldattractions.utils.factory.RusIsland;
import com.example.vldattractions.utils.factory.Swimming;
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
    public static int index = 0;
    private static final String TAG = "MainActivity";
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecViewAdapter recViewAdapter;
    private ArraysFactory factory = new ArraysFactory(this);
    private Category category;

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
        switch (id) {
            case R.id.nav_places:
                fillArray(R.string.menu_places, Places.INDEX);
                break;
            case R.id.nav_food:
                fillArray(R.string.menu_catering,Food.INDEX);
                break;
            case R.id.nav_hotels:
                fillArray(R.string.menu_hotels, Hotels.INDEX);
                break;
            case R.id.nav_swimming:
                fillArray(R.string.menu_swimming, Swimming.INDEX);
                break;
            case R.id.nav_rus_island:
                fillArray(R.string.menu_rus_island, RusIsland.INDEX);
                break;
            case R.id.nav_about:
                launchActivityAbout();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void fillArray(int title, int index) {
        toolbar.setTitle(title);
        this.index = index;
        category = factory.getCategory(index);
        recViewAdapter.clearItems();
        recViewAdapter.setItems(category);
        recViewAdapter.notifyDataSetChanged();
    }

    private void init() {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recViewAdapter = new RecViewAdapter(getApplicationContext());
        recyclerView.setAdapter(recViewAdapter);
        category = factory.getCategory(Places.INDEX);
        recViewAdapter.setItems(category);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.menu_places);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
    }

    private void launchActivityAbout(){
        Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
      //  super.onBackPressed();
        moveTaskToBack(true);
//        Intent startMain = new Intent(Intent.ACTION_MAIN);
//        startMain.addCategory(Intent.CATEGORY_HOME);
//        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(startMain);
       // finish();
    }
}

