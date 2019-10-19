package com.example.logininterface_with_image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //Button btnSingIn = findViewById(R.id.btn_signIn);
    SwipeRefreshLayout swipeRefresh;
    ListView lstNumeros;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensajeFAB();
        Toast.makeText(this,getResources().getString(R.string.onCreate), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, getResources().getString(R.string.onStart), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, getResources().getString(R.string.onResume), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, getResources().getString(R.string.onRestart), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, getResources().getString(R.string.onPause), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, getResources().getString(R.string.onStop), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, getResources().getString(R.string.onDestroy), Toast.LENGTH_SHORT).show();
    }

    public void verCards(View view){
        startActivity(new Intent(this, CardView.class));
    }

    
    public void signIn(View view){
        //Toast.makeText(this, "No puedes iniciar sesión en este momento", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, ContactosActivity.class));
    }

    public void mensajeFAB(){
        FloatingActionButton fabButton = findViewById(R.id.fab_flotante);
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Imprime este mensaje", Toast.LENGTH_SHORT).show();
                //Snackbar.make(view, "Mensaje por Snack", Snackbar.LENGTH_SHORT).show();
                Snackbar.make(view, "Mensaje por Snack", Snackbar.LENGTH_SHORT)
                        .setAction("La accion", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("Snack", "Mi boton snack");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();
            }
        });
    }
}
