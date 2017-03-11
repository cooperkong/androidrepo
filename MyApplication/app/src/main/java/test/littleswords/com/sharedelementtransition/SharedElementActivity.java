package test.littleswords.com.sharedelementtransition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import test.littleswords.com.coordinatelayout.R;
import test.littleswords.com.sharedelementtransition.fragments.ListFragment;

public class SharedElementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_holder_activity);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListFragment()).commit();
    }

}
