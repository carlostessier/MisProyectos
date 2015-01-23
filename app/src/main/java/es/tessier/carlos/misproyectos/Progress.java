package es.tessier.carlos.misproyectos;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


public class Progress extends ActionBarActivity {
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        requestWindowFeature(Window.FEATURE_PROGRESS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        setSupportProgressBarIndeterminateVisibility(Boolean.TRUE);


    }

    public void progressDialog(View button) {
        // muestra el cuadro de diálogo
        // Clase para crear un cuadro de diálogo de progreso
        final ProgressDialog dialog = ProgressDialog.show(this,
                "Haciendo algo", "Por favor espere...", true);
        new Thread(new Runnable() {
            public void run() {
                try {
                    // simulamos que hacemos una actividad
                    // prolongada
                    Thread.sleep(5000);
                    dialog.dismiss();
                    // cerramos el cuadro de diálogo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    public void openProgressDialog(View button) {


        progressDialog = createProgressDialog();
        progressDialog.show();
        progressDialog.setProgress(0);
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    try {
                        // simulamos que hacemos una actividad prolongada
                        Thread.sleep(1000);
                        // cerramos el cuadro de diálogo
                        progressDialog.incrementProgressBy((int) (100 / 15));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                progressDialog.dismiss();
            }
        }).start();


    }

    ProgressDialog createProgressDialog() {

        ProgressDialog progressDialog = new ProgressDialog(this);


        progressDialog.setIcon(R.drawable.ic_launcher);
        progressDialog.setTitle("Bajando ficheros...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        // Establecemos los dos botones que mostraremos en la ventana
        progressDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(),
                                "¡OK pulsado!", Toast.LENGTH_SHORT).show();
                    }
                });


        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
                getString(android.R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(),
                                "¡OK pulsado!", Toast.LENGTH_SHORT).show();
                    }
                });


        return progressDialog;
    }

}
