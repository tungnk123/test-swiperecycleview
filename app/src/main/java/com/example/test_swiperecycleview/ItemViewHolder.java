package com.example.test_swiperecycleview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewItemName;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewItemName = itemView.findViewById(R.id.textViewItemName);
    }
}
