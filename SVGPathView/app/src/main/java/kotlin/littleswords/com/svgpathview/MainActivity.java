package kotlin.littleswords.com.svgpathview;

import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mcxtzhang.pathanimlib.PathAnimView;
import com.mcxtzhang.pathanimlib.utils.SvgPathParser;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {

    private PathAnimView pathAnimView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Path sPath = new Path();
        sPath.moveTo(0, 0);
        SvgPathParser svgPathParser = new SvgPathParser();
        try {
            sPath = svgPathParser.parsePath("M 384.00,0.00\n" +
                    "           C 384.00,0.00 384.00,384.00 384.00,384.00\n" +
                    "             384.00,384.00 0.00,384.00 0.00,384.00\n" +
                    "             0.00,384.00 0.00,0.00 0.00,0.00\n" +
                    "             0.00,0.00 384.00,0.00 384.00,0.00 Z\n" +
                    "           M 127.00,111.92\n" +
                    "           C 93.61,139.68 81.17,187.17 95.70,228.00\n" +
                    "             106.00,256.96 127.17,277.01 155.00,289.00\n" +
                    "             155.00,289.00 155.00,96.00 155.00,96.00\n" +
                    "             145.50,98.69 134.55,105.64 127.00,111.92 Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        pathAnimView1 = (PathAnimView) findViewById(R.id.pathAnimView1);
        pathAnimView1.setSourcePath(sPath);
        pathAnimView1.startAnim();
    }
}
