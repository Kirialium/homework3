package com.example.homework3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class TicketFragment extends Fragment{

    private final int turCostAdult = 70;
    private final int turCostKid = 35;
    private final int turCostRetiree = 21;
    public int costTicket = 0;
    private int count = 1;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ticket, container, false);
        Button btnCountMines = (Button) rootView.findViewById(R.id.btn_count_minus);
        Button btnCountPlus = (Button) rootView.findViewById(R.id.btn_count_plus);
        CheckBox adultCheckBox = (CheckBox) rootView.findViewById(R.id.adult_check_box);
        CheckBox retireeCheckBox = (CheckBox) rootView.findViewById(R.id.retiree_check_box);
        CheckBox kidCheckBox = (CheckBox) rootView.findViewById(R.id.kid_check_box);
        TextView counterFragment = (TextView) rootView.findViewById(R.id.counter_fragment);
        TextView costFragment = (TextView) rootView.findViewById(R.id.cost_fragment);
        counterFragment.setText((String.valueOf(count)));

        //Плюс и минус для каунта
        btnCountMines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!adultCheckBox.isChecked() & !retireeCheckBox.isChecked() & !kidCheckBox.isChecked()){
                    Toast.makeText(getActivity(), "Укажите категорию", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(count > 1){
                        count--;
                        counterFragment.setText((String.valueOf(count)));
                        setCostFragment(costFragment);
                    }
                }
            }
        });

        btnCountPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!adultCheckBox.isChecked() & !retireeCheckBox.isChecked() & !kidCheckBox.isChecked()){
                    Toast.makeText(getActivity(), "Укажите категорию", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(count != 10){
                        count++;
                        counterFragment.setText(String.valueOf(count));
                        setCostFragment(costFragment);
                    }
                }
            }
        });

        //Чек боксы
        adultCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    setFalseCheckBox(retireeCheckBox, kidCheckBox);
                    costTicket = turCostAdult * count;
                    setCostFragment(costFragment);
                }
            }
        });

        retireeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    setFalseCheckBox(adultCheckBox, kidCheckBox);
                    costTicket = turCostRetiree * count;
                    setCostFragment(costFragment);
                }
            }
        });
        kidCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    setFalseCheckBox(adultCheckBox, retireeCheckBox);
                    costTicket = turCostKid * count;
                    setCostFragment(costFragment);
                }
            }
        });

        return rootView;
    }

    private void setFalseCheckBox(@NonNull CheckBox firstCheckBox, CheckBox secondCheckBox){
        if (firstCheckBox.isChecked()) firstCheckBox.setChecked(false);
        if(secondCheckBox.isChecked()) secondCheckBox.setChecked(false);
    }

    private void setCostFragment(@NonNull TextView costFragment){
        String strCost = String.valueOf(costTicket * count);
        costFragment.setText((String)strCost);
    }
    
    public void transferFragment(){
        Fragment totalCostFragment = new Fragment();
        Bundle bundle = new Bundle();
        String key = "12";
        bundle.putInt(key, costTicket);
        totalCostFragment.setArguments(bundle);
    }

}