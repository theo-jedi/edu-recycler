package com.example.newrecycler;

import androidx.fragment.app.Fragment;

public interface FragmentHolder {

    void startFragment(Fragment fragment, boolean addToBackStack);
}
