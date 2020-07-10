package com.example.myandroidtwo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private RatingBar ratingBar_1;
    private RatingBar ratingBar_2;
    private TextView textView_rating;
    private Switch switch_1;
    private Switch switch_2;
    private RadioGroup radioGroup;
    private ListView listView;
    private ArrayList<Item> my_list_item;
    private GridView gridView;
    private TabHost tabHost;
    private WebView webView;
    private ProgressBar progressBar_web;
    private SearchView searchView;
    private TimePicker timePicker;
    private DatePicker datePicker;
    private Chronometer chronometer;
    private long timePause;
    private Boolean isPlay;
    private Boolean isPausa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //se infla(podemos usar sus componentes declarado en xml) nuestra vista
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_chronometer);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        findViewById(R.id.btn_play).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);
        findViewById(R.id.btn_pause).setOnClickListener(this);
        timePause=0;
        isPlay = false;
        isPausa = false;

//        datePicker = (DatePicker) findViewById(R.id.datepicker);
//
//        //establesco una fecha máxima
//        //Indico el formato
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        //Tomando el formato de fecha, procedo a indicar la fecha
//        Date date = null;
//        try {
//            date = simpleDateFormat.parse("2020/10/01");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        //asigno la fecha ya creada
//        datePicker.setMaxDate(date.getTime());
//
//        //Los meses empienzan del 0 al 11
//        sendLog(1,"Fecha: "+datePicker.getDayOfMonth()+"/"+(datePicker.getMonth()+1)+"/"+datePicker.getYear() ,"DatePicker");
//
//        datePicker.init(2020, 6, 7, new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                sendLog(1,"Fecha seleccionada: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year,"DatePicker");
//            }
//        });
//        timePicker = (TimePicker) findViewById(R.id.timepicker);
//
//        //Asignar tipo de visualizacion de 24 horas
//        timePicker.setIs24HourView(true);
//
//        //cambio la hora:minuto por defecto a desplegar
//        timePicker.setHour(13);
//        timePicker.setMinute(0);
//
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                sendLog(1,"is24Hour: "+view.is24HourView() ,"TimePicker");
//                sendLog(1,"HH:MM "+hourOfDay+":"+minute ,"TimePicker");
//
//            }
//        });

//        searchView = (SearchView)findViewById(R.id.my_search_view);
//        CharSequence charSequence = searchView.getQuery();
//        CharSequence charSequence_hint = searchView.getQueryHint();
//
//        sendLog(1,"getQuery: "+charSequence ,"SearchView");
//        sendLog(1,"getQueryHint: "+charSequence_hint ,"SearchView");
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                sendLog(1,"onQueryTextSubmit: "+query ,"SearchView");
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                sendLog(1,"onQueryTextChange: "+newText ,"SearchView");
//                return false;
//            }
//        });
//        webView =  (WebView)findViewById(R.id.webview);
//        progressBar_web = (ProgressBar) findViewById(R.id.progressBar_web);
//
//        //Indico la página a cargar al inicio
//        //webView.loadUrl("https://www.google.cl");
//
//        //*Si yo quiero cargar mi propio HTML* - debo comentar la función .loadUrl()
//        String my_HTML = "<html><body> <h1>Hola!</h1> <h2>Adiós!</h2> <h3>WebView</h3> </body></html>";
//        webView.loadData(my_HTML,  "text/html; charset=UTF-8",null);
//        webView.setBackgroundColor(Color.GREEN);
//
//        //establezco algunas propiedades a partir de las que tiene el WebView
//        WebSettings webSettings = webView.getSettings();
//        //activo contenido en JS
//        webSettings.setJavaScriptEnabled(true);
//        //activo el uso de zoom en el texto
//        webSettings.setTextZoom(80);
//
//        webView.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                //se le indica al progressbar donde debe ir cargando
//                progressBar_web.setProgress(newProgress);
//                //si la página esta cargada se hace invisible el progressbar
//                if(newProgress == 100){
//                    progressBar_web.setVisibility(View.GONE);
//                }
//                super.onProgressChanged(view, newProgress);
//            }
//        });

//        tabHost = (TabHost)findViewById(R.id.tabhost);
//        tabHost.setup();
//
//        //se crean las instancias del TabHost
//        newTab("tab1", R.id.tab1, "Tab N° 1", getIcon(R.drawable.icono_email));
//        newTab("tab2", R.id.tab2, "Tab N° 2", getIcon(R.drawable.icono_email));
//        newTab("tab3", R.id.tab3, "",getIcon(R.drawable.icono_email));
//
//        //marco el tab por defecto
//        tabHost.setCurrentTab(1);
//
//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String tabId) {
//                Toast.makeText(getApplicationContext(), "Identificador: " + tabId + " - Id: " + tabHost.getCurrentTab(), Toast.LENGTH_LONG).show();
//                sendLog(1,"Identificador: "+tabId + " - Id: " + tabHost.getCurrentTab(),"TabHost");
//            }
//        });
//        gridView = (GridView)findViewById(R.id.gridview);
//        my_list_item = Item.getItems();
//        final AdapterItem adapterItem = new AdapterItem(this, R.layout.item_adapter, my_list_item);
//        gridView.setAdapter(adapterItem);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Item item_selected = adapterItem.getItem(position);
//                sendLog(1,"Gridview (item seleccionado): "+item_selected.getId()+" - "+item_selected.getName(),"Gridview");
//            }
//        });
//
//        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Item item_selected = adapterItem.getItem(position);
//                Toast.makeText(getApplicationContext(), "Acciones disponibles para: "+item_selected.getName(), Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });

