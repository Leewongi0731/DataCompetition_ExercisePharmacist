package com.example.physicalplatform.chatting;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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

    private String sendText;
    private Integer chatIdx = 0; // 채팅 임시 변수

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

        String chatBotIntro = "안녕하세요.\n근력/지구력을 위한 헬스트레이닝 강좌입니다.";
        chattingTalkDatasets.add(new ChattingTalkDataset(R.drawable.trainer_profile_1, false,"이강사",chatBotIntro,"2020-12-11 16:22:00"));

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
    }

    Handler handler;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            ChatBot chatBot = new ChatBot(sendText);
            chattingTalkDatasets.add(chatBot.sendChatting());
            chattingTalkRecyclerView.scrollToPosition(chattingTalkAdapter.getItemCount()-1);
            chattingTalkAdapter.notifyDataSetChanged();
        }
    };

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.imageViewTalkBackBtn:
                fragmentManager.popBackStackImmediate();
                break;
            case R.id.imageViewSendButton:
                sendText = editTextSendMessage.getText().toString();
                editTextSendMessage.setText("");
                chattingTalkDatasets.add(new ChattingTalkDataset(R.drawable.profile, true,"나",sendText,"2020-12-11 16:22:00"));
                chattingTalkRecyclerView.scrollToPosition(chattingTalkAdapter.getItemCount()-1);
                chattingTalkAdapter.notifyDataSetChanged();

                Integer delays[] = {6500,5500,3500,3000};
                handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(runnable,delays[chatIdx++]);
                break;
        }
    }
}
