package com.example.logininterface_with_image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactosActivity extends AppCompatActivity {

    ArrayList<ClassContacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);
        contactos = new ArrayList<ClassContacto>();

        contactos.add(new ClassContacto("Isaac Montes", "6461997110", "isaac@gmail.com"));
        contactos.add(new ClassContacto("Ana Hernandez", "6467746657", "ana@gmail.com"));
        contactos.add(new ClassContacto("Daniel Lopez", "6461785230", "daniel@gmail.com"));
        contactos.add(new ClassContacto("Susan Diaz", "6461997110", "susan@gmail.com"));

        ArrayList<String> nombresContactos = new ArrayList<>();
        for(ClassContacto contacto: contactos){
            nombresContactos.add(contacto.getNombre());
        }

        ListView lstContactos = (ListView)findViewById(R.id.lstContactos);
        //el simple_list_item_1 es para agregar solo el primer element en el list view, y no el subtutulo
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContactos));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ContactosActivity.this, DetallesContactoActivity.class);
                intent.putExtra("nombre", contactos.get(i).getNombre());
                intent.putExtra("telefono", contactos.get(i).getTelefono());
                intent.putExtra("email", contactos.get(i).getEmail());
                startActivity(intent);
            }
        });

    }


}
