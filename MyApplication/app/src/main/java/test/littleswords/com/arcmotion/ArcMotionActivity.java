package test.littleswords.com.arcmotion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import test.littleswords.com.coordinatelayout.R;

/**
 * Created by wenchaokong on 11/03/2017.
 */

public class ArcMotionActivity extends AppCompatActivity {

    private FrameLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arcmotion_main);
        container = (FrameLayout) findViewById(R.id.container);
        setSceneAnimator();
    }

    private void setSceneAnimator(){
        new SceneAnimatorImpl(new TransitionManager()).init(this, container, R.layout.arcmotion_scene1, R.layout.arcmotion_scene2, R.transition.arc);
    }

}
