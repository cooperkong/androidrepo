package test.littleswords.com.coordinatelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CoordinateLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_holder_activity);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListFragment()).commit();
    }

}
