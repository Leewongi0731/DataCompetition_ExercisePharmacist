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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.MatchingListDataset;

import java.util.ArrayList;

public class MatchingFragment extends Fragment implements View.OnClickListener, TextWatcher {
    private ViewGroup viewGroup;
    private Context context;

    private boolean[] isLayoutSelected;
    private LinearLayout linearLayoutRegistered;
    private LinearLayout linearLayoutAlmost;
    private LinearLayout linearLayoutStar;

    private Integer numOfRegistered;
    private Integer numOfAlmost;
    private Integer numOfStar;

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

        textViewNumOfRegistered.setText(numOfRegistered.toString());
        textViewNumOfAlmost.setText(numOfAlmost.toString());
        textViewNumOfStar.setText(numOfStar.toString());

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

        matchingListDatasets.add(new MatchingListDataset(R.drawable.trainer_profile_1, true,true,true,"근력/지구력을 위한 헬스트레이닝","송파구","주1회 (수)","09:00"));
        matchingListDatasets.add(new MatchingListDataset(R.drawable.trainer_profile_2,true,false,true,"심폐지구력 향상을 위한 강좌","강남구","주2회","11:00"));
        matchingListDatasets.add(new MatchingListDataset(R.drawable.trainer_profile_3,false,true,false,"유연성 강화를 위한 트레이닝","중구","주3회","13:00"));
        matchingListDatasets.add(new MatchingListDataset(R.drawable.trainer_profile_4,true,false,false,"완벽한 균형 감각을 위한 강좌","강서구","주2회","09:00"));
        matchingListDatasets.add(new MatchingListDataset(R.drawable.trainer_profile_5,false,false,false,"관절염을 위한 심폐지구력 강화운동","광진구","주1회 (목)","14:00"));
        matchingListDatasets.add(new MatchingListDataset(R.drawable.trainer_profile_6,true,false,true,"요통 방지를 위한 근력운동","송파구","주3회","15:00"));

        setNumOfTextViews();

        matchingListDatasetsFiltered.addAll(matchingListDatasets);
    }

    private void setNumOfTextViews() {
        numOfRegistered = 0;
        numOfAlmost = 0;
        numOfStar = 0;

        for(int idx=0; idx<matchingListDatasets.size(); idx++) {
            if(matchingListDatasets.get(idx).isRegistered()) numOfRegistered += 1;
            if(matchingListDatasets.get(idx).isAlmost()) numOfAlmost += 1;
            if(matchingListDatasets.get(idx).isStar()) numOfStar += 1;
        }
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