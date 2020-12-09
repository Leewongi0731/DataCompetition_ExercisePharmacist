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

    private String exerciseName = "";
    private FragmentManager fragmentManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.health_info_main, container, false);
        context = container.getContext();


        Bundle bundle=getArguments();
        if(bundle !=null) {
            exerciseName = bundle.getString("exerciseName");
        }

        // set backBtn
        healthInfoBackBtn = (Button) viewGroup.findViewById(R.id.healthInfoBackBtn);
        healthInfoBackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStackImmediate();
            }
        });

        // set health Title
        healthInfoItemTitle = (TextView) viewGroup.findViewById(R.id.healthInfoItemTitle);
        healthInfoItemTitle.setText( exerciseName );


        // set health contents
        healthInfoItemContents = (TextView) viewGroup.findViewById(R.id.healthInfoItemContents);
        healthInfoItemContents.setText(  MainPageActivity.HEALTH_DB.get( exerciseName ).getInfo() );


        // set video btn
        healthInfoFrontBtn = (Button) viewGroup.findViewById(R.id.healthInfoFrontBtn);
        healthInfoFrontBtn.setText( exerciseName + "에 대한 영상보기" );
        healthInfoFrontBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("exerciseName", exerciseName); // key value를 Bundle에 담아서 파라미터로 전송

                HealthInfoVideoFragment healthInfoVideoFragment = new HealthInfoVideoFragment();
                healthInfoVideoFragment.setArguments(args);

                activity = (AppCompatActivity)v.getContext();
                transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, healthInfoVideoFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return viewGroup;
    }

}