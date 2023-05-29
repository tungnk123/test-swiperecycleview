package com.example.test_swiperecycleview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<String> itemList;

    public ItemAdapter(List<String> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String itemName = itemList.get(position);
        holder.textViewItemName.setText(itemName);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void removeItem(int position) {
        itemList.remove(position);
        notifyItemRemoved(position);
    }

    public void checkDoneItem(int position) {
        // Perform check done action
        // You can update the item status or perform any other necessary operations
        itemList.remove(position);
        notifyItemChanged(position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewItemName;
        public Button buttonDelete;
        public Button buttonCheckDone;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textViewItemName = itemView.findViewById(R.id.textViewItemName);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
            buttonCheckDone = itemView.findViewById(R.id.buttonCheckDone);

            // Set different icons and colors for buttons
            Drawable deleteIcon = ContextCompat.getDrawable(itemView.getContext(), R.drawable.ic_launcher_background);
            Drawable checkDoneIcon = ContextCompat.getDrawable(itemView.getContext(), R.drawable.baseline_done_24);
            int deleteColor = ContextCompat.getColor(itemView.getContext(), R.color.purple_200);
            int checkDoneColor = ContextCompat.getColor(itemView.getContext(), R.color.teal_200);

            buttonDelete.setCompoundDrawablesWithIntrinsicBounds(deleteIcon, null, null, null);
            buttonCheckDone.setCompoundDrawablesWithIntrinsicBounds(checkDoneIcon, null, null, null);
            buttonDelete.setBackgroundColor(deleteColor);
            buttonCheckDone.setBackgroundColor(checkDoneColor);
        }
    }
}
