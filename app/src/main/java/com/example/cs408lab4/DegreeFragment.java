package com.example.cs408lab4;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class DegreeFragment extends Fragment implements OnClickListener {


    public DegreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_degree, container, false);


        return view;
    }

    @Override
    public void onClick(View v) {
        
    }
}
