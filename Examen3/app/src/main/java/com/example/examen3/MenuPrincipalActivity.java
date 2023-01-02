package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipalActivity extends AppCompatActivity {

    Button btnMenuOptC1Huella, btnMenuOptC2Temperatura, btnMenuOptC3LucesOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnMenuOptC1Huella = (Button) findViewById( R.id.btnMenuOptC1Huella );
        btnMenuOptC2Temperatura = (Button) findViewById( R.id.btnMenuOptC2Temperatura );
        btnMenuOptC3LucesOff = (Button) findViewById( R.id.btnMenuOptC3LucesOff );

        btnMenuOptC1Huella.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //TODO: Redirigir a la Pantalla (Acticity) :: Circuito 1: Huella
            }
        }); //--fin: btnMenuOptC1Huella.clickListener()

        btnMenuOptC2Temperatura.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //TODO: Redirigir a la Pantalla (Acticity) :: Circuito 2: Temperatura Corporal
            }
        }); //--fin: btnMenuOptC2Temperatura.clickListener()

        btnMenuOptC3LucesOff.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //TODO: Redirigir a la Pantalla (Acticity) :: Circuito 3: Luces de Oficina
            }
        }); //--fin: btnMenuOptC3LucesOff.clickListener()

    }//--fin : onCreate()

} //--FIN :: Clase :: MenuPrincipalActivity