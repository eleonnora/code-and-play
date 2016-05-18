package rtrk.pnrs.codeandplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cake extends Activity implements View.OnClickListener {

    public Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);
        next= (Button) findViewById(R.id.next_phase);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.next_phase){
            Intent intent = new Intent(Cake.this, PrimaryMain.class);
            startActivity(intent);
        }
    }
}