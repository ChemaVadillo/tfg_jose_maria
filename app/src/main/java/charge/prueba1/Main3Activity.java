package charge.prueba1;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Main3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {
    private GoogleMap mMap;
    TextView tvNombre , tvUsuario, tvEdad, tvPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayShowTitleEnabled(false);
        // toolbar.setNavigationIcon(R.drawable.ic_toolbar);
        toolbar.setTitle("");
        toolbar.setSubtitle("");



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Intent intent = getIntent();
        final String username = intent.getStringExtra("username");

//       tvUsuario = (TextView) findViewById(R.id.textView2);
//
//
//       tvUsuario.setText(name);

    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        final LatLng madrid1 = new LatLng(40.423838, -3.711283);
        final LatLng stacion11 = new LatLng(40.437428, -3.704321);
        final LatLng stacion22 = new LatLng(40.417020, -3.695384);
        final LatLng stacion33 = new LatLng(40.405854, -3.707070);
        final LatLng stacion44 = new LatLng(40.409736, -3.728266);


        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            private final View v = getLayoutInflater().inflate(R.layout.info_window, null);

            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {


                Location loc1 = new Location("");
                loc1.setLatitude(marker.getPosition().latitude);
                loc1.setLongitude(marker.getPosition().longitude);
                Location loc2 = new Location("");
                final double feetToMeters = 0.000000305;
                float f = (float)feetToMeters;
                float distanceInMeters = loc1.distanceTo(loc2)*f;

                ImageView icono = (ImageView) v.findViewById(R.id.icono);
                TextView tvEstacion = (TextView) v.findViewById(R.id.tv_estacion);
                TextView tvPrecioCharge = (TextView) v.findViewById(R.id.tv_precio_charge);
                TextView tvPrecioRed = (TextView) v.findViewById(R.id.tv_precio_red);
                TextView tvCargadores = (TextView) v.findViewById(R.id.tv_cargadores);
                TextView tvEnergia = (TextView) v.findViewById(R.id.tv_energia);
                TextView tvDistancia = (TextView) v.findViewById(R.id.tv_distancia);

                if (marker.getPosition().equals(stacion11)) {

                    loc2.setLatitude(stacion11.latitude);
                    loc2.setLongitude(stacion11.longitude);


                    icono.setImageResource(R.drawable.ic_estacion);
                    tvEstacion.setText("Estación 1");
                    tvPrecioCharge.setText(("Precio Charge4Less 2 €/kWh"));
                    tvPrecioRed.setText("Precio Red Electrica 3 €/kWH");
                    tvPrecioRed.setTextSize(14);
                    tvCargadores.setText("Número de cargadores: 3");
                    tvEnergia.setText("Energía disponible 200 kWh");
                    tvDistancia.setText("Distancia: " + distanceInMeters + " km");
                } else if (marker.getPosition().equals(stacion22)) {

                    loc2.setLatitude(stacion22.latitude);
                    loc2.setLongitude(stacion22.longitude);

                    icono.setImageResource(R.drawable.ic_estacion);
                    tvEstacion.setText("Estación 2");
                    tvPrecioCharge.setText(("Precio Charge4Less 2.5 €/kWh"));
                    tvPrecioRed.setText("Precio Red Electrica 3.0 €/kWH");
                    tvPrecioRed.setTextSize(14);
                    tvCargadores.setText("Número de cargadores: 2");
                    tvEnergia.setText("Energía disponible 150 kWh");
                    tvDistancia.setText("Distancia: " + distanceInMeters + " km");
                } else if (marker.getPosition().equals(stacion33)) {

                    loc2.setLatitude(stacion33.latitude);
                    loc2.setLongitude(stacion33.longitude);

                    icono.setImageResource(R.drawable.ic_estacion);
                    tvEstacion.setText("Estación 3");
                    tvPrecioCharge.setText(("Precio Charge4Less  1 €/kWh"));
                    tvPrecioRed.setText("Precio Red Electrica 2.4 €/kWH");
                    tvPrecioRed.setTextSize(14);
                    tvCargadores.setText("Número de cargadores: 1");
                    tvEnergia.setText("Energía disponible 100 kWh");
                    tvDistancia.setText("Distancia: " + distanceInMeters + " km");
                } else if (marker.getPosition().equals(stacion44)) {


                    loc2.setLatitude(stacion44.latitude);
                    loc2.setLongitude(stacion44.longitude);

                    icono.setImageResource(R.drawable.ic_estacion);
                    tvEstacion.setText("Estacion 4");
                    tvPrecioCharge.setText(("Precio Charge4Less 2.7 €/kWh"));
                    tvPrecioRed.setText("Precio Red Electrica 4 €/kWH");
                    tvPrecioRed.setTextSize(14);
                    tvCargadores.setText("Número de cargadores: 5");
                    tvEnergia.setText("Energía disponible 40 kWh");
                    tvDistancia.setText("Distancia: " + distanceInMeters + " km");

                } else if(marker.getPosition().equals(madrid1)){
                    icono.setImageResource(R.drawable.ic_marker_usuario);
                    tvEstacion.setText("");
                    tvPrecioCharge.setText((""));
                    tvPrecioRed.setText("Tu posición");
                    tvPrecioRed.setTextSize(20);
                    tvCargadores.setText("");
                    tvEnergia.setText("");
                    tvDistancia.setText("");
                }

                return v;

            }

        });

        LatLng madrid = new LatLng(40.423838, -3.711283);
        LatLng stacion1 = new LatLng(40.437428, -3.704321);
        LatLng stacion2 = new LatLng(40.417020, -3.695384);
        LatLng stacion3 = new LatLng(40.405854, -3.707070);
        LatLng stacion4 = new LatLng(40.409736, -3.728266);

        Marker Usuario = mMap.addMarker(new MarkerOptions().position(madrid).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_usuario)));
        Marker estacion1 = mMap.addMarker(new MarkerOptions().position(stacion1).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_estacion)));
        Marker estacion2 = mMap.addMarker(new MarkerOptions().position(stacion2).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_estacion)));
        Marker estacion3 = mMap.addMarker(new MarkerOptions().position(stacion3).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_estacion)));
        Marker estacion4 = mMap.addMarker(new MarkerOptions().position(stacion4).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_estacion)));
        float zoomLevel = 13.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(madrid, zoomLevel));

    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent siguiente = new Intent(Main3Activity.this, MainActivity.class);
            startActivity(siguiente);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String password = intent.getStringExtra("password");
        final String edad = intent.getStringExtra("age");
        final String email = intent.getStringExtra("email");
        final String dni = intent.getStringExtra("dni");
        final String telefono = intent.getStringExtra("telefono");
        final String pais = intent.getStringExtra("pais");
        int id = item.getItemId();

        if (id == R.id.mi_perfil) {
            // Handle the camera action

            Intent siguiente = new Intent(Main3Activity.this, Main2Activity.class);
            siguiente.putExtra("name", name);
            siguiente.putExtra("password", password);
            siguiente.putExtra("age", edad);
            siguiente.putExtra("email", email);
            siguiente.putExtra("dni", dni);
            siguiente.putExtra("telefono", telefono);
            siguiente.putExtra("pais", pais);
            startActivity(siguiente);

        } else if (id == R.id.nav_gallery) {

            Intent siguiente = new Intent(Main3Activity.this, MapsActivity.class);

//            intent.putExtra("username", tvUsuario);
//            intent.putExtra("age", tvEdad);
//            intent.putExtra("password", tvPassword);
            startActivity(siguiente);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

            Intent siguiente = new Intent(Main3Activity.this, RegistroEstacionActivity.class);
            startActivity(siguiente);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_sesion){
            Intent siguiente = new Intent(Main3Activity.this, LoginActivity.class);
            startActivity(siguiente);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
