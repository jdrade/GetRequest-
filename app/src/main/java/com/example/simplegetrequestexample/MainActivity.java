package com.example.simplegetrequestexample;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.simplegetrequestexample.fragments.DetallePersonajeFragment;
import com.example.simplegetrequestexample.fragments.ListaPersonajeFragment;

public class MainActivity extends AppCompatActivity implements ListaPersonajeFragment.OnFragmentInteractionListener, DetallePersonajeFragment.OnFragmentInteractionListener{

    ListaPersonajeFragment listaFragment;
    DetallePersonajeFragment detalleFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaFragment = new ListaPersonajeFragment();
        detalleFragment = new DetallePersonajeFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,listaFragment).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
