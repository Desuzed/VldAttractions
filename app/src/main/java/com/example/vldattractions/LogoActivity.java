package com.example.vldattractions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LogoActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
    }

    public void onClickStart(View view) {
        Intent intent  = new Intent(LogoActivity.this, MainActivity.class );
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();       //метод для того, чтобы при возврате "назад" не вернулось на это активити
    }
}
