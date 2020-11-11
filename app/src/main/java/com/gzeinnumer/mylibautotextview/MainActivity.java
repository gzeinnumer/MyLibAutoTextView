package com.gzeinnumer.mylibautotextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    ArrayList<AdapterAutoCompleteText.ModelClass> list = new ArrayList<>();
    AutoCompleteTextView act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        act = findViewById(R.id.act);

        simple1();
        simple2();
    }

    private void simple1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Zein");
        list.add("Zein2");
        list.add("Zein3");
        list.add("Zein4");

        AdapterAutoCompleteText<String> adapter = new AdapterAutoCompleteText<String>(getApplicationContext(), list);
        adapter.setItemStyle(R.style.AutoCompleteTextViewStyle);
        act.setAdapter(adapter);

        act.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                act.setText(list.get(position).toString(), false);
            }
        });
    }

    private void simple2() {


        ArrayList<ExampleModel> listObject = new ArrayList<>();
        listObject.add(new ExampleModel(1, "Zein", "Balbar"));
        listObject.add(new ExampleModel(2, "Zein2", "Balbar2"));
        listObject.add(new ExampleModel(3, "Zein3", "Balbar3"));
        listObject.add(new ExampleModel(4, "Zein4", "Balbar4"));

        AdapterAutoCompleteText<ExampleModel> adapter = new AdapterAutoCompleteText<ExampleModel>(getApplicationContext(), listObject);
        adapter.setItemStyle(R.style.AutoCompleteTextViewStyle);
        act.setAdapter(adapter);

        act.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                act.setText(listObject.get(position).toString(), false);
            }
        });
    }
}