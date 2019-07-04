package com.tranduc.smacthuctap.view.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.tranduc.smacthuctap.R;

public class MainActivity extends AppCompatActivity implements MainActivityContact{
    private RecyclerView recyclerView;
    private MainActivityPresenter activityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        activityPresenter = new MainActivityPresenter(this, this);
    }

    @Override
    public RecyclerView getRecylerView() {
        return recyclerView;
    }

    @Override
    public void StartActivity(Intent intent) {
        startActivity(intent);
    }
}
