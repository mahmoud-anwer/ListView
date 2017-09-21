package com.example.root.others;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by root on 9/20/17.
 */



public class MyCustomAdapter extends BaseAdapter {
    ArrayList<ListItem> Items = new ArrayList<ListItem>();
    Context context;

    MyCustomAdapter(Context context, ArrayList<ListItem> Items){
        this.context = context;
        this.Items = Items;
    }

    @Override
    public int getCount(){
        return Items.size();
    }

    @Override
    public Object getItem(int index){
        return Items.get(index).name;
    }

    @Override
    public long getItemId(int id){
        return id;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup ){

        final String tmp = Items.get(i).name;
        LayoutInflater Linflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        //LayoutInflater Linflater = getLayoutInflater();
        View Lview = Linflater.inflate(R.layout.row_view, null);
        TextView name = (TextView)Lview.findViewById(R.id.textViewName);
        TextView description = (TextView)Lview.findViewById(R.id.textViewDesc);
        Button button = (Button)Lview.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getApplicationContext(), tmp, Toast.LENGTH_LONG).show();
            }
        });
        name.setText(Items.get(i).name);
        description.setText(Items.get(i).desc);
        return Lview;
    }

}
