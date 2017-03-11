package test.littleswords.com.arcmotion;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import test.littleswords.com.coordinatelayout.R;

/**
 * Created by wenchaokong on 11/03/2017.
 */

final public class SceneAnimatorImpl implements SceneAnimator {
    private Scene scene1;
    private Scene scene2;
    private TransitionManager transitionManager;

    public SceneAnimatorImpl(TransitionManager transitionManager){
        this.transitionManager = transitionManager;
    }

    public SceneAnimatorImpl init(Context context, ViewGroup container, int layout1Id, int layout2Id, int transitionId){
        scene1 = createScene(this, context, container, layout1Id);
        scene2 = createScene(this, context, container, layout2Id);
        Transition transition = TransitionInflater.from(context).inflateTransition(transitionId);
        transitionManager.setTransition(scene1, scene2, transition);
        transitionManager.setTransition(scene2, scene1, transition);
        transitionManager.transitionTo(scene1);
        return this;
    }

    private void sceneTransition(Scene from) {
        if (from == scene1) {
            transitionManager.transitionTo(scene2);
        } else {
            transitionManager.transitionTo(scene1);
        }
    }

    private static Scene createScene(@NonNull SceneAnimatorImpl sceneAnimator, @NonNull Context context,
                                     @NonNull ViewGroup container, @LayoutRes int layoutId) {
        Scene scene = Scene.getSceneForLayout(container, layoutId, context);
        scene.setEnterAction(new EnterAction(sceneAnimator, scene));
        return scene;
    }

    private static final class EnterAction implements Runnable, View.OnClickListener {
        private final SceneAnimatorImpl sceneAnimator;
        private final Scene scene;

        private EnterAction(@NonNull SceneAnimatorImpl sceneAnimator, @NonNull Scene scene) {
            this.sceneAnimator = sceneAnimator;
            this.scene = scene;
        }

        @Override
        public void run() {
            ViewGroup sceneRoot = scene.getSceneRoot();
            View view = sceneRoot.findViewById(R.id.view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sceneAnimator.sceneTransition(scene);
        }
    }
}
