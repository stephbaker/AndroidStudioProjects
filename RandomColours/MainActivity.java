package com.example.stephaniebaker_macpro.randomcolours;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View v)
    {
        int red = (int) (256 * Math.random());
        int green = (int) (256 * Math.random());
        int blue = (int) (256 * Math.random());

        int c = Color.rgb(red, green, blue);

        v.setBackgroundColor(c);

        String redResult = String.format("%.0f", red/2.55);
        String greenResult = String.format("%.0f", green/2.55);
        String blueResult = String.format("%.0f", blue/2.55);

        ((TextView) findViewById(R.id.answer)).setText("R=" + redResult + "% G=" + greenResult + "% B=" + blueResult + "%" );
    }



}
