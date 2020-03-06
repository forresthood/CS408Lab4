package com.example.cs408lab4;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class DegreeFragment extends Fragment implements OnClickListener {
    private Button b;
    private EditText fahrenheit;
    private EditText celsius;


    public DegreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_degree, container, false);

        b = (Button)view.findViewById(R.id.convertButton2);
        b.setOnClickListener(this);
        fahrenheit = (EditText)view.findViewById(R.id.farenheitInput);
        celsius = (EditText)view.findViewById(R.id.celciusInput);

        return view;
    }

    @Override
    public void onClick(View v) {
        String result;
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String f = fahrenheit.getText().toString();
        String c = celsius.getText().toString();

        if (f.equals("")){
            if (!c.equals("")){
                double celsiusDouble = Double.parseDouble(c);
                result = df.format((celsiusDouble * 1.8) + 32);
                fahrenheit.setText(result);
            }
            else{
                Toast toast= Toast.makeText(getActivity().getBaseContext(), "Error", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else{
            double fahrenDouble = Double.parseDouble(f);
            result = df.format((fahrenDouble - 32) / 1.8);
            celsius.setText(result);
        }

    }
}
