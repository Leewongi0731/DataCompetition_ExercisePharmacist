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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.MainPageActivity;
import com.example.physicalplatform.R;
import com.example.physicalplatform.data.HealthCardDataset;
import com.example.physicalplatform.data.HealthVideoDataset;
import com.example.physicalplatform.matching.MatchingFragment;

import java.util.ArrayList;

public class HealthInfoVideoFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;

    private Button healthInfoVideoBackBtn;
    private Button goMactchingPageBtn;

    private ArrayList<HealthVideoDataset> healthVideoDatasets;
    private RecyclerView.LayoutManager healthLayoutManager;
    private RecyclerView recyclerView;
    private HealthVideoFragmentRecycleViewAdapter healthVideoFragmentRecycleViewAdapter;

    private AppCompatActivity activity;
    private FragmentTransaction transaction;

    private String exerciseName = "";
    private FragmentManager fragmentManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.health_info_video, container, false);
        context = container.getContext();

        Bundle bundle=getArguments();
        if(bundle !=null) {
            exerciseName = bundle.getString("exerciseName");
        }

        // set backBtn
        healthInfoVideoBackBtn = (Button) viewGroup.findViewById(R.id.healthInfoVideoBackBtn);
        healthInfoVideoBackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStackImmediate();
            }
        });

        // set backBtn
        goMactchingPageBtn = (Button) viewGroup.findViewById(R.id.goMactchingPageBtn);
        goMactchingPageBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                activity = (AppCompatActivity)v.getContext();
                transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new MatchingFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        // draw mvList
        String[] mvNameList = MainPageActivity.HEALTH_DB.get( exerciseName ).getVideoNameList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        healthVideoDatasets = new ArrayList<>();
        for(int i = 0 ; i < mvNameList.length ; i++ ){
            healthVideoDatasets.add( MainPageActivity.HEALTH_VIDEO_DB.get(  mvNameList[i] ) );
        }

        recyclerView = viewGroup.findViewById(R.id.healthInfoVideoRecyclerView);
        healthLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(healthLayoutManager);
        healthVideoFragmentRecycleViewAdapter = new HealthVideoFragmentRecycleViewAdapter(context, healthVideoDatasets);
        recyclerView.setAdapter(healthVideoFragmentRecycleViewAdapter);

        return viewGroup;
    }
}
