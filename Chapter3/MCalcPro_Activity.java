import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import ca.roumani.i2c.MPro;

public class MCalcPro_Activity extends AppCompatActivity implements TextToSpeech.OnInitListener, SensorEventListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcalcpro_layout);
        this.tts = new TextToSpeech(this, this);
    }

    public void onInit(int initStatus)
    {
        this.tts.setLanguage(Locale.US);
    }

    public void onAccuracyChanged(Sensor arg0, int arg1)
    {
    }

    public void onSensorChanged(SensorEvent event)
    {
        double ax = event.values[0];
        double ay = event.values[1];
        double az = event.values[2];
        double a = Math.sqrt(ax*ax + ay*ay + az*az);
        if (a > 20)
        {
            ((EditText) findViewById(R.id.pBox)).setText("");
            ((EditText) findViewById(R.id.aBox)).setText("");
            ((EditText) findViewById(R.id.iBox)).setText("");
            ((TextView) findViewById(R.id.output)).setText("");
        }
    }

    public void buttonClicked(View v)
    {
        try
        {
            EditText principleView = (EditText) findViewById(R.id.pBox);
            String principle = principleView.getText().toString();
            EditText amorizationView = (EditText) findViewById(R.id.aBox);
            String amorization = amorizationView.getText().toString();
            EditText interestView = (EditText) findViewById(R.id.iBox);
            String interest = interestView.getText().toString();

            MPro mp = new MPro();
            mp.setPrinciple(principle);
            mp.setAmortization(amorization);
            mp.setInterest(interest);
            String monthly = mp.computePayment("%,.2f");
            String s = "Monthly Payment = " + monthly;
            s += "\n\n";
            s += "By making this payments monthly for ";
            s += amorization + " years, the mortgage will be paid in full.";
            s += "\n\n";
            s += String.format("%8d", 0) + mp.outstandingAfter(0, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 1) + mp.outstandingAfter(1, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 2) + mp.outstandingAfter(2, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 3) + mp.outstandingAfter(3, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 4) + mp.outstandingAfter(4, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 5) + mp.outstandingAfter(5, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 10) + mp.outstandingAfter(10, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 15) + mp.outstandingAfter(15, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 20) + mp.outstandingAfter(20, "%,16.0f");

            ((TextView) findViewById(R.id.output)).setText(s);

            tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
        }
        catch (Exception e)
        {
            //display e.getMessage()
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }

    }



    public static void main(String[] args) {
        MPro mp = new MPro();
        mp.setPrinciple("400000");
        mp.setAmortization("20");
        mp.setInterest("5");
        System.out.println(mp.computePayment("%,.2f"));
        System.out.println(mp.outstandingAfter(2,"%,16.0f"));
    }

}
