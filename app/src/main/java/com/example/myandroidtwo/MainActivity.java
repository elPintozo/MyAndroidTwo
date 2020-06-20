package com.example.myandroidtwo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btNext;
    private Button btnAdd;
    private ProgressBar my_progressBar;
    private int my_progress;
    private Button btnAceptar;
    private Button btnCancelar;
    private Button btnGuardar;
    private CheckBox my_checkBox;
    private RadioButton my_radioButton;
    private Spinner my_spinner;
    private SeekBar my_seekBar_1;
    private SeekBar my_seekBar_2;
    private QuickContactBadge quickContactBadge_phone;
    private QuickContactBadge quickContactBadge_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //se infla(podemos usar sus componentes declarado en xml) nuestra vista
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_quick_contact_badge);

        quickContactBadge_email = (QuickContactBadge)findViewById(R.id.quick_email);
        quickContactBadge_phone = (QuickContactBadge)findViewById(R.id.quick_phone);

        quickContactBadge_email.assignContactFromEmail("ricardo.sr.lepe@gmail.com", true);
        quickContactBadge_phone.assignContactFromPhone("981275086",true);
//        my_seekBar_1 = (SeekBar) findViewById(R.id.seekBar);
//        my_seekBar_2 = (SeekBar) findViewById(R.id.seekBar2);
//
//        my_seekBar_1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            /**
//             * Función que no notifica que el progreso de la barra a cambiado
//             * seekBar : el componente
//             * progress : el progreso actual
//             * fromUser : notifica de cambio de proceso
//             */
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//
//            }
//
//            @Override
//            /**
//             * función que notifica que se esa haciendo una interacción táctil
//             * seekBar : el componente
//             */
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                sendLog(1, "Se está cambiando el valor del seekbar 1", "Seekbar 1");
//            }
//
//            @Override
//            /**
//             * función que notifica que se esa ha terminado una interacción táctil
//             * seekBar : el componente
//             */
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                sendLog(1, "Se termino de cambiar el  valor del seekbar 1", "Seekbar 1");
//            }
//        });
//
//        my_seekBar_2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            /**
//             * Función que no notifica que el progreso de la barra a cambiado
//             * seekBar : el componente
//             * progress : el progreso actual
//             * fromUser : notifica de cambio de proceso
//             */
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                sendLog(1, "Se está cambiando el valor del seekbar 2", "Seekbar 2");
//            }
//
//            @Override
//            /**
//             * función que notifica que se esa haciendo una interacción táctil
//             * seekBar : el componente
//             */
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                sendLog(1, "Se termino de cambiar el  valor del seekbar 2", "Seekbar 2");
//            }
//
//            @Override
//            /**
//             * función que notifica que se esa ha terminado una interacción táctil
//             * seekBar : el componente
//             */
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });

//        btnAdd = (Button)findViewById(R.id.btnAdd);
//        my_progressBar = (ProgressBar)findViewById(R.id.progressBar_2);
//        btnAdd.setOnClickListener(this);

//        //ArrayAdapter<Item> itemArrayAdapter = new ArrayAdapter<Item>(getApplicationContext(), R.layout.item_adapter, R.id.txt_id, Item.getItems());
//        AdapterItem adapterItem = new AdapterItem(this, R.layout.item_adapter, Item.getItems());
//        my_spinner = (Spinner)findViewById(R.id.my_spinner);
//        my_spinner.setAdapter(adapterItem);

//        my_checkBox = (CheckBox) findViewById(R.id.my_checkBox);
//        my_radioButton = (RadioButton)findViewById(R.id.my_radioButton);
//
//        my_checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    Toast.makeText(getApplicationContext(), "CheckBox Seleccionado", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(getApplicationContext(), "CheckBox No Seleccionado", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        my_radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    Toast.makeText(getApplicationContext(), "RadioButton Seleccionado", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(getApplicationContext(), "RadioButton No Seleccionado", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
//        sendLog(1, "onCreate", "onCreate");

