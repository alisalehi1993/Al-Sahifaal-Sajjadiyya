package ir.quantumsoft.al_sahifaal_sajjadiyya;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ArabicFavActivity extends AppCompatActivity {

    ListView listView;
    List<String> favList ;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_fav);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ادعیه برگزیده");

        listView = (ListView) findViewById(R.id.ArabicFavSuppList);

        DatabaseAccess access = DatabaseAccess.getInstance(this);
        access.open();
        favList = access.getArabicFvList();
        access.close();

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,favList);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ArabicFavSuppActivity.class);
                String  title = favList.get(position);
                intent.putExtra("title",title);
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
