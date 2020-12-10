package com.example.physicalplatform.matching;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.MatchingListDataset;

import java.util.ArrayList;
import java.util.Locale;

public class MatchingFragment extends Fragment implements View.OnClickListener, TextWatcher {
    private ViewGroup viewGroup;
    private Context context;

    private boolean[] isLayoutSelected;
    private LinearLayout linearLayoutRegistered;
    private LinearLayout linearLayoutAlmost;
    private LinearLayout linearLayoutStar;

    private TextView textViewNumOfRegistered;
    private TextView textViewNumOfAlmost;
    private TextView textViewNumOfStar;

    private EditText matchingEditText;

    private RecyclerView matchingRecyclerView;
    private RecyclerView.LayoutManager matchingLayoutManager;
    private MatchingFragmentRecyclerViewAdapter matchingAdapter;
    private ArrayList<MatchingListDataset> matchingListDatasets;
    private ArrayList<MatchingListDataset> matchingListDatasetsFiltered;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.matching_page, container, false);
        context = container.getContext();

        initLayout();

        linearLayoutRegistered.setOnClickListener(this);
        linearLayoutAlmost.setOnClickListener(this);
        linearLayoutStar.setOnClickListener(this);

        matchingEditText.addTextChangedListener(this);

        return viewGroup;
    }

    private void initLayout() {
        initDatasets();

        isLayoutSelected = new boolean[]{false,false,false};

        linearLayoutRegistered = viewGroup.findViewById(R.id.linearLayoutRegistered);
        linearLayoutAlmost = viewGroup.findViewById(R.id.linearLayoutAlmost);
        linearLayoutStar = viewGroup.findViewById(R.id.linearLayoutStar);

        textViewNumOfRegistered = viewGroup.findViewById(R.id.textViewNumOfRegistered);
        textViewNumOfAlmost = viewGroup.findViewById(R.id.textViewNumOfAlmost);
        textViewNumOfStar = viewGroup.findViewById(R.id.textViewNumOfStar);

        matchingEditText = viewGroup.findViewById(R.id.matchingEditText);

        matchingRecyclerView = viewGroup.findViewById(R.id.matchingRecyclerView);

        matchingAdapter = new MatchingFragmentRecyclerViewAdapter(context, matchingListDatasetsFiltered);
        matchingRecyclerView.setAdapter(matchingAdapter);
        matchingRecyclerView.setHasFixedSize(true);

        matchingLayoutManager = new LinearLayoutManager(context);
        matchingRecyclerView.setLayoutManager(matchingLayoutManager);
    }

    private void initDatasets() {
        matchingListDatasets = new ArrayList<>();
        matchingListDatasetsFiltered = new ArrayList<>();

        matchingListDatasets.add(new MatchingListDataset(true,true,true,"헬스트레이닝1","송파","주1회 (수)","07:00"));
        matchingListDatasets.add(new MatchingListDataset(true,false,true,"헬스트레이닝2","송파","주2회 (수)","08:00"));
        matchingListDatasets.add(new MatchingListDataset(false,true,false,"헬스트레이닝3","송파","주3회 (수)","09:00"));
        matchingListDatasets.add(new MatchingListDataset(true,false,false,"헬스트레이닝4","송파","주4회 (수)","10:00"));

        matchingListDatasetsFiltered.addAll(matchingListDatasets);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.linearLayoutRegistered:
                attachFilterToDataset(0, R.drawable.border_small_red, R.drawable.border_small, R.drawable.border_small);
                break;
            case R.id.linearLayoutAlmost:
                attachFilterToDataset(1, R.drawable.border_small, R.drawable.border_small_red, R.drawable.border_small);
                break;
            case R.id.linearLayoutStar:
                attachFilterToDataset(2, R.drawable.border_small, R.drawable.border_small, R.drawable.border_small_red);
                break;
        }
    }

    private void attachFilterToDataset(int position, Integer l1, Integer l2, Integer l3) {
        matchingListDatasetsFiltered.clear();
        if(isLayoutSelected[position]) {                                   // 필터 해제
            matchingListDatasetsFiltered.addAll(matchingListDatasets);

            linearLayoutRegistered.setBackground(getResources().getDrawable(R.drawable.border_small));
            linearLayoutAlmost.setBackground(getResources().getDrawable(R.drawable.border_small));
            linearLayoutStar.setBackground(getResources().getDrawable(R.drawable.border_small));
        } else {                                                     // 필터 적용
            linearLayoutRegistered.setBackground(getResources().getDrawable(l1));
            linearLayoutAlmost.setBackground(getResources().getDrawable(l2));
            linearLayoutStar.setBackground(getResources().getDrawable(l3));

            ArrayList<MatchingListDataset> filteringList = new ArrayList<>();

            for(int idx=0; idx<matchingListDatasets.size(); idx++) {
                if(position == 0) {
                    if(matchingListDatasets.get(idx).isRegistered()) {
                        filteringList.add(matchingListDatasets.get(idx));
                    }
                } else if(position == 1) {
                    if(matchingListDatasets.get(idx).isAlmost()) {
                        filteringList.add(matchingListDatasets.get(idx));
                    }
                } else if(position == 2) {
                    if(matchingListDatasets.get(idx).isStar()) {
                        filteringList.add(matchingListDatasets.get(idx));
                    }
                }
            }

            matchingListDatasetsFiltered.addAll(filteringList);
//            matchingListDatasets.clear();
//            matchingListDatasets.addAll(tempMatchingListDatasets);
        }
        isLayoutSelected[position] = !isLayoutSelected[position];
        matchingAdapter.notifyDataSetChanged();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        matchingAdapter.getFilter().filter(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}