package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button addNewTicketBtn;
    private View lineBehind;

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
                lineBehind.setAlpha(1);
            }
        });
    }

    private void setNewFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.first_frame, fragment);
        ft.commit();
    }

    private void fillVariables(){
        addNewTicketBtn = findViewById(R.id.new_ticket);
        lineBehind = findViewById(R.id.line_behind_1);
    }
}
