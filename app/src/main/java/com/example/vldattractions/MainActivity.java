package com.example.vldattractions;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    private  String [] strArray;
    private ArrayAdapter<String> adapter;
    private  int categoryIndex = 0;
    private ListView listView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Что посмотреть");
        setSupportActionBar(toolbar);
        listView =findViewById(R.id.listView);
        strArray =getResources().getStringArray(R.array.array_places);
        adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(strArray)));
        listView.setAdapter(adapter);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ListContentActivity.class);
                intent.putExtra("categoryIndex", categoryIndex);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

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
            categoryIndex = 0;
            strArray = getResources().getStringArray(R.array.array_places);
            adapter.clear();
            adapter.addAll(strArray);
            toolbar.setTitle("Что посмотреть");
            adapter.notifyDataSetChanged();
        }else if (id == R.id.nav_food){
            Toast.makeText(this, "Food", Toast.LENGTH_SHORT).show();
            categoryIndex = 1;
            strArray = getResources().getStringArray(R.array.array_food);
            adapter.clear();
            adapter.addAll(strArray);
            toolbar.setTitle("Места общепита");
            adapter.notifyDataSetChanged();
        }else if (id == R.id.nav_hotels){
            Toast.makeText(this, "Hotels", Toast.LENGTH_SHORT).show();
            categoryIndex = 2;
            strArray = getResources().getStringArray(R.array.array_hotels);
            adapter.clear();
            adapter.addAll(strArray);
            toolbar.setTitle("Отели");
            adapter.notifyDataSetChanged();
        }else if (id == R.id.nav_swimming){
            Toast.makeText(this, "Swimming", Toast.LENGTH_SHORT).show();
            categoryIndex = 3;
            strArray = getResources().getStringArray(R.array.array_swimming);
            adapter.clear();
            adapter.addAll(strArray);
            toolbar.setTitle("Где искупаться");
            adapter.notifyDataSetChanged();
        }else if (id == R.id.nav_rus_island){
            Toast.makeText(this, "Russky Island", Toast.LENGTH_SHORT).show();
            categoryIndex = 4;
            strArray = getResources().getStringArray(R.array.array_rus_island);
            adapter.clear();
            adapter.addAll(strArray);
            toolbar.setTitle("Русский остров");
            adapter.notifyDataSetChanged();
        }else if (id == R.id.nav_about){
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
            categoryIndex = 5;

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}