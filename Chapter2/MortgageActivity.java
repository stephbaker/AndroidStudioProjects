package com.example.stephaniebaker_macpro.chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MortgageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mortgage_layout);
    }

    public void buttonClicked(View v)
    {
        EditText principleView = (EditText) findViewById(R.id.principleBox);
        String principle = principleView.getText().toString();
        EditText amorizationView = (EditText) findViewById(R.id.amortizationBox);
        String amorization = amorizationView.getText().toString();
        EditText interestView = (EditText) findViewById(R.id.interestBox);
        String interest = interestView.getText().toString();

        MortgageModel myModel = new MortgageModel(principle, amorization, interest);
        String myAnswer = myModel.computePayment();

        ((TextView) findViewById(R.id.calculation)).setText(myAnswer);

    }

}
