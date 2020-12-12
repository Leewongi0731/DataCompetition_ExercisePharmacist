package com.example.physicalplatform.chatting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import com.example.physicalplatform.data.ChattingTalkDataset;

import java.util.ArrayList;

public class ChattingTalkFragment extends Fragment implements View.OnClickListener {
    private ViewGroup viewGroup;
    private Context context;

    private ImageView imageViewTalkBackBtn;

    private EditText editTextSendMessage;
    private ImageView imageViewSendButton;

    private RecyclerView chattingTalkRecyclerView;
    private RecyclerView.LayoutManager chattingTalkLayoutManager;
    private ChattingTalkRecyclerViewAdapter chattingTalkAdapter;
    private ChattingTalkDataset chattingTalkDataset;

    private ArrayList<ChattingTalkDataset> chattingTalkDatasets;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    public ChattingTalkFragment(ChattingListDataset ChattingTalkDataset) {
        this.chattingTalkDataset = chattingTalkDataset;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.chatting_talk_page, container, false);
        context = container.getContext();

        initLayout();

        imageViewTalkBackBtn.setOnClickListener(this);
        imageViewSendButton.setOnClickListener(this);

        return viewGroup;
    }

    private void initLayout() {
        initDataset();

        imageViewTalkBackBtn = viewGroup.findViewById(R.id.imageViewTalkBackBtn);

        editTextSendMessage = viewGroup.findViewById(R.id.editTextSendMessage);
        imageViewSendButton = viewGroup.findViewById(R.id.imageViewSendButton);

        chattingTalkRecyclerView = viewGroup.findViewById(R.id.recyclerViewChattingTalk);

        chattingTalkAdapter = new ChattingTalkRecyclerViewAdapter(context, chattingTalkDatasets);
        chattingTalkRecyclerView.setAdapter(chattingTalkAdapter);
        chattingTalkRecyclerView.setHasFixedSize(true);

        chattingTalkLayoutManager = new LinearLayoutManager(context);
        chattingTalkRecyclerView.setLayoutManager(chattingTalkLayoutManager);

        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
    }

    private void initDataset() {
        chattingTalkDatasets = new ArrayList<>();

        chattingTalkDatasets.add(new ChattingTalkDataset(R.drawable.trainer_profile_1,false,"이강사","안녕하세요","2020-12-11 16:18:00"));
        chattingTalkDatasets.add(new ChattingTalkDataset(R.drawable.profile,true,"나","안녕하세요","2020-12-11 16:19:00"));
        chattingTalkDatasets.add(new ChattingTalkDataset(R.drawable.trainer_profile_1,false,"이강사","오늘은 1주차 강의 들으셨는데 어떠셨나요?","2020-12-11 16:20:00"));
        chattingTalkDatasets.add(new ChattingTalkDataset(R.drawable.profile,true,"나","좋았어요 리뷰 올려 드릴게요","2020-12-11 16:21:00"));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.imageViewTalkBackBtn:
                fragmentManager.popBackStackImmediate();
                break;
            case R.id.imageViewSendButton:
                String sendText = editTextSendMessage.getText().toString();
                editTextSendMessage.setText("");
                chattingTalkDatasets.add(new ChattingTalkDataset(R.drawable.profile, true,"나",sendText,"2020-12-11 16:22:00"));
                chattingTalkAdapter.notifyDataSetChanged();
                break;
        }
    }
}