package com.example.myandroidtwo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AdapterItem extends ArrayAdapter {
    private Activity context;
    private int resource;
    private ArrayList<Item> items;

    public AdapterItem(@NonNull Activity context, int resource, ArrayList<Item> items ) {
        //cada variable que se trae de otra vista debe ser cargada en super
        super(context, resource, items);

        this.context = context;
        this.resource = resource;
        this.items = items;
    }

    @Override
    /***
     * Función que retorna el total de elementos que se mostrarán
     */
    public int getCount() {
        return items.size();
    }

    @Override
    /**
     * Función que se utiliza para obtener un item en especifico de la lista
     */
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    /**
     * Función que se utiliza para obtener el id especifico de un elemento de la lista
     */
    public long getItemId(int position) {
        return items.get(position).getId() ;
    }

    @Override
    /**
     * Función que se infla para poder mostrar cada uno de los items en la lista
     *
     * position : indica la posicion del item actual
     * view : es la vista del item
     * viewGroup : es la vista del padre (ListVier)
     */
    public View getView(int position, View view, ViewGroup viewGroup) {
        //Aca se maneja la vista

        if (context!=null){
            //se debe inflar(crear/OnCreate) la vista
            view =  context.getLayoutInflater().inflate(resource, null);

            //creo los componentes que mostrarán la información
            TextView txt_id = (TextView)view.findViewById(R.id.txt_id);
            TextView txt_name = (TextView)view.findViewById(R.id.txt_name);
            TextView txt_stock = (TextView)view.findViewById(R.id.txt_stock);

            //obtengo el item para obtener su información
            Item item = items.get(position);
            txt_id.setText(String.valueOf(item.getId()));
            txt_name.setText(item.getName());

            if(item.getStock()){
                txt_stock.setText("Disponible");
                view.setBackgroundColor(Color.GREEN);
            }else{
                txt_stock.setText("No disponible");
                view.setBackgroundColor(Color.YELLOW);
            }
        }
        return view;
    }
}
