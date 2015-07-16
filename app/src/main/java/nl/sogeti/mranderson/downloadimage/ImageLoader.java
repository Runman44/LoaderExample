package nl.sogeti.mranderson.downloadimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import de.greenrobot.event.EventBus;

/**
 * Created by MrAnderson1 on 15/07/15.
 */
public class ImageLoader extends android.support.v4.content.AsyncTaskLoader<Bitmap> {

    Bitmap myBitmap = null;

    public ImageLoader(Context context) {
        super(context);
    }

    public static void downloadHugeImage() {
        Thread t = new Thread() {
            EventBus bus = EventBus.getDefault();


            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    java.net.URL url = new java.net.URL("http://www.sultanswallpaper.com/static/images/simple-wallpapers-for-android-mobile.jpg");
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    Bitmap myBitmap = BitmapFactory.decodeStream(input);

                    MessageEvent event = new MessageEvent();
                    event.setBitmap(myBitmap);
                    bus.post(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        t.start();

    }

    @Override
    protected void onStartLoading() {
        if (myBitmap != null) {
            // If we currently have a result available, deliver it
            // immediately.
            deliverResult(myBitmap);
        } else {
            // else we need to load it
            forceLoad();
        }
    }

    @Override
    public Bitmap loadInBackground() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            java.net.URL url = new java.net.URL("http://www.sultanswallpaper.com/static/images/simple-wallpapers-for-android-mobile.jpg");
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            myBitmap = BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myBitmap;
    }


}
