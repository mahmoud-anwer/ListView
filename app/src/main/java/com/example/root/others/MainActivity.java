package com.example.root.others;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listViewList);
        final ArrayList<ListItem> Items = new ArrayList<ListItem>();
        Items.add(new ListItem("Anwer", "Programmer"));

        Items.add(new ListItem("Mahmoud", "Engineer"));
        final MyCustomAdapter myAdapter = new MyCustomAdapter(getApplicationContext(), Items);
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView name = (TextView)view.findViewById(R.id.textViewName);
                TextView description = (TextView)view.findViewById(R.id.textViewDesc);
                Toast.makeText(getApplicationContext(), "Name: "+ name.getText() + " Desc: " + description.getText(), Toast.LENGTH_LONG).show();
                //myAdapter.notifyDataSetChanged();
            }
        });

        /*
        setContentView(R.layout.activity_main);
        LayoutInflater myInflater = getLayoutInflater();
        View myView = myInflater.inflate(R.layout.welcome_activity, (ViewGroup)findViewById(R.id.linearLayout));
        TextView txt = (TextView)myView.findViewById(R.id.textviewWelcome);
        txt.setText("Hello");

        Toast myToast = new Toast(this);
        myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        myToast.setDuration(Toast.LENGTH_LONG);
        myToast.setView(myView);
        myToast.show();
        */
    }
}
