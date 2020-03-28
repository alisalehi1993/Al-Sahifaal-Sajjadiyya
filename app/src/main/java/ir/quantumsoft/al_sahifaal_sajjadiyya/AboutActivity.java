package ir.quantumsoft.al_sahifaal_sajjadiyya;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("درباره ما");

        TextView textView = (TextView) findViewById(R.id.aboutText);
        textView.setMovementMethod(new ScrollingMovementMethod());
        Typeface customFont = Typeface.createFromAsset(getAssets(),  "fonts/QuranTaha.ttf");
        textView.setTypeface(customFont);

        textView.setTextSize(24);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
