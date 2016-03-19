package com.cfi.bhraman;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chhavi on 19/3/16.
 */
public class GroupsMainActivity extends AppCompatActivity {


    ListView groupsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groups_main);
        groupsList = (ListView)findViewById(R.id.groups_list);

        ArrayList<String> groups = new ArrayList<>();
        groups.add("Family");
        groups.add("Friends");
     //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(R.layout.groups_item_layout, R.id.group_name, groups);


    }

    public class GroupsListAdapter extends ArrayAdapter<Person>{

        List<Person> persons;
        Context context;
        public GroupsListAdapter(Context context, List objects) {
            super(context, 0, objects);
            this.context = context;
            this.persons = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }
    }
}
