package es.tessier.carlos.misproyectos.lifecycle;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import es.tessier.carlos.misproyectos.R;

public class Pulsame extends ActionBarActivity {

    private int numVeces;
    private final static String NUM_VECES = "numVeces";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulsame);
    }

    public void actionPush(View v){
        ++numVeces;
        writeButton();
    }

    private void writeButton( ) {
        Button button = (Button) findViewById(R.id.buttonPulsame);
        String sNumVeces =
               getResources().
                       getQuantityString(R.plurals.vecesPulsado,
                               numVeces,numVeces);

        button.setText(sNumVeces);
    }

    // guardamos el estado de la actividad
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NUM_VECES,numVeces);

    }
    // cargamos el estado de la actividad
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        numVeces = savedInstanceState.getInt(NUM_VECES);
        writeButton();

    }
}
