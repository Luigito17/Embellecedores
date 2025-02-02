package com.example.examen3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2TemperaturaActivity extends AppCompatActivity {

    Button btnBackToHome;
    ImageButton btnReloadTemperature;
    TextView tvValorTemperaturaCorp, tVValorTimestamp;
    String urlConsultaTempCorp = "https://conceptos-web-2010067-eec.000webhostapp.com/consultar_temperatura_corporal.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_temperatura);

        btnBackToHome = (Button) findViewById( R.id.btnBackToHome );
        btnReloadTemperature = (ImageButton) findViewById( R.id.btnReloadTemperature );
        tvValorTemperaturaCorp = (TextView) findViewById( R.id.tvValorTemperaturaCorp );
        tVValorTimestamp = (TextView) findViewById( R.id.tVValorTimestamp );

        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // -->> Enviar a pantalla de MENU Principal
                Intent intent = new Intent(C2TemperaturaActivity.this, MenuPrincipalActivity.class);
                startActivity( intent );
                finish();
            }
        }); //--fin: btnBackToHome.clickListener()

        btnReloadTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : Actualizar temperatura [Consultar Temperatura en BD]
                consultarTemperaturaBD( urlConsultaTempCorp );
            }
        }); //--fin: btnReloadTemperature.clickListener()

        // Consultar Temperatura en BD y actualizar label 'TextView' [tvValorTemperaturacorp]...
        // String urlConsultaTempCorp = "http://192.168.100.48/ws_punto_venta_android/random_temperatures.php";

        consultarTemperaturaBD( urlConsultaTempCorp );

    } //--fin : onCreate()

    //--INI: consultarTemperaturaBD( url: String )
    private void consultarTemperaturaBD(String url){

        // String nombreCompletoTmp;
        Toast.makeText( getApplicationContext(), url, Toast.LENGTH_LONG ).show();

        // Para JsonArrayRequest :: default :: método GET de Http

        JsonArrayRequest stringArray = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                // Toast.makeText( getApplicationContext(), response.toString(), Toast.LENGTH_LONG ).show();
                // String nombreEmpleado = "";
                String strTemperatura = "", strTimestamp = "";
                int accessCode;

                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        // ctNombre.setText(jsonObject.getString("nombre"));
                        // ctEstado.setText( jsonObject.getString("estado") );
                        // Integer.toString(123)
                        // Toast.makeText(getApplicationContext(), Integer.toString( jsonObject.getInt("code") ) , Toast.LENGTH_LONG ).show();
                        accessCode = jsonObject.getInt( "code" );
                        /*
                        nombreEmpleado += jsonObject.getString( "nombre" );
                        nombreEmpleado += " ";
                        nombreEmpleado += jsonObject.getString( "ap_pat" );
                        nombreEmpleado += " ";
                        nombreEmpleado += jsonObject.getString( "ap_mat" );
                        labelMsgLogin.setText( Integer.toString(accessCode) );
                        */
                        strTemperatura = jsonObject.getString("temperatura_corp" );
                        strTimestamp = jsonObject.getString( "timestamp_temperatura" );

                        if( strTemperatura.length() > 5 ){
                            strTemperatura = strTemperatura.substring(0, 5);
                        }

                        // Toast.makeText( getApplicationContext(), nombreEmpleado, Toast.LENGTH_LONG ).show();

                        if( accessCode == 100 ){
                            // OK : Dejar pasar al Usuario...
                            // Registrar nombreCompleto en archivo Preferences..,
                            // registrarNombreEmpleado( nombreEmpleado );
                            // registrarIDEmpleado( jsonObject.getInt( "id_empleado" ) );
                            // -->> Enviar a pantalla de MENU Principal...
                            /*
                            Intent intent = new Intent(LoginActivity.this, MenuPrincipalActivity.class);
                            startActivity( intent );
                            finish();
                            */
                            tvValorTemperaturaCorp.setText( strTemperatura + " °C" );
                            tVValorTimestamp.setText( strTimestamp );
                        }else{
                            Toast.makeText( getApplicationContext(), "ERROR al recurepar Temp. Corp. del WS", Toast.LENGTH_LONG).show();
                            // labelMsgLogin.setText( "Usuario y contraseña NO coinciden." );
                        } //-- fin : IF accessCode == 100 (OK - Dejar pasar)

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add( stringArray );

        // return accessCode;
    }
    //++FIN: consultarTemperaturaBD( url: String )

} //--FIN :: Clase :: C2TemperaturaActivity