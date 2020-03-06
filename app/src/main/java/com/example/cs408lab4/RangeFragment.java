package com.example.cs408lab4;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */

public class RangeFragment extends Fragment implements OnClickListener {

    private EditText miles;
    private EditText kilometers;
    private Button b;


    public RangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_range, container, false);

        b = (Button)view.findViewById(R.id.convertButton);
        b.setOnClickListener(this);
        miles = (EditText)view.findViewById(R.id.milesInput);
        kilometers = (EditText)view.findViewById(R.id.kilometerInput);

        return view;
    }

    @Override
    public void onClick(View v) {
        String result;
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String m = miles.getText().toString();
        String k = kilometers.getText().toString();

        if (m.equals("")){
            if (!k.equals("")){
                double kiloDouble = Double.parseDouble(k);
                result = df.format(kiloDouble * 0.62137);
                miles.setText(result);
            }
            else{
                Toast toast= Toast.makeText(getActivity().getBaseContext(), "Error", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else{
            double mileDouble = Double.parseDouble(m);
            result = df.format(mileDouble * 1.609344);
            kilometers.setText(result);
        }
    }

}
