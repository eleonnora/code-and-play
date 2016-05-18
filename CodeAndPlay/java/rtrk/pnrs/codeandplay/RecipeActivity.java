package rtrk.pnrs.codeandplay;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class RecipeActivity extends Activity {

    public Drawable cupcakeBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        cupcakeBackground=findViewById(R.id.cupcake).getBackground();
        cupcakeBackground.setAlpha(100);

    }
}
