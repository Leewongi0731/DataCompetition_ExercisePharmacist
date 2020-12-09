package com.example.physicalplatform.health;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.HealthCardDataset;

import java.util.ArrayList;

public class HealthFragmentRecyclerViewAdapter extends RecyclerView.Adapter<HealthFragmentRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HealthCardDataset> healthCardDataset;

    private AppCompatActivity activity;
    private FragmentTransaction transaction;

    public HealthFragmentRecyclerViewAdapter(Context context, ArrayList<HealthCardDataset> healthCardDataset) {
        this.context = context;
        this.healthCardDataset = healthCardDataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.health_recycle_view_item, parent, false);
        HealthFragmentRecyclerViewAdapter.ViewHolder vh = new HealthFragmentRecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HealthCardDataset dataSet = healthCardDataset.get(position);

        holder.healtItemTextView.setText(dataSet.getName());
        holder.healtItemImageView.setImageResource( (int)dataSet.getImagePath() );

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("exerciseName", dataSet.getName()); // key value를 Bundle에 담아서 파라미터로 전송

                HealthInfoMainFragment healthInfoMainFragment = new HealthInfoMainFragment();
                healthInfoMainFragment.setArguments(args);

                activity = (AppCompatActivity)v.getContext();
                transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, healthInfoMainFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        };
        holder.healtItemImageView.setOnClickListener(clickListener);

    }

    @Override
    public int getItemCount() {
        return healthCardDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView healtItemTextView;
        private ImageView healtItemImageView;

        public ViewHolder(View view) {
            super(view);

            healtItemTextView = view.findViewById(R.id.healtItemTextView);
            healtItemImageView = view.findViewById(R.id.healtItemImageView);
        }
    }
}
