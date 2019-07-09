package com.tranduc.smacthuctap.view.MainActivity;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tranduc.smacthuctap.model.MainActivity;
import com.tranduc.smacthuctap.view.Canvas.CanvasActivity;
import com.tranduc.smacthuctap.view.DayEight.DayEight;
import com.tranduc.smacthuctap.view.DayFive.DayFive;
import com.tranduc.smacthuctap.view.DayFour.DayFour;
import com.tranduc.smacthuctap.view.DayNine.DayNine;
import com.tranduc.smacthuctap.view.DayOne.DayOne;
import com.tranduc.smacthuctap.view.DaySix.DaySix;
import com.tranduc.smacthuctap.view.DayThree.DayThree;
import com.tranduc.smacthuctap.view.DayTwo.DayTwo;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter {
    private Context context;
    private MainActivityContact activityContact;
    private MainActivityAdapter mainActivityAdapter;
    private List<MainActivity> activityList;

    public MainActivityPresenter(Context context, MainActivityContact mainActivityContact) {
        this.context = context;
        this.activityContact = mainActivityContact;
        setUpItemButton();
    }

    public void setUpItemButton() {
        activityList = new ArrayList<>();
        RecyclerView recyclerView = activityContact.getRecylerView();

        activityList.add(new MainActivity(MainActivity.menuScreen.DayOne, "Day One"));
        activityList.add(new MainActivity(MainActivity.menuScreen.DayTwo, "Day Two"));
        activityList.add(new MainActivity(MainActivity.menuScreen.DayThree, "Day Three"));
        activityList.add(new MainActivity(MainActivity.menuScreen.DayFour, "Day Four"));
        activityList.add(new MainActivity(MainActivity.menuScreen.DayFive, "Day Five"));
        activityList.add(new MainActivity(MainActivity.menuScreen.DaySix, "Day Six"));
        activityList.add(new MainActivity(MainActivity.menuScreen.DaySeven, "Day Seven"));
        activityList.add(new MainActivity(MainActivity.menuScreen.DayEight, "Day Eight"));
        activityList.add(new MainActivity(MainActivity.menuScreen.DayNine, "Day Nine"));
        activityList.add(new MainActivity(MainActivity.menuScreen.Canvas, "Canvas"));

        mainActivityAdapter = new MainActivityAdapter(activityList, context);

        mainActivityAdapter.setListener(new MainActivityAdapter.OnClickListener() {
            @Override
            public void onClickItem(MainActivity mainActivity, int position) {
                onChangeScreen(mainActivity);
            }
        });

        LinearLayoutManager layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainActivityAdapter);
    }

    private void onChangeScreen(MainActivity mainActivity){
        Intent intent = null;

        switch (mainActivity.getScreen()){
            case MainActivity.menuScreen.DayOne:
                intent = new Intent(context, DayOne.class);
                break;
            case MainActivity.menuScreen.DayTwo:
                intent = new Intent(context, DayTwo.class);
                break;
            case MainActivity.menuScreen.DayThree:
                intent = new Intent(context, DayThree.class);
                break;
            case MainActivity.menuScreen.DayFour:
                intent = new Intent(context, DayFour.class);
                break;
            case MainActivity.menuScreen.DayFive:
                intent = new Intent(context, DayFive.class);
                break;
            case MainActivity.menuScreen.DaySix:
                intent = new Intent(context, DaySix.class);
                break;
            case MainActivity.menuScreen.DaySeven:
                intent = new Intent(context, DaySix.class);
                break;
            case MainActivity.menuScreen.DayEight:
                intent = new Intent(context, DayEight.class);
                break;
            case MainActivity.menuScreen.DayNine:
                intent = new Intent(context, DayNine.class);
                break;
            case MainActivity.menuScreen.Canvas:
                intent = new Intent(context, CanvasActivity.class);
                break;
        }
        activityContact.StartActivity(intent);
    }
}
