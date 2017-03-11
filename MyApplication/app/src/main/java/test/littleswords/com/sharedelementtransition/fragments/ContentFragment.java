package test.littleswords.com.sharedelementtransition.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import test.littleswords.com.coordinatelayout.R;

/**
 * Created by wenchaokong on 25/02/2017.
 */

public class ContentFragment extends Fragment{

    private View imageView;
    private Button button;
    int y = 10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_fragment, container, false);
        button = (Button) v.findViewById(R.id.button);
        imageView = v.findViewById(R.id.contentImage);
        return v;
    }

}
