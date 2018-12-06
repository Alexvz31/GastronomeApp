package com.example.alexis.gastronome;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    public static List<MealItem> mealItems;
    private RecyclerView rv;
    private RVAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.my_recycler_view);
        rv.setLayoutManager(new GridLayoutManager(this, 1));


        initializeData();
        initializeAdapter();

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            /**
             * Method that defines the drag and drop functionality
             * @param recyclerView The RecyclerView that contains the list items
             * @param viewHolder The SportsViewHolder that is being moved
             * @param target The SportsViewHolder that you are switching the original one with.
             * @return returns true if the item was moved, false otherwise
             */
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                //Get the from and to position
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                //Swap the items and notify the adapter
                Collections.swap(mealItems, from, to);
                adapter.notifyItemMoved(from, to);
                return true;
            }

            /**
             * Method that defines the swipe to dismiss functionality
             * @param viewHolder The viewholder being swiped
             * @param direction The direction it is swiped in
             */
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                //Remove the item from the dataset
                mealItems.remove(viewHolder.getAdapterPosition());

                //Notify the adapter
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        //Attach the helper to the RecyclerView
        helper.attachToRecyclerView(rv);
    }


    /**
     * Method for initializing the meal data from resources.
     */

    private void initializeData(){
        mealItems= new ArrayList<>();
        mealItems.add(new MealItem("Salmon", "Here is a Salmon recipe", R.drawable.food_item1));
        mealItems.add(new MealItem("Pizza", "Here is a Pizza recipe", R.drawable.food_item2));
        mealItems.add(new MealItem("Burger", "Here is a Burger recipe", R.drawable.food_item3));


    }


    private void initializeAdapter(){
        adapter = new RVAdapter(this,mealItems);
        rv.setAdapter(adapter);
    }


    public void addFoodItem(View view) {

        PopupMenu popUpMenu = new PopupMenu(this, view);
        popUpMenu.setOnMenuItemClickListener(this);
        popUpMenu.inflate(R.menu.menu_items);
        popUpMenu.show();


    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.item1:
                mealItems.add(new MealItem("Cookies", "Here is a Cookie recipe", R.drawable.food_item4));
                initializeAdapter();
                return true;
            case R.id.item2:
                mealItems.add(new MealItem("Chicken Nuggets", "Here is a Chicken Nuggets recipe", R.drawable.food_item5));
                initializeAdapter();
                return true;
            default:
                return false;
        }

    }
}
