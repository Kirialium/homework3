package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity{

    private Button addNewTicketBtn;
    private View lineBehind1, lineBehind2;
    private int countNewFrame = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(this.getSupportActionBar()).hide();
        fillVariables();

        addNewTicketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countNewFrame++;
                switch (countNewFrame) {
                    case 1:
                        TicketFragment firstFragment = new TicketFragment();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.first_frame, firstFragment);
                        ft.commit();

                        lineBehind1.setAlpha(1);
                        break;
                    case 2:
                        TicketFragment secondFragment = new TicketFragment();
                        FragmentTransaction st = getSupportFragmentManager().beginTransaction();
                        st.replace(R.id.second_frame, secondFragment);
                        st.commit();
                        lineBehind2.setAlpha(1);
                        break;
                    case 3:
                        TicketFragment thirdFragment = new TicketFragment();
                        FragmentTransaction tt = getSupportFragmentManager().beginTransaction();
                        tt.replace(R.id.third_frame, thirdFragment);
                        tt.commit();
                        break;
                }
            }
        });
    }


    private void fillVariables(){
        addNewTicketBtn = findViewById(R.id.btn_new_ticket);
        lineBehind1 = findViewById(R.id.line_behind_1);
        lineBehind2 = findViewById(R.id.line_behind_2);
    }
}
