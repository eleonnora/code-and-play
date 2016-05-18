package rtrk.pnrs.codeandplay;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PrimaryMain extends Activity implements View.OnClickListener {

    private Button cookAndCode, areYouForIt, tryYourself, learnMore, whatElse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cookAndCode = (Button) findViewById(R.id.cookAndCode);
        areYouForIt = (Button) findViewById(R.id.areYouForIT);
        tryYourself = (Button) findViewById(R.id.tryYourself);
        learnMore = (Button) findViewById(R.id.learnMore);
        // whatElse = (Button) findViewById(R.id.whatElse);

        cookAndCode.setOnClickListener(this);
        areYouForIt.setOnClickListener(this);
        tryYourself.setOnClickListener(this);
        learnMore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;

        if (v == cookAndCode) {
            Intent statisticIntent = new Intent(PrimaryMain.this, CodeGameActivity.class);
            startActivity(statisticIntent);
        } else if (v == areYouForIt) {
            Intent Main2Activity = new Intent(PrimaryMain.this, Main2Activity.class);
            startActivity(Main2Activity);
        } else if (v == tryYourself) {
            Intent statisticIntent = new Intent(PrimaryMain.this, HelloGameActivity.class);
            startActivity(statisticIntent);
        } else if (v == learnMore) {
            Intent statisticIntent = new Intent(PrimaryMain.this, LearnActivity.class);
            startActivity(statisticIntent);
        }
    }
}
