package com.example.cs408lab4;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipFragment extends Fragment implements OnClickListener {

    private TextView txtOutput;
    private Button b;
    private EditText totalBill;
    private EditText tipPercent;
    private EditText numPeople;
    private double bill;
    private double tip;
    private double people;
    private double result;
    private boolean error;


    public TipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tip, container, false);

        txtOutput = (TextView)view.findViewById(R.id.resultText);
        b = (Button)view.findViewById(R.id.calculateButton);
        b.setOnClickListener(this);
        totalBill = (EditText)view.findViewById(R.id.totalBillInput);
        tipPercent = (EditText)view.findViewById(R.id.tipPercentInput);
        numPeople = (EditText)view.findViewById(R.id.numPeopleInput);

        return view;

    }

    @Override
    public void onClick(View v) {
        try {
            bill = Double.parseDouble(totalBill.getText().toString());
            tip = Double.parseDouble(tipPercent.getText().toString());
            people = Double.parseDouble(numPeople.getText().toString());
        } catch (NumberFormatException e){
            error = true;
            Toast toast= Toast.makeText(getActivity().getBaseContext(), "Error", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (!error){
            tip = tip * 0.01;
            result = (bill * tip)/people;
            DecimalFormat df = new DecimalFormat("#.##");
            String text = "$" + df.format(result);
            txtOutput.setText(text);
        }

    }

}
