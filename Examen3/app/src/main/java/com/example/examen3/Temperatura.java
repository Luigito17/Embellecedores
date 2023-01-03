package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;

public class Temperatura extends AppCompatActivity {
    TableLayout tabTemperaturas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        tabTemperaturas =  findViewById(R.id.tabTemperaturas);
        tabTemperaturas.removeAllViews();



    }
}