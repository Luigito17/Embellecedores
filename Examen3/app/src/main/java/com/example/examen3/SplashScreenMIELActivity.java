package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenMIELActivity extends AppCompatActivity {

    static final long SPLASH_SCREEN_DELAY = 5000;

    TextView labelWelcomeMessage, labelSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_mielactivity);

        labelWelcomeMessage = (TextView) findViewById( R.id.labelWelcomeMessage );
        labelSlogan = (TextView) findViewById( R.id.labelSlogan );

        // -->> Abrir Pantalla de MainActivity [MainActivity] ::
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenMIELActivity.this, MenuPrincipalActivity.class);
                startActivity( intent );
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule( task, SPLASH_SCREEN_DELAY );

        Animation animation1 = AnimationUtils.loadAnimation( SplashScreenMIELActivity.this, R.anim.animation2 );
        labelWelcomeMessage.startAnimation( animation1 );

        Animation animation2 = AnimationUtils.loadAnimation( SplashScreenMIELActivity.this, R.anim.animation1 );
        labelSlogan.startAnimation( animation2 );

    } //--fin : onCreate()

} //-- FIN :: Clase :: SplashScreenMIELActivity