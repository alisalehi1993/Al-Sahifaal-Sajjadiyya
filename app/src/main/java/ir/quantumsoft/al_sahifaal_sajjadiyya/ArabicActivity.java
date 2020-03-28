package ir.quantumsoft.al_sahifaal_sajjadiyya;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class ArabicActivity extends AppCompatActivity {

    public void getArabicFav(View view){
        Intent intent = new Intent(this ,ArabicFavActivity.class);
        startActivity(intent);

    }

    public void getArabicSupp (View view){

        Intent intent = new Intent(this ,ArabicSuActivity.class);
        startActivity(intent);
    }


    public void getAboutArabic (View view){

        Intent intent = new Intent(this ,AboutActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("الصحیفه السجادیه");
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
