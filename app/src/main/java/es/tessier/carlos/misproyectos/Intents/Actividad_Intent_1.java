package es.tessier.carlos.misproyectos.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.tessier.carlos.misproyectos.R;


public class Actividad_Intent_1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad__intent_1);
    }

    public void onClick(View boton){
        Intent intent = new Intent(this, es.tessier.carlos.misproyectos.intents.Actividad_Intent_1_2.class);
        startActivity(intent);

    }


}
