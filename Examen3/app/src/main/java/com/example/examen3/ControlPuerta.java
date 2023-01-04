package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ControlPuerta extends AppCompatActivity {
    Switch switch1;
    Integer statusPuer;
    ImageButton btniPuer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_puerta);
        switch1 = findViewById(R.id.switch1);
        btniPuer = findViewById(R.id.btniPuer);
        statusPuer = 1;
        btniPuer.setBackgroundDrawable(null);


        validarstatusPuer();

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (statusPuer == 1) {
                    statusPuer = 0;
                    validarstatusPuer();
                } else {
                    statusPuer = 1;
                    validarstatusPuer();
                }
            }
        });


    }

    public void validarstatusPuer(){
        if (statusPuer==1){//Cuando el switch es checado
            switch1.setChecked(true);
            switch1.setText("Cerrar la puerta");
            btniPuer.setImageResource(R.drawable.abierta);
            Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();

        }else{
            switch1.setChecked(false);
            switch1.setText("Abrir la puerta");
            btniPuer.setImageResource(R.drawable.cerrada);
            Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show();

        }

    }



}