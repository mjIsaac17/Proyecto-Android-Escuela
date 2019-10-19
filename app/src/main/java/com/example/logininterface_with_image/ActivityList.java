package com.example.logininterface_with_image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    SwipeRefreshLayout swipeRefresh;
    ListView lstNumeros;
    Adapter adapter;
    int num = 0;
    ArrayList<String> numeros = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        swipeRefresh = (SwipeRefreshLayout)findViewById(R.id.swipefresh);
        lstNumeros = (ListView)findViewById(R.id.lst1);
        numeros.add(String.valueOf(num));
        lstNumeros.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, numeros));
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescarContenido();
            }
        });
    }

    public void refrescarContenido(){
        num++;
        numeros.add(String.valueOf(num));
        lstNumeros.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, numeros));
        swipeRefresh.setRefreshing(false);
    }
}
