package es.tessier.carlos.misproyectos.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.tessier.carlos.misproyectos.R;


public class BroadcastReceiver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
    }


    public void sendBroadcastIntent(View button){
        Intent i = new Intent();
        i.putExtra("message","Hello World");
        i.setAction("es.tessier.carlos.misproyectos.CUSTOM_INTENT");
        sendBroadcast(i);
    }
}
