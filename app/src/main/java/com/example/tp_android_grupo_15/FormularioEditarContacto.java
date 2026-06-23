package com.example.tp_android_grupo_15;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import OpenHelper.OpenHelper;

public class FormularioEditarContacto extends AppCompatActivity {

    private EditText etNombre, etApellido, etTelefono, etEmail, etDireccion, etFechaNacimiento;
    private Spinner spinnerTelefono, spinnerEmail;
    private RadioGroup radioGroupEstudios;
    private CheckBox cbDeporte, cbMusica, cbArte, cbTecnologia;
    private Switch switchSiNo;
    private int idContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_editar_contacto);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Editar Contacto");


        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDireccion = findViewById(R.id.etDireccion);
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        spinnerTelefono = findViewById(R.id.spinnerTelefono);
        spinnerEmail = findViewById(R.id.spinnerEmail);
        radioGroupEstudios = findViewById(R.id.radioGroupEstudios);
        cbDeporte = findViewById(R.id.cbDeporte);
        cbMusica = findViewById(R.id.cbMusica);
        cbArte = findViewById(R.id.cbArte);
        cbTecnologia = findViewById(R.id.cbTecnologia);
        switchSiNo = findViewById(R.id.switchSiNo);


        String[] opciones = {"Casa", "Trabajo", "Móvil"};
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, opciones);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTelefono.setAdapter(adapterSpinner);
        spinnerEmail.setAdapter(adapterSpinner);


        idContacto = getIntent().getIntExtra("ID", -1);
        etNombre.setText(getIntent().getStringExtra("NOMBRE"));
        etApellido.setText(getIntent().getStringExtra("APELLIDO"));
        etTelefono.setText(getIntent().getStringExtra("TELEFONO"));
        etEmail.setText(getIntent().getStringExtra("EMAIL"));
        etDireccion.setText(getIntent().getStringExtra("DIRECCION"));
        etFechaNacimiento.setText(getIntent().getStringExtra("FECHANACIMIENTO"));


        setSpinner(spinnerTelefono, opciones, getIntent().getStringExtra("TIPOTELEFONO"));
        setSpinner(spinnerEmail, opciones, getIntent().getStringExtra("TIPOEMAIL"));


        String nivelEstudios = getIntent().getStringExtra("NIVELESTUDIOS");
        for (int i = 0; i < radioGroupEstudios.getChildCount(); i++) {
            RadioButton rb = (RadioButton) radioGroupEstudios.getChildAt(i);
            if (rb.getText().toString().equals(nivelEstudios)) {
                rb.setChecked(true);
                break;
            }
        }


        cbDeporte.setChecked(getIntent().getIntExtra("DEPORTE", 0) == 1);
        cbMusica.setChecked(getIntent().getIntExtra("MUSICA", 0) == 1);
        cbArte.setChecked(getIntent().getIntExtra("ARTE", 0) == 1);
        cbTecnologia.setChecked(getIntent().getIntExtra("TECNOLOGIA", 0) == 1);


        boolean recibirInfo = getIntent().getIntExtra("RECIBIRINFORMACION", 1) == 1;
        switchSiNo.setChecked(recibirInfo);
        switchSiNo.setText(recibirInfo ? "Si" : "No");
        switchSiNo.setOnCheckedChangeListener((btn, isChecked) ->
                switchSiNo.setText(isChecked ? "Si" : "No"));


        Button btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this::onGuardarClick);
    }

    private void setSpinner(Spinner spinner, String[] opciones, String valor) {
        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i].equals(valor)) {
                spinner.setSelection(i);
                return;
            }
        }
    }

    public void onGuardarClick(View view) {
        int selectedId = radioGroupEstudios.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Seleccione nivel de estudios", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!cbDeporte.isChecked() && !cbMusica.isChecked()
                && !cbArte.isChecked() && !cbTecnologia.isChecked()) {
            Toast.makeText(this, "Seleccione al menos un interés", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selected = findViewById(selectedId);

        Entidades.Contacto contacto = new Entidades.Contacto();
        contacto.setId(idContacto);
        contacto.setNombre(etNombre.getText().toString());
        contacto.setApellido(etApellido.getText().toString());
        contacto.setTelefono(etTelefono.getText().toString());
        contacto.setTipoTelefono(spinnerTelefono.getSelectedItem().toString());
        contacto.setEmail(etEmail.getText().toString());
        contacto.setTipoEmail(spinnerEmail.getSelectedItem().toString());
        contacto.setDireccion(etDireccion.getText().toString());
        contacto.setFechaNacimiento(etFechaNacimiento.getText().toString());
        contacto.setNivelEstudios(selected.getText().toString());
        contacto.setInteresDeporte(cbDeporte.isChecked() ? 1 : 0);
        contacto.setInteresMusica(cbMusica.isChecked() ? 1 : 0);
        contacto.setInteresArte(cbArte.isChecked() ? 1 : 0);
        contacto.setInteresTecnologia(cbTecnologia.isChecked() ? 1 : 0);
        contacto.setRecibirInformacion(switchSiNo.isChecked() ? 1 : 0);

        OpenHelper dbHelper = new OpenHelper(this, "ContactosDB", null, 1);
        boolean resultado = dbHelper.ActualizarContacto(contacto);

        if (resultado) {
            Toast.makeText(this, "Contacto actualizado", Toast.LENGTH_SHORT).show();
            startActivity(new android.content.Intent(this, FormularioListarContactos.class));
            finish();
        } else {
            Toast.makeText(this, "Error al actualizar", Toast.LENGTH_SHORT).show();
        }
    }
}