package com.cfi.bhraman;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chhavi on 19/3/16.
 */
public class GroupsMainActivity extends AppCompatActivity {


    ListView groupsList;
    GroupsListAdapter adapter;

    ArrayList<Person> persons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groups_main);
        groupsList = (ListView)findViewById(R.id.groups_list);

      persons = new ArrayList<>();
      /*  groups.add("Family");
        groups.add("Friends");*/
     //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(R.layout.groups_item_layout, R.id.group_name, groups);

         adapter = new GroupsListAdapter(GroupsMainActivity.this, persons);
        groupsList.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.groups_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.add_member){
                persons.add(new Person("Ramesh", "as45154"));
            adapter.notifyDataSetChanged();


        }
        return true;
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

            View view = LayoutInflater.from(context).inflate(R.layout.groups_item_layout, null, false);
            Person person = persons.get(position);
            TextView name = (TextView)view.findViewById(R.id.name_person);
            TextView id= (TextView)view.findViewById(R.id.person_id);

            name.setText(person.getName());
            id.setText(person.getId());
         /*   if(person.getImageResouce()==0) {
                ImageView im =(ImageView) view.findViewById(R.id.person_image);
                im.setImageResource(person.getImageResouce());

            }*/
            return view;
        }

        @Override
        public int getCount() {
            return persons.size();
        }
    }
}
