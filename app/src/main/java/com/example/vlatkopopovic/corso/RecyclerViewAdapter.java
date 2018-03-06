package com.example.vlatkopopovic.corso;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vlatko Popovic on 3/2/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    //MODEL
    List<ItemModel> listItems;
    //CONTEXT
    Context context;

    public RecyclerViewAdapter(List<ItemModel> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        final ItemModel listItem = listItems.get(position);
        holder.itemId.setText(String.valueOf(listItem.getItemId()));
        holder.itemName.setText(listItem.getItemName());
        holder.itemCount.setText(String.valueOf(listItem.getItemCount()));
        holder.itemDate.setText(listItem.getItemDate());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemId;
        public TextView itemName;
        public TextView itemCount;
        public TextView itemDate;

        public ViewHolder(final View itemView) {
            super(itemView);
            itemId = itemView.findViewById(R.id.itemIdBase);
            itemName = itemView.findViewById(R.id.itemNameBase);
            itemCount = itemView.findViewById(R.id.itemCountBase);
            itemDate = itemView.findViewById(R.id.itemDateBase);



        }


    }

}
