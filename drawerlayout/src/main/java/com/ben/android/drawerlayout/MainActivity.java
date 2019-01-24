package com.ben.android.drawerlayout;

import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.id_drawerlayout);
        //cancel scrim bg
        drawerLayout.setScrimColor(Color.TRANSPARENT);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        //设置默认状态
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                float scale = 1 - slideOffset;
                //0.7 - 1.0
                drawerView.setScaleX(1 - 0.3f * scale);
                drawerView.setScaleY(1 - 0.3f * scale);

                //content view
                View contentView = drawerLayout.getChildAt(0);
                contentView.setScaleX((float) (0.7 + 0.3f * scale));
                contentView.setScaleY((float) (0.7 + 0.3f * scale));
                contentView.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                Snackbar.make(drawerView, "", 20).show();
                ArrayList<Object> arrayList = new ArrayList<>();
                LinkedList<Object> objects = new LinkedList<>();
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


    }


    private void chnageColor() {
        drawerLayout.getChildAt(0).setBackgroundColor(Color.RED);
    }
}
