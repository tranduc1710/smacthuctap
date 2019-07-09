package com.tranduc.smacthuctap.view.Canvas;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyCanvasView myCanvasView;
        // No XML file; just one custom view created programmatically.
        myCanvasView = new MyCanvasView(this);
        // Request the full available screen for layout.
        myCanvasView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(myCanvasView);
    }
}
