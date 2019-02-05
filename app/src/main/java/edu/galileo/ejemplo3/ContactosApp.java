package edu.galileo.ejemplo3;

import android.app.Application;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ContactosApp extends Application {
    private List<Contacto> listContactos;
    @Override
    public void onCreate() {
        super.onCreate();
        listContactos = new ArrayList<Contacto>();
    }

    public void insertaContacto(Contacto contacto) {
        listContactos.add(contacto);
    }

    public List<Contacto> getContactos() {
        return listContactos;
    }
}
