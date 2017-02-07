package test.littleswords.com.aspectj;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import test.littleswords.com.aspectjtest.annotation.DebugTrace;

/**
 * Created by wenchaokong on 7/02/2017.
 */

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        testAnnotatedMethod();
    }


    @DebugTrace
    private void testAnnotatedMethod() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
