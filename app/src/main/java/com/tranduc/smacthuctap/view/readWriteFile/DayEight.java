package com.tranduc.smacthuctap.view.readWriteFile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tranduc.smacthuctap.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DayEight extends AppCompatActivity implements DayEightContact{
    private EditText edtText;
    private TextView tvTextRead;
    private String text;
    private String textName = "TextName.txt";
    private String cachedName = "CachedName.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_eight);

        tvTextRead = (TextView) findViewById(R.id.tvTextRead);
        edtText = findViewById(R.id.edtTextWrite);
    }

    @SuppressLint("WrongConstant")
    public void writeFile(View view) {
        text = edtText.getText().toString();

        if (TextUtils.isEmpty(text)){
            Toast.makeText(this, "Text is empty", Toast.LENGTH_SHORT).show();
            return;
        }else {
            //bo nho trong
//            File file = new File(getFilesDir(), textName);
//            writeDataToFile(file, text);
            try{
                FileOutputStream fileOutputStream = getApplicationContext().openFileOutput(textName, getApplicationContext().MODE_PRIVATE);
                writeDataToFile(fileOutputStream, text);
                Toast.makeText(this, "Success", 0).show();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    @SuppressLint("WrongConstant")
    public void readFile(View view) {
        try {
            FileInputStream fileInputStream = getApplicationContext().openFileInput(textName);
            String fileData = readFromFileInputStream(fileInputStream);

            if (fileData.length()>0){
                tvTextRead.setText(fileData);
                Toast.makeText(this, "Loading complete", 0).show();
            }else {
                Toast.makeText(this, "Not load any data", 0).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void createCachedFile(View view) {
        text = edtText.getText().toString();

        if (TextUtils.isEmpty(text)){
            Toast.makeText(this, "Input data can't be empty", 0).show();
            return;
        }else {
            File file = new File(getCacheDir(), cachedName);
            writeDataToFile(file, text);
            Toast.makeText(this, "Cached file is create in file", 0).show();
        }
    }

    @SuppressLint("WrongConstant")
    public void readCachedFile(View view) {
        try {
            File file = new File(getCacheDir(), cachedName);
            FileInputStream fileInputStream = new FileInputStream(file);
            String fileData = readFromFileInputStream(fileInputStream);

            if (fileData.length()>0){
                tvTextRead.setText(fileData);
                Toast.makeText(this, "Load save cached data save complete", 0).show();
            }else {
                Toast.makeText(this, "Not load any cached data", 0).show();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void createTempFile(View view) {
        text = edtText.getText().toString();

        try{
            if (TextUtils.isEmpty(text)){
                Toast.makeText(this, "Input data can't be empty", 0).show();
                return;
            }else {
                File file = File.createTempFile("temp", ".txt", getCacheDir());
                String tempFileName = file.getAbsolutePath();
                writeDataToFile(file, textName);
                Toast.makeText(this, "Temp file is create", 0).show();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void writeDataToFile(File file, String data)
    {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.writeDataToFile(fileOutputStream, data);
            fileOutputStream.close();
        }catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private void writeDataToFile(FileOutputStream file, String s){
        try{
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(s);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private String readFromFileInputStream(FileInputStream fileInputStream){
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (fileInputStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String lineData = bufferedReader.readLine();
                while (lineData != null){
                    stringBuffer.append(lineData);
                    lineData = bufferedReader.readLine();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            return stringBuffer.toString();
        }
    }
}
