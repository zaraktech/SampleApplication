package com.example.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         EditText EdGoldValue = (EditText) findViewById(R.id.EdGoldValue);
         EditText edSilverValue = (EditText) findViewById(R.id.edSilverValue);
         EditText edCash = (EditText) findViewById(R.id.edCash);
         EditText edBank = (EditText) findViewById(R.id.edBank);
         EditText edLiablities = (EditText) findViewById(R.id.edLiablities);
        Button  btnCalculate=(Button) findViewById(R.id.btnCalculate);
        Button  btnClear=(Button) findViewById(R.id.btnClear);


    }
}