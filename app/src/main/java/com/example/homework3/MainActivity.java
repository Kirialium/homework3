package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Objects;
public class MainActivity extends AppCompatActivity {

    private Button addNewTicketBtn, fragmentPlus, fragmentMinus;
    public CheckBox adultTicketCheckBox, retireeTicketCheckBox, kidTicketCheckBox;
    public TextView counterFragment, costFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        fillVariables();

        addNewTicketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TicketFragment ticketFragment = new TicketFragment();
                setNewFragment(ticketFragment);
            }
        });

    }
    public void setNewFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.first_frame, fragment);
        ft.commit();
    }
    public void fillVariables(){
        addNewTicketBtn = findViewById(R.id.new_ticket);
        adultTicketCheckBox = findViewById(R.id.adult_check_box);
        retireeTicketCheckBox = findViewById(R.id.retiree_check_box);
        kidTicketCheckBox = findViewById(R.id.kid_check_box);
        counterFragment = findViewById(R.id.counter_fragment);
        costFragment = findViewById(R.id.cost_fragment);
        fragmentMinus = findViewById(R.id.btn_count_minus);
        fragmentPlus = findViewById(R.id.btn_count_plus);
    }
}
