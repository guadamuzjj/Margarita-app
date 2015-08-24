package com.stormcoders.margarita_app.exercises;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stormcoders.margarita_app.R;

public class CompleteFragment extends Fragment {

    public static CompleteFragment newInstance(String text) {

        CompleteFragment f = new CompleteFragment();

        Bundle b = new Bundle();
        b.putString("text", text);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.complete_fragment, container, false);

        ((TextView) v.findViewById(R.id.tvComplete)).setText(getArguments().getString("text"));
        return v;
    }
}
