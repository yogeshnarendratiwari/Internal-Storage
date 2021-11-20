package com.oslac.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText text;
    TextView view;
    Button save ,see;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = findViewById(R.id.button);
        see = findViewById(R.id.button2);
        text = findViewById(R.id.editTextTextPersonName2);
        view = findViewById(R.id.textView);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = null;
                FileOutputStream fos = null;
                String txt = text.getText().toString();


                try {
                    txt=txt+" ";
                    file=getFilesDir();
                    fos=openFileOutput("File.txt", Context.MODE_PRIVATE);
                    fos.write(txt.getBytes());
                    text.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}