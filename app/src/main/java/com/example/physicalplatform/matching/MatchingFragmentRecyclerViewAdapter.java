package com.example.physicalplatform.matching;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.MatchingListDataset;

import java.util.ArrayList;

public class MatchingFragmentRecyclerViewAdapter extends RecyclerView.Adapter<MatchingFragmentRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MatchingListDataset> matchingListDatasets;

    private AppCompatActivity activity;
    private FragmentTransaction transaction;

    public MatchingFragmentRecyclerViewAdapter(Context context, ArrayList<MatchingListDataset> matchingListDatasets) {
        this.context = context;
        this.matchingListDatasets = matchingListDatasets;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewMatchingListTitle;
        private TextView textViewMatchingListLocation;
        private TextView textViewMatchingListPeriod;
        private TextView textViewMatchingListClassTime;

        public ViewHolder(View view) {
            super(view);

            textViewMatchingListTitle= view.findViewById(R.id.textViewMatchingListTitle);
            textViewMatchingListLocation= view.findViewById(R.id.textViewMatchingListLocation);
            textViewMatchingListPeriod= view.findViewById(R.id.textViewMatchingListPeriod);
            textViewMatchingListClassTime= view.findViewById(R.id.textViewMatchingListClassTime);

            view.setOnClickListener(new View.OnClickListener() {            // recycler view item 클릭
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
//                        transaction.replace(R.id.frameLayout, new MatchingDetailFragment());
//                        transaction.addToBackStack("matchingList-" + position);
//                        transaction.commit();

                        activity = (AppCompatActivity)view.getContext();
                        transaction = activity.getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_container, new MatchingDetailFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public MatchingFragmentRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.matching_recycler_view_item, parent, false);
        MatchingFragmentRecyclerViewAdapter.ViewHolder vh = new MatchingFragmentRecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchingFragmentRecyclerViewAdapter.ViewHolder holder, int position) {
        MatchingListDataset matchingListDataset = matchingListDatasets.get(position);

        holder.textViewMatchingListTitle.setText(matchingListDataset.getListTitle());
        holder.textViewMatchingListLocation.setText(matchingListDataset.getLocation());
        holder.textViewMatchingListPeriod.setText(matchingListDataset.getPeriod());
        holder.textViewMatchingListClassTime.setText(matchingListDataset.getClassTime());
    }

    @Override
    public int getItemCount() {
        return matchingListDatasets.size();
    }
}
