package com.example.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();


        mAdView.loadAd(adRequest);

        //----------------------------------------------------------
        EditText EdGoldValue = (EditText) findViewById(R.id.EdGoldValue);
        EditText edSilverValue = (EditText) findViewById(R.id.edSilverValue);
        EditText edCash = (EditText) findViewById(R.id.edCash);
        EditText edBank = (EditText) findViewById(R.id.edBank);
        EditText edLiablities = (EditText) findViewById(R.id.edLiablities);
        Button btnCalculate = (Button) findViewById(R.id.btnCalculate);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        TextView tvZakat = (TextView) findViewById(R.id.tvZakat);



        if (btnCalculate != null) {
            btnCalculate.setOnClickListener((View.OnClickListener) (new View.OnClickListener() {
                public final void onClick(View it) {

                    // displaying a toast message
                    //Toast.makeText((Context) MainActivity.this, "Hello Android", Toast.LENGTH_LONG).show();
                    double GoldValue, SilverValue, Cash, Bank, Liablity, Zakat;
                    String zakat;
                    try {


                        GoldValue = Float.parseFloat(String.valueOf(CheckNull(EdGoldValue.getText().toString())));

                        SilverValue = Float.parseFloat(String.valueOf(CheckNull(edSilverValue.getText().toString())));
                        Cash = Float.parseFloat(String.valueOf(CheckNull(edCash.getText().toString())));
                        Bank = Float.parseFloat(String.valueOf(CheckNull(edBank.getText().toString())));
                        Liablity = Float.parseFloat(String.valueOf(CheckNull(edLiablities.getText().toString())));
                        Zakat = ((GoldValue + SilverValue + Cash + Bank) - Liablity) * (2.5 / 100);
                        zakat = String.format("%.2f",Zakat);
                        tvZakat.setText("Zakat Payable: " + zakat);


                    }
                    catch (Exception ex)
                    {
                        //Toast.makeText(MainActivity.this, ex.getStackTrace().toString(), Toast.LENGTH_SHORT).show();
                        tvZakat.setText(ex.toString());
                    }
                }
            }));


        }
        if (btnClear != null) {
            btnClear.setOnClickListener((View.OnClickListener) (new View.OnClickListener() {
                public final void onClick(View it) {
                    EdGoldValue.setText("");
                    edSilverValue.setText("");
                    edBank.setText("");
                    edCash.setText("");
                    edLiablities.setText("");
                    tvZakat.setText("0.00");
                    EdGoldValue.requestFocus();
                }
            }));
        }
    }
    double CheckNull(String Values)
    { if(TextUtils.isEmpty(Values))
        return (double) 0.00F;
        else
            return Double.valueOf(Values);
    }
}