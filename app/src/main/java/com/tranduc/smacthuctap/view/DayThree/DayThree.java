package com.tranduc.smacthuctap.view.DayThree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.tranduc.smacthuctap.R;

public class DayThree extends AppCompatActivity implements DayThreeContact{
    private ImageButton imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_three);

        imgButton = findViewById(R.id.imgButton);

        registerForContextMenu(imgButton);
        LinearLayout linearLayout = findViewById(R.id.ll_day3);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_day_one, linearLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_day3, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_day3_1, menu);
        menu.setHeaderTitle("Choice");
    }
}
