package com.cfi.bhraman.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cfi.bhraman.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MonumentFragmnet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonumentFragmnet extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int index;


    public MonumentFragmnet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param i Parameter 2.
     * @return A new instance of fragment MonumentFragmnet.
     */
    // TODO: Rename and change types and number of parameters
    public static MonumentFragmnet newInstance(String param1, int i) {
        MonumentFragmnet fragment = new MonumentFragmnet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt("INDEX", i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monument_fragmnet, container, false);
    }

}
