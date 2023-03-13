package com.example.newrecycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newrecycler.databinding.FragmentPageBinding;

public class PageFragment extends Fragment {

    private static final String ARG_NAME = "arg_name";
    private FragmentPageBinding binding;

    public static PageFragment newInstance(String name) {
        PageFragment fragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putString(ARG_NAME, name);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPageBinding.inflate(LayoutInflater.from(getContext()));
        binding.text.setText(requireArguments().getString(ARG_NAME, "error"));
        return binding.getRoot();
    }

    public PageFragment() {
        super(R.layout.fragment_page);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
