package com.example.stephaniebaker_macpro.pushcount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonClicked(View v)
    {
        TextView countView = (TextView) findViewById(R.id.counted);
        String number = countView.getText().toString();
        int result = Integer.parseInt(number);
        result = result + 1;
        number = Integer.toString(result);

        countView.setText(number);
    }
}
