package com.example.physicalplatform.matching;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.MatchingListDataset;

import java.util.ArrayList;

public class MatchingFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;
    private TextView textViewNumOfRegistered;
    private TextView textViewNumOfAlmost;
    private TextView textViewNumOfStar;
    private RecyclerView matchingRecyclerView;
    private RecyclerView.LayoutManager matchingLayoutManager;
    private MatchingFragmentRecyclerViewAdapter matchingAdapter;
    private ArrayList<MatchingListDataset> matchingListDatasets;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.matching_page, container, false);
        context = container.getContext();

        initLayout();

        return viewGroup;
    }

    private void initLayout() {
        matchingListDatasets = new ArrayList<>();
        matchingListDatasets.add(new MatchingListDataset(true,"헬스트레이닝1","송파","주1회 (수)","07:00"));
        matchingListDatasets.add(new MatchingListDataset(true,"헬스트레이닝2","송파","주2회 (수)","08:00"));
        matchingListDatasets.add(new MatchingListDataset(false,"헬스트레이닝3","송파","주3회 (수)","09:00"));
        matchingListDatasets.add(new MatchingListDataset(false,"헬스트레이닝4","송파","주4회 (수)","10:00"));

        textViewNumOfRegistered = viewGroup.findViewById(R.id.textViewNumOfRegistered);
        textViewNumOfAlmost = viewGroup.findViewById(R.id.textViewNumOfAlmost);
        textViewNumOfStar = viewGroup.findViewById(R.id.textViewNumOfStar);

        matchingRecyclerView = viewGroup.findViewById(R.id.matchingRecyclerView);

        matchingLayoutManager = new LinearLayoutManager(context);
        matchingRecyclerView.setLayoutManager(matchingLayoutManager);

        matchingAdapter = new MatchingFragmentRecyclerViewAdapter(context, matchingListDatasets);
        matchingRecyclerView.setAdapter(matchingAdapter);


    }
}