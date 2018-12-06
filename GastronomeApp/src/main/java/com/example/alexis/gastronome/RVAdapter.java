package com.example.alexis.gastronome;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.util.Log.d;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.FoodViewHolder> {

    List<MealItem> meals;
    private Context mContext;

    RVAdapter(Context c, List<MealItem> meals){
        this.meals = meals;
        this.mContext = c;

    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FoodViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.card_view, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(FoodViewHolder foodViewHolder, int i) {
        MealItem currentSport = meals.get(i);

        //Bind the data to the views
        foodViewHolder.bindTo(currentSport);

    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView info;
        ImageView photo;
        MealItem mCurrentMeal;
        private Context mContext;

        FoodViewHolder(Context c, View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.food_name);
            info= (TextView)itemView.findViewById(R.id.info);
            photo = (ImageView)itemView.findViewById(R.id.food_photo);
            mContext = c;
            itemView.setOnClickListener(this);

        }

        void bindTo(MealItem currentMeal){
            //Populate the textviews with data
            name.setText(currentMeal.name);
            info.setText(currentMeal.info);
            photo.setImageResource(currentMeal.photoId);

            mCurrentMeal = currentMeal;

        }

        @Override
        public void onClick(View v) {
            Log.d("RVAdapter", "Button was clicked" );
            Intent detailIntent = MealItem.starter(mContext, mCurrentMeal.getName(),
                    mCurrentMeal.getImageResource());
            //Start the detail activity
            mContext.startActivity(detailIntent);
        }


    }

}

