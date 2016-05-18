package rtrk.pnrs.codeandplay;

/**
 * Created by nora on 5/14/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloGameActivity extends Activity implements View.OnClickListener {

    Button main;
    Button printf;
    Button rtrn;

    TextView mainText;
    TextView printfText;
    TextView returnText;
    TextView hello;

    private boolean mainDone = false;
    private boolean printDone = false;
    private boolean returnDone = false;


    private Drawable backround;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_game);

        findViewById(R.id.mainButton).setOnClickListener(this);
        findViewById(R.id.printfButton).setOnClickListener(this);
        findViewById(R.id.return0Button).setOnClickListener(this);
        findViewById(R.id.next).setOnClickListener(this);

        backround = (Drawable) findViewById(R.id.back).getBackground();
        backround.setAlpha(20);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.mainButton:
                main = (Button) findViewById(R.id.mainButton);
                main.setEnabled(false);

                mainText = (TextView)  findViewById(R.id.main);
                mainText.setVisibility(View.VISIBLE);

                mainDone = true;

                break;

            case R.id.printfButton:
                if (mainDone)
                {
                    printf = (Button) findViewById(R.id.printfButton);
                    printf.setEnabled(false);

                    printfText = (TextView)  findViewById(R.id.printf);
                    printfText.setVisibility(View.VISIBLE);


                    printDone = true;
                }
                break;

            case R.id.return0Button:
                if (mainDone && printDone)
                {
                    rtrn = (Button) findViewById(R.id.return0Button);
                    rtrn.setEnabled(false);

                    returnText = (TextView) findViewById(R.id.return0);
                    returnText.setVisibility(View.VISIBLE);

                    hello = (TextView) findViewById(R.id.helloTerm);
                    hello.setVisibility(View.VISIBLE);

                    returnDone = true;
                }

                break;

            case R.id.next:
                if (mainDone && printDone && returnDone)
                {
                    startActivity(new Intent(this, OperationsGameActivity.class));
                    break;
                }
        }
    }

}

