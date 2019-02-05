package edu.galileo.ejemplo3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    private ListView lista;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lista = findViewById(R.id.list_contactos);
        lista.setAdapter(new ContactosAdapter(this, ((ContactosApp)getApplication()).getContactos()));
    }
}
