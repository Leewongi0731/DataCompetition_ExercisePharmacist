package com.example.physicalplatform.chatting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.ChattingListDataset;
import com.example.physicalplatform.data.MatchingListDataset;

import java.util.ArrayList;

public class ChattingTalkFragment extends Fragment implements View.OnClickListener {
    private ViewGroup viewGroup;
    private Context context;

    private ImageView imageViewTalkBackBtn;

    private RecyclerView chattingRecyclerView;
    private RecyclerView.LayoutManager chattingLayoutManager;
    private ChattingFragmentRecyclerViewAdapter chattingAdapter;
    private ChattingListDataset chattingListDataset;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    public ChattingTalkFragment(ChattingListDataset chattingListDataset) {
        this.chattingListDataset = chattingListDataset;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.chatting_talk_page, container, false);
        context = container.getContext();

        initLayout();

        imageViewTalkBackBtn.setOnClickListener(this);

        return viewGroup;
    }

    private void initLayout() {
        chattingRecyclerView = viewGroup.findViewById(R.id.recyclerViewChatting);

        imageViewTalkBackBtn = viewGroup.findViewById(R.id.imageViewTalkBackBtn);

//        chattingAdapter = new ChattingFragmentRecyclerViewAdapter(context, chattingListDatasetsFiltered);
//        chattingRecyclerView.setAdapter(chattingAdapter);
//        chattingRecyclerView.setHasFixedSize(true);
//
//        chattingLayoutManager = new LinearLayoutManager(context);
//        chattingRecyclerView.setLayoutManager(chattingLayoutManager);

        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.imageViewTalkBackBtn:
                fragmentManager.popBackStackImmediate();
                break;
        }
    }
}