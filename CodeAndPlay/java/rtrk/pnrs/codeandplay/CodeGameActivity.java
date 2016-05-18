package rtrk.pnrs.codeandplay;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CodeGameActivity extends Activity implements View.OnClickListener {


    static final int NUM_OF_EGGS = 4;
    static final int NUM_OF_MILK = 2;
    static final int NUM_OF_FLOUR = 3;
    static final int NUM_OF_SUGAR = 5;
    static final int NUM_OF_OIL = 1;


    public Button addSugar, addMilk, addFlour, addOil, submitButton, plus, minus, addEgg, addChoco,recipe;
    public CheckBox blackCh, whiteCh;
    public TextView forText, intQuantity;
    public TextView number;
    static public boolean sugarAllow, milkAllow, flourAllow, oilAllow, globalAllow, eggAllow, chocAllow;
    public ImageView e1, e2, e3, e4, e5, sg, ml, oil, fl, ch, w_ch;
    static int num;
    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_game);

        addSugar = (Button) findViewById(R.id.add_sugar);
        addMilk = (Button) findViewById(R.id.add_milk);
        addFlour = (Button) findViewById(R.id.add_flour);
        addOil = (Button) findViewById(R.id.add_oil);
        addEgg = (Button) findViewById(R.id.add_egg);
        addChoco = (Button) findViewById(R.id.add_choco);
        submitButton = (Button) findViewById(R.id.submit_button);
        recipe=(Button)findViewById(R.id.recipe);

        e1 = (ImageView) findViewById(R.id.egg1);
        e2 = (ImageView) findViewById(R.id.egg2);
        e3 = (ImageView) findViewById(R.id.egg3);
        e4 = (ImageView) findViewById(R.id.egg4);
        e5 = (ImageView) findViewById(R.id.egg5);

        sg = (ImageView) findViewById(R.id.sugarimg);
        ml = (ImageView) findViewById(R.id.milkimg);
        oil = (ImageView) findViewById(R.id.oilimg);
        fl = (ImageView) findViewById(R.id.flourimg);
        ch = (ImageView) findViewById(R.id.choco);
        w_ch = (ImageView) findViewById(R.id.white_choco);

        blackCh = (CheckBox) findViewById(R.id.checkBoxBlackCh);
        whiteCh = (CheckBox) findViewById(R.id.checkBoxWhiteCh);

        e1.setVisibility(View.INVISIBLE);
        e2.setVisibility(View.INVISIBLE);
        e3.setVisibility(View.INVISIBLE);
        e4.setVisibility(View.INVISIBLE);
        e5.setVisibility(View.INVISIBLE);
        sg.setVisibility(View.INVISIBLE);
        ml.setVisibility(View.INVISIBLE);
        oil.setVisibility(View.INVISIBLE);
        fl.setVisibility(View.INVISIBLE);
        ch.setVisibility(View.INVISIBLE);
        w_ch.setVisibility(View.INVISIBLE);
        blackCh.setVisibility(View.INVISIBLE);
        whiteCh.setVisibility(View.INVISIBLE);


        forText = (TextView) findViewById(R.id.for_text);
        intQuantity = (TextView) findViewById(R.id.int_quantity);

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        number = (TextView) findViewById(R.id.number);

        addSugar.setOnClickListener(this);
        addMilk.setOnClickListener(this);
        addFlour.setOnClickListener(this);
        addOil.setOnClickListener(this);
        addEgg.setOnClickListener(this);
        addChoco.setOnClickListener(this);
        submitButton.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        recipe.setOnClickListener(this);

        sugarAllow = false;
        milkAllow = false;
        flourAllow = false;
        oilAllow = false;
        eggAllow = false;
        chocAllow = false;

        num = 0;
        points=0;
    }

    void disableAll() {
        flourAllow = false;
        sugarAllow = false;
        milkAllow = false;
        oilAllow = false;
        eggAllow = false;
        chocAllow = false;
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.recipe){
            Intent intent=new Intent(CodeGameActivity.this,Recepie.class);
            startActivity(intent);
        }else if (view.getId() == R.id.add_flour) {
            flourAllow = true;
            sugarAllow = false;
            milkAllow = false;
            oilAllow = false;
            eggAllow = false;
            chocAllow = false;
            plus.setVisibility(View.VISIBLE);
            minus.setVisibility(View.VISIBLE);
            blackCh.setVisibility(View.INVISIBLE);
            whiteCh.setVisibility(View.INVISIBLE);
            intQuantity.setVisibility(View.VISIBLE);
            number.setVisibility(View.VISIBLE);
            intQuantity.setText("Int flourQuantity=");
        } else if (view.getId() == R.id.add_milk) {
            flourAllow = false;
            sugarAllow = false;
            milkAllow = true;
            oilAllow = false;
            eggAllow = false;
            chocAllow = false;
            plus.setVisibility(View.VISIBLE);
            minus.setVisibility(View.VISIBLE);
            blackCh.setVisibility(View.INVISIBLE);
            whiteCh.setVisibility(View.INVISIBLE);
            number.setVisibility(View.VISIBLE);
            intQuantity.setVisibility(View.VISIBLE);
            intQuantity.setText("Int milkQuantity=");
        } else if (view.getId() == R.id.add_oil) {
            flourAllow = false;
            sugarAllow = false;
            milkAllow = false;
            oilAllow = true;
            eggAllow = false;
            chocAllow = false;
            plus.setVisibility(View.VISIBLE);
            minus.setVisibility(View.VISIBLE);
            number.setVisibility(View.VISIBLE);
            blackCh.setVisibility(View.INVISIBLE);
            whiteCh.setVisibility(View.INVISIBLE);
            intQuantity.setVisibility(View.VISIBLE);
            intQuantity.setText("Int oilQuantity=");
        } else if (view.getId() == R.id.add_sugar) {
            flourAllow = false;
            sugarAllow = true;
            milkAllow = false;
            oilAllow = false;
            eggAllow = false;
            chocAllow = false;
            plus.setVisibility(View.VISIBLE);
            minus.setVisibility(View.VISIBLE);
            number.setVisibility(View.VISIBLE);
            blackCh.setVisibility(View.INVISIBLE);
            whiteCh.setVisibility(View.INVISIBLE);
            intQuantity.setVisibility(View.VISIBLE);
            intQuantity.setText("Int sugarQuantity=");
        } else if (view.getId() == R.id.add_choco) {
            flourAllow = false;
            sugarAllow = false;
            milkAllow = false;
            oilAllow = false;
            eggAllow = false;
            chocAllow = true;
            plus.setVisibility(View.INVISIBLE);
            minus.setVisibility(View.INVISIBLE);
            blackCh.setVisibility(View.VISIBLE);
            whiteCh.setVisibility(View.VISIBLE);
            number.setVisibility(View.INVISIBLE);
            intQuantity.setVisibility(View.INVISIBLE);
        } else if (view.getId() == R.id.add_egg) {
            flourAllow = false;
            sugarAllow = false;
            milkAllow = false;
            oilAllow = false;
            eggAllow = true;
            chocAllow = false;
            plus.setVisibility(View.VISIBLE);
            minus.setVisibility(View.VISIBLE);
            number.setVisibility(View.VISIBLE);
            blackCh.setVisibility(View.INVISIBLE);
            whiteCh.setVisibility(View.INVISIBLE);
            intQuantity.setVisibility(View.VISIBLE);
            intQuantity.setText("Int eggQuantity=");
        } else if (view.getId() == R.id.plus) {
            if (num < 6) {
                num++;
                number.setText(String.valueOf(num));
            }
        } else if (view.getId() == R.id.minus) {
            if (num > 0) {
                num--;
                number.setText(String.valueOf(num));
            }
        } else if (view.getId() == R.id.submit_button) {
            Log.d("dugme", "submit");
            if (eggAllow && num == NUM_OF_EGGS) {
                e1.setVisibility(View.VISIBLE);
                e2.setVisibility(View.VISIBLE);
                e3.setVisibility(View.VISIBLE);
                e4.setVisibility(View.VISIBLE);
                points++;
                disableAll();
                forText.setText("  FOR(I=0;I<" + num + ";I++)\n" +
                        "                    add_egg(quantity);");

            } else if(eggAllow && num != NUM_OF_EGGS) {
                Toast.makeText(CodeGameActivity.this, "NOT THE RIGHT AMOUNT",
                        Toast.LENGTH_LONG).show();
            }
            if (flourAllow && num == NUM_OF_FLOUR) {
                fl.setVisibility(View.VISIBLE);
                points++;
                disableAll();
                forText.setText("  FOR(I=0;I<" + num + ";I++)\n" +
                        "                    add_flour(spoons);");
            } else  if (flourAllow && num != NUM_OF_FLOUR){
                Toast.makeText(CodeGameActivity.this, "NOT THE RIGHT AMOUNT",
                        Toast.LENGTH_LONG).show();
            }
            if (oilAllow && num == NUM_OF_OIL) {
                oil.setVisibility(View.VISIBLE);
                points++;
                disableAll();
                forText.setText("  FOR(I=0;I<" + num + ";I++)\n" +
                        "                    add_oil(spoons);");
            } else if (oilAllow && num != NUM_OF_OIL){
                Toast.makeText(CodeGameActivity.this, "NOT THE RIGHT AMOUNT",
                        Toast.LENGTH_LONG).show();
            }
            if (sugarAllow && num == NUM_OF_SUGAR) {
                sg.setVisibility(View.VISIBLE);
                points++;
                disableAll();
                forText.setText("  FOR(I=0;I<" + num + ";I++)\n" +
                        "                    add_sugar(spoons);");
            } else if (sugarAllow && num != NUM_OF_SUGAR) {
                Toast.makeText(CodeGameActivity.this, "NOT THE RIGHT AMOUNT",
                        Toast.LENGTH_LONG).show();
            }
            if (milkAllow && num == NUM_OF_MILK) {
                ml.setVisibility(View.VISIBLE);
                points++;
                disableAll();
                forText.setText("  FOR(I=0;I<" + num + ";I++)\n" +
                        "                    add_milk(spoons);");
                Log.d("dugme", "submit22");
            } else if (milkAllow && num != NUM_OF_MILK) {
                Toast.makeText(CodeGameActivity.this, "NOT THE RIGHT AMOUNT",
                        Toast.LENGTH_LONG).show();
            }
            if (chocAllow && blackCh.isChecked() && !whiteCh.isChecked()) {
                ch.setVisibility(View.VISIBLE);
                points++;
                disableAll();
                forText.setText("IF(choice==white_chocolate" +
                        "               add(white_chocolate);" +
                        "        IF(choice==black_chocolate)" +
                        "               add(black_chocolate);");

            } else  if (chocAllow && blackCh.isChecked() && whiteCh.isChecked()){
                Toast.makeText(CodeGameActivity.this, "CHOSE ONLY ONE INGREDIENT FROM TWO",
                        Toast.LENGTH_LONG).show();
            }
            if (chocAllow && whiteCh.isChecked() && !blackCh.isChecked()) {
                w_ch.setVisibility(View.VISIBLE);
                points++;
                disableAll();
                forText.setText("IF(choice==white_chocolate" +
                        "               add(white_chocolate);" +
                        "        IF(choice==black_chocolate)" +
                        "               add(black_chocolate);");
            } else if (chocAllow &&whiteCh.isChecked() && blackCh.isChecked()){
                Toast.makeText(CodeGameActivity.this, "CHOSE ONLY ONE INGREDIENT FROM TWO",
                        Toast.LENGTH_LONG).show();
            }
            if(points==6){
                Intent intent=new Intent(CodeGameActivity.this,Cake.class);
                startActivity(intent);
            }
        }


    }
}
