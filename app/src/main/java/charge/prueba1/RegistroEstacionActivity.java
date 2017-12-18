package charge.prueba1;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistroEstacionActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etnombre, etcargadores, etprice1, etprice2, etenergia, etlongitud, etlatitud;
    Button bt_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_estacion);

        etnombre = (EditText) findViewById(R.id.et_nombreestacion);
        etprice1 = (EditText) findViewById(R.id.et_price1);
        etprice2 = (EditText) findViewById(R.id.et_price2);
        etcargadores = (EditText) findViewById(R.id.cargadores);
        etenergia = (EditText) findViewById(R.id.energia);
        etlongitud = (EditText) findViewById(R.id.et_longitud);
        etlatitud = (EditText) findViewById(R.id.et_latitud);

        bt_add = (Button) findViewById(R.id.btn_add);

        bt_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final String name = etnombre.getText().toString();
        final String price1 = etprice1.getText().toString();
        final String price2 = etprice2.getText().toString();
        final int cargadores = Integer.parseInt(etcargadores.getText().toString());
        final int energy = Integer.parseInt(etenergia.getText().toString());
        final String longitude = etlongitud.getText().toString();
        final String latitude = etlatitud.getText().toString();


        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Estación Añadida", Toast.LENGTH_SHORT);

                        toast1.show();
                        Intent intent = new Intent(RegistroEstacionActivity.this, Main3Activity.class);
                        RegistroEstacionActivity.this.startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegistroEstacionActivity.this);
                        builder.setMessage("Error registro")
                                .setNegativeButton("Retry", null)
                                .create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RegisterEstacionRequest registerEstacionRequest = new RegisterEstacionRequest(name, price1, price2, cargadores, energy, latitude, longitude, respoListener);
        RequestQueue queue = Volley.newRequestQueue(RegistroEstacionActivity.this);
        queue.add(registerEstacionRequest);

    }
}
