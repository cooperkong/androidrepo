package test.littleswords.com.annotationtest;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import test.littleswords.com.annotationtest.simplebutterknife.ButterKnife;
import test.littleswords.com.annotationtest.simplebutterknife.ContentView;
import test.littleswords.com.annotationtest.simplebutterknife.ViewInject;
@ContentView(value = R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private AlertDialog dialog;

    @ViewInject(id = R.id.activity_main, clickable = true)
    FrameLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("test");
        alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog = alertDialog.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        });
        dialog.show();
        ButterKnife.init(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
    }
}
