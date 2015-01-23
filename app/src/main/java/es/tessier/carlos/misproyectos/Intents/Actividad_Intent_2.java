package es.tessier.carlos.misproyectos.Intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import es.tessier.carlos.misproyectos.R;


public class Actividad_Intent_2 extends Activity {

    static final int ACTIVIDAD_INTENT_2_2_REQUEST_CODE = 1;
    private static final String TAG = Actividad_Intent_2.class.getName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad__intent_2);
    }

    public void onClick(View boton) {
        Intent intent = new Intent(this, Actividad_Intent_2_2.class);
        startActivityForResult(intent,
                ACTIVIDAD_INTENT_2_2_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // nombreclase.class.getName()
        if (requestCode == ACTIVIDAD_INTENT_2_2_REQUEST_CODE) {
            if(resultCode==RESULT_OK) {
                Log.d(TAG,"Recibe intent 2_2 ok");
                String resultado = data.getStringExtra("edittext");
                Toast.makeText(this,resultado,Toast.LENGTH_LONG).show();
            }
        }

    }
}
