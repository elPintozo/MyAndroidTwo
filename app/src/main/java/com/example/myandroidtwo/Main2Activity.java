package com.example.myandroidtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();

        String mi_string = "";
        int mi_int = 0 ;
        boolean mi_booleano = false ;

        if(bundle!=null){
            mi_string =  bundle.getString("mi_string","Error");
            mi_int = bundle.getInt("mi_int",-1);
            mi_booleano =  bundle.getBoolean("mi_booleano", false);
            Toast.makeText(getApplicationContext(), "Llegó desde bundle:\nmi_string: "+mi_string+"\n mi_int: "+mi_int+"\n mi_booleano: "+mi_booleano, Toast.LENGTH_LONG).show();
        }
    }

    /**
     *
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG).show();
    }
}
