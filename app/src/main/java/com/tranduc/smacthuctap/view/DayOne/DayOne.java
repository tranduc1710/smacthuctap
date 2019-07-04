package com.tranduc.smacthuctap.view.DayOne;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.tranduc.smacthuctap.R;

public class DayOne extends AppCompatActivity implements DayOneContact{
    private ImageView imgAvatar;
    private CheckBox cbConductGood, cbConductRather, cbConductLeast;
    private ToggleButton tbStatus;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private DayOnePresenter dayOnePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_one);
        setTitle(R.string.day_one);

        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        cbConductGood = (CheckBox) findViewById(R.id.cbConductGood);
        cbConductRather = (CheckBox) findViewById(R.id.cbConductRather);
        cbConductLeast = (CheckBox) findViewById(R.id.cbConductLeast);
        tbStatus = (ToggleButton) findViewById(R.id.tbStatus);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);

        dayOnePresenter = new DayOnePresenter(this, this);
    }

    public void submit(View view) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = layoutInflater.inflate(R.layout.dialog_dayone, null);

        final ImageView imgAvatarD1;
        TextView tvConductStudent;
        TextView tvStatus;
        TextView tvGender;

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Info student");
        dialog.setView(view1);
        dialog.setCancelable(true);

        imgAvatarD1 = (ImageView) view1.findViewById(R.id.imgAvatarD1);
        tvConductStudent = (TextView) view1.findViewById(R.id.tvConductStudent);
        tvStatus = (TextView) view1.findViewById(R.id.tvStatus);
        tvGender = (TextView) view1.findViewById(R.id.tvGender);

        imgAvatarD1.setImageResource(R.drawable.img01);
        tvConductStudent.setText(dayOnePresenter.checkConduct(cbConductGood, cbConductRather, cbConductLeast));
        if (tbStatus.isChecked()){
            tvStatus.setText("Study");
        }else {
            tvStatus.setText("Absent");
        }
        if (rbMale.isChecked()){
            tvGender.setText("Male");
        }else {
            tvGender.setText("Female");
        }

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
}
