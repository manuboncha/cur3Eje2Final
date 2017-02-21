package com.manuboncha.appcontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmarContactos extends AppCompatActivity {

    private String datoNombre;
    private String datoFechaNacimiento;
    private String datoTelefono;
    private String datoEmail;
    private String datoDescripcion;


    TextView tvNombre;
    TextView tvFechaNacimiento;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_contactos);


        //Recibir datos del Intent de MainActivity
        Bundle parametros = getIntent().getExtras();

        String nombre           = parametros.getString(getResources().getString(R.string.pnombre));
        String fechanacimiento  = parametros.getString(getResources().getString(R.string.pfechaNacimiento));
        String telefono         = parametros.getString(getResources().getString(R.string.ptelefono));
        String email            = parametros.getString(getResources().getString(R.string.pemail));
        String descripcion      = parametros.getString(getResources().getString(R.string.pdescripcion));

        tvNombre           = (TextView) findViewById(R.id.tv_cc_nombre);
        tvFechaNacimiento  = (TextView) findViewById(R.id.tv_cc_fechaNacimiento);
        tvTelefono         = (TextView) findViewById(R.id.tv_cc_tel);
        tvEmail            = (TextView) findViewById(R.id.tv_cc_email);
        tvDescripcion      = (TextView) findViewById(R.id.tv_cc_descripcion);

        tvNombre.setText(nombre);
        tvFechaNacimiento.setText(fechanacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);



    }

    //Metodo para la Accion del boton editar campos
    public void editarCampos(View v) {

        //Log.i("MetodoEdit","Entro");
        //datoNombre = tvNombre.getText().toString();

        onBackPressed();
    }

    //Metodo para volver es como presionar en back
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
