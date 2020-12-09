package com.example.physicalplatform.health;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.MainPageActivity;
import com.example.physicalplatform.R;
import com.example.physicalplatform.data.HealthCardDataset;

import java.util.ArrayList;

public class HealthFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;

    private ArrayList<HealthCardDataset> bestHealthCardDataset;
    private ArrayList<HealthCardDataset> trendHealthCardDataset;
    private RecyclerView.LayoutManager bestHealthLayoutManager;
    private RecyclerView.LayoutManager trendHealthLayoutManager;
    private RecyclerView bestRecyclerView;
    private RecyclerView trendRecyclerView;
    private HealthFragmentRecyclerViewAdapter bestHealthAdapter;
    private HealthFragmentRecyclerViewAdapter trendHealthAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.health_page, container, false);
        context = container.getContext();

        initLayout();

        return viewGroup;
    }

    private void initLayout() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        bestHealthCardDataset = new ArrayList<>();
        bestHealthCardDataset.add( MainPageActivity.HEALTH_DB.get( "어깨 스트레칭" ) );
        bestHealthCardDataset.add( MainPageActivity.HEALTH_DB.get( "발바닥 치기" ) );
        bestHealthCardDataset.add( MainPageActivity.HEALTH_DB.get( "몸통 비틀기" ) );
        bestHealthCardDataset.add( MainPageActivity.HEALTH_DB.get( "종아리 스트레칭" ) );

        bestRecyclerView = viewGroup.findViewById(R.id.bestRecyclerView);
        bestHealthLayoutManager = new LinearLayoutManager(context);
        bestRecyclerView.setLayoutManager(bestHealthLayoutManager);
        bestRecyclerView.setLayoutManager(layoutManager);  // 세로로 나오게 설정
        bestHealthAdapter = new HealthFragmentRecyclerViewAdapter(context, bestHealthCardDataset);
        bestRecyclerView.setAdapter(bestHealthAdapter);


        layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        trendHealthCardDataset = new ArrayList<>();
        trendHealthCardDataset.add( MainPageActivity.HEALTH_DB.get( "몸통 비틀기" ) );
        trendHealthCardDataset.add( MainPageActivity.HEALTH_DB.get( "종아리 스트레칭" ) );
        trendRecyclerView = viewGroup.findViewById(R.id.trendRecyclerView);

        trendHealthLayoutManager = new LinearLayoutManager(context);
        trendRecyclerView.setLayoutManager(trendHealthLayoutManager);
        trendRecyclerView.setLayoutManager(layoutManager);  // 세로로 나오게 설정
        trendHealthAdapter = new HealthFragmentRecyclerViewAdapter(context, trendHealthCardDataset);
        trendRecyclerView.setAdapter(trendHealthAdapter);
    }

}