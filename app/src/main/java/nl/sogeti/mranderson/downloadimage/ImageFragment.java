package nl.sogeti.mranderson.downloadimage;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by MrAnderson1 on 15/07/15.
 */
public class ImageFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
//      another way, if not using the loader object
//        ImageLoader.downloadHugeImage();
    }
}
