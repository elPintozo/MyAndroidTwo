package com.example.myandroidtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_linearlayout);

        //AdapterItem adapter = new AdapterItem(this, R.layout.item_adapter, Item.getItems());
        //ListView listView = (ListView) findViewById(R.id.list_items);
        //listView.setAdapter(adapter);
    }

    /**
     * Función que genera errores de tipo LogCat
     * @param type (int) : tipo de error. [1]Error, [2]Warning, [3]Info, [4]depuracion, [5]detail
     * @param message (string) : mensaje a mostrar
     * @param tag (string) : origen del mensaje
     */
    public static void sendLog(int type, String message, String tag){
        switch (type){
            case 1 :
                //Mensaje del tipo Error
                Log.e(tag, message);
                break;
            case 2 :
                //Mensaje del tipo warning/advertencia
                Log.w(tag, message);
                break;
            case 3 :
                //Mensaje del tipo info/información
                Log.i(tag, message);
                break;
            case 4 :
                //Mensaje del tipo depuracion
                Log.d(tag, message);
                break;
            case 5 :
                //Mensaje del tipo detail/detalles
                Log.v(tag, message);
                break;
        }
    }
}
