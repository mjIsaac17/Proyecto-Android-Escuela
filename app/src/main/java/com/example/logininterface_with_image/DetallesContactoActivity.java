package com.example.logininterface_with_image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DetallesContactoActivity extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_contacto);

        Bundle params = getIntent().getExtras();
        String nombre = params.getString("nombre");
        String tel = params.getString("telefono");
        String email = params.getString("email");

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        tvEmail = (TextView)findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvEmail.setText(email);
        tvTelefono.setText(tel);
    }

    public void llamar(View view){
        Log.i("Mensaje", "Llamada");
        String tel = tvTelefono.getText().toString();
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }

        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+tel)));
    }

    public void enviarEmail(View view){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailTo:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email); //cc, subject,text, se deben agregar mas putExtra para las otras modalidades
        emailIntent.setType("message/rfc822"); //codigo para solo abrir en el gmail
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }
}
