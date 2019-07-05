package com.tranduc.smacthuctap.view.DaySix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tranduc.smacthuctap.R;

public class DaySix extends AppCompatActivity implements DaySixContact{
    private static final int SEND_SMS_PERMISSION_REQUEST_CODE = 111;
    private EditText edtPhoneNumber;
    private EditText edtMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_six);

        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);
        edtMessage = (EditText) findViewById(R.id.edtMessage);
        btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setEnabled(false);
        if (checkPermission(Manifest.permission.SEND_SMS)){
            btnSend.setEnabled(true);
        }else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS},
                    SEND_SMS_PERMISSION_REQUEST_CODE);
        }
    }

    public void play(View view) {
        Intent intent = new Intent(this, PlayMusicService.class);
        this.startService(intent);
    }

    public void stop(View view) {
        Intent intent = new Intent(this, PlayMusicService.class);
        this.stopService(intent);
    }

    public void send(View view) {
        String phone = edtPhoneNumber.getText().toString().trim();
        String message = edtMessage.getText().toString();

        if (!TextUtils.isEmpty(phone) || !TextUtils.isEmpty(message)){
            if (checkPermission(Manifest.permission.SEND_SMS)){
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phone, null, message, null, null);
                PendingIntent sentIntent;
                sentIntent = PendingIntent.getBroadcast(this, 0, new Intent("Success"), 0);
                smsManager.sendTextMessage(phone, null, message, sentIntent, null);
            }else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean checkPermission(String sendSms) {
        int checkPermission = ContextCompat.checkSelfPermission(this, sendSms);
        return (checkPermission == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case SEND_SMS_PERMISSION_REQUEST_CODE: {
                if(grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    btnSend.setEnabled(true);
                }
                return;
            }
        }
    }

    public void call(View view) {
        String phoneNumber = edtPhoneNumber.getText().toString().trim();
        if (!TextUtils.isEmpty(phoneNumber)){
            String dial = "tel:" + phoneNumber;
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
        }else {
            Toast.makeText(this, "Enter phone number", Toast.LENGTH_SHORT).show();
        }
    }
}