//        btnAceptar = (Button)findViewById(R.id.btnAceptar);
//        btnCancelar = (Button)findViewById(R.id.btnCancelar);
//        btnGuardar = (Button)findViewById(R.id.btnGuardar);
//
//        btnAceptar.setOnClickListener(this);
//        btnCancelar.setOnClickListener(this);
//        btnGuardar.setOnClickListener(this);

        //AdapterItem adapter = new AdapterItem(this, R.layout.item_adapter, Item.getItems());
        //ListView listView = (ListView) findViewById(R.id.list_items);
        //listView.setAdapter(adapter);

//        btNext = (Button)findViewById(R.id.btn_next_activity_2);
//        btNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                // indicamos que queremos hacer con aplicaciones externas
//                intent.setAction(Intent.ACTION_SEND);
//                // le indicamos a la otra aplicación que le enviaremos texto
//                intent.putExtra(Intent.EXTRA_TEXT, "Este mensaje fue enviado desde otra app");
//                // se especifica que dato enviaremos
//                intent.setType("text/plain");
//                // se inicia la instancia de conversación con otra aplicacion
//                startActivity(Intent.createChooser(intent,"Enviar el texto a"));
//            }
//        });

//        //Se valida que se tiene permiso para hacer uso de algo en particular
//        //Si se tiene el permiso se retorna 0, sino -1
//        //una forma de usar mejor el comparador es usando PackageManager.PERMISSION_GRANTED (es igual a == 0)/ PERMISSION_DENIED (es igual a == -1)
//        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
//            //se notifica que si hay permiso para hacer uso de algun componente
//            Toast.makeText(getApplicationContext(), "Permiso aceptado 1.", Toast.LENGTH_LONG).show();
//        }else {
//            //se vuelve a pedir el permiso para hacer uso de algun componente
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
//
//            //se notifica que no hay permiso para hacer uso de algun componente
//            Toast.makeText(getApplicationContext(), "Permiso denegado 1.", Toast.LENGTH_LONG).show();
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //se notifica que si hay permiso para hacer uso de algun componente
                    Toast.makeText(getApplicationContext(), "Permiso aceptado 2.", Toast.LENGTH_LONG).show();
                }else {
                    //se vuelve a pedir el permiso para hacer uso de algun componente
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);

                    //se notifica que no hay permiso para hacer uso de algun componente
                    Toast.makeText(getApplicationContext(), "Permiso denegado 2.", Toast.LENGTH_LONG).show();
                }
        }
    }

    /**
     * Función que me ayuda a mantener al instancia cuando se quiera cambiar
     * la orientación del movil para hacer uso en vertical, a veces suelen haber
     * comportamientos raros(android reinicia la instancia), entonces se
     * controla para evitar eso se usa esta función.
     * -Se ejecuta antes de un onstop
     */

    /**
     *  Función que recibe los datos tras haberse ejecutado una rotación de la
     *  aplicación, los datos son provenientes de  onSaveInstanceState
     * @param savedInstanceState
     */
    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "Nombre:"+savedInstanceState.getString("name", "error"), Toast.LENGTH_LONG).show();
        sendLog(1, savedInstanceState.getString("name", "error"), "onRestoreInstanceState");
    }

    /**
     * Función que nos ayuda a respaldar los datos en caso que se cambie la orientación
     * de la aplicación. (Funcion que envia los datos antes de la rotación)
     * Se ejecuta antes de la función onStop
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", "Ricardo");
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
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
        sendLog(1, "onResume", "onResume");
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAceptar:
                Toast.makeText(MainActivity.this, "Botón Aceptar", Toast.LENGTH_SHORT).show();
                sendLog(1, "Botón Aceptar", "Button");
                break;
            case R.id.btnCancelar:
                Toast.makeText(getApplicationContext(), "Botón Cancelar", Toast.LENGTH_SHORT).show();
                sendLog(1, "Botón Cancelar", "Button");
                break;
            case R.id.btnGuardar:
                Toast.makeText(getApplicationContext(), "Botón Guardar", Toast.LENGTH_SHORT).show();
                sendLog(1, "Botón Guardar", "Button");
                break;
            case R.id.btnAdd:
                my_progress = my_progressBar.getProgress();
                my_progress = my_progress +10;
                if(my_progress<100){
                    my_progressBar.setProgress(my_progress);
                    btnAdd.setText("Add 10%");
                }else{
                    btnAdd.setText("Felicidades "+my_progress+"%");
                    my_progressBar.setProgress(0);
                }
                break;
        }
    }
}
