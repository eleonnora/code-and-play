package rtrk.pnrs.codeandplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main2Activity extends Activity {

    public String[] questions = {"Can you ask for help? ", "Are you able to listen and evaluate the advice of the people around you?",
            "Can you inspire people and get them to follow you?","Are you confident enough to take action even though the outcome is uncertain?",
            "Can you work on your business and still work for someone else?","Are you good in math?","Do you enjoy solving problems?"};
    public TextView que;
    public CheckBox checkBoxT, checkBoxF;
    public ImageButton nextQue;
    public int counterNumQ = 0;
    public static int counterTrue = 0, counterFalse = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        que = (TextView) findViewById(R.id.question);
        checkBoxT = (CheckBox) findViewById(R.id.checkBoxT);
        checkBoxF = (CheckBox) findViewById(R.id.checkBoxF);
        nextQue = (ImageButton) findViewById(R.id.imageButton);

        nextQue.setEnabled(false);

    }


    public void itemClickedT(View v) {
        CheckBox checkBox = (CheckBox) v;
        if (checkBox.isChecked()) {
            checkBoxF.setEnabled(false);
            checkBoxT.setEnabled(false);
            counterTrue++;
            counterNumQ++;
            nextQue.setEnabled(true);
            Log.d("trueeee", "aaaaaaaa");
        }
    }

    public void itemClickedF(View v) {
        CheckBox checkBox = (CheckBox) v;
        if (checkBox.isChecked()) {
            checkBoxF.setEnabled(false);
            checkBoxT.setEnabled(false);
            counterFalse++;
            counterNumQ++;
            nextQue.setEnabled(true);
            Log.d("falseeee", "kkkkkk");
        }
    }

    public void itemClickedNext(View v) {
        Log.d("activiti2", "next button");
        ImageButton imageButton = (ImageButton) v;
        if (imageButton.isClickable()) {
            if (counterNumQ == 7) {
                Intent intent = new Intent(Main2Activity.this, ResultActivity.class);
                startActivity(intent);
            } else {
                que.setText(questions[counterNumQ - 1]);
                checkBoxF.setEnabled(true);
                checkBoxT.setEnabled(true);
                nextQue.setEnabled(false);
                checkBoxF.setChecked(false);
                checkBoxT.setChecked(false);

            }
        }
    }

}
