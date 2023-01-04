package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ControlLuz extends AppCompatActivity {
    Switch switch2;
    Integer  statusLuz;
    ImageButton btniLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_luz);
        switch2 = findViewById(R.id.switch2);
        btniLuz = findViewById(R.id.btniLuz);
        statusLuz = 1;

        validarstatusLuz();


        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (statusLuz == 1) {
                    statusLuz = 0;
                    validarstatusLuz();
                } else {
                    statusLuz = 1;
                    validarstatusLuz();
                }

            }
        });
    }



    public void validarstatusLuz(){
        if (statusLuz==1){//Cuando el switch es checado
            switch2.setChecked(true);
            switch2.setText("Apagar la luz");
            btniLuz.setImageResource(R.drawable.encendido);
            Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();

        }else{
            switch2.setChecked(false);
            switch2.setText("Encender la luz");
            btniLuz.setImageResource(R.drawable.apagado);
            Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show();


        }
    }
}