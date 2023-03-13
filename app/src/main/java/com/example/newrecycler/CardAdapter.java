package com.example.newrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newrecycler.databinding.ItemCardBinding;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private List<CardItem> items = new ArrayList<>();
    private final CardClickListener listener;

    public CardAdapter(CardClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCardBinding binding = ItemCardBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new CardViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(CardItem item) {
        items.add(item);
        notifyItemChanged(items.size() - 1);
    }

    public void deleteItem(CardItem item) {
        int index = items.indexOf(item);
        if (index != -1) {
            items.remove(index);
            notifyItemRemoved(index);
        }
    }
}

class CardViewHolder extends RecyclerView.ViewHolder {

    private final ItemCardBinding binding;
    private final CardClickListener listener;

    public CardViewHolder(ItemCardBinding binding, CardClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void bind(CardItem item) {
        binding.name.setText(item.getName());
        binding.delete.setOnClickListener(v -> listener.onButtonClick(item));
        binding.getRoot().setOnClickListener(v -> listener.onCardClick(item));
    }
}
