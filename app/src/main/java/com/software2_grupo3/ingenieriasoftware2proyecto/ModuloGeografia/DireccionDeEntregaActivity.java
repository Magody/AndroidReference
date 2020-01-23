package com.software2_grupo3.ingenieriasoftware2proyecto.ModuloGeografia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Utilidad;
import com.software2_grupo3.ingenieriasoftware2proyecto.ModuloAdministracion.Parametros;
import com.software2_grupo3.ingenieriasoftware2proyecto.R;

import static android.util.Log.e;

public class DireccionDeEntregaActivity extends FragmentActivity
        implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, DireccionDeEntregaContracts.View {

    public static final String TAG = "MapaDireccionActivity";
    private double latitud, longitud;


    private Location currentLocation;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE_FINE_LOCATION = 101;

    private AlertDialog alertDialogPermisos;

    private ProgressBar progressBar;


    private DireccionDeEntregaContracts.Presenter mapDirPresenter;

    @Override
    public void volver(View view){

        if(view == null){
            setResult(RESULT_OK);
        }else{
            Intent intent = new Intent();
            intent.putExtra(Parametros.DIRECTORIO_RAM_BOOLEAN_VOLVER_DE_MAPA, true);
            setResult(RESULT_CANCELED, intent);
        }

        onBackPressed();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion_de_entrega);

        progressBar = findViewById(R.id.progressBarDireccionDeEntrega);
        mapDirPresenter = new DireccionDeEntregaPresenter(this, this);
        inicializarAlertaPermisosUbicacion();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();


        Bundle bundle = getIntent().getExtras();

        if(bundle != null){

            //se envía latitud y longitud cuando ha sido previamente registrada entre los datos del cliente
            latitud = bundle.getDouble(Parametros.DIRECTORIO_RAM_DOUBLE_LATITUD, 0.0);
            longitud = bundle.getDouble(Parametros.DIRECTORIO_RAM_DOUBLE_LONGITUD, 0.0);



        }else{
            latitud = 0.0;
            longitud = 0.0;
        }

        findViewById(R.id.buttonConfirmarDireccionEnvio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(latitud != 0.0 && longitud != 0.0){
                    mapDirPresenter.enBotonConfirmarPresionado(latitud, longitud);
                }else{
                    mostrarToast(getString(R.string.errorNoSePudoLeerLaPosicion));
                    e(TAG, "buttonConfirmarDireccionEnvio: onClick : " + "Latitud y longitud iguales a 0");
                }
            }
        });




    }

    private void inicializarAlertaPermisosUbicacion(){

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.textoTituloPermisoDeUbicacion);
        builder.setMessage(R.string.msgDebeAceptarElPermisoDeUbicacion);

        builder.setPositiveButton(R.string.stringAceptar, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                //solicita el permiso
                ActivityCompat.requestPermissions(DireccionDeEntregaActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_FINE_LOCATION);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(R.string.stringVolver, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                onBackPressed();
                dialog.dismiss();
            }
        });


        alertDialogPermisos = builder.create();
    }

    private void fetchLastLocation(){

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_FINE_LOCATION);
            return;
        }

        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    currentLocation = location;

                    if(latitud == 0.0 && longitud == 0.0){
                        latitud = currentLocation.getLatitude();
                        longitud = currentLocation.getLongitude();
                    }

                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.direccionDeEntregaMap);
                    if(supportMapFragment != null){
                        supportMapFragment.getMapAsync(DireccionDeEntregaActivity.this);

                    }else{
                        mostrarToast("El fragmento del mapa no ha sido inicializado. Avise a los administradores.");
                    }
                }
            }
        });


    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        if(latitud == 0.0 && longitud == 0.0){
            latitud = currentLocation.getLatitude();
            longitud = currentLocation.getLongitude();
        }

        LatLng latLng = new LatLng(latitud, longitud);

        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(getString(R.string.textoUbicacionActual));

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));
        googleMap.addMarker(markerOptions);

        googleMap.setMyLocationEnabled(true);

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                /*
                allPoints.add(point);
                map.clear();
                map.addMarker(new MarkerOptions().position(point));
                * */


                MarkerOptions marker = new MarkerOptions().position(new LatLng(point.latitude, point.longitude)).title(getString(R.string.textoUbicacionActual));
                googleMap.clear();
                googleMap.addMarker(marker);

                latitud = point.latitude;
                longitud = point.longitude;


                mostrarToast("("+latitud+","+longitud+")");
                Log.i(TAG, point.latitude + "," + point.longitude);
            }
        });

        buildGoogleApiClient();


    }

    protected synchronized void buildGoogleApiClient(){
        GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_FINE_LOCATION){
            if(grantResults.length > 0){
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    fetchLastLocation();
                }else{
                    alertDialogPermisos.show();
                }
            }
        }
    }

    public void mostrarToast(String mensaje){
        Utilidad.mostrarToast(this, mensaje, Toast.LENGTH_LONG);
    }

    @Override
    public void mostrarProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void salirDeAplicacion() {
        setResult(RESULT_CANCELED);
        onBackPressed();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
