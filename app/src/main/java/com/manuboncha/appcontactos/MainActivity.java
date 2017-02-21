package com.manuboncha.appcontactos;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private ImageButton ib;
    private Calendar cal;
    private int day;
    private int month;
    private int year;
    private EditText et;
    private static DatePickerDialog.OnDateSetListener ctx;
    private Button btnSiguiente;

    //Datos
    private String datoNombre;
    private EditText etNombre;

    private String datoFechaNacimiento;
    private EditText etFechaNacimiento;

    private String datoTelefono;
    private EditText etTelefono;

    private String datoEmail;
    private EditText etEmail;

    private String datoDescripcion;
    private EditText etDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ib = (ImageButton) findViewById(R.id.ib_btn_calendario);
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);
        //et = (EditText) findViewById(R.id.et_fecha_nacimiento);
        ctx = this;

        //Referenciar campos y botones del activity contactos - Obteniendo una instancia del boton
        etNombre = (EditText) findViewById(R.id.et_nombre);
        etFechaNacimiento = (EditText) findViewById(R.id.et_fecha_nacimiento);
        etTelefono = (EditText) findViewById(R.id.et_tel);
        etEmail = (EditText) findViewById(R.id.et_mail);
        etDescripcion = (EditText) findViewById(R.id.et_descripcion);
        btnSiguiente = (Button) findViewById(R.id.btn_siguiente); //boton siguiente definirlo y relacionarlo con el id en android


        //Al hacer click en el image_view de calendario
        ib.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");

            }
        });

        //Al hacer click en el boton siguiente del activity_main
        btnSiguiente.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declar un intent Explicito para ir al activity_confirmar_contactos
                Intent intentSiguiente = new Intent(MainActivity.this, ConfirmarContactos.class);

                datoNombre = etNombre.getText().toString();
                datoFechaNacimiento = etFechaNacimiento.getText().toString();
                datoTelefono = etTelefono.getText().toString();
                datoEmail = etEmail.getText().toString();
                datoDescripcion = etDescripcion.getText().toString();

                //Datos a enviar a la otra activity
                /*Nota: por mejor practica es mejor guardar el nombre de la variable a enviar en el archivo strings.xml por eso se pone esta linea
                        getResources().getString(R.string.pnombre)
                 */
                intentSiguiente.putExtra(getResources().getString(R.string.pnombre),datoNombre);
                intentSiguiente.putExtra(getResources().getString(R.string.pfechaNacimiento),datoFechaNacimiento);
                intentSiguiente.putExtra(getResources().getString(R.string.ptelefono),datoTelefono);
                intentSiguiente.putExtra(getResources().getString(R.string.pemail),datoEmail);
                intentSiguiente.putExtra(getResources().getString(R.string.pdescripcion),datoDescripcion);
                // Log.i("SNACKBAR","Click en boton de Snackbar");

                //iniciar INTENT
                startActivity(intentSiguiente);

            }
        });


    }

    //En donde y como va a mostrar lo seleccionado en el calendario
    public void onDateSet(DatePicker view, int year, int month, int day) {
        etFechaNacimiento.setText(year + " / "  + month + " / " + day);
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,int selectedMonth, int selectedDay) {
            etFechaNacimiento.setText(selectedDay + " / " + (selectedMonth + 1) + " / "+ selectedYear);
        }
    };

    public static class DatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            DatePickerDialog dPickerDialog = new DatePickerDialog(getActivity(), ctx, year, month, day);
            return dPickerDialog;
        }


    }


}
