package nl.sogeti.mranderson.downloadimage;

import android.graphics.Bitmap;

/**
 * Created by MrAnderson1 on 16/07/15.
 */
public class MessageEvent {

    private Bitmap bitmap;

    public MessageEvent() {

    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
