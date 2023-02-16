package com.example.homework3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class TicketFragment extends Fragment {

    final int turCostAdult = 70;
    final int turCostKid = 35;
    final int turCostRetiree = 21;
    int costTicket = 0;
    int count = 1;

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
                costTicket = turCostAdult * count;
                setCostFragment(costFragment);
                retireeCheckBox.setChecked(false);
                kidCheckBox.setChecked(false);
            }
        });

        retireeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                costTicket = turCostRetiree * count;
                setCostFragment(costFragment);
                adultCheckBox.setChecked(false);
                kidCheckBox.setChecked(false);
            }
        });
        kidCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                costTicket = turCostKid * count;
                setCostFragment(costFragment);
                adultCheckBox.setChecked(false);
                retireeCheckBox.setChecked(false);
            }
        });

        return rootView;
    }
    private void setCostFragment(TextView costFragment){

        String strCost = String.valueOf(costTicket);
        costFragment.setText((String)strCost);
    }
}