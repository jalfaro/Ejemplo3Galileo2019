package edu.galileo.ejemplo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtNombre, txtNumeroTelefono;
    private RadioGroup rgSexo;
    private Button btnGrabar, btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = findViewById(R.id.et_nombre);
        txtNumeroTelefono = findViewById(R.id.et_telefono);
        rgSexo = findViewById(R.id.rg_sexo);
        btnGrabar = findViewById(R.id.btn_guardar);
        btnConsultar = findViewById(R.id.btn_consultar);

        btnGrabar.setOnClickListener(this);
        btnConsultar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Contacto temp;
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_consultar :
                Toast.makeText(this,"Click sobre consultar", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_guardar :
                temp = new Contacto();
                temp.setNombre(txtNombre.getText().toString());
                temp.setTelefono(txtNumeroTelefono.getText().toString());
                boolean sexo = ((RadioButton)rgSexo.getChildAt(1)).isChecked();
                temp.setSexo(sexo);
                txtNombre.setText("");
                txtNumeroTelefono.setText("");
                ((RadioButton)rgSexo.getChildAt(0)).setChecked(true);
                ((ContactosApp)getApplication()).insertaContacto(temp); //Guardando en lista
                Toast.makeText(this,"Click sobre guardar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
