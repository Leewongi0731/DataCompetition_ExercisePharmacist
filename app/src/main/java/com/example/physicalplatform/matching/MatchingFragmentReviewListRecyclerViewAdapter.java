package com.example.physicalplatform.matching;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.MatchingReviewListDataset;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MatchingFragmentReviewListRecyclerViewAdapter  extends RecyclerView.Adapter<MatchingFragmentReviewListRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MatchingReviewListDataset> matchingReviewListDatasets;

    public MatchingFragmentReviewListRecyclerViewAdapter(Context context, ArrayList<MatchingReviewListDataset> matchingReviewListDatasets) {
        this.context = context;
        this.matchingReviewListDatasets = matchingReviewListDatasets;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView circleImageViewProfile;
        private TextView textViewName;
        private TextView textViewDate;
        private TextView textViewContents;
        private TextView textViewRating;

        public ViewHolder(View view) {
            super(view);

            circleImageViewProfile = view.findViewById(R.id.circleImageViewProfile);
            textViewName = view.findViewById(R.id.textViewName);
            textViewDate = view.findViewById(R.id.textViewDate);
            textViewContents = view.findViewById(R.id.textViewContents);
            textViewRating = view.findViewById(R.id.textViewRating);
        }
    }

    @NonNull
    @Override
    public MatchingFragmentReviewListRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.matching_recycler_view_review_list, parent, false);
        MatchingFragmentReviewListRecyclerViewAdapter.ViewHolder vh = new MatchingFragmentReviewListRecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchingFragmentReviewListRecyclerViewAdapter.ViewHolder holder, int position) {
        MatchingReviewListDataset matchingReviewListDataset = matchingReviewListDatasets.get(position);

        holder.textViewName.setText(matchingReviewListDataset.getName());
        holder.textViewDate.setText(matchingReviewListDataset.getDate());
        holder.textViewContents.setText(matchingReviewListDataset.getContents());
        holder.textViewRating.setText(matchingReviewListDataset.getRating().toString());
    }

    @Override
    public int getItemCount() {
        return matchingReviewListDatasets.size();
    }
}
