package com.example.physicalplatform.chatting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.ChattingListDataset;
import com.example.physicalplatform.data.ChattingTalkDataset;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChattingTalkRecyclerViewAdapter extends RecyclerView.Adapter<ChattingTalkRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ChattingTalkDataset> chattingListDatasets;

    private AppCompatActivity activity;
    private FragmentTransaction transaction;

    public ChattingTalkRecyclerViewAdapter(Context context, ArrayList<ChattingTalkDataset> chattingListDatasets) {
        this.context = context;
        this.chattingListDatasets = chattingListDatasets;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayoutOpponentChat;
        private CircleImageView circleImageViewOpponent;
        private TextView textViewOpponent;
        private TextView textViewOpponentContents;

        private LinearLayout linearLayoutMyChat;
        private CircleImageView circleImageViewMy;
        private TextView textViewMy;
        private TextView textViewMyContents;

        public ViewHolder(View view) {
            super(view);

            linearLayoutOpponentChat = view.findViewById(R.id.linearLayoutOpponentChat);
            circleImageViewOpponent = view.findViewById(R.id.circleImageViewOpponent);
            textViewOpponent = view.findViewById(R.id.textViewOpponent);
            textViewOpponentContents = view.findViewById(R.id.textViewOpponentContents);

            linearLayoutMyChat = view.findViewById(R.id.linearLayoutMyChat);
            circleImageViewMy = view.findViewById(R.id.circleImageViewMy);
            textViewMy = view.findViewById(R.id.textViewMy);
            textViewMyContents = view.findViewById(R.id.textViewMyContents);
        }
    }

    @NonNull
    @Override
    public ChattingTalkRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chatting_talk_recycler_view_item, parent, false);
        ChattingTalkRecyclerViewAdapter.ViewHolder vh = new ChattingTalkRecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ChattingTalkRecyclerViewAdapter.ViewHolder holder, int position) {
        ChattingTalkDataset chattingListDataset = chattingListDatasets.get(position);

        if(chattingListDataset.isMine()) {      // 내가 친 채팅
            holder.circleImageViewMy.setImageResource(chattingListDataset.getImageSrc());
            holder.linearLayoutOpponentChat.setVisibility(View.GONE);
            holder.linearLayoutMyChat.setVisibility(View.VISIBLE);

            holder.textViewMy.setText("나");
            holder.textViewMyContents.setText(chattingListDataset.getContents());
        } else {
            holder.circleImageViewOpponent.setImageResource(chattingListDataset.getImageSrc());
            holder.linearLayoutOpponentChat.setVisibility(View.VISIBLE);
            holder.linearLayoutMyChat.setVisibility(View.GONE);

            holder.textViewOpponent.setText(chattingListDataset.getName());
            holder.textViewOpponentContents.setText(chattingListDataset.getContents());
        }
    }

    @Override
    public int getItemCount() {
        return chattingListDatasets.size();
    }
}