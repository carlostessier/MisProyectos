package es.tessier.carlos.misproyectos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ShareActionProvider;


public class Compartir extends Activity {

    private static final String TAG = Compartir.class.getName() ;
    private ShareActionProvider mShareActionProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartir);
    }



    private Intent createShareCompartirIntent(){
        EditText editText = (EditText) findViewById(R.id.editText);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags((Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET));
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());

        return shareIntent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu resource file.
        getMenuInflater().inflate(R.menu.menu_compartir, menu);

        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.action_share);

        // Fetch and store ShareActionProvider
        //mShareActionProvider = (ShareActionProvider) item.getActionProvider();
        mShareActionProvider = (ShareActionProvider) item.getActionProvider();
        // Return true to display menu

        if (mShareActionProvider!=null)
            mShareActionProvider.setShareIntent(createShareCompartirIntent());
        else
            Log.e(TAG,"shareactionprovider is null!");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
