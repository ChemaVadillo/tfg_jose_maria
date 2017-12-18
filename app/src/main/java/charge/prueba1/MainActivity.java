package charge.prueba1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button siguiente;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
////        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        //toolbar.setNavigationIcon(R.drawable.ic_toolbar);
//        toolbar.setTitle("");
//        toolbar.setSubtitle("");
        siguiente = (Button)findViewById(R.id.button5);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {

                Intent siguiente = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(siguiente);

            }
        });
    }
}
