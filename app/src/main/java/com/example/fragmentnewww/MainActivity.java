package com.example.fragmentnewww;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_next;
    private boolean isFragmentDisplayed = false;
    private View fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_next = findViewById(R.id.button_next);
        fragment = findViewById(R.id.fragment1);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFragmentDisplayed){
                    displayFragment();
                } else {
                    closeFragment();
                }
            }
        });

    }
    public void displayFragment(){
        SecondFragment secondFragment = SecondFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment1, secondFragment).addToBackStack(null).commit();
        fragment.setVisibility(View.GONE);
        btn_next.setText("Keren !!!");
        isFragmentDisplayed = true;
    }

    public void closeFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentById(R.id.fragment1);
        if(secondFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(secondFragment).commit();
        }
        fragment.setVisibility(View.VISIBLE);
        btn_next.setText("Lihat Sejarah Bali");
        isFragmentDisplayed = false;
    }
}