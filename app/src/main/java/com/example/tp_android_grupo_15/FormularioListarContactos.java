package com.example.tp_android_grupo_15;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import Entidades.Contacto;
import OpenHelper.OpenHelper;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FormularioListarContactos extends AppCompatActivity {

    private ListView lvContactos;
    private ArrayList<Contacto> listaContactosOriginal;
    private ArrayList<String> listaParaMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);androidx.activity.EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_listar_contactos);

        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            androidx.core.graphics.Insets systemBars = insets.getInsets(androidx.core.view.WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Listado de Contactos");
        }
        lvContactos = findViewById(R.id.lvContactos);

        OpenHelper dbHelper = new OpenHelper(this, "ContactosDB", null, 1);
        listaContactosOriginal = dbHelper.getListadoContactos();
        listaParaMostrar = new ArrayList<>();

        for (Contacto c : listaContactosOriginal) {
           String formato = c.getNombre().toUpperCase() + " " + c.getApellido().toUpperCase() + " - " + c.getEmail().toUpperCase();
            listaParaMostrar.add(formato);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaParaMostrar
        );
        lvContactos.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();

        if (id == R.id.AgregarContactos) {
            Intent intent = new Intent(this, FormularioAgregarContactos.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.ListadoContactos) {
            Intent intent = new Intent(this, FormularioListarContactos.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}