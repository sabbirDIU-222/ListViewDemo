package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // initialize the value of listview
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create all in one method
        allInOne();


    }

    public void allInOne(){
        /// initialize the listview
        listView =  findViewById(R.id.listviewId);
        // in string resouese we create a string array to create item
        // and to find them we need an array of  string
        /// so we take a string of array you can set any of it's reference name
        // then we can set it like {"","","", }
        // but we have a very alterativre way to find it
        // type getResources method which contain have getStringArray method
        // so call them and set the resourse array id in get Stirng array method

        final String[] get_array = getResources().getStringArray(R.array.country_name);

        // we know about adapter
        // in this season we use arrayadapter
        /// so what does array adapter do
        // it will work like a bridge
        // it convert the data source as a view
        // and convert it in our main layout view
        // what we see in ArrayAdapter construtor it's having overloading construcor
        // it take the context name , so put it
        // then it will take the layout which is created by layout resource file without no java file
        // then put it layout resource name
        // then it will take a id of which i want to covert my data source like
        // it can be a text view or something like that
        // then put it ...........
        // after that the perameter will take the string array , which we created to store our string
        // so put the array string
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.viewconvert,
                R.id.textViewID,get_array);
        // finished of array adapter work

        // now this is the time to set the adapter

        listView.setAdapter(arrayAdapter);
        // after setting the adapter we need to click on item
        // so when user click any item each item will show a short toast



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                // we create another array to put an assignment operator
                // and set our data source array string
                // because we want to make a toast which will print the item name
                // it is a very well known that the position of onItemClick start with 0
                // so if you want to see it start at position in 1
                // you can set it like position+1 in this way
                String countryname = get_array[position];

                Toast.makeText(MainActivity.this,
                        countryname + " " + position,Toast.LENGTH_LONG).show();

            }
        });

        }

}
