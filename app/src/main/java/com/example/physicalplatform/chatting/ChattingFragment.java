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
import java.util.Collections;
import java.util.Comparator;

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

        chattingListDatasets.add(new ChattingListDataset(R.drawable.trainer_profile_1,"근력/지구력을 위한 헬스트레이닝","안녕하세요.\n근력/지구력을 위한 헬스트레이닝 강좌입니다.",1,1));
        chattingListDatasets.add(new ChattingListDataset(R.drawable.trainer_profile_2,"심폐지구력 향상을 위한 강좌","안녕하세요.\n심폐지구력 향상을 위한 강좌입니다.",5,1));
        chattingListDatasets.add(new ChattingListDataset(R.drawable.trainer_profile_3,"유연성 강화를 위한 트레이닝","안녕하세요.\n유연성 강화를 위한 트레이닝 강좌입니다.",20,0));
        chattingListDatasets.add(new ChattingListDataset(R.drawable.trainer_profile_4,"완벽한 균형 감각을 위한 강좌","안녕하세요.\n완벽한 균형 감각을 위한 강좌입니다.",76,0));
        chattingListDatasets.add(new ChattingListDataset(R.drawable.trainer_profile_5,"관절염을 위한 심폐지구력 강화운동","안녕하세요.\n관절염을 위한 심폐지구력 강화운동 강좌입니다.",60,0));
        chattingListDatasets.add(new ChattingListDataset(R.drawable.trainer_profile_6,"요통 방지를 위한 근력운동","안녕하세요.\n요통 방지를 위한 근력운동 강좌입니다.",15,0));

        // 시간 순으로 정렬
        Collections.sort(chattingListDatasets, new BeforeTimeAscending());

        chattingListDatasetsFiltered.addAll(chattingListDatasets);
    }
}

class BeforeTimeAscending implements Comparator<ChattingListDataset> {
    @Override
    public int compare(ChattingListDataset o1, ChattingListDataset o2) {
        return o1.getBeforeTime().compareTo(o2.getBeforeTime());
    }
}