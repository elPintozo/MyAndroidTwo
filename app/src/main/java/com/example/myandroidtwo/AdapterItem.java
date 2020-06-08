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
import androidx.annotation.Nullable;

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
     *  acá se verá reflejado la opción seleccionada del spinner
     * position : indica la posicion del item actual
     * view : es la vista del item
     * viewGroup : es la vista del padre (ListVier)
     */
    public View getView(int position, View view, ViewGroup viewGroup) {
        //Aca se maneja la vista

        ViewHolder holder = new ViewHolder();
        if(view==null) {
            if (context != null) {
                //se debe inflar(crear/OnCreate) la vista
                view = context.getLayoutInflater().inflate(resource, null);

                //creo los componentes que mostrarán la información
                holder.txt_id = (TextView) view.findViewById(R.id.txt_id);
                holder.txt_name = (TextView) view.findViewById(R.id.txt_name);
                holder.txt_stock = (TextView) view.findViewById(R.id.txt_stock);
                view.setTag(holder);
            }
        }else{
            holder = (ViewHolder)view.getTag();
        }

        //obtengo el item para obtener su información
        Item item = items.get(position);
        holder.txt_id.setText(String.valueOf(item.getId()));
        holder.txt_name.setText(item.getName());

        if (item.getStock()) {
            holder.txt_stock.setText("Disponible");
            view.setBackgroundColor(Color.GREEN);
        } else {
            holder.txt_stock.setText("No disponible");
            view.setBackgroundColor(Color.YELLOW);
        }

        return view;
    }

    /**
     * Acá se realizan los cambios que se verán reflejados en las opciones seleccionables del spinner
     * @param position (int) :
     * @param convertView (View):
     * @param parent (ViewGroup):
     * @return convertView (View):
     */
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if(convertView==null) {
            if (context != null) {
                //se debe inflar(crear/OnCreate) la vista
                convertView = context.getLayoutInflater().inflate(resource, null);

                //creo los componentes que mostrarán la información
                holder.txt_id = (TextView) convertView.findViewById(R.id.txt_id);
                holder.txt_name = (TextView) convertView.findViewById(R.id.txt_name);
                holder.txt_stock = (TextView) convertView.findViewById(R.id.txt_stock);
                convertView.setTag(holder);
            }
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        //obtengo el item para obtener su información
        Item item = items.get(position);
        holder.txt_id.setText(String.valueOf(item.getId()));
        holder.txt_name.setText(item.getName());

        if (item.getStock()) {
            holder.txt_stock.setText("Disponible");
            convertView.setBackgroundColor(Color.GREEN);
        } else {
            holder.txt_stock.setText("No disponible");
            convertView.setBackgroundColor(Color.YELLOW);
        }

        return convertView;
    }

    static class ViewHolder{
        private TextView txt_id;
        private TextView txt_name;
        private TextView txt_stock;
    }
}