//        listView = (ListView)findViewById(R.id.my_listview);
//        my_list_item = Item.getItems();
//        final AdapterItem adapterItem = new AdapterItem(this, R.layout.item_adapter, my_list_item);
//        listView.setAdapter(adapterItem);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Item item = adapterItem.getItem(position);
//                sendLog(1,"Listview (item seleccionado): "+item.getId()+" / "+item.getName(),"Listview");
//            }
//        });
//        //funcion que aplica cuando se mantiene presionado una opción por un perido largo, por lo general se suelen
//        //desplegar opciones para esa seleccion
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Item item = adapterItem.getItem(position);
//                Toast.makeText(getApplicationContext(), "Acciones disponibles para: "+item.getName(), Toast.LENGTH_LONG).show();
//                return false;//se mantendrá seleccionado hasta sacar el dedo de la opcion seleccionada
//            }
//        });

//        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                //Forma 1 de obtener el boton presionado
//                switch (checkedId){
//                    case R.id.radio_opcion_1:
//                        sendLog(1,"Forma 1: Opción 1","RadioGroup");
//                        break;
//                    case R.id.radio_opcion_2:
//                        sendLog(1,"Forma 1: Opción 2","RadioGroup");
//                        break;
//                    case R.id.radio_opcion_3:
//                        sendLog(1,"Forma 1: Opción 3","RadioGroup");
//                        break;
//                    case R.id.radio_opcion_4:
//                        sendLog(1,"Forma 1: O1pción 4","RadioGroup");
//                        break;
//                }
//
//                //forma 2 de obtener el radio seleccionado
//                RadioButton rb_seleccionado = (RadioButton)findViewById(checkedId);
//                sendLog(1, "Forma 2: "+(String) rb_seleccionado.getText(),"RadioGroup");
//            }
//        });
//        switch_1 = (Switch)findViewById(R.id.switch1);
//        switch_2 = (Switch)findViewById(R.id.switch2);
//
//        switch_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    sendLog(1, "Switch 1 Checked","Switch");
//                }else{
//                    sendLog(1, "Switch 2 No Checked","Switch");
//                }
//            }
//        });
//
//        switch_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    sendLog(1, "Switch 2 Checked","Switch");
//                }else{
//                    sendLog(1, "Switch 2 No Checked","Switch");
//                }
//            }
//        });

//        ratingBar_1 = (RatingBar)findViewById(R.id.ratingBar);
//        ratingBar_2 = (RatingBar)findViewById(R.id.ratingBar2);
//        textView_rating = (TextView)findViewById(R.id.text_rating);
//
//        ratingBar_1.setRating((float) 2.0);
//        textView_rating.setText(ratingBar_1.getRating()+"");
//        ratingBar_1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            /**
//             * Función que notifica cambios del rating realizado por el usuario
//             *ratingBar : view del componente
//             *rating : valor del ranking otorgado
//             *fromUser : variable encargada de noticar si hay cambios
//             */
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                textView_rating.setText(rating+"");
//            }
//        });
//        quickContactBadge_email = (QuickContactBadge)findViewById(R.id.quick_email);
//        quickContactBadge_phone = (QuickContactBadge)findViewById(R.id.quick_phone);
//
//        quickContactBadge_email.assignContactFromEmail("ricardo.sr.lepe@gmail.com", true);
//        quickContactBadge_phone.assignContactFromPhone("981275086",true);
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

    /**
     * Función que me ayuda a generar los iconos que se desplegarán en los Tab
     * @param idDrawable
     * @return
     */
    private Drawable getIcon(int idDrawable){
        return ContextCompat.getDrawable(getApplicationContext(), idDrawable);
    }
    /**
     * Función que me ayuda a crear los tab/pestañas del TabHost
     * @param tab (String): identificador de la pestaña
     * @param idContent (int): id del contendor de los elementos que están dentro del tab
     * @param title (String): titulo de la pestaña
     */
    private void newTab(String tab, int idContent, String title, Drawable drawable){
        TabHost.TabSpec spec = tabHost.newTabSpec(tab);
        spec.setContent(idContent);
        spec.setIndicator(title, drawable);

        //se agrega el tab creado al TabHost
        tabHost.addTab(spec);
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

            case R.id.btn_play:
                if(!isPlay) {
                    chronometer.setBase(SystemClock.elapsedRealtime() - timePause);
                    sendLog(1, "Play-timePause:" + timePause, "Chronometer");
                    sendLog(1, "SystemClock:" + SystemClock.elapsedRealtime(), "Chronometer");
                    chronometer.start();
                    isPlay=true;
                    isPausa=false;
                }
                break;
            case R.id.btn_pause:
                if(!isPausa) {
                    timePause = SystemClock.elapsedRealtime() - chronometer.getBase();
                    sendLog(1, "SystemClock.elapsedRealtime()-chronometer.getBase():" + SystemClock.elapsedRealtime() + " - " + chronometer.getBase(), "Chronometer");
                    sendLog(1, "Pause-timePause:" + timePause, "Chronometer");
                    chronometer.stop();
                    isPausa=true;
                    isPlay=false;
                }
                break;
            case R.id.btn_stop:
                if(isPausa) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.stop();
                    timePause=0;
                }
                break;
        }
    }
}
