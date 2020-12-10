package com.example.physicalplatform.health;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.R;

public class HealthTestResultFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;

    private String test1;
    private String test2;
    private String test3;
    private TextView healthTestUserName;
    private TextView healthTestUserPositionAge;
    private Button healthTestMainBtn;

    private AppCompatActivity activity;
    private FragmentTransaction transaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.health_test_result, container, false);
        context = container.getContext();


        Bundle bundle=getArguments();
        if(bundle !=null) {
            test1 = bundle.getString("test1");
            test2 = bundle.getString("test2");
            test3 = bundle.getString("test3");
        }

        getRecommendExercise();

        // set Name
        healthTestUserName = (TextView)viewGroup.findViewById(R.id.healthTestUserName);
    //    healthTestUserName.setText("이원기");

        // set position, Age
        healthTestUserPositionAge = viewGroup.findViewById(R.id.healthTestUserPositionAge);
     //   healthTestUserPositionAge.setText("서울 88세");


        // click homeBtn
        healthTestMainBtn = viewGroup.findViewById(R.id.healthTestMainBtn);
        healthTestMainBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                activity = (AppCompatActivity)v.getContext();
                transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HealthFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return viewGroup;
    }


    private String[] getRecommendExercise(){
        // 운동추천 모델 돌리고 결과 return
        String[] recommendExercise = { "목운동", "허리운동" };
        return recommendExercise;
    }
}