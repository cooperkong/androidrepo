package test.littleswords.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import test.littleswords.com.arcmotion.ArcMotionActivity;
import test.littleswords.com.coordinatelayout.CoordinateLayoutActivity;
import test.littleswords.com.coordinatelayout.R;
import test.littleswords.com.sharedelementtransition.SharedElementActivity;

/**
 * Created by wenchaokong on 11/03/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        findViewById(R.id.coordinatelayout_activity_btn).setOnClickListener(this);
        findViewById(R.id.sharedelement_activity_btn).setOnClickListener(this);
        findViewById(R.id.arcmotion_activity_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.coordinatelayout_activity_btn:
                intent.setClass(this, CoordinateLayoutActivity.class);
                break;
            case R.id.sharedelement_activity_btn:
                intent.setClass(this, SharedElementActivity.class);
                break;
            case R.id.arcmotion_activity_btn:
                intent.setClass(this, ArcMotionActivity.class);
                break;
        }
        startActivity(intent);
    }
}
