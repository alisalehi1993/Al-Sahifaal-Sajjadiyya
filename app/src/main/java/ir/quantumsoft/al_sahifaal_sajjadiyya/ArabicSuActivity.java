package ir.quantumsoft.al_sahifaal_sajjadiyya;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ArabicSuActivity extends AppCompatActivity {


    ListView suppListView ;
    List <String> title;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_su);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ادعیه");

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        title = databaseAccess.getTitles();

        databaseAccess.close();

        suppListView = (ListView) findViewById(R.id.ArabicSuppList);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , title);

        suppListView.setAdapter(arrayAdapter);






        suppListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SuppContextArActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("title" , title.get(position));
                Log.i("position",String.valueOf(position));
                startActivity(intent);
            }
        });


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
