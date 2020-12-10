package com.example.physicalplatform.chatting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.ChattingListDataset;
import com.example.physicalplatform.matching.MatchingDetailFragment;

import java.util.ArrayList;

public class ChattingFragmentRecyclerViewAdapter extends RecyclerView.Adapter<ChattingFragmentRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ChattingListDataset> chattingListDatasets;
    private ArrayList<ChattingListDataset> chattingListDatasetsFiltered;

    private AppCompatActivity activity;
    private FragmentTransaction transaction;

    public ChattingFragmentRecyclerViewAdapter(Context context, ArrayList<ChattingListDataset> chattingListDatasets) {
        this.context = context;
        this.chattingListDatasets = chattingListDatasets;
        this.chattingListDatasetsFiltered = chattingListDatasets;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewProfile;
        private ImageView imageViewCircleBtn;
        private TextView textViewOpponent;
        private TextView textViewRecentTalk;
        private TextView textViewBeforeTime;
        private TextView textViewNumOfChat;

        public ViewHolder(View view) {
            super(view);

            imageViewProfile = view.findViewById(R.id.imageViewProfile);
            imageViewCircleBtn = view.findViewById(R.id.imageViewCircleBtn);
            textViewOpponent = view.findViewById(R.id.textViewOpponent);
            textViewRecentTalk = view.findViewById(R.id.textViewRecentTalk);
            textViewBeforeTime = view.findViewById(R.id.textViewBeforeTime);
            textViewNumOfChat = view.findViewById(R.id.textViewNumOfChat);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        activity = (AppCompatActivity)view.getContext();
                        transaction = activity.getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_container, new ChattingTalkFragment(chattingListDatasetsFiltered.get(position)));
                        transaction.addToBackStack("chattingTalk");
                        transaction.commit();
                    }
                }
            });

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        Toast.makeText(context, position + " 롱 클릭", Toast.LENGTH_SHORT).show();
                    }
                    return false;
                }
            });
        }
    }

    @NonNull
    @Override
    public ChattingFragmentRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chatting_page_recycler_view, parent, false);
        ChattingFragmentRecyclerViewAdapter.ViewHolder vh = new ChattingFragmentRecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ChattingFragmentRecyclerViewAdapter.ViewHolder holder, int position) {
        ChattingListDataset chattingListDataset = chattingListDatasetsFiltered.get(position);

        holder.textViewOpponent.setText(chattingListDataset.getOpponentName());
        holder.textViewRecentTalk.setText(chattingListDataset.getRecentTalk());
        if(chattingListDataset.getBeforeTime() < 60) {
            holder.textViewBeforeTime.setText(chattingListDataset.getBeforeTime().toString() + " 분전");
        } else {
            holder.textViewBeforeTime.setText("오래전");
        }

        if(chattingListDataset.getNumOfChat() == 0) {
            holder.imageViewCircleBtn.setVisibility(View.GONE);
            holder.textViewNumOfChat.setVisibility(View.GONE);
        } else {
            holder.textViewNumOfChat.setText(chattingListDataset.getNumOfChat().toString());
        }

    }

    @Override
    public int getItemCount() {
        return chattingListDatasetsFiltered.size();
    }
}
