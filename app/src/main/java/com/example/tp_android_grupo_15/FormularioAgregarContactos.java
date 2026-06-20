package com.example.tp_android_grupo_15;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormularioAgregarContactos extends AppCompatActivity {

    private EditText etNombre;
    private EditText etApellido;
    private EditText etTelefono;
    private EditText etEmail;
    private Spinner spinnerTelefono, spinnerEmail;
    private android.widget.Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_agregar_contactos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etTelefono = findViewById(R.id.etTelefono);

        etEmail = findViewById(R.id.etEmail);

        spinnerTelefono = findViewById(R.id.spinnerTelefono);
        spinnerEmail = findViewById(R.id.spinnerEmail);

        // Spinners
        String[] opcionesSpinner = {"Casa", "Trabajo", "Móvil"};

        android.widget.ArrayAdapter<String> adapter = new android.widget.ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTelefono.setAdapter(adapter);
        spinnerEmail.setAdapter(adapter);


        btnContinuar = findViewById(R.id.btnContinuar);
        btnContinuar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                boolean esValido = Validaciones();

                if (esValido) {
                    //  Para pruebas eliminar  despues
                    android.widget.Toast.makeText(FormularioAgregarContactos.this,
                            "Estamos Ok!",
                            android.widget.Toast.LENGTH_LONG).show();
                } else {
                   android.widget.Toast.makeText(FormularioAgregarContactos.this,
                            "Hay errores en el formulario",
                            android.widget.Toast.LENGTH_LONG).show();
                }
            }
        });
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
    public boolean Validaciones(){
        boolean estado = true;

        etNombre.setError(null);
        etApellido.setError(null);
        etTelefono.setError(null);
        etEmail.setError(null);

        if(etNombre.getText().toString().isEmpty()){
            etNombre.setError("Campo requerido");
            estado = false;
        }
        else{

            if(!etNombre.getText().toString().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                etNombre.setError("No se permiten numeros");
                estado = false;
            }
        }
        if(etApellido.getText().toString().isEmpty()){
            etApellido.setError("Campo requerido");
            estado = false;
        }
        else{

            if(!etApellido.getText().toString().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                etApellido.setError("No se permiten numeros");
                estado = false;
            }
        }
        if(etTelefono.getText().toString().isEmpty()){
            etTelefono.setError("Campo requerido");
            estado = false;
        }
        else{
            if(!etTelefono.getText().toString().matches("[0-9-]+")){
                etTelefono.setError("No se permiten letras");
                estado = false;
            }

        }
        String email = etEmail.getText().toString().trim();
        if (email.isEmpty()) {
            etEmail.setError("Campo requerido");
            estado = false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Ingrese un email válido");
            estado = false;
        }

        return estado;
        
    }
}