package com.example.stephaniebaker_macpro.pushtimecount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ca.roumani.i2c.Utility;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View v)
    {

        double marker = Utility.mark();
        String result = String.format("%.0f", marker/1000);

        ((TextView) findViewById(R.id.counter)).setText(result + " sec since last push");
    }
}
