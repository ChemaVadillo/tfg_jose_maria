package charge.prueba1;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng madrid = new LatLng(40.423838, -3.711283);
        LatLng stacion1 = new LatLng(40.3818, 1.685);
        LatLng stacion2 = new LatLng(42.2603, -2.93341);
        LatLng stacion3 = new LatLng(42.7125, -8.4188010);
        LatLng stacion4 = new LatLng(37.1410, -5.95917);

        Marker Usuario = mMap.addMarker(new MarkerOptions().position(madrid).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_usuario)));
        Marker estacion1 = mMap.addMarker(new MarkerOptions().position(stacion1).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_estacion)));
        Marker estacion2 = mMap.addMarker(new MarkerOptions().position(stacion2).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_estacion)));
        Marker estacion3 = mMap.addMarker(new MarkerOptions().position(stacion3).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_estacion)));
        Marker estacion4 = mMap.addMarker(new MarkerOptions().position(stacion4).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_estacion)));
        float zoomLevel = 5.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(madrid, zoomLevel));




    }
}
