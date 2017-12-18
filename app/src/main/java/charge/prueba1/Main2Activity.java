package charge.prueba1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    Button siguiente1;
    TextView tvNombre, tvTelefono, tvDni, tvAge, tvEmail, tvPassword, tvModelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_perfil);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String password = intent.getStringExtra("password");
        final String age = intent.getStringExtra("age");
        final String email = intent.getStringExtra("email");
        final String dni = intent.getStringExtra("dni");
        final String telefono = intent.getStringExtra("telefono");
        final String pais = intent.getStringExtra("pais");

        tvNombre = (TextView) findViewById(R.id.user_profile_name);
        tvPassword = (TextView) findViewById(R.id.password) ;
        tvAge = (TextView) findViewById(R.id.edad);
        tvEmail = (TextView) findViewById(R.id.email);
        tvDni = (TextView) findViewById(R.id.documento);
        tvTelefono = (TextView) findViewById(R.id.telefono);
        tvModelo = (TextView) findViewById(R.id.modelo);


        tvNombre.setText(name);
        tvPassword.setText("Contraseña: " +password);
        tvAge.setText("Matrícula: " +age);
        tvEmail.setText("Email: " +email);
        tvDni.setText("DNI: " + dni);
        tvTelefono.setText("Telefono: "+telefono);
        tvModelo.setText("Modelo de coche: "+pais);


//
//
//       tvUsuario.setText(name);

//       tvUsuario = (TextView) findViewById(R.id.textView2);
//
//
//       tvUsuario.setText(name);
//        siguiente1 = (Button)findViewById(R.id.button2);
//
//        siguiente1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View w) {
//
//                Intent siguiente = new Intent(Main2Activity.this, MainActivity.class);
//                startActivity(siguiente);

            }
//        });

    }
//}
