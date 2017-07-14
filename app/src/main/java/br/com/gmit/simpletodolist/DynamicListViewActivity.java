package br.com.gmit.simpletodolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class DynamicListViewActivity extends AppCompatActivity {

    private EditText item;
        private ArrayList<String> list;
        private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_list_view);
        item = (EditText) findViewById(R.id.itemEditText);
        Button add = (Button) findViewById(R.id.addItemButton);
        ListView dynamicListView = (ListView) findViewById(R.id.itemsListView);

        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(DynamicListViewActivity.this, android.R.layout.simple_list_item_1, list);
        dynamicListView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoItem = item.getText().toString();
                if (todoItem.length() > 0) {
                    list.add(item.getText().toString());
                    adapter.notifyDataSetChanged();
                    item.setText("");
                }
            }


        });
        dynamicListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                list.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
