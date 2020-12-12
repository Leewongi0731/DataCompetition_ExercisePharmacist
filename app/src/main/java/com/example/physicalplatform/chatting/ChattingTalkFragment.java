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

        String chatBotIntro = "안녕하세요. 헬스트레이닝1 강좌 이강사입니다.\n강좌 커리큘럼은 '커리큘럼'\n강좌 수업일정은 '수업일정'\n강사 정보는 '강사'\n회원님의 체력정보는 '체력정보'\n회원님의 테스트결과는 '테스트결과'\n를 입력하시면 정보를 얻을 수 있습니다.";
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

                handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(runnable,1000);
                break;
        }
    }
}
