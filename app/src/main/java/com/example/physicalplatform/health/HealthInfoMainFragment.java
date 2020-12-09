package com.example.physicalplatform.health;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.MainPageActivity;
import com.example.physicalplatform.R;

import org.w3c.dom.Text;

public class HealthInfoMainFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;

    private Button healthInfoBackBtn;
    private TextView healthInfoItemTitle;
    private TextView healthInfoItemContents;
    private Button healthInfoFrontBtn;

    private AppCompatActivity activity;
    private FragmentTransaction transaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.health_info_main, container, false);
        context = container.getContext();

        String exerciseName = "";
        Bundle bundle=getArguments();
        if(bundle !=null) {
            exerciseName = bundle.getString("exerciseName");
        }

        Toast.makeText(context, exerciseName, Toast.LENGTH_SHORT).show();


        // set backBtn
        healthInfoBackBtn = (Button) viewGroup.findViewById(R.id.healthInfoBackBtn);
        healthInfoBackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                activity = (AppCompatActivity)v.getContext();
                transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HealthFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        // set health Title
        healthInfoItemTitle = (TextView) viewGroup.findViewById(R.id.healthInfoItemTitle);
        healthInfoItemTitle.setText( exerciseName );


        // set health contents
        healthInfoItemContents = (TextView) viewGroup.findViewById(R.id.healthInfoItemContents);
        healthInfoItemContents.setText( "나중에 데이터베이스 연동해서 해당 운동에 맞는 걸로 채워야 합니다 아 아 앙 ㅏㅇ ㅏ아아아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ" );


        // set video btn
        healthInfoFrontBtn = (Button) viewGroup.findViewById(R.id.healthInfoFrontBtn);
        healthInfoFrontBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                activity = (AppCompatActivity)v.getContext();
                transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HealthInfoVideoFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return viewGroup;
    }

}