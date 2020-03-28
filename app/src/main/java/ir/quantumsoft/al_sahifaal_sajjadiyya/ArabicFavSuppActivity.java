package ir.quantumsoft.al_sahifaal_sajjadiyya;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ArabicFavSuppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_fav_supp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        getSupportActionBar().setTitle(title);


        TextView textView = (TextView) findViewById(R.id.favSuppTextView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        Typeface customFont = Typeface.createFromAsset(getAssets(),  "fonts/UthmanicHafs1 Ver09.otf");
        textView.setTypeface(customFont);

        textView.setTextSize(24);


        DatabaseAccess access = DatabaseAccess.getInstance(this);
        access.open();
        String text = access.getArabicFavSupp(title);
        textView.setText(text);
        access.close();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
