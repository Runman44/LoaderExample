package nl.sogeti.mranderson.downloadimage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.greenrobot.event.EventBus;


public class MainActivity extends FragmentActivity implements android.support.v4.app.LoaderManager.LoaderCallbacks<Bitmap> {

    TextView view;
    ImageView image;
    private EventBus eventBus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (TextView) findViewById(R.id.title_text);
        image = (ImageView) findViewById(R.id.image);
        eventBus.register(this);

        if (getFragmentManager().findFragmentByTag("network") == null) {
            ImageFragment quoteFragment = new ImageFragment();
            getFragmentManager().beginTransaction().add(quoteFragment, "network").commit();
        }
        getSupportLoaderManager().initLoader(0, null, this);
    }

    public void onButtonClicked(View v) {
//        if (getSupportLoaderManager().getLoader(0) == null) {
//            getSupportLoaderManager().initLoader(0, null, this);
//        } else {
//            getSupportLoaderManager().restartLoader(0, null, this);
//        }
    }

    @Override
    public android.support.v4.content.Loader<Bitmap> onCreateLoader(int id, Bundle args) {
        return new ImageLoader(this);
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<Bitmap> loader, Bitmap data) {
        view.setText("Loader is Done!");
        image.setImageBitmap(data);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Bitmap> loader) {
    }

    public void onEventMainThread(MessageEvent event) {
        // Need to save this.
        image.setImageBitmap(event.getBitmap());
        view.setText("Fragment is Done!");
    }

}
