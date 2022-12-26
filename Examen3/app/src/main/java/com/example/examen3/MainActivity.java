package com.example.examen3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo prompInfo;
    LinearLayout mMainLayout ;
    ImageButton btnluz, btnpuerta;
    Boolean estadoBoton, estadoPuerta;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estadoBoton = true;
        estadoPuerta = true;
        mMainLayout = findViewById(R.id.main_layout);
        btnluz = findViewById(R.id.btnluz);
        btnluz.setImageResource(R.drawable.encendido);

        btnpuerta = findViewById(R.id.btnpuerta);
        btnpuerta.setImageResource(R.drawable.abierta);

        /////////////////////Inicio de desbloqueo por huella|||||||||||||||||||||||
        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()){
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getApplicationContext(), "El dispositivo no tiene huella digital", Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getApplicationContext(), "Not woring", Toast.LENGTH_SHORT).show();

            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getApplicationContext(), "No se ha asignado la huella dactilar", Toast.LENGTH_SHORT).show();

        }

        Executor executor = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(MainActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(), "Acceso exitoso", Toast.LENGTH_SHORT).show();
                mMainLayout.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }

        });

        prompInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("ISC Proyectos").setDescription("Utilizar la huella dactilar para iniciar sesión").setDeviceCredentialAllowed(true).build();

        biometricPrompt.authenticate(prompInfo);
        /////////////////////////Fin de desboqueo de huella////////////////////////////////////

        btnluz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (estadoBoton == true){
                    //cambia la imgen 1 por la 2
                    btnluz.setImageResource(R.drawable.apagado);
                    //cambia el estado del boton
                    estadoBoton = false;



                }else{
                    //cambia la imagen 2 por la 1
                    btnluz.setImageResource(R.drawable.encendido);
                    //cmbie le estado del boton
                    estadoBoton = true;
                }

            }
        });

        btnpuerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (estadoPuerta == true){
                    //cambia la imgen 1 por la 2
                    btnpuerta.setImageResource(R.drawable.cerrada);
                    //cambia el estado del boton
                    estadoPuerta = false;



                }else{
                    //cambia la imagen 2 por la 1
                    btnpuerta.setImageResource(R.drawable.abierta);
                    //cmbie le estado del boton
                    estadoPuerta = true;
                }

            }
        });





    }

}