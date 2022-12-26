package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity3 extends AppCompatActivity {
    Button btnTemperatura, btnpuertaabierta, btnpuertacerrado,btnluzprendida,btnluzapagar;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnTemperatura = findViewById(R.id.btnTemperatura);
        btnpuertaabierta = findViewById(R.id.btnpuertaabierta);
        btnpuertacerrado = findViewById(R.id.btnpuertacerrado);
        btnluzprendida = findViewById(R.id.btnluzprendida);
        btnluzapagar = findViewById(R.id.btnluzapagar);

        btnluzapagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizar("http://192.168.114.225/serviceexamen/regprodfact.php");

            }
        });


        btnluzprendida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizar("http://192.168.114.225/serviceexamen/regprodfact.php");

            }
        });


        btnpuertacerrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizar("http://192.168.114.225/serviceexamen/regprodfact.php");

            }
        });


        btnpuertaabierta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizar("http://192.168.114.225/serviceexamen/regprodfact.php");

            }
        });

    }
    private void actualizar(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "operción realiizada", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }



}