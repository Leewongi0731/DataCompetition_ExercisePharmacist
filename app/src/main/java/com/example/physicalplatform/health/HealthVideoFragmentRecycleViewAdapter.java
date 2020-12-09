package com.example.physicalplatform.health;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.HealthVideoDataset;

import java.util.ArrayList;

public class HealthVideoFragmentRecycleViewAdapter extends RecyclerView.Adapter<HealthVideoFragmentRecycleViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HealthVideoDataset> healthVideoDatasets;

    private AppCompatActivity activity;
    private FragmentTransaction transaction;

    public HealthVideoFragmentRecycleViewAdapter(Context context, ArrayList<HealthVideoDataset> healthVideoDatasets) {
        this.context = context;
        this.healthVideoDatasets = healthVideoDatasets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.health_video_recycle_view_item, parent, false);
        HealthVideoFragmentRecycleViewAdapter.ViewHolder vh = new HealthVideoFragmentRecycleViewAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HealthVideoDataset dataSet = healthVideoDatasets.get(position);

        holder.textViewHealthVideoListRunTime.setText(dataSet.getVideoRunTime());
        holder.textViewHealthVideoListName.setText(dataSet.getVideoName());

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("videoPath", dataSet.getVideoURL()); // key value를 Bundle에 담아서 파라미터로 전송

                HealthShowVideoFragment healthShowVideoFragment = new HealthShowVideoFragment();
                healthShowVideoFragment.setArguments(args);

                activity = (AppCompatActivity)v.getContext();
                transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, healthShowVideoFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        };
        holder.linearLayoutHealthRunVideoBtn.setOnClickListener(clickListener);

    }

    @Override
    public int getItemCount() {
        return healthVideoDatasets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewHealthVideoListRunTime;
        private TextView textViewHealthVideoListName;
        private LinearLayout linearLayoutHealthRunVideoBtn;

        public ViewHolder(View view) {
            super(view);

            textViewHealthVideoListRunTime = view.findViewById(R.id.textViewHealthVideoListRunTime);
            textViewHealthVideoListName = view.findViewById(R.id.textViewHealthVideoListName);
            linearLayoutHealthRunVideoBtn = view.findViewById(R.id.linearLayoutHealthRunVideoBtn);
        }
    }
}
