package ir.quantumsoft.al_sahifaal_sajjadiyya;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void getAbout (View view){

        Intent intent = new Intent(this,AboutActivity.class);
        startActivity(intent);
    }

    public void getArabic (View view){

        Intent intent = new Intent(this,ArabicActivity.class);
        startActivity(intent);

    }
    public void getEnglish (View view){

        Intent intent = new Intent(this,EnglishActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("صحیفه سجادیه");



    }
}
