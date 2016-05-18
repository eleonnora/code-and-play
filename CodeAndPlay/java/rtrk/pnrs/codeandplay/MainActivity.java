package rtrk.pnrs.codeandplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    Button next1, next2, next3;
    ImageView image1, image2, image3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_main);

        next1 = (Button) findViewById(R.id.NextButton1);
        next1.setOnClickListener(this);
        next1.setVisibility(View.VISIBLE);
        next1.setEnabled(true);

        next2 = (Button) findViewById(R.id.NextButton2);
        next2.setOnClickListener(this);
        next2.setVisibility(View.INVISIBLE);
        next2.setEnabled(false);


        next3 = (Button) findViewById(R.id.NextButton3);
        next3.setOnClickListener(this);
        next3.setVisibility(View.INVISIBLE);
        next3.setEnabled(false);

        image1 = (ImageView) findViewById(R.id.image1);
        image1.setOnClickListener(this);

        image2 = (ImageView) findViewById(R.id.image2);
        image2.setOnClickListener(this);
        image2.setVisibility(View.INVISIBLE);

        image3 = (ImageView) findViewById(R.id.image3);
        image3.setOnClickListener(this);
        image3.setVisibility(View.INVISIBLE);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.NextButton1:
                next1.setVisibility(View.INVISIBLE);
                next1.setEnabled(false);

                next3.setVisibility(View.INVISIBLE);
                next3.setEnabled(false);

                next2.setVisibility(View.VISIBLE);
                next2.setEnabled(true);


                image1.setVisibility(ImageView.INVISIBLE);

                image2.setVisibility(ImageView.VISIBLE);
                image2.bringToFront();
                next2.bringToFront();

                break;

            case R.id.NextButton2:
                Log.d("caos", "button2");
                next1.setVisibility(View.INVISIBLE);
                next1.setEnabled(false);
                next2.setVisibility(View.INVISIBLE);


                next3.setVisibility(View.VISIBLE);
                next3.setEnabled(true);


                image1.setVisibility(ImageView.INVISIBLE);
                image2.setVisibility(ImageView.INVISIBLE);

                image3.setVisibility(ImageView.VISIBLE);
                image3.bringToFront();
                next2.setEnabled(false);
                next3.bringToFront();

                break;

            case R.id.NextButton3:
                next1.setVisibility(View.INVISIBLE);
                next2.setVisibility(View.INVISIBLE);
                next3.setVisibility(View.INVISIBLE);

                next1.setEnabled(false);
                next2.setEnabled(false);
                next3.setEnabled(false);


                image1.setVisibility(ImageView.INVISIBLE);
                image2.setVisibility(ImageView.INVISIBLE);
                image3.setVisibility(ImageView.INVISIBLE);

                Intent menu_intent = new Intent(MainActivity.this, PrimaryMain.class);
                startActivity(menu_intent);

                // break;


        }

    }
}

