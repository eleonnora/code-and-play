package rtrk.pnrs.codeandplay;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class ResultActivity extends Activity {

    public ImageView text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Drawable backr = findViewById(R.id.backround).getBackground();
        //backr.setAlpha(50);
        text1 = (ImageView) findViewById(R.id.winnertext);
        text2 = (ImageView) findViewById(R.id.losertext);

        text1.setVisibility(View.INVISIBLE);
        text2.setVisibility(View.INVISIBLE);


        if (Main2Activity.counterTrue > 3) {
            text1.setVisibility(View.VISIBLE);
            text1.bringToFront();
            text2.setVisibility(View.INVISIBLE);
        } else {
            text2.setVisibility(View.VISIBLE);
            text1.setVisibility(View.INVISIBLE);
            text2.bringToFront();


        }
    }
}

