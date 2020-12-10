package com.example.physicalplatform.chatting;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.ChattingListDataset;
import com.example.physicalplatform.data.MatchingListDataset;
import com.example.physicalplatform.matching.MatchingFragmentRecyclerViewAdapter;

import java.util.ArrayList;

public class ChattingFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;

    private RecyclerView chattingRecyclerView;
    private RecyclerView.LayoutManager chattingLayoutManager;
    private ChattingFragmentRecyclerViewAdapter chattingAdapter;
    private ArrayList<ChattingListDataset> chattingListDatasets;
    private ArrayList<ChattingListDataset> chattingListDatasetsFiltered;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.chatting_page, container, false);
        context = container.getContext();

        initLayout();

        return viewGroup;
    }

    private void initLayout() {
        initDatasets();

        chattingRecyclerView = viewGroup.findViewById(R.id.recyclerViewChatting);

        chattingLayoutManager = new LinearLayoutManager(context);
        chattingRecyclerView.setLayoutManager(chattingLayoutManager);

        chattingAdapter = new ChattingFragmentRecyclerViewAdapter(context, chattingListDatasetsFiltered);
        chattingRecyclerView.setAdapter(chattingAdapter);

    }

    private void initDatasets() {
        chattingListDatasets = new ArrayList<>();
        chattingListDatasetsFiltered = new ArrayList<>();

        chattingListDatasets.add(new ChattingListDataset("헬스트레이닝1","안녕하세요.\n헬스트레이닝1입니다.","10분전",1));
        chattingListDatasets.add(new ChattingListDataset("헬스트레이닝2","안녕하세요.\n헬스트레이닝2입니다.","50분전",2));
        chattingListDatasets.add(new ChattingListDataset("헬스트레이닝3","안녕하세요.\n헬스트레이닝3입니다.","20분전",0));
        chattingListDatasets.add(new ChattingListDataset("헬스트레이닝3","안녕하세요.\n헬스트레이닝3입니다.","30분전",0));
        chattingListDatasets.add(new ChattingListDataset("헬스트레이닝3","안녕하세요.\n헬스트레이닝3입니다.","20분전",0));
        chattingListDatasets.add(new ChattingListDataset("헬스트레이닝3","안녕하세요.\n헬스트레이닝3입니다.","15분전",0));

        chattingListDatasetsFiltered.addAll(chattingListDatasets);
    }
}