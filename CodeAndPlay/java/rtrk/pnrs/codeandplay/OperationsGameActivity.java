package rtrk.pnrs.codeandplay;

/**
 * Created by nora on 5/14/2016.
 */

import android.widget.TextView;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OperationsGameActivity extends Activity implements View.OnClickListener{

    private boolean mainDone = false;
    private boolean printDone = false;
    private boolean returnDone = false;
    private boolean aDone = false;
    private boolean bDone = false;
    private boolean cDone = false;
    private boolean okDone = false;

    private Drawable backround;

    Button main;
    Button a;
    Button b;
    Button c;
    Button ok;
    Button print;
    Button return0;

    TextView mainText;
    TextView aText;
    TextView aTextSec;
    TextView bText;
    TextView bTextSec;
    TextView cText;
    TextView cTextSec;
    TextView printText;
    TextView returnText;
    TextView cTerm;

    EditText aEdit;
    EditText bEdit;
    EditText cEdit;

    Editable aChange;
    Editable bChange;
    Editable cChange;

    int ai, bi;
    double ci;
    String cs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations_game);

        findViewById(R.id.mainButton).setOnClickListener(this);
        findViewById(R.id.printfButton).setOnClickListener(this);
        findViewById(R.id.return0Button).setOnClickListener(this);
        findViewById(R.id.end).setOnClickListener(this);
        findViewById(R.id.aButton).setOnClickListener(this);
        findViewById(R.id.bButton).setOnClickListener(this);
        findViewById(R.id.cButton).setOnClickListener(this);
        findViewById(R.id.okButton).setOnClickListener(this);

        backround = (Drawable) findViewById(R.id.backArim).getBackground();
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

            case R.id.aButton:
                if (mainDone)
                {
                    a = (Button) findViewById(R.id.aButton);
                    a.setEnabled(false);

                    aText = (TextView)  findViewById(R.id.a);
                    aText.setVisibility(View.VISIBLE);

                    aEdit = (EditText) findViewById(R.id.aEdit);
                    aEdit.setVisibility(View.VISIBLE);

                    aTextSec = (TextView)  findViewById(R.id.aSecond);
                    aTextSec.setVisibility(View.VISIBLE);

                    aDone = true;
                }
                break;

            case R.id.bButton:
                if (mainDone && aDone)
                {
                    b = (Button) findViewById(R.id.bButton);
                    b.setEnabled(false);

                    bText = (TextView)  findViewById(R.id.b);
                    bText.setVisibility(View.VISIBLE);

                    bEdit = (EditText) findViewById(R.id.bEdit);
                    bEdit.setVisibility(View.VISIBLE);

                    bTextSec = (TextView)  findViewById(R.id.bSecond);
                    bTextSec.setVisibility(View.VISIBLE);

                    bDone = true;
                }
                break;

            case R.id.cButton:
                if (mainDone && aDone && bDone)
                {
                    c = (Button) findViewById(R.id.cButton);
                    c.setEnabled(false);

                    cText = (TextView)  findViewById(R.id.c);
                    cText.setVisibility(View.VISIBLE);

                    cEdit = (EditText) findViewById(R.id.cEdit);
                    cEdit.setVisibility(View.VISIBLE);

                    cTextSec = (TextView)  findViewById(R.id.cSecond);
                    cTextSec.setVisibility(View.VISIBLE);

                    cDone = true;
                }
                break;

            case R.id.printfButton:
                if (mainDone && aDone && bDone && cDone)
                {
                    print = (Button) findViewById(R.id.printfButton);
                    print.setEnabled(false);

                    printText = (TextView)  findViewById(R.id.printf);
                    printText.setVisibility(View.VISIBLE);


                    printDone = true;
                }
                break;

            case R.id.return0Button:
                if (mainDone && aDone && bDone && cDone && printDone && okDone)
                {
                    return0 = (Button) findViewById(R.id.return0Button);
                    return0.setEnabled(false);

                    returnText = (TextView) findViewById(R.id.return0);
                    returnText.setVisibility(View.VISIBLE);

                    ai = Integer.parseInt(aEdit.getText().toString());
                    bi = Integer.parseInt(bEdit.getText().toString());

                    if (cEdit.getText().toString().equals("+"))
                        ci = ai + bi;
                    else if (cEdit.getText().toString().equals("-"))
                        ci = ai - bi;
                    else if (cEdit.getText().toString().equals("*")) {
                        ci = ai * bi;
                    }
                    else if (cEdit.getText().toString().equals("/"))
                        ci = (double)ai / (double)bi;

                    cs = ">> c = " + ci;


                    cTerm = (TextView) findViewById(R.id.cTerm);
                    cTerm.setVisibility(View.VISIBLE);
                    cTerm.setText(cs);

                    returnDone = true;
                }
                break;

            case R.id.okButton:
                if (mainDone && aDone && bDone && cDone && printDone) {
                    okDone = true;

                }
                break;

            case R.id.end:
                if (mainDone && aDone && bDone && cDone && printDone && returnDone)
                {
                    startActivity(new Intent(this, EndActivity.class));
                    break;
                }
        }
    }
}
