package com.ugb.controlesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tempVal;
    Button btn;
    String id="";

    String accion="nuevo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnGuardarAgendaAmigos);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempVal = findViewById(R.id.txtNombre);
                String nombre = tempVal.getText().toString();

                tempVal = findViewById(R.id.txtDireccion);
                String direccion = tempVal.getText().toString();

                tempVal = findViewById(R.id.txtTelefono);
                String telefono = tempVal.getText().toString();

                tempVal = findViewById(R.id.txtEmail);
                String email = tempVal.getText().toString();

                tempVal = findViewById(R.id.txtDui);
                String dui = tempVal.getText().toString();

                String[] datos = new  String[]{id,nombre,direccion,telefono,email,dui};
                DB db = new DB(getApplicationContext(), "", null, 1);
                String respuesta = db.administrar_amigos(accion,datos);
                if (respuesta.equals("ok")){
                    Toast.makeText(getApplicationContext(), "Amigo registrado con exito", Toast.LENGTH_LONG ).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error: " + respuesta, Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}