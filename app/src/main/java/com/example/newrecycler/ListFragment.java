package com.example.newrecycler;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newrecycler.databinding.FragmentListBinding;

import java.util.UUID;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private FragmentHolder fragmentHolder;

    private final CardClickListener cardClickListener = new CardClickListener() {

        @Override
        public void onButtonClick(CardItem cardItem) {
            adapter.deleteItem(cardItem);
        }

        @Override
        public void onCardClick(CardItem cardItem) {
            fragmentHolder.startFragment(PageFragment.newInstance(cardItem.getName()), true);
        }
    };
    private final CardAdapter adapter = new CardAdapter(cardClickListener);

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentHolder = (FragmentHolder) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(LayoutInflater.from(getContext()));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerView.setAdapter(adapter);
        binding.add.setOnClickListener(v -> addItem());
    }

    private void addItem() {
        String id = UUID.randomUUID().toString();
        String name = binding.name.getText().toString();
        CardItem item = new CardItem(id, name);
        adapter.addItem(item);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentHolder = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
