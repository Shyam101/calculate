package com.example.calculatour;

import android.graphics.Typeface;
import android.hardware.display.DisplayManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Display.onMessageListner {
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //requestWindowFeature(Window.FEATURE_OPTIONS_PANEL);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
       // getSupportActionBar().hide();

        if(findViewById(R.id.display)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }

            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction().add(R.id.buttouns,new Display(),null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void msg(String message) {
        textView=findViewById(R.id.textVie);
        textView.setText(message);
    }

    @Override
    public void setans(String ans) {
        textView=findViewById(R.id.textView);
        textView.setText(ans);
    }

}
