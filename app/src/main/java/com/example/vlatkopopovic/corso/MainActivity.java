package com.example.vlatkopopovic.corso;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {
   // List<ItemModel> allItems;


    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /*  fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/




       //TEST BEZ BAZE
         RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // recyclerView.setNestedScrollingEnabled(false);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    if (fab.isShown()) fab.hide();
                } else {
                    if (!fab.isShown()) fab.show();
                }
            }
        });
      /*  ItemModel im = new ItemModel(001,"Coca Cola", 300, "10.7.2018. 28:56");
        ItemModel im1 = new ItemModel(002,"Viski", 23, "10.7.2018. 28:56");
        ItemModel im2 = new ItemModel(003,"Vino", 444, "10.7.2018. 28:56");
        ItemModel im3 = new ItemModel(004,"Fanta", 234, "10.7.2018. 28:56");
        ItemModel im4 = new ItemModel(005,"Sprite", 54, "10.7.2018. 28:56");
        ItemModel im5 = new ItemModel(006,"Mirinda", 56, "10.7.2018. 28:56");

       ima.add(im);
        ima.add(im1);
        ima.add(im2);
        ima.add(im3);
        ima.add(im4);
        ima.add(im5);*/
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "magacin").allowMainThreadQueries().build();
      //  db.itemDao().insertAll(new ItemModel(001,"Coca Cola", 300, "10.7.2018. 28:56"));
        RecyclerView.Adapter adapter = new RecyclerViewAdapter(db.itemDao().getAll(),this);
       recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
