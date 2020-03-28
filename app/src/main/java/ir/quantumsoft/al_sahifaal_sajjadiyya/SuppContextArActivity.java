package ir.quantumsoft.al_sahifaal_sajjadiyya;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class SuppContextArActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supp_context_ar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = (TextView) findViewById(R.id.suppTextView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        Typeface customFont = Typeface.createFromAsset(getAssets(),  "fonts/UthmanicHafs1 Ver09.otf");
        textView.setTypeface(customFont);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setTextSize(24);

        Intent intent = getIntent();
        final int position = intent.getIntExtra("position",0) + 1;
        String title = intent.getStringExtra("title");

        getSupportActionBar().setTitle(title);

        final DatabaseAccess access = DatabaseAccess.getInstance(this);
        access.open();

        textView.setText(access.getArabicSuppContext(position));
        access.close();




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                access.open();
                access.addToFavArabic(position);
                access.close();
                Snackbar.make(view, "برگزیده شد", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
