package com.example.myandroidtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //se infla(podemos usar sus componentes declarado en xml) nuestra vista
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_activity);

        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_LONG).show();
        //AdapterItem adapter = new AdapterItem(this, R.layout.item_adapter, Item.getItems());
        //ListView listView = (ListView) findViewById(R.id.list_items);
        //listView.setAdapter(adapter);

        btNext = (Button)findViewById(R.id.btn_next_activity_2);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("mi_int", 99);
                intent.putExtra("mi_string", "ricardo");
                intent.putExtra("mi_booleano", true);
                startActivity(intent);
            }
        });

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

    /**
     *Se ejecuta despues de onCreate, y se ejecuta antes de lanzar la vista al usuario,
     * en este punto aún no es visible al usuario
     */
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_LONG).show();
    }

    /**
     *Se ejecuta despues de onStart, se ejecuta cuando el usuario empezará a interactura con
     * la aplicación. en este punto ya se podría comenzar a implementar tanto animaciones
     * como música para presentar la aplicacion
     */
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_LONG).show();
    }

    /**
     *Se ejecuta despues de onResume,se ejecuta antes de pasar a la aplicación a segundo plano, es decir
     * se pasará a una nueva activity pero aún esta visible al usuario
     */
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_LONG).show();
    }

    /**
     *Se ejecuta despues de onPause,se ejecuta cuando la primera activity ya no es visible pero no así la segunda
     */
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_LONG).show();
    }

    /**
     *
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG).show();
    }

    /**
     *Se ejecuta luego del OnPause, retorna a la última activity visible, se ejecuta cuando le damos al
     * botón volver del celular
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_LONG).show();
    }
}
