package com.example.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
   Button convert;
   EditText enter;
   TextToSpeech mToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter= findViewById(R.id.editText);
        convert=findViewById(R.id.button);

        mToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
             if(status!=TextToSpeech.ERROR){
                 mToSpeech.setLanguage(Locale.ENGLISH);
             }
            }
        });
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToSpeech.speak(enter.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}
