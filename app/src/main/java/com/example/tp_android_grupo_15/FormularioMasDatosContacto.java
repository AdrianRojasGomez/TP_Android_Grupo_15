package com.example.tp_android_grupo_15;

import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormularioMasDatosContacto extends AppCompatActivity {

    private RadioGroup radioGroupEstudios;
    private CheckBox cbDeporte, cbMusica, cbArte, cbTecnologia;
    private Switch switchSiNo;

    //FORMULARIO AGREGARCONTACTOS
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipoTelefono;
    private String email;
    private String tipoEmail;
    private String direccion;
    private String fechaNacimiento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_mas_datos_contacto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Aqui inicializamos el radioGroup!
        radioGroupEstudios = findViewById(R.id.radioGroupEstudios);
        cbDeporte = findViewById(R.id.cbDeporte);
        cbMusica = findViewById(R.id.cbMusica);
        cbArte = findViewById(R.id.cbArte);
        cbTecnologia = findViewById(R.id.cbTecnologia);


        //SWITCH POR DEFECTO EN SI
        switchSiNo = findViewById(R.id.switchSiNo);
        switchSiNo.setChecked(true);
        switchSiNo.setText("Si");
        switchSiNo.setOnCheckedChangeListener((buttonView, isChecked)->{
            if(isChecked){
                switchSiNo.setText("Si");
            }else{
                switchSiNo.setText("No");
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Formulario de Contacto 2/2");
        }
        //RECUPERAR DATOS DEL PRIMER FORMULARIO

        nombre = getIntent().getStringExtra("nombre");
        apellido = getIntent().getStringExtra("apellido");
        telefono = getIntent().getStringExtra("telefono");
        tipoTelefono = getIntent().getStringExtra("tipoTelefono");
        email = getIntent().getStringExtra("email");
        tipoEmail = getIntent().getStringExtra("tipoEmail");
        direccion = getIntent().getStringExtra("direccion");
        fechaNacimiento = getIntent().getStringExtra("fechaNacimiento");



    }


    public boolean validaciones(){
        boolean estado = true;

        int selectedId = radioGroupEstudios.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Por favor seleccione un nivel de estudios", Toast.LENGTH_LONG).show();
            estado = false;
        }

        if (!cbDeporte.isChecked() && !cbArte.isChecked() && !cbMusica.isChecked() && !cbTecnologia.isChecked()) {

            Toast.makeText(this, "Seleccione al menos un interes" , Toast.LENGTH_LONG).show();
            estado = false;
        }

        return estado;

    }


    public void OnGuardarClick(View view) {

        if(!validaciones()){
            return;
        }
        int selectedId = radioGroupEstudios.getCheckedRadioButtonId();
        RadioButton selected = findViewById(selectedId);

        String nivelEstudio = selected.getText().toString();


        //CBOX
        boolean interesDeporte = cbDeporte.isChecked();
        boolean interesMusica = cbMusica.isChecked();
        boolean interesArte = cbArte.isChecked();
        boolean interesTecnologia = cbTecnologia.isChecked();

        //SWITCH
        boolean recibirInformacion = switchSiNo.isChecked();

    }


}