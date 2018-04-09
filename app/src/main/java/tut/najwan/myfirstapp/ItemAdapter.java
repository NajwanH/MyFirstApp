package tut.najwan.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by user on 08/04/2018.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] items;
    String[] prices;
    String[] descriptions;

    public ItemAdapter(Context c, String[] items, String[] prices, String[] descriptions) {
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = items;
        this.prices = prices;
        this.descriptions = descriptions;
    }

    @Override // The size of the items
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override //Here we tell how to present the info, to do that we need a layoutInflater: my_listview_detail
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.my_listview_detail,null);
        TextView nameTextView =  v.findViewById(R.id.nameTextView);
        TextView priceTextView =  v.findViewById(R.id.priceTextView);
        TextView descriptionTextView =  v.findViewById(R.id.descriptionTextView);

        String name = items[position];
        return null;
    }
}
