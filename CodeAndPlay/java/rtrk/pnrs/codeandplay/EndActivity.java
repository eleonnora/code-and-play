package rtrk.pnrs.codeandplay;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class EndActivity extends Activity implements View.OnClickListener{
    Drawable layout;
    private Button menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        menu = (Button) findViewById(R.id.button);
        menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(EndActivity.this, PrimaryMain.class);
        startActivity(intent);
    }
}
