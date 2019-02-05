package edu.galileo.ejemplo3;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ContactosAdapter extends ArrayAdapter<Contacto> {
    private List<Contacto> lista;
    private Context context;
    private int layout;
    public ContactosAdapter(@NonNull Context context,  @NonNull List<Contacto> objects) {
        super(context, R.layout.item_list_contacto_layout, objects);
        this.lista = objects;
        this.context = context;
        this.layout = R.layout.item_list_contacto_layout;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(layout, null);
        }
        if (lista.get(position) != null) {
            int color;
            LinearLayout lytFondo;
            TextView txNombre, txTelefono;
            lytFondo = v.findViewById(R.id.lyt_fondo);
            txNombre = v.findViewById(R.id.tx_nombre);
            txTelefono = v.findViewById(R.id.tx_telefono);
            txNombre.setText(lista.get(position).getNombre());
            txTelefono.setText(lista.get(position).getTelefono());
            if (lista.get(position).isSexo()) {
                color = Color.rgb(255,204,255);
            } else {
                color = Color.rgb(102,204,255);
            }
            lytFondo.setBackgroundColor(color);
        }
        return v;
    }
}
