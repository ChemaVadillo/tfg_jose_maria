package charge.prueba1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etnombre, etusuario, etpassword, etedad, etemail, etdni, etpais, ettelefono;
    Button bt_registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etnombre = (EditText) findViewById(R.id.et_nombre);
        etusuario = (EditText) findViewById(R.id.et_usuario);
        etpassword = (EditText) findViewById(R.id.et_password);
        etedad = (EditText) findViewById(R.id.et_edad);
        etemail = (EditText) findViewById(R.id.userEmail);
        etdni = (EditText) findViewById(R.id.userdni);
        etpais = (EditText) findViewById(R.id.pais);
        ettelefono = (EditText) findViewById(R.id.telefono);

        bt_registrar = (Button) findViewById(R.id.btn_aceptar);

        bt_registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        final String name = etnombre.getText().toString();
        final String username = etusuario.getText().toString();
        final String password = etpassword.getText().toString();
        final String age = etedad.getText().toString();
        final String email = etemail.getText().toString();
        final String dni = etdni.getText().toString();
        final String pais = etpais.getText().toString();
        final int telefono = Integer.parseInt(ettelefono.getText().toString());

        if (TextUtils.isEmpty(name) && TextUtils.isEmpty(username) && TextUtils.isEmpty(password) && TextUtils.isEmpty(etedad.getText().toString()) && TextUtils.isEmpty(email)
                && TextUtils.isEmpty(dni) && TextUtils.isEmpty(pais) && TextUtils.isEmpty(ettelefono.getText().toString())) {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Los campos no pueden estar vacios", Toast.LENGTH_SHORT);

            toast1.show();
            return;
        } else if (TextUtils.isEmpty(username)) {
            etusuario.setError("Usuario no puede estar vacio");
            return;
        } else if (TextUtils.isEmpty(password)) {
            etpassword.setError("Password no puede estar vacio");
            return;
        } else if (TextUtils.isEmpty(etedad.getText().toString())) {
            etedad.setError("Edad no puede estar vacio");
            return;
        } else if (TextUtils.isEmpty(email)) {
            etemail.setError("Email no puede estar vacio");
            return;
        }else if (password.length()< 6){
            etpassword.setError("La longitud de la contraseña tiene que ser de almenos 6 dígitos");
        } else if (TextUtils.isEmpty(dni)) {
            etdni.setError("DNI no puede estar vacio");
            return;
        } else if (TextUtils.isEmpty(pais)) {
            etpais.setError("Pais no puede estar vacio");
            return;
        } else if (TextUtils.isEmpty(ettelefono.getText().toString())) {
            ettelefono.setError("Telefono no puede estar vacio");
            return;
        } else if (!isEmailValid(email)) {
            etemail.setError("El formato del email no es válido");
            return;
       } else if(TextUtils.isEmpty(name)) {
            etnombre.setError("Nombre no puede estar vacio");
            return;
        }
        else {


            Response.Listener<String> respoListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");

                        if (success) {
                            Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                            RegistroActivity.this.startActivity(intent);
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegistroActivity.this);
                            builder.setMessage("Error registro")
                                    .setNegativeButton("Retry", null)
                                    .create().show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };

            RegisterRequest registerRequest = new RegisterRequest(name, username, age, password, email, pais, dni, telefono, respoListener);
            RequestQueue queue = Volley.newRequestQueue(RegistroActivity.this);
            queue.add(registerRequest);

        }
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



}
