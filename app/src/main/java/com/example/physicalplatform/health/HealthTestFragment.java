package com.example.physicalplatform.health;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.R;

public class HealthTestFragment  extends Fragment {
    private ViewGroup viewGroup;
    private Context context;


    private EditText healthTestEditTest1;
    private EditText healthTestEditTest2;
    private EditText healthTestEditTest3;
    private Button healthTestResultBtn;


    private AppCompatActivity activity;
    private FragmentTransaction transaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.health_test, container, false);
        context = container.getContext();


        healthTestEditTest1 = viewGroup.findViewById(R.id.healthTestEditTest1);
        healthTestEditTest2 = viewGroup.findViewById(R.id.healthTestEditTest2);
        healthTestEditTest3 = viewGroup.findViewById(R.id.healthTestEditTest3);


        // click test btn
        healthTestResultBtn = viewGroup.findViewById(R.id.healthTestResultBtn);
        healthTestResultBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("test1", healthTestEditTest1.getText().toString()); // key value를 Bundle에 담아서 파라미터로 전송
                args.putString("test2", healthTestEditTest2.getText().toString());
                args.putString("test3", healthTestEditTest3.getText().toString());

                HealthTestResultFragment healthTestResultFragment = new HealthTestResultFragment();
                healthTestResultFragment.setArguments(args);

                activity = (AppCompatActivity)v.getContext();
                transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, healthTestResultFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return viewGroup;
    }
}
