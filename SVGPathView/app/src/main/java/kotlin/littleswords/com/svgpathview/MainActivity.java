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
                    "             145.50,98.69 134.55,105.64 127.00,111.92 "+"M 195.00,89.00\n" +
                    "           C 219.87,89.04 246.64,101.30 263.83,119.09\n" +
                    "             312.33,169.29 298.78,253.64 236.00,285.03\n" +
                    "             217.58,294.24 203.94,295.00 184.00,295.00\n" +
                    "             184.00,295.00 184.00,230.00 184.00,230.00\n" +
                    "             230.47,229.58 267.45,183.93 249.24,139.00\n" +
                    "             246.29,131.71 240.18,122.80 234.71,117.17\n" +
                    "             225.87,108.04 213.35,100.75 201.00,97.66\n" +
                    "             186.72,94.09 184.35,98.86 184.00,89.00\n" +
                    "             184.00,89.00 195.00,89.00 195.00,89.00 Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        pathAnimView1 = (PathAnimView) findViewById(R.id.pathAnimView1);
        pathAnimView1.setSourcePath(sPath);
        pathAnimView1.startAnim();
    }
}
