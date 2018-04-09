package tut.najwan.myfirstapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    ListView myList;
    String[] items;
    String[] prices;
    String[] descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Resources res = getResources();
        myList = findViewById(R.id.viewListView);
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);
        //Merging all together to set in one listView using support class ItemAdapter

        if(getIntent().hasExtra("ListViewKey") ){
            String txt = getIntent().getExtras().getString("ListViewKey");
            Toast viewListToast = Toast.makeText(getApplicationContext(),txt,Toast.LENGTH_SHORT);
            viewListToast.show();



        }
    }
}
