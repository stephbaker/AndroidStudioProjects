package com.example.stephaniebaker_macpro.chapter4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEncrypt(View v)
    {
        try
        {
            EditText keyView = (EditText) findViewById(R.id.cryptKey);
            String k = keyView.getText().toString();
            EditText noteView = (EditText) findViewById(R.id.data);
            String note = noteView.getText().toString();

            Cipher myModel = new Cipher(k);
            String myAnswer = myModel.Encrypt(note);
            ((EditText) findViewById(R.id.data)).setText(myAnswer);
        }
        catch (Exception e)
        {
            //display e.getMessage()
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
        }
    }

    public void onDecrypt(View v)
    {
        try
        {
            EditText keyView = (EditText) findViewById(R.id.cryptKey);
            String k = keyView.getText().toString();
            EditText noteView = (EditText) findViewById(R.id.data);
            String note = noteView.getText().toString();

            Cipher myModel = new Cipher(k);
            String myAnswer = myModel.Decrypt(note);
            ((EditText) findViewById(R.id.data)).setText(myAnswer);
        }
        catch (Exception e)
        {
            //display e.getMessage()
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
        }

    }

    public void onSave(View v)
    {
        try
        {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((EditText) findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast.makeText(this, "Note Saved.", Toast.LENGTH_SHORT);
        }
        catch (Exception e)
        {
            //display e.getMessage()
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
        }
    }

    public void onLoad(View v)
    {
        try
        {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileReader fr = new FileReader(file);

            String show = "";
            for (int c = fr .read(); c != -1; c= fr.read())
            {
                show += (char) c;
            }
            fr.close();
            ((EditText) findViewById(R.id.data)).setText(show);
        }
        catch (Exception e)
        {
            //display e.getMessage()
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
        }
    }

}
